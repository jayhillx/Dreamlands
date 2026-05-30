package com.mystanica.dreamlands.common.worldgen.feature.tree;

import com.mystanica.dreamlands.common.worldgen.feature.config.DreamTreeConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiConsumer;

public record TreeContext(LevelAccessor level,
                          RandomSource random,
                          BiConsumer<BlockPos, BlockState> trunkSetter,
                          BiConsumer<BlockPos, BlockState> branchSetter,
                          BiConsumer<BlockPos, BlockState> foliageSetter,
                          DreamTreeConfiguration config) {

}