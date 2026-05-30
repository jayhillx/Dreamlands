package com.mystanica.dreamlands.common.block;

import com.mystanica.dreamlands.init.DreamItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class WallWisteriaBlock extends Block {
    public static final EnumProperty<Shape> SHAPE = EnumProperty.create("shape", Shape.class);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty TOP = BooleanProperty.create("connector_top");
    public static final BooleanProperty BOTTOM = BooleanProperty.create("connector_bottom");
    public static final BooleanProperty LEFT = BooleanProperty.create("connector_left");
    public static final BooleanProperty RIGHT = BooleanProperty.create("connector_right");

    public WallWisteriaBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(SHAPE, Shape.CENTER)
                .setValue(FACING, Direction.NORTH)
                .setValue(TOP, false)
                .setValue(BOTTOM, false)
                .setValue(LEFT, false)
                .setValue(RIGHT, false)
        );
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return new ItemStack(DreamItems.WISTERIA.get());
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockState state = this.defaultBlockState();

        Direction clickedFace = context.getClickedFace();
        BlockPos clickedPos = context.getClickedPos().relative(clickedFace.getOpposite());
        BlockState clickedState = level.getBlockState(clickedPos);

        if (clickedState.is(this)) {
            Shape clickedShape = clickedState.getValue(SHAPE);
            Direction facing = clickedState.getValue(FACING);

            state = state.setValue(FACING, facing);
            switch (clickedShape) {
                case CENTER -> {
                    switch (clickedFace) {
                        case UP -> state = state.setValue(SHAPE, Shape.TOP);
                        case DOWN -> state = state.setValue(SHAPE, Shape.BOTTOM);
                        case NORTH, SOUTH, EAST, WEST -> {
                            if (clickedFace == facing.getClockWise()) {
                                state = state.setValue(SHAPE, Shape.CENTER_LEFT);
                            } else if (clickedFace == facing.getCounterClockWise()) {
                                state = state.setValue(SHAPE, Shape.CENTER_RIGHT);
                            }
                        }
                    }
                }
                case TOP -> {
                    switch (clickedFace) {
                        case UP, DOWN -> state = state.setValue(SHAPE, Shape.CENTER);
                        case NORTH, SOUTH, EAST, WEST -> {
                            if (clickedFace == facing.getClockWise()) {
                                state = state.setValue(SHAPE, Shape.TOP_LEFT);
                            } else if (clickedFace == facing.getCounterClockWise()) {
                                state = state.setValue(SHAPE, Shape.TOP_RIGHT);
                            }
                        }
                        default -> state = state.setValue(SHAPE, Shape.TOP);
                    }
                }
                case BOTTOM -> {
                    switch (clickedFace) {
                        case UP, DOWN -> state = state.setValue(SHAPE, Shape.CENTER);
                        case NORTH, SOUTH, EAST, WEST -> {
                            if (clickedFace == facing.getClockWise()) {
                                state = state.setValue(SHAPE, Shape.BOTTOM_LEFT);
                            } else if (clickedFace == facing.getCounterClockWise()) {
                                state = state.setValue(SHAPE, Shape.BOTTOM_RIGHT);
                            }
                        }
                        default -> state = state.setValue(SHAPE, Shape.BOTTOM);
                    }
                }
            }
        } else {
            state = state.setValue(SHAPE, Shape.CENTER);
            state = state.setValue(FACING, clickedFace);
        }

        state = this.updateConnectors(level, state, clickedPos);

        return state;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos pos, BlockPos facingPos) {
        if (!state.canSurvive(level, pos)) {
            return Blocks.AIR.defaultBlockState();
        }

        return this.updateConnectors(level, state, pos);
    }

    private BlockState updateConnectors(LevelReader level, BlockState state, BlockPos pos) {
        Direction facing = state.getValue(FACING);
        BlockState aboveState = level.getBlockState(pos.above());
        BlockState belowState = level.getBlockState(pos.below());
        BlockState leftState = level.getBlockState(pos.relative(facing.getClockWise()));
        BlockState rightState = level.getBlockState(pos.relative(facing.getCounterClockWise()));

        Shape shape = state.getValue(SHAPE);
        if (shape == Shape.CENTER) {
            return state
                    .setValue(TOP, this.hasShape(aboveState, Shape.CENTER, Shape.TOP))
                    .setValue(BOTTOM, this.hasShape(belowState, Shape.CENTER, Shape.BOTTOM))
                    .setValue(LEFT, true)
                    .setValue(RIGHT, true);
        }

        if (shape == Shape.TOP) {
            return state
                    .setValue(TOP, false)
                    .setValue(BOTTOM, true)
                    .setValue(LEFT, this.hasShape(leftState, Shape.TOP_LEFT))
                    .setValue(RIGHT, this.hasShape(rightState, Shape.TOP_RIGHT));
        }

        if (shape == Shape.BOTTOM) {
            return state
                    .setValue(TOP, true)
                    .setValue(BOTTOM, false)
                    .setValue(LEFT, this.hasShape(leftState, Shape.BOTTOM_LEFT))
                    .setValue(RIGHT, this.hasShape(rightState, Shape.BOTTOM_RIGHT));
        }

        return state;
    }

    private boolean hasShape(BlockState state, Shape... shapes) {
        if (!state.is(this)) {
            return false;
        }

        for (Shape shape : shapes) {
            if (state.getValue(SHAPE) == shape) {
                return true;
            }
        }

        return false;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case EAST -> Block.box(0.0D, 0.0D, 0.0D, 5.0D, 16.0D, 16.0D);
            case SOUTH -> Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 5.0D);
            case WEST -> Block.box(11.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
            default -> Block.box(0.0D, 0.0D, 11.0D, 16.0D, 16.0D, 16.0D);
        };
    }

    @Override
    public boolean canSurvive(@NotNull BlockState state, LevelReader level, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockPos oppositePos = pos.relative(direction.getOpposite());
        return level.getBlockState(oppositePos).isFaceSturdy(level, oppositePos, direction);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(SHAPE, FACING, TOP, BOTTOM, LEFT, RIGHT);
    }

    public enum Shape implements StringRepresentable {
        CENTER("center"),
        CENTER_LEFT("center_left"),
        CENTER_RIGHT("center_right"),
        TOP("top"),
        TOP_LEFT("top_left"),
        TOP_RIGHT("top_right"),
        BOTTOM("bottom"),
        BOTTOM_LEFT("bottom_left"),
        BOTTOM_RIGHT("bottom_right");

        private final String name;

        Shape(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getSerializedName() {
            return this.name;
        }
    }

}