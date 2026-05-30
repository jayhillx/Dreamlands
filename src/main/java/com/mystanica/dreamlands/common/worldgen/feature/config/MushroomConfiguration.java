package com.mystanica.dreamlands.common.worldgen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class MushroomConfiguration implements FeatureConfiguration {
    public static final Codec<MushroomConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockStateProvider.CODEC.fieldOf("stem_provider").forGetter(config -> config.stemProvider),
            BlockStateProvider.CODEC.fieldOf("cap_provider").forGetter(config -> config.capProvider),
            IntProvider.CODEC.fieldOf("stem_height").forGetter(config -> config.stemHeight),
            IntProvider.CODEC.fieldOf("cap_radius").forGetter(config -> config.capRadius),
            Codec.BOOL.fieldOf("round").forGetter(config -> config.round),
            Codec.BOOL.fieldOf("flat").forGetter(config -> config.flat)
    ).apply(instance, MushroomConfiguration::new));
    public final BlockStateProvider stemProvider;
    public final BlockStateProvider capProvider;
    public final IntProvider stemHeight;
    public final IntProvider capRadius;
    public final boolean round;
    public final boolean flat;

    protected MushroomConfiguration(BlockStateProvider stemProvider,
                                    BlockStateProvider capProvider,
                                    IntProvider stemHeight,
                                    IntProvider capRadius,
                                    boolean round,
                                    boolean flat) {
        this.stemProvider = stemProvider;
        this.capProvider = capProvider;
        this.stemHeight = stemHeight;
        this.capRadius = capRadius;
        this.round = round;
        this.flat = flat;
    }

    public record Builder(BlockStateProvider stemProvider,
                          BlockStateProvider capProvider,
                          IntProvider stemHeight,
                          IntProvider capRadius,
                          boolean round,
                          boolean flat
    ) {
        public MushroomConfiguration build() {
            return new MushroomConfiguration(
                    this.capProvider,
                    this.stemProvider,
                    this.stemHeight,
                    this.capRadius,
                    this.round,
                    this.flat
            );
        }
    }

}