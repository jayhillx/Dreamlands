package com.mystanica.dreamlands.common.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class StackableTallFlowerBlock extends DreamTallFlowerBlock implements DirectionalBlock, StackableBlock {

    public StackableTallFlowerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(AMOUNT, 1));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        return state.is(this)
                ? state.setValue(AMOUNT, Math.min(3, state.getValue(AMOUNT) + 1))
                : this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return DirectionalBlock.rotate(state, rotation);
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return DirectionalBlock.mirror(state, mirror);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return StackableBlock.canBeReplaced(state, context, this.asItem());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, AMOUNT);
    }

}