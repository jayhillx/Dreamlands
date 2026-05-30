package com.mystanica.dreamlands.common.worldgen.feature.tree;

import com.mojang.serialization.Codec;
import com.mystanica.dreamlands.common.worldgen.feature.config.DreamTreeConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiConsumer;

public class DreamyTreeFeature extends BushyTreeFeature {

    public DreamyTreeFeature(Codec<DreamTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config) {
        return super.placeTree(level, random, initialPos, trunkSetter, branchSetter, foliageSetter, config);
    }

}