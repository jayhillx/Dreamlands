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

public class CottonCandyTreeFeature extends DreamTreeFeature {

    public CottonCandyTreeFeature(Codec<DreamTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config) {
        setDirtAt(level, random, initialPos.below(), trunkSetter, config);

        List<Direction> directions = new ArrayList<>();
        int branchCount = random.nextIntBetweenInclusive(1, 4);
        int trunkHeight = config.trunkShape.getTrunkHeight(random);

        for (int currentY = 0; currentY <= trunkHeight; currentY++) {
            BlockPos currentPos = initialPos.above(currentY);
            this.placeLog(level, random, currentPos, Direction.Axis.Y, trunkSetter, config);

            if (currentY > 2 && currentY < trunkHeight / 2) {
                for (int i = branchCount; i > 0; i--) {
                    /// chance for the branches to spawn. higher chance if the tree is taller.
                    if (random.nextDouble() < (trunkHeight > 9 ? 0.9D : 0.5D)) {
                        Direction branchDirection = Direction.Plane.HORIZONTAL.getRandomDirection(random);

                        if (!directions.contains(branchDirection)) {
                            this.generateBranch(level, random, currentPos, config, branchDirection, branchSetter, foliageSetter, 3, false);
                            directions.add(branchDirection);
                        }
                    }
                }
            }
        }

        this.placeBushyFoliage(level, random, initialPos.above(trunkHeight), foliageSetter, config, 3, 3, false);
        //this.placeFoliage(level, random, initialPos.above(trunkHeight).below(2), foliageSetter, config, 4, 3);
        //this.placeFoliage(level, random, initialPos.above(trunkHeight).below(), foliageSetter, config, 4, 2);
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
            int forwardInterval = 1 + Math.round((float) steps / branchLength * 2);
            int upwardInterval = 1 + Math.round((float) steps / branchLength * 2);

            for (int i = 0; i < forwardInterval && steps < branchLength; i++, steps++) {
                mutablePos.move(branchDirection);
                this.placeLog(level, random, mutablePos, branchDirection.getAxis(), branchSetter, config);
            }

            for (int i = 0; i < upwardInterval; i++) {
                mutablePos.move(Direction.UP);
                this.placeLog(level, random, mutablePos, Direction.Axis.Y, branchSetter, config);
            }

            if (steps == branchLength) {
                this.placeBushyFoliage(level, random, mutablePos, foliageSetter, config, 2, 2, false);
                return;
            }
        }
    }

    protected void placeFoliage(LevelAccessor level,
                                RandomSource random,
                                BlockPos pos,
                                BiConsumer<BlockPos, BlockState> foliageSetter,
                                DreamTreeConfiguration config,
                                int foliageHeight,
                                int foliageRadius
    ) {
        BlockPos.MutableBlockPos mutablePos = pos.mutable();

        for (int y = 0; y >= -foliageHeight; y--) {
            int radius = foliageRadius + (y != 0 && y != -foliageHeight ? 1 : 0);

            this.placeLeavesRow(level, random, mutablePos, foliageSetter, config, foliageHeight, radius, false);
            mutablePos.move(Direction.DOWN);
        }
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk) {
        return x == radius && z == radius && (random.nextInt(2) == 0 || y == 0);
        //return Mth.square((float)x + 0.5F) + Mth.square((float)z + 0.5F) > (float)(radius * radius);
    }

}