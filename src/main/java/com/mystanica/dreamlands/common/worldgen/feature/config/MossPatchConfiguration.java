package com.mystanica.dreamlands.common.worldgen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class MossPatchConfiguration extends PatchConfiguration {
    public static final Codec<MossPatchConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockStateProvider.CODEC.fieldOf("block_provider").forGetter(config -> config.blockProvider),
            BlockStateProvider.CODEC.fieldOf("carpet_provider").forGetter(config -> config.carpetProvider),
            Codec.INT.fieldOf("radius").forGetter(config -> config.radius),
            Codec.INT.fieldOf("tries").forGetter(config -> config.tries)
    ).apply(instance, MossPatchConfiguration::new));
    public final BlockStateProvider carpetProvider;

    public MossPatchConfiguration(BlockStateProvider blockProvider, BlockStateProvider carpetProvider, int radius, int tries) {
        super(blockProvider, radius, tries);
        this.carpetProvider = carpetProvider;
    }

}