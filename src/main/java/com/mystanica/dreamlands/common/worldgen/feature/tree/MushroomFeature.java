package com.mystanica.dreamlands.common.worldgen.feature.tree;

import com.mojang.serialization.Codec;
import com.mystanica.dreamlands.common.worldgen.feature.config.MushroomConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class MushroomFeature extends Feature<MushroomConfiguration> {

    public MushroomFeature(Codec<MushroomConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<MushroomConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos initialPos = context.origin();
        MushroomConfiguration config = context.config();

        int stemHeight = this.getStemHeight(random, config);
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        if (!this.isValidPosition(level, random, initialPos, mutablePos, config, stemHeight)) {
            return false;
        } else {
            this.makeCap(level, random, initialPos, mutablePos, config, stemHeight);

            for (int i = 0; i < stemHeight; i++) {
                mutablePos.set(initialPos).move(Direction.UP, i);
                if (!level.getBlockState(mutablePos).isSolidRender(level, mutablePos)) {
                    this.setBlock(level, mutablePos, config.stemProvider.getState(random, initialPos));
                }
            }
            return true;
        }
    }

    protected int getStemHeight(RandomSource random, MushroomConfiguration config) {
        int i = config.stemHeight.sample(random);
        if (random.nextInt(12) == 0) { /// chance for it to double the height it is.
            i *= 2;
        }
        return i;
    }

    protected boolean isValidPosition(LevelAccessor level, RandomSource random, BlockPos pos, BlockPos.MutableBlockPos mutablePos, MushroomConfiguration config, int maxHeight) {
        int i = pos.getY();
        if (i >= level.getMinBuildHeight() + 1 && i + maxHeight + 1 < level.getMaxBuildHeight()) {
            BlockState belowState = level.getBlockState(pos.below());
            if (!isDirt(belowState) && !belowState.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
                return false;
            } else {
                for (int dy = 0; dy <= maxHeight; dy++) {
                    int radius = this.getRadiusForHeight(random, config, dy);

                    for (int dx = -radius; dx <= radius; dx++) {
                        for (int dz = -radius; dz <= radius; dz++) {
                            BlockState offsetPos = level.getBlockState(mutablePos.setWithOffset(pos, dx, dy, dz));
                            if (!offsetPos.isAir() && !offsetPos.is(BlockTags.LEAVES)) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
        } else {
            return false;
        }
    }

    protected int getRadiusForHeight(RandomSource random, MushroomConfiguration config, int currentY) {
        int capRadius = config.capRadius.sample(random);
        int radius = 0;
        if (config.round) {
            if (currentY < -1 && currentY >= -1 - 3) {
                radius = capRadius;
            } else if (currentY == -1) {
                radius = capRadius;
            }
        } else if (config.flat) {
            return currentY <= 3 ? 0 : capRadius;
        }
        return radius;
    }

    protected void makeCap(LevelAccessor level, RandomSource random, BlockPos basePos, BlockPos.MutableBlockPos mutablePos, MushroomConfiguration config, int topY) {
        int capRadius = config.capRadius.sample(random);

        if (config.round) {
            int capHeight;
            if (topY - 1 <= 1) {
                capHeight = 1;
            } else if (topY - 1 >= 6) {
                capHeight = 3;
            } else {
                int height = (int)Mth.randomBetween(random, 3, 4);
                capHeight = random.nextBoolean() ? height - 1 : height;
            }

            for (int capY = topY - capHeight; capY <= topY; capY++) {
                int radius = capY < topY ? capRadius : capRadius - 1;
                int innerRadius = capRadius - 2;

                for (int xOffset = -radius; xOffset <= radius; xOffset++) {
                    for (int zOffset = -radius; zOffset <= radius; zOffset++) {
                        boolean isWestEdge = xOffset == -radius;
                        boolean isEastEdge = xOffset == radius;
                        boolean isNorthEdge = zOffset == -radius;
                        boolean isSouthEdge = zOffset == radius;

                        boolean isXEdge = isWestEdge || isEastEdge;
                        boolean isZEdge = isNorthEdge || isSouthEdge;

                        if (capY >= topY || isXEdge != isZEdge) {
                            mutablePos.setWithOffset(basePos, xOffset, capY, zOffset);

                            if (!level.getBlockState(mutablePos).isSolidRender(level, mutablePos)) {
                                BlockState blockState = config.capProvider.getState(random, basePos);

                                if (blockState.hasProperty(HugeMushroomBlock.WEST)
                                        && blockState.hasProperty(HugeMushroomBlock.EAST)
                                        && blockState.hasProperty(HugeMushroomBlock.NORTH)
                                        && blockState.hasProperty(HugeMushroomBlock.SOUTH)
                                        && blockState.hasProperty(HugeMushroomBlock.UP)
                                ) {
                                    blockState = blockState
                                            .setValue(HugeMushroomBlock.UP, capY >= topY - 1)
                                            .setValue(HugeMushroomBlock.WEST, xOffset < -innerRadius)
                                            .setValue(HugeMushroomBlock.EAST, xOffset > innerRadius)
                                            .setValue(HugeMushroomBlock.NORTH, zOffset < -innerRadius)
                                            .setValue(HugeMushroomBlock.SOUTH, zOffset > innerRadius);
                                }
                                this.setBlock(level, mutablePos, blockState);
                            }
                        }
                    }
                }
            }
        } else if (config.flat) {
            for (int xOffset = -capRadius; xOffset <= capRadius; xOffset++) {
                for (int zOffset = -capRadius; zOffset <= capRadius; zOffset++) {
                    boolean isWestEdge = xOffset == -capRadius;
                    boolean isEastEdge = xOffset == capRadius;
                    boolean isNorthEdge = zOffset == -capRadius;
                    boolean isSouthEdge = zOffset == capRadius;

                    boolean isXEdge = isWestEdge || isEastEdge;
                    boolean isZEdge = isNorthEdge || isSouthEdge;

                    if (!isXEdge || !isZEdge) {
                        mutablePos.setWithOffset(basePos, xOffset, topY, zOffset);

                        if (!level.getBlockState(mutablePos).isSolidRender(level, mutablePos)) {
                            boolean westFace = isWestEdge || (isZEdge && xOffset == 1 - capRadius);
                            boolean eastFace = isEastEdge || (isZEdge && xOffset == capRadius - 1);
                            boolean northFace = isNorthEdge || (isXEdge && zOffset == 1 - capRadius);
                            boolean southFace = isSouthEdge || (isXEdge && zOffset == capRadius - 1);

                            BlockState blockState = config.capProvider.getState(random, basePos);
                            if (blockState.hasProperty(HugeMushroomBlock.WEST)
                                    && blockState.hasProperty(HugeMushroomBlock.EAST)
                                    && blockState.hasProperty(HugeMushroomBlock.NORTH)
                                    && blockState.hasProperty(HugeMushroomBlock.SOUTH)
                            ) {
                                blockState = blockState
                                        .setValue(HugeMushroomBlock.WEST, westFace)
                                        .setValue(HugeMushroomBlock.EAST, eastFace)
                                        .setValue(HugeMushroomBlock.NORTH, northFace)
                                        .setValue(HugeMushroomBlock.SOUTH, southFace);
                            }
                            this.setBlock(level, mutablePos, blockState);
                        }
                    }
                }
            }
        }
    }

}