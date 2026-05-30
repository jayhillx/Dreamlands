package com.mystanica.dreamlands.common.worldgen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class PatchConfiguration implements FeatureConfiguration {
    public static final Codec<PatchConfiguration> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((config) -> config.blockProvider),
            Codec.INT.fieldOf("radius").forGetter((config) -> config.radius),
            Codec.INT.fieldOf("tries").forGetter((config) -> config.tries)
    ).apply(instance, PatchConfiguration::new));
    public final BlockStateProvider blockProvider;
    public final int radius;
    public final int tries;

    public PatchConfiguration(BlockStateProvider blockProvider, int radius, int tries) {
        this.blockProvider = blockProvider;
        this.radius = radius;
        this.tries = tries;
    }

}