package com.mystanica.dreamlands.common.block;

import com.mystanica.dreamlands.init.DreamBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.VoxelShape;

public interface Wisteria {
    BooleanProperty LEAFY = BooleanProperty.create("leafy");
    VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    static BlockState updateShape(BlockState state, LevelAccessor level, BlockPos pos) {
        BlockState aboveState = level.getBlockState(pos.above());
        if (!aboveState.is(DreamBlocks.WISTERIA_LEAVES.get())) {
            state = state.setValue(LEAFY, false);
        }
        return state;
    }

}