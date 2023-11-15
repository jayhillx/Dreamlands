package com.dreamlands.common.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.HolderGetter;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.*;

import java.util.List;

public interface BiomeTemplate {

    static Biome biome(float temperature, float downfall, int waterColor, int waterFogColor, int fogColor, MobSpawnSettings.Builder mobSpawns, BiomeGenerationSettings.Builder generation) {
        return (new Biome.BiomeBuilder()).hasPrecipitation(true).temperature(temperature).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(fogColor).skyColor(calculateSkyColor(temperature)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobSpawns.build()).generationSettings(generation.build()).build();
    }

    static int calculateSkyColor(float temperature) {
        float $$1 = temperature / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);

        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    static BiomeSource buildDreamlandBiomeSource(HolderGetter<Biome> biomes) {
        Climate.Parameter range = Climate.Parameter.span(-1.0F, 1.0F);

        return MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(List.of(
                Pair.of(new Climate.ParameterPoint(Climate.Parameter.point(0.0F), range, range, range, range, range, 0), biomes.getOrThrow(Biomes.PLAINS))
        )));
    }

}