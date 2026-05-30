package com.mystanica.dreamlands.common.worldgen.feature.tree;

import com.mojang.serialization.Codec;
import com.mystanica.dreamlands.common.worldgen.feature.config.DreamTreeConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiConsumer;

public class EtherealTreeFeature extends DreamTreeFeature {

    public EtherealTreeFeature(Codec<DreamTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config) {
        setDirtAt(level, random, initialPos.below(), trunkSetter, config);

        int trunkHeight = config.trunkShape.baseHeight + random.nextInt(config.trunkShape.randHeight);
        int branchHeight = Mth.nextInt(random, 4, trunkHeight / 2);
        int branchLength = Mth.nextInt(random, 2, 4);
        Direction branchDirection = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        for (int currentY = 0; currentY <= trunkHeight; currentY++) {
            this.placeTrunk(level, random, initialPos, trunkSetter, config, currentY, currentY < trunkHeight);

            if (currentY == trunkHeight - 1) {
                this.placeBushyFoliage(level, random, initialPos.above(currentY), foliageSetter, config, 3, 3, true);
            }

            if (currentY == branchHeight) {
                BlockPos branchPos = this.getBranchPos(initialPos.above(currentY), branchDirection, random.nextBoolean(), true);

                if (this.canGenerateBranch(level, branchPos, branchDirection, branchLength)) {
                    this.generateBranch(level, random, branchPos, branchDirection, branchSetter, foliageSetter, config, branchLength);
                }
            }
        }

        int i = Mth.nextInt(random, 2, branchHeight - 2);
        Direction direction = random.nextBoolean() ? branchDirection.getClockWise() : branchDirection.getCounterClockWise();
        BlockPos branchPos = this.getBranchPos(initialPos.above(i), direction, random.nextBoolean(), true);

        if (this.canGenerateBranch(level, branchPos, direction, 1)) {
            this.generateSmallBranch(level, random, branchPos, direction, direction, branchSetter, foliageSetter, config);
        }

        return true;
    }

    /**
     * generates the branches with the leaves already attached.
     * essentially a modified version of the cherry trunk branches.
     *
     * todo: make it so the branches branch further out so they aren't fully on the trunk.
     * @param branchLength determines how long the branch will be. it will move upwards and a random point in its length.
     */
    protected void generateBranch(LevelAccessor level,
                                  RandomSource random,
                                  BlockPos branchPos,
                                  Direction direction,
                                  BiConsumer<BlockPos, BlockState> branchSetter,
                                  BiConsumer<BlockPos, BlockState> foliageSetter,
                                  DreamTreeConfiguration config,
                                  int branchLength
    ) {
        BlockPos.MutableBlockPos mutablePos = branchPos.mutable();
        mutablePos.set(branchPos);

        BlockPos branchEndPos = branchPos.relative(direction, branchLength).above(2);
        for (int i = 0; i < branchLength / 2; ++i) {
            mutablePos.set(branchPos.relative(direction, i));
            this.placeLog(level, random, mutablePos, direction.getAxis(), branchSetter, config);
        }

        Direction verticalDirection = branchEndPos.getY() > mutablePos.getY() ? Direction.UP : Direction.DOWN;
        while (true) {
            int distanceToTarget = mutablePos.distManhattan(branchEndPos);
            if (distanceToTarget == 0) {
                this.placeLog(level, random, mutablePos.above(), Direction.Axis.Y, branchSetter, config);
                this.placeBushyFoliage(level, random, mutablePos.above(), foliageSetter, config, 2, 2, false);
                return;
            }

            float f = (float) Math.abs(branchEndPos.getY() - mutablePos.getY()) / (float) distanceToTarget;
            boolean flag = random.nextFloat() < f;
            mutablePos.move(flag ? verticalDirection : direction);
            this.placeLog(level, random, mutablePos, flag ? verticalDirection.getAxis() : direction.getAxis(), branchSetter, config);
        }
    }

    protected void generateSmallBranch(LevelAccessor level, RandomSource random, BlockPos pos, Direction direction, Direction leafOffsetDirection, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config) {
        this.placeLogWithSurroundingLeaves(level, random, pos, direction, leafOffsetDirection, branchSetter, foliageSetter, config, true, false);
        this.placeLeaves(level, random, pos.above().relative(direction), foliageSetter, config);
        this.placeLeaves(level, random, pos.above().relative(leafOffsetDirection.getClockWise()), foliageSetter, config);
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk) {
        return x == radius && z == radius && (random.nextInt(2) == 0 || y == 0);
    }

}