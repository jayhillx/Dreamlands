package com.mystanica.dreamlands.common.block;

import com.mystanica.dreamlands.init.DreamBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class FloweringLeavesBlock extends DreamLeavesBlock {
    public static final BooleanProperty FLOWERING = BooleanProperty.create("flowering");

    public FloweringLeavesBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FLOWERING, false));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState updatedState = super.getStateForPlacement(context);

        BlockState aboveState = context.getLevel().getBlockState(context.getClickedPos().above());
        BlockState belowState = context.getLevel().getBlockState(context.getClickedPos().below());
        if (updatedState != null && (belowState.is(this.getBlossomsBlock()))) {
            updatedState = updatedState.setValue(FLOWERING, true);
        }

        return updatedState;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos pos, BlockPos facingPos) {
        BlockState updatedState = super.updateShape(state, facing, facingState, level, pos, facingPos);

        BlockState belowState = level.getBlockState(pos.below());
        return updatedState.setValue(FLOWERING, belowState.is(this.getBlossomsBlock()));
    }

    /**
     * @return the corresponding blossoms block to this leaves block. (i.e. if this block is wisteria leaves, return wisteria blossoms)
     */
    protected Block getBlossomsBlock() {
        if (this == DreamBlocks.WISTERIA_LEAVES.get()) {
            return DreamBlocks.WISTERIA_BLOSSOMS.get();
        }
        return null;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FLOWERING);
    }

}