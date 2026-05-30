package com.mystanica.dreamlands.common.worldgen.feature.misc;

import com.mystanica.dreamlands.common.worldgen.feature.config.MossPatchConfiguration;
import com.mystanica.dreamlands.init.DreamBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class MossPatchFeature extends PatchFeature<MossPatchConfiguration> {

    public MossPatchFeature(Codec<MossPatchConfiguration> codec) {
        super(codec);
    }

    @Override
    protected void placeBlocks(LevelAccessor level, BlockPos pos, RandomSource random, MossPatchConfiguration config) {
        BlockState state = level.getBlockState(pos);
        BlockState belowState = level.getBlockState(pos.below());

        if (random.nextDouble() < 0.25D && (state.canBeReplaced() || state.isAir())) {
            level.setBlock(pos, DreamBlocks.FOREST_MOSS_CARPET.get().defaultBlockState(), 2);
        }

        if (!belowState.canBeReplaced() || !belowState.isAir()) {
            level.setBlock(pos.below(), DreamBlocks.FOREST_MOSS_BLOCK.get().defaultBlockState(), 2);
        }
    }

    @Override
    protected boolean canPlace(LevelAccessor level, BlockPos pos, RandomSource random, MossPatchConfiguration config) {
        BlockState state = level.getBlockState(pos);
        BlockState belowState = level.getBlockState(pos.below());
        if (state.getFluidState().isSource()) {
            return false;
        }

        return !state.is(BlockTags.LEAVES) && belowState.is(BlockTags.DIRT) && (state.canBeReplaced() || state.isAir());
    }

}