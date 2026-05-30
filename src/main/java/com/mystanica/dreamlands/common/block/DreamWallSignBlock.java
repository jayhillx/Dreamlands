package com.mystanica.dreamlands.common.block;

import com.mystanica.dreamlands.common.block.entity.DreamSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class DreamWallSignBlock extends WallSignBlock {

    public DreamWallSignBlock(WoodType woodType, Properties properties) {
        super(properties, woodType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DreamSignBlockEntity(pos, state);
    }

}