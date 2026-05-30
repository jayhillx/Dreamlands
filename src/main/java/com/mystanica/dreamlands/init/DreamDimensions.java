package com.mystanica.dreamlands.init;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.common.worldgen.biome.BiomeTemplate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public class DreamDimensions {

    public static final ResourceKey<Level> DREAMLAND = createKey("dreamland");
    ///public static final ResourceKey<Level> NIGHTMOOR = createKey("nightmoor");

    private static ResourceKey<Level> createKey(String path) {
        return ResourceKey.create(Registries.DIMENSION, Dreamlands.modLoc(path));
    }

    public static void bootstrap(BootstapContext<LevelStem> context) {
        HolderGetter<DimensionType> dimensions = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<NoiseGeneratorSettings> settings = context.lookup(Registries.NOISE_SETTINGS);

        context.register(
                Registries.levelToLevelStem(DREAMLAND),
                new LevelStem(dimensions.getOrThrow(DreamDimensionTypes.DREAMLAND),
                        new NoiseBasedChunkGenerator(
                                BiomeTemplate.buildDreamlandBiomeSource(biomes),
                                settings.getOrThrow(DreamNoiseSettings.DREAMLAND))
                )
        );
        ///context.register(
        ///        Registries.levelToLevelStem(NIGHTMOOR),
        ///        new LevelStem(dimensions.getOrThrow(DreamDimensionTypes.NIGHTMOOR),
        ///                new NoiseBasedChunkGenerator(
        ///                        BiomeTemplate.buildDreamlandBiomeSource(biomes),
        ///                        settings.getOrThrow(DreamNoiseSettings.NIGHTMOOR))
        ///        )
        ///);
    }

}