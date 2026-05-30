package com.mystanica.dreamlands.common.worldgen.feature.tree;

import com.mojang.serialization.Codec;
import com.mystanica.dreamlands.common.worldgen.feature.config.DreamTreeConfiguration;
import com.mystanica.dreamlands.common.worldgen.feature.tree.config.BranchShapeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.function.BiConsumer;

public class EvergreenTreeFeature extends DreamTreeFeature {

    public EvergreenTreeFeature(Codec<DreamTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config) {
        final TreeContext context = new TreeContext(level, random, trunkSetter, branchSetter, foliageSetter, config);
        final boolean small = !config.large && random.nextDouble() < 0.1D; /// 10% chance for the tree to be small.

        int baseHeight = config.trunkShape.baseHeight + (small ? - 9 : 0);
        int trunkHeight = baseHeight + random.nextInt(config.trunkShape.randHeight);
        for (int currentY = 0; currentY <= trunkHeight; currentY++) {
            boolean doubleTrunk = config.large && currentY < 13;
            this.placeTrunk(level, random, initialPos, trunkSetter, config, currentY, doubleTrunk);

            /// place the branches as the currentY moves upward.
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                Direction right = direction.getClockWise();
                Direction left = direction.getCounterClockWise();
                BlockPos currentPos = initialPos.above(currentY);
                BlockPos branchPos = !doubleTrunk ? currentPos.relative(direction) : switch (direction) {
                    case NORTH -> currentPos.relative(Direction.NORTH).east();
                    case EAST -> currentPos.relative(Direction.EAST).east().south();
                    case SOUTH -> currentPos.relative(Direction.SOUTH).south();
                    case WEST -> currentPos.relative(Direction.WEST);
                    default -> currentPos.relative(direction);
                };
                BlockPos offsetPos = branchPos.relative(right);
                BlockPos oppositeOffsetPos = branchPos.relative(right.getOpposite());
                
                if (currentY > 1 && currentY < 4 && random.nextInt(4) == 0 && !small) {
                    this.placeLogWithSurroundingLeaves(level, random, branchPos, direction, branchSetter, foliageSetter, config, true, false);
                }

                if (small) {
                    if (currentY == 5) {
                        this.straightBranch(context, branchPos, direction, direction, branchBuilder().length(3).hasOffsetLeaves());
                    } if (currentY == 6) {
                        this.diagonalBranch(context, offsetPos, direction, branchBuilder().length(2));
                    } if (currentY == 7) {
                        this.diagonalBranch(context, branchPos, direction, branchBuilder().length(1).noBottomLeaves());
                    } if (currentY == 8) {
                        this.diagonalBranch(context, branchPos, direction, branchBuilder().length(2).noBottomLeaves());
                    } if (currentY == 9) {
                        this.straightBranch(context, branchPos, direction, direction, branchBuilder().length(2).noBottomLeaves());
                    } if (currentY == 11) {
                        this.straightBranch(context, offsetPos, direction, direction, branchBuilder().length(1).hasOffsetLeaves());
                    } if ((currentY == 12 && trunkHeight <= 16) || (currentY == 13 && trunkHeight >= 17)) {
                        this.straightBranch(context, branchPos, direction, direction, branchBuilder().length(2));
                    } if ((currentY == 13 && trunkHeight <= 16) || (currentY == 14 && trunkHeight >= 17)) {
                        this.placeLeaves(level, random, offsetPos, foliageSetter, config);
                    } if ((currentY == 14 && trunkHeight <= 16) || (currentY == 15 && trunkHeight >= 17)) {
                        this.placeLeaves(level, random, branchPos, foliageSetter, config);
                    }
                } else if (config.large) {
                    if (currentY == 8) {
                        this.branch(context, branchPos, direction, right, 2, branchBuilder().length(6).droop(2));
                        this.branch(context, oppositeOffsetPos, direction, left, 2, branchBuilder().length(6).droop(2));
                    } if (currentY == 9) {
                        this.branch(context, offsetPos, direction, right, 1, branchBuilder().length(5).droop(2));
                    } if (currentY == 10) {
                        this.branch(context, oppositeOffsetPos, direction, right, 3, branchBuilder().length(6).droop(2));
                    } if (currentY == 11) {
                        this.branch(context, offsetPos, direction, right, 2, branchBuilder().length(4).droop(2));
                    } if (currentY == 12) {
                        this.branch(context, oppositeOffsetPos, direction, left, 2, branchBuilder().length(5).droop(2));
                    } if (currentY == 14) {
                        this.branch(context, offsetPos, direction, right, 1, branchBuilder().length(4).droop(2));
                    } if (currentY == 15) {
                        this.branch(context, branchPos, direction, right, 3, branchBuilder().length(4).droop(3));
                    } if (currentY == 17) {
                        this.branch(context, branchPos, direction, left, 3, branchBuilder().length(4).droop(2));
                    } if (currentY == 18) {
                        this.branch(context, offsetPos, direction, right, 1, branchBuilder().length(3).droop(2));
                    } if (currentY == 20) {
                        this.branch(context, branchPos, direction, right, 2, branchBuilder().length(3).droop(1));
                    } if (currentY == 23) {
                        this.branch(context, branchPos, direction, left, 2, branchBuilder().length(3).droop(1));
                    } if ((currentY == 25 && trunkHeight <= 31) || (currentY == 26 && trunkHeight >= 32)) {
                        this.branch(context, branchPos, direction, right, 1, branchBuilder().length(3).droop(1));
                    } if ((currentY == 28 && trunkHeight <= 31) || (currentY == 29 && trunkHeight >= 32)) {
                        this.branch(context, branchPos, direction, left, 0, branchBuilder().length(2).droop(1));
                    }
                } else {
                    if (currentY == 7) {
                        this.straightBranch(context, branchPos, direction, direction, branchBuilder().length(5).droop(2).staticDroop());
                    } if (currentY == 8) {
                        this.diagonalBranch(context, branchPos, direction, branchBuilder().length(4).droop(2).hasOffsetLeaves().staticDroop());
                    } if (currentY == 9) {
                        this.diagonalBranch(context, oppositeOffsetPos, direction, branchBuilder().length(4).droop(2).staticDroop());
                    } if (currentY == 10) {
                        this.diagonalBranch(context, oppositeOffsetPos, direction.getOpposite(), branchBuilder().length(3).droop(2).staticDroop());
                    } if (currentY == 11) {
                        this.diagonalBranch(context, offsetPos, direction, branchBuilder().length(3).droop(2).staticDroop());
                    } if (currentY == 12) {
                        this.straightBranch(context, branchPos, direction, direction, branchBuilder().length(4).droop(2).staticDroop());
                    } if (currentY == 13) {
                        this.straightBranch(context, branchPos, direction, direction, branchBuilder().length(3).droop(2).staticDroop());
                        this.diagonalBranch(context, offsetPos, direction, branchBuilder().length(2));
                    } if (currentY == 16) {
                        this.diagonalBranch(context, oppositeOffsetPos, direction, branchBuilder().length(3).droop(2).staticDroop());
                    } if (currentY == 18) {
                        this.diagonalBranch(context, oppositeOffsetPos, direction.getOpposite(), branchBuilder().length(2).droop(2).staticDroop());
                    } if (currentY == 20) {
                        this.diagonalBranch(context, offsetPos, direction, branchBuilder().length(1));
                    } if (currentY == 22 && trunkHeight >= 26) {
                        this.straightBranch(context, branchPos, direction, direction, branchBuilder().length(2));
                    } if ((currentY == 22 && trunkHeight <= 25) || (currentY == 23 && trunkHeight >= 26)) {
                        this.straightBranch(context, branchPos, direction, direction, branchBuilder().length(1));
                    }
                }

                /// place top foliage shape.
                if (currentY == trunkHeight) {
                    this.placeLeaves(level, random, offsetPos.below(), foliageSetter, config);
                    this.placeLeaves(level, random, currentPos.relative(direction, 2), foliageSetter, config);
                    this.placeLeavesRow(level, random, currentPos, foliageSetter, config, 1, false, false);

                    for (int i = 0; i < 5; i++) {
                        this.placeLeaves(level, random, currentPos.above(i), foliageSetter, config);

                        if (i < 3) {
                            this.placeLeaves(level, random, branchPos.above(i), foliageSetter, config);
                        }
                    }
                }
            }
        }
        return true;
    }

    protected void diagonalBranch(TreeContext context, BlockPos branchPos, Direction branchDirection, BranchShapeConfig.Builder builder) {
        this.branch(context, branchPos, branchDirection, branchDirection.getClockWise(), 1, builder.hasOffsetLeaves());
    }

    protected void straightBranch(TreeContext context, BlockPos branchPos, Direction branchDirection, Direction offsetDirection, BranchShapeConfig.Builder builder) {
        this.branch(context, branchPos, branchDirection, offsetDirection, 0, builder);
    }

    /**
     * @param bendDirection --- determines what direction the branch curves toward.
     * @param bendStrength ---- while this determines at which rate it will curve.
     *                          higher values will result in a gradual curve, while 1 is completely diagonal.
     */
    protected void branch(TreeContext context,
                          BlockPos branchPos,
                          Direction branchDirection,
                          @Nullable Direction bendDirection,
                          int bendStrength,
                          BranchShapeConfig.Builder branchBuilder
    ) {
        if (bendStrength > 0) {
            branchBuilder.horizontalBend(bendDirection, bendStrength);
        }

        Direction leafOffsetDirection = bendDirection == null ? branchDirection : bendDirection;
        this.createBranch(context, branchPos, branchDirection, leafOffsetDirection.getCounterClockWise(), branchBuilder.build());
    }

    protected BranchShapeConfig.Builder branchBuilder() {
        return new BranchShapeConfig.Builder();
    }

    protected void createBranch(TreeContext context, BlockPos branchPos, Direction branchDirection, Direction leafOffsetDirection, BranchShapeConfig branchConfig) {
        int verticalOffset = 0;
        int horizontalOffset = 0;
        for (int i = 0; i < branchConfig.branchLength; i++) {
            if (branchConfig.droopCurveAmount < 2) {
                if (branchConfig.droopInterval > 0 && i > 0 && i % branchConfig.droopInterval == 0) {
                    verticalOffset++;
                }
            }

            if (branchConfig.bendStrength > 0 && i > 0 && i % branchConfig.bendStrength == 0) {
                horizontalOffset++;
            }

            Direction bendDirection = branchConfig.bendDirection != null ? branchConfig.bendDirection : branchDirection.getClockWise();
            BlockPos placePos = branchPos.relative(branchDirection, i).relative(bendDirection, horizontalOffset).below(verticalOffset);
            this.placeLogWithSurroundingLeaves(context.level(), context.random(), placePos, branchDirection, leafOffsetDirection, context.branchSetter(), context.foliageSetter(), context.config(), branchConfig.offsetLeaves, branchConfig.bottomLeaves);

            if (branchConfig.droopCurveAmount == 2) {
                verticalOffset = (branchConfig.droopInterval > 0 && i > 0) ? 1 : 0;
            }
        }
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk) {
        return false;
    }

}