package com.dreamlands.datagen.registry;

import com.dreamlands.common.biome.BiomeTemplate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import static com.dreamlands.Dreamlands.createKey;

public class DreamDimensions {

    public static final ResourceKey<Level> DREAMLAND = createKey(Registries.DIMENSION, "dreamland");

    public static void bootstrap(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimensions = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> settings = context.lookup(Registries.NOISE_SETTINGS);

        context.register(Registries.levelToLevelStem(DREAMLAND), levelStem(dimensions.getOrThrow(DreamDimensionTypes.DREAMLAND), BiomeTemplate.buildDreamlandBiomeSource(biomes), settings.getOrThrow(DreamNoiseSettings.DREAMLAND)));
    }

    private static LevelStem levelStem(Holder<DimensionType> dimension, BiomeSource source, Holder<NoiseGeneratorSettings> noise) {
        return new LevelStem(dimension, new NoiseBasedChunkGenerator(source, noise));
    }

}