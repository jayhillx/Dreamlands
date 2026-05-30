package com.mystanica.dreamlands.common.block;

import com.mojang.serialization.MapCodec;
import com.mystanica.dreamlands.init.DreamBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import javax.annotation.Nonnull;

public class DreamDirtPathBlock extends Block {
    public static final IntegerProperty CONNECTED = IntegerProperty.create("connected", 0, 15);

    public DreamDirtPathBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return !this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos())
                ? DreamBlocks.DREAMY_DIRT.get().defaultBlockState()
                : super.getStateForPlacement(context);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor level, BlockPos pos, BlockPos pos1) {
        if (direction == Direction.UP && !state.canSurvive(level, pos)) {
            level.scheduleTick(pos, this, 1);
        }

        state.setValue(CONNECTED, computeMask(level, pos, this));

        return super.updateShape(state, direction, state1, level, pos, pos1);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState aboveState = level.getBlockState(pos.above());
        return !aboveState.isSolid() || aboveState.getBlock() instanceof FenceGateBlock;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        DreamSoilBlock.turnToDirt(level, pos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CONNECTED);
    }

    public static int computeMask(LevelAccessor level, BlockPos pos, Block block) {
        int mask = 0;
        if (level.getBlockState(pos.north()).is(block)) mask |= 1;
        if (level.getBlockState(pos.south()).is(block)) mask |= 2;
        if (level.getBlockState(pos.west()).is(block))  mask |= 4;
        if (level.getBlockState(pos.east()).is(block))  mask |= 8;
        return mask;
    }

}