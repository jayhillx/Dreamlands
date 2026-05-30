package com.mystanica.dreamlands.common.block;

import com.mystanica.dreamlands.init.DreamBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class WisteriaBlock extends PlantHeadBlock implements BonemealableBlock, Wisteria {

    public WisteriaBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE);
        this.registerDefaultState(this.stateDefinition.any().setValue(LEAFY, true));
    }

    @Override
    protected Block getBodyBlock() {
        return DreamBlocks.WISTERIA_PLANT.get();
    }

    @Override
    protected Block getWallBlock() {
        return DreamBlocks.WALL_WISTERIA.get();
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelReader level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        Direction clickedFace = context.getClickedFace();

        BlockState state = super.getStateForPlacement(context);
        BlockState aboveState = level.getBlockState(clickedPos.above());
        BlockState belowState = level.getBlockState(clickedPos.below());

        if (this.getWallBlock() != null) {
            if (clickedFace.getAxis().isHorizontal() || aboveState.is(this.getWallBlock()) || belowState.is(this.getWallBlock())) {
                BlockPos supportPos = context.getClickedPos().relative(clickedFace.getOpposite());
                BlockState supportState = level.getBlockState(supportPos);

                if (supportState.isFaceSturdy(level, supportPos, clickedFace) || supportState.is(this.getWallBlock())) {
                    return this.getWallBlock().getStateForPlacement(context);
                }
            }

            if (!aboveState.is(this.getWallBlock())) {
                if (state != null) {
                    if (aboveState.is(DreamBlocks.WISTERIA_BLOSSOMS.get()) || aboveState.is(DreamBlocks.WISTERIA_PLANT.get())) {
                        state = state.setValue(LEAFY, false);
                    }
                }
            }
        }
        return state;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos pos, BlockPos facingPos) {
        BlockState updatedState = super.updateShape(state, facing, facingState, level, pos, facingPos);
        BlockState aboveState = level.getBlockState(pos.above());
        if (aboveState.is(DreamBlocks.WISTERIA_BLOSSOMS.get()) || aboveState.is(DreamBlocks.WISTERIA_PLANT.get())) {
            return updatedState.setValue(LEAFY, false);
        }

        return updatedState;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState aboveState = level.getBlockState(pos.above());
        return aboveState.is(BlockTags.LEAVES) || aboveState.getBlock() instanceof Wisteria || super.canSurvive(state, level, pos);
    }

    @Override
    protected boolean canGrowInto(BlockState state) {
        return state.isAir();
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource random) {
        return 1;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LEAFY);
    }

}