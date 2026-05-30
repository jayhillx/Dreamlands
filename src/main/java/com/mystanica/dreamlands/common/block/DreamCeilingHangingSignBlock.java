package com.mystanica.dreamlands.common.block;

import com.mystanica.dreamlands.common.block.entity.DreamHangingSignBlockEntity;
import com.mystanica.dreamlands.common.block.entity.DreamSignBlockEntity;
import com.mystanica.dreamlands.init.DreamBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class DreamCeilingHangingSignBlock extends CeilingHangingSignBlock {

    public DreamCeilingHangingSignBlock(WoodType woodType, Properties properties) {
        super(properties, woodType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DreamHangingSignBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, DreamBlockEntities.HANGING_SIGN.get(), DreamSignBlockEntity::tick);
    }

}