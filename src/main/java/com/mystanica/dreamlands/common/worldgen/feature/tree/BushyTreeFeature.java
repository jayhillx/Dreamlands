package com.mystanica.dreamlands.common.worldgen.feature.tree;

import com.mojang.serialization.Codec;
import com.mystanica.dreamlands.common.worldgen.feature.config.DreamTreeConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class BushyTreeFeature extends DreamTreeFeature {

    public BushyTreeFeature(Codec<DreamTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config) {
        setDirtAt(level, random, initialPos.below(), trunkSetter, config);

        /// place trunk
        int trunkHeight = config.trunkShape.getTrunkHeight(random);
        for (int currentY = 0; currentY <= trunkHeight; currentY++) {
            this.placeLog(level, random, initialPos.above(currentY), Direction.Axis.Y, trunkSetter, config);
        }

        /// place foliage
        this.placeBushyFoliage(level, random, initialPos.above(trunkHeight - 2), foliageSetter, config, 2, 4, false);

        /// place branches
        List<Direction> directions = new ArrayList<>();
        int branchCount = random.nextIntBetweenInclusive(1, 4);
        for (int i = 0; i < branchCount; i++) {
            Direction branchDirection = Direction.Plane.HORIZONTAL.getRandomDirection(random);
            int minBranchY = random.nextInt(1, 3);
            int maxBranchY = trunkHeight - 4;
            int branchY = minBranchY + random.nextInt(maxBranchY - minBranchY);

            if (!directions.contains(branchDirection)) {
                this.generateBranch(level, random, initialPos.above(branchY), config, branchDirection, branchSetter, foliageSetter, 2, random.nextBoolean());
                directions.add(branchDirection);
            }
        }
        return true;
    }

    protected void generateBranch(LevelAccessor level, RandomSource random, BlockPos startPos, DreamTreeConfiguration config, Direction branchDirection, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, int branchLength, boolean diagonal) {
        BlockPos.MutableBlockPos mutablePos = startPos.mutable();

        if (random.nextBoolean()) {
            mutablePos.move(branchDirection);
            this.placeLog(level, random, mutablePos, branchDirection.getAxis(), branchSetter, config);
        }

        int steps = 0;
        while (steps <= branchLength) {
            int forwardInterval = 1;
            int upwardInterval = 1 + Math.round((float) steps / branchLength * 2);

            for (int i = 0; i < forwardInterval && steps < branchLength; i++, steps++) {
                mutablePos.move(branchDirection);

                final Direction diagonalDirection = branchDirection.getClockWise();
                if (diagonal) {
                    this.placeLog(level, random, mutablePos, branchDirection.getAxis(), branchSetter, config);
                    mutablePos.move(diagonalDirection);
                }
                this.placeLog(level, random, mutablePos, diagonal ? diagonalDirection.getAxis() : branchDirection.getAxis(), branchSetter, config);
            }

            for (int i = 0; i < upwardInterval; i++) {
                mutablePos.move(Direction.UP);
                this.placeLog(level, random, mutablePos, Direction.Axis.Y, branchSetter, config);
            }

            if (steps == branchLength) {
                this.placeBushyFoliage(level, random, mutablePos, foliageSetter, config, 1, 3, false);
                return;
            }
        }
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk) {
        return x == radius && z == radius && (random.nextInt(2) == 0 || y == 0);
    }

}