package com.mystanica.dreamlands.common.worldgen.feature.tree;

import com.mojang.serialization.Codec;
import com.mystanica.dreamlands.common.worldgen.feature.config.DreamTreeConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiConsumer;

public class AspenTreeFeature extends DreamTreeFeature {

    public AspenTreeFeature(Codec<DreamTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config) {
        setDirtAt(level, random, initialPos.below(), trunkSetter, config);

        int trunkHeight = config.trunkShape.getTrunkHeight(random);
        int minBranchY = trunkHeight / 2;
        int maxBranchY = trunkHeight - 4;
        int branchCount = random.nextIntBetweenInclusive(2, 4);

        for (int currentY = 0; currentY <= trunkHeight; currentY++) {
            this.placeLog(level, random, initialPos.above(currentY), Direction.Axis.Y, trunkSetter, config);

            /// place small branches, only when there are less than 3 branches.
            if (currentY < minBranchY && currentY > 3) {
                Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
                BlockPos branchPos = initialPos.above(currentY).relative(direction);

                if (this.canPlaceBranch(level, branchPos, direction, 1) && random.nextBoolean()) {
                    this.placeLog(level, random, branchPos, direction.getAxis(), branchSetter, config);
                    this.placeLeafShape(level, random, branchPos, direction, foliageSetter, config);
                }
            }
        }

        /// place top foliage
        this.placeTopFoliage(level, random, initialPos.above(trunkHeight - 3), foliageSetter, config, 1, 6);

        /// place branches
        for (int i = 0; i < branchCount; i++) {
            int branchY = minBranchY + random.nextInt(maxBranchY - minBranchY);
            int branchLength = 1 + random.nextInt(2);

            Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
            BlockPos branchPos = initialPos.above(branchY);
            if (this.canPlaceBranch(level, branchPos.relative(direction), direction, 2)) {
                this.generateBranch(level, random, branchPos, config, direction, trunkSetter, foliageSetter, branchLength);
            }
        }
        return true;
    }

    protected void generateBranch(LevelAccessor level, RandomSource random, BlockPos pos, DreamTreeConfiguration config, Direction direction, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, int branchLength) {
        this.placeLogWithSurroundingLeaves(level, random, pos.relative(direction), direction, branchSetter, foliageSetter, config, false, false);

        BlockPos.MutableBlockPos mutablePos = pos.mutable();
        int interval = Math.max(1, branchLength / 3);
        for (int length = 0; length <= branchLength; length++) {
            mutablePos.move(direction);
            this.placeLog(level, random, mutablePos, direction.getAxis(), branchSetter, config);

            if (length % interval == 0 && length != 0 ) {
                mutablePos.move(Direction.UP);
                this.placeLogWithSurroundingLeaves(level, random, mutablePos, Direction.UP, branchSetter, foliageSetter, config, false, false);

                if (length == branchLength) {
                    this.placeLeafShape(level, random, mutablePos, direction, foliageSetter, config);

                    if (random.nextDouble() > 0.33 && level.isEmptyBlock(mutablePos.below(2))) { /// add leaves underneath the blob of leaves.
                        for (Direction directions : Direction.Plane.HORIZONTAL) {
                            this.placeLeaves(level, random, mutablePos.below(2), foliageSetter, config);
                            this.placeLeaves(level, random, mutablePos.relative(directions).below(2), foliageSetter, config);
                            if (random.nextBoolean()) this.placeLeaves(level, random, mutablePos.below(3), foliageSetter, config);
                        }
                    }
                }
            }
        }
    }

    private void placeTopFoliage(LevelAccessor level, RandomSource random, BlockPos pos, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config, int foliageRadius, int foliageHeight) {
        for (int radius = 0; radius <= foliageRadius; radius++) {
            for (int height = 0; height <= foliageHeight; height++) {
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    BlockPos currentPos = pos.above(height);
                    this.placeLeaves(level, random, currentPos.above(), foliageSetter, config);

                    if (height == 1 || height == foliageHeight || height == foliageHeight - 3) {
                        this.placeLeaves(level, random, currentPos.relative(direction), foliageSetter, config);
                    }

                    if ((height == 2 || height == foliageHeight - 1|| height == foliageHeight - 2) && radius <= 2) {
                        this.placeLeavesRow(level, random, currentPos, foliageSetter, config, foliageRadius, false, false);
                        if (height == 2 || height == 4) this.placeLeaves(level, random, currentPos.relative(direction, 2), foliageSetter, config);
                    }
                }
            }
        }
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk) {
        return false;
    }
    
}