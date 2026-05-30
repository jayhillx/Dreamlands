package com.mystanica.dreamlands.common.worldgen.feature.tree;

import com.mojang.serialization.Codec;
import com.mystanica.dreamlands.common.worldgen.feature.config.DreamTreeConfiguration;
import com.mystanica.dreamlands.common.worldgen.feature.tree.config.BasicBranchShapeConfig;
import com.mystanica.dreamlands.common.worldgen.feature.tree.config.BasicBranchShapeConfig.BendDirection;
import com.mystanica.dreamlands.common.worldgen.feature.tree.config.FoliageShapeConfig;
import com.mystanica.dreamlands.init.DreamBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiConsumer;

public class MysticalTreeFeature extends DreamTreeFeature {

    public MysticalTreeFeature(Codec<DreamTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config) {
        /// place trunk
        int trunkHeight = config.trunkShape.baseHeight + random.nextInt(config.trunkShape.randHeight);
        for (int currentY = 0; currentY <= trunkHeight; currentY++) {
            this.placeTrunk(level, random, initialPos, trunkSetter, branchSetter, foliageSetter, config, currentY, trunkHeight);
        }

        /// place roots
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            int rootHeight = random.nextIntBetweenInclusive(1, 3);

            for (int y = 0; y <= rootHeight; y++) {
                this.placeLog(level, random, initialPos.above(y).relative(direction, 2), Direction.Axis.Y, trunkSetter, config);
            }
        }

        /// place branches
        for (Direction side : Direction.Plane.HORIZONTAL) {
            int branchHeight = trunkHeight - random.nextIntBetweenInclusive(1, 4);
            int branchLength = random.nextIntBetweenInclusive(6, 8);

            Direction direction = random.nextBoolean() ? side : random.nextBoolean() ? side.getClockWise() : side.getCounterClockWise();
            BlockPos branchPos = initialPos.relative(direction);

            BasicBranchShapeConfig.Builder branchBuilder = new BasicBranchShapeConfig.Builder(branchLength).bendVertically(BendDirection.UP, 2, 1);
            FoliageShapeConfig.Builder foliageBuilder = new FoliageShapeConfig.Builder(2, 2);

            this.generateBranch(level, random, branchPos.above(branchHeight), direction, branchSetter, foliageSetter, config, branchBuilder.build(), foliageBuilder.build());

            if (random.nextBoolean()) {
                this.generateSmallBranch(level, random, branchPos.relative(direction).above(branchHeight - 3), direction, direction, branchSetter, foliageSetter, config);
            }
        }

        return true;
    }

    /** 3x3 triple mega large trunk vibes */
    protected void placeTrunk(LevelAccessor level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config, int currentY, int trunkHeight) {
        BlockState woodState = DreamBlocks.MYSTICAL_WOOD.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y);
        BlockPos currentPos = initialPos.above(currentY);
        this.placeLog(level, random, currentPos, Direction.Axis.Y, trunkSetter, config);

        float progress = (float) currentY / trunkHeight;
        if (progress < 0.8F) {
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    BlockPos offsetPos = currentPos.offset(x, 0, z);
                    this.placeLog(level, random, offsetPos, Direction.Axis.Y, trunkSetter, config);
                }
            }
        } else {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                BlockPos pos = currentPos.relative(direction);
                trunkSetter.accept(pos, woodState);
                trunkSetter.accept(currentPos.above(), woodState);
                trunkSetter.accept(pos.relative(direction.getCounterClockWise()), woodState);
            }
        }

        if (currentY == trunkHeight - 2) {
            Direction branchDirection = Direction.Plane.HORIZONTAL.getRandomDirection(random);
            this.generateSplitTrunk(level, random, currentPos.relative(branchDirection.getCounterClockWise()), branchDirection, branchSetter, foliageSetter, config, new FoliageShapeConfig.Builder(3, 4).build(), 3, 3, true);

            this.generateSplitTrunk(level, random, currentPos.below(2).relative(branchDirection, 2).relative(branchDirection.getCounterClockWise()), branchDirection.getClockWise(), branchSetter, foliageSetter, config, new FoliageShapeConfig.Builder(3, 3).build(), 5, 4, false);

            this.generateSplitTrunk(level, random, currentPos.below().relative(branchDirection.getClockWise()), branchDirection.getClockWise(), branchSetter, foliageSetter, config, new FoliageShapeConfig.Builder(2, 4).build(), 3, 2, true);

            this.generateSplitTrunk(level, random, currentPos.below(2).relative(branchDirection.getCounterClockWise()), branchDirection.getOpposite(), branchSetter, foliageSetter, config, new FoliageShapeConfig.Builder(3, 4).build(), 3, 3, true);

            this.generateSplitTrunk(level, random, currentPos.below().relative(branchDirection.getCounterClockWise()).relative(branchDirection.getOpposite()), branchDirection.getCounterClockWise(), branchSetter, foliageSetter, config, new FoliageShapeConfig.Builder(2, 3).build(), 3, 3, true);
        }
    }

    /**
     * @param segments ------ the amount of times this should repeat itself, making the "branch" longer.
     * @param segmentHeight - the height of each segment the branch will be, smaller values making it look smaller.
     */
    protected void generateSplitTrunk(LevelAccessor level, RandomSource random, BlockPos pos, Direction direction, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config, FoliageShapeConfig foliageConfig, int segments, int segmentHeight, boolean diagonal) {
        BlockPos.MutableBlockPos mutablePos = pos.mutable();

        BlockState woodState = DreamBlocks.MYSTICAL_WOOD.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y);

        if (diagonal) {
            for (int i = 1; i <= segmentHeight; i++) {
                if (i == 1) mutablePos.move(Direction.UP);
                branchSetter.accept(pos.above(i).relative(direction), woodState);
            }

            for (int i = 0; i < segmentHeight; i++) {
                if (i == 1) mutablePos.move(Direction.UP).move(direction);
                branchSetter.accept(pos.above(2 + i).relative(direction, 2), woodState);
                branchSetter.accept(pos.above(2 + i).relative(direction).relative(direction.getCounterClockWise()), woodState);
            }
        } else {
            for (int i = 0; i < segmentHeight; i++) {
                if (i > 0 && i < segmentHeight - 1) {
                    for (int radius = 0; radius < 3; radius++) {
                        branchSetter.accept(pos.above(i).relative(direction, radius), woodState);
                    }
                }

                if (i == 1) mutablePos.move(Direction.UP);
                branchSetter.accept(pos.above(i).relative(direction), woodState);
            }
        }

        if (segments > 1) {
            this.generateSplitTrunk(level, random, mutablePos.relative(direction.getCounterClockWise()), direction, branchSetter, foliageSetter, config, foliageConfig, segments - 1, segmentHeight, diagonal);
        } else {
            for (int i = 0; i < segmentHeight; i++) {
                if (i == 0) mutablePos.move(direction);
                if (i == 0 && !diagonal) mutablePos.move(Direction.DOWN);

                mutablePos.move(Direction.UP);
                branchSetter.accept(mutablePos.relative(direction.getCounterClockWise()), woodState);
            }

            this.placeBushyFoliage(level, random, mutablePos.below().relative(direction.getCounterClockWise()), foliageSetter, config, foliageConfig.foliageRadius, foliageConfig.foliageHeight, false, 0.6D);
        }
    }

    protected void generateBranch(LevelAccessor level, RandomSource random, BlockPos branchPos, Direction branchDirection, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config, BasicBranchShapeConfig branchConfig, FoliageShapeConfig foliageConfig) {
        BlockPos.MutableBlockPos mutablePos = branchPos.mutable();

        int steps = 0;
        while (steps < branchConfig.branchLength) {
            Direction verticalDirection = branchConfig.verticalBendDirection.bendDirection(branchDirection);
            Direction horizontalDirection = branchConfig.horizontalBendDirection.bendDirection(branchDirection);

            if (branchConfig.bendInterval > 0 && branchConfig.verticalBendInterval == 0) {
                int forwardInterval = 1;
                int upwardInterval = 1 + Math.round((float) steps / branchConfig.branchLength * 2);

                for (int i = 0; i < forwardInterval && steps < branchConfig.branchLength; i++, steps++) {
                    mutablePos.move(branchDirection);
                    this.placeLog(level, random, mutablePos, branchDirection.getAxis(), branchSetter, config);
                }

                for (int i = 0; i < upwardInterval && steps < branchConfig.branchLength && random.nextDouble() < 0.4D; i++) {
                    mutablePos.move(Direction.UP);
                    this.placeLog(level, random, mutablePos, Direction.Axis.Y, branchSetter, config);
                }
            } else {
                int forwardInterval = Math.max(1, branchConfig.forwardInterval);
                int verticalAmount = Math.max(1, branchConfig.verticalBendInterval);
                int horizontalAmount = Math.max(1, branchConfig.horizontalBendInterval);

                for (int i = 0; i < forwardInterval && steps < branchConfig.branchLength; i++, steps++) {
                    mutablePos.move(branchDirection);
                    this.placeLog(level, random, mutablePos, branchDirection.getAxis(), branchSetter, config);
                }

                for (int i = 0; i < verticalAmount && steps < branchConfig.branchLength; i++, steps++) {
                    mutablePos.move(verticalDirection);
                    this.placeLog(level, random, mutablePos, Direction.Axis.Y, branchSetter, config);
                }

                if (branchConfig.horizontalBendInterval > 0) {
                    for (int i = 0; i < horizontalAmount && steps < branchConfig.branchLength; i++, steps++) {
                        mutablePos.move(horizontalDirection);
                        this.placeLog(level, random, mutablePos, horizontalDirection.getAxis(), branchSetter, config);
                    }
                }
            }

            if (steps == branchConfig.branchLength) {
                mutablePos.move(Direction.UP);
                this.placeLog(level, random, mutablePos, Direction.Axis.Y, branchSetter, config);
                this.placeBushyFoliage(level, random, mutablePos, foliageSetter, config, foliageConfig.foliageRadius, foliageConfig.foliageHeight, false, 0.6D);
                return;
            }
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