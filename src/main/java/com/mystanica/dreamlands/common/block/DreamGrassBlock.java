package com.mystanica.dreamlands.common.block;

import com.mystanica.dreamlands.common.worldgen.placement.DreamVegetationPlacements;
import com.mystanica.dreamlands.init.DreamBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
import java.util.Optional;

public class DreamGrassBlock extends DreamDirtBlock implements BonemealableBlock {

    public DreamGrassBlock(Properties properties) {
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
        BlockState plantState = this.getPlant(state).defaultBlockState();
        Optional<Holder.Reference<PlacedFeature>> optional = level.registryAccess()
                .registryOrThrow(Registries.PLACED_FEATURE)
                .getHolder(DreamVegetationPlacements.PATCH_DREAMY_GRASS);

        i:
        for (int i = 0; i < 128; i++) {
            BlockPos abovePos = pos.above();
            BlockState aboveState = level.getBlockState(abovePos);

            for (int j = 0; j < i / 16; j++) {
                abovePos = abovePos.offset(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
                if (!state.is(this) || aboveState.isCollisionShapeFullBlock(level, abovePos)) {
                    continue i;
                }
            }

            if (aboveState.is(plantState.getBlock()) && random.nextInt(10) == 0) {
                ((BonemealableBlock)plantState.getBlock()).performBonemeal(level, random, abovePos, aboveState);
            }

            if (aboveState.isAir()) {
                Holder<PlacedFeature> holder;
                if (random.nextInt(8) == 0) {
                    List<ConfiguredFeature<?, ?>> list = level.getBiome(abovePos).value().getGenerationSettings().getFlowerFeatures();
                    if (list.isEmpty()) {
                        continue;
                    }

                    holder = ((RandomPatchConfiguration)list.get(0).config()).feature();
                } else {
                    if (optional.isEmpty()) {
                        continue;
                    }

                    holder = optional.get();
                }
                holder.value().place(level, level.getChunkSource().getGenerator(), random, abovePos);
            }
        }
    }

    /**
     * @param state - being the grass block itself, returning the matching grass. (i.e. dried grass block returning dried grass)
     */
    private Block getPlant(BlockState state) {
        if (state.getBlock() == DreamBlocks.DREAMY_GRASS_BLOCK.get()) {
            return DreamBlocks.DREAMY_GRASS.get();
        }
        return Blocks.AIR;
    }
    
}