package com.dreamlands.common.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class DreamlandBiomes {

    public static Biome evergreenForest(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        return BiomeTemplate.biome(0.95F, 0.5F, 4159204, 329011, 12638463, mobBuilder, biomeBuilder);
    }

    public static Biome etherealForest(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        return BiomeTemplate.biome(0.95F, 0.5F, 4159204, 329011, 12638463, mobBuilder, biomeBuilder);
    }

    public static Biome cottonCandyForest(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        return BiomeTemplate.biome(0.95F, 0.5F, 4159204, 329011, 12638463, mobBuilder, biomeBuilder);
    }

}