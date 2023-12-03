package com.dreamlands.common.block.entity;

import com.dreamlands.init.DreamBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

public class DreamSignBlockEntity extends SignBlockEntity {

    public DreamSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Nonnull
    public BlockEntityType<?> getType() {
        return DreamBlockEntities.SIGN.get();
    }

}