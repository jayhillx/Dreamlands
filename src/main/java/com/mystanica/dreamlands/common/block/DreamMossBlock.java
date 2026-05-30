package com.mystanica.dreamlands.common.block;

import com.mystanica.dreamlands.common.worldgen.feature.DreamVegetationFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DreamMossBlock extends Block implements BonemealableBlock {

    public DreamMossBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean valid) {
        return level.getBlockState(pos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        level.registryAccess()
                .registry(Registries.CONFIGURED_FEATURE)
                .flatMap(features -> features.getHolder(DreamVegetationFeatures.PATCH_FOREST_MOSS))
                .ifPresent(reference -> reference.value().place(level, level.getChunkSource().getGenerator(), random, pos.above()));
    }

}