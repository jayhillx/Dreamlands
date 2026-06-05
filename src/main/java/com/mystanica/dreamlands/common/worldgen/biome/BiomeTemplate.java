package com.mystanica.dreamlands.common.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import com.mystanica.dreamlands.init.DreamBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface BiomeTemplate {

    default Biome biome(boolean hasPrecipitation, float temperature, float downfall, MobSpawnSettings.Builder mobSpawns, BiomeGenerationSettings.Builder generation) {
        return biome(hasPrecipitation, temperature, downfall, 4159204, 329011, calculateSkyColor(temperature), 12638463, null, null, mobSpawns, generation);
    }

    static Biome biome(boolean hasPrecipitation, float temperature, float downfall, int waterColor, int waterFogColor, int fogColor, @Nullable Integer grassColor, @Nullable Integer foliageColor, MobSpawnSettings.Builder mobSpawns, BiomeGenerationSettings.Builder generation) {
        return biome(hasPrecipitation, temperature, downfall, waterColor, waterFogColor, calculateSkyColor(temperature), fogColor, grassColor, foliageColor, mobSpawns, generation);
    }

    static Biome biome(boolean hasPrecipitation, float temperature, float downfall, int waterColor, int waterFogColor, int skyColor, int fogColor, @Nullable Integer grassColor, @Nullable Integer foliageColor, MobSpawnSettings.Builder mobSpawns, BiomeGenerationSettings.Builder generation) {
        BiomeSpecialEffects.Builder effects = new BiomeSpecialEffects.Builder()
                .waterColor(waterColor)
                .waterFogColor(waterFogColor)
                .skyColor(skyColor)
                .fogColor(fogColor)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(null);

        if (grassColor != null) {
            effects.grassColorOverride(grassColor);
        }

        if (foliageColor != null) {
            effects.foliageColorOverride(foliageColor);
        }

        return new Biome.BiomeBuilder()
                .hasPrecipitation(hasPrecipitation)
                .temperature(temperature)
                .downfall(downfall)
                .specialEffects(effects.build())
                .mobSpawnSettings(mobSpawns.build())
                .generationSettings(generation.build())
                .build();
    }

    static int calculateSkyColor(float temperature) {
        float i = temperature / 3.0F;
        i = Mth.clamp(i, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - i * 0.05F, 0.5F + i * 0.1F, 1.0F);
    }

    static BiomeSource buildDreamlandBiomeSource(HolderGetter<Biome> biomes) {
        Climate.Parameter full = Climate.Parameter.span(-1.0F, 1.0F);

        Climate.Parameter temp0 = Climate.Parameter.span(-1.0F, -0.6F);
        Climate.Parameter temp1 = Climate.Parameter.span(-0.6F, -0.2F);
        Climate.Parameter temp2 = Climate.Parameter.span(-0.2F, 0.2F);
        Climate.Parameter temp3 = Climate.Parameter.span(0.2F, 0.5F);
        Climate.Parameter temp4 = Climate.Parameter.span(0.5F, 0.8F);
        Climate.Parameter temp5 = Climate.Parameter.span(0.8F, 1.0F);

        Climate.Parameter weird0 = Climate.Parameter.span(-1.0F, -0.33F);
        Climate.Parameter weird1 = Climate.Parameter.span(-0.33F, 0.33F);
        Climate.Parameter weird2 = Climate.Parameter.span(0.33F, 1.0F);

        return MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(List.of(
                Pair.of(new Climate.ParameterPoint(temp0, full, full, full, full, weird0, 0), biomes.getOrThrow(DreamBiomes.WILDERNESS)),
                Pair.of(new Climate.ParameterPoint(full, full, full, full, full, weird0, 0), biomes.getOrThrow(DreamBiomes.ASPEN_FOREST)),
                Pair.of(new Climate.ParameterPoint(temp1, full, full, full, full, weird0, 0), biomes.getOrThrow(DreamBiomes.EVERGREEN_FOREST)),
                Pair.of(new Climate.ParameterPoint(temp2, full, full, full, full, weird1, 0), biomes.getOrThrow(DreamBiomes.ETHEREAL_FOREST)),
                Pair.of(new Climate.ParameterPoint(temp3, full, full, full, full, weird1, 0), biomes.getOrThrow(DreamBiomes.COTTON_CANDY_FOREST)),
                Pair.of(new Climate.ParameterPoint(temp4, full, full, full, full, weird2, 0), biomes.getOrThrow(DreamBiomes.WISTERIA_GROVE)),
                Pair.of(new Climate.ParameterPoint(temp5, full, full, full, full, weird2, 0), biomes.getOrThrow(DreamBiomes.FAERIE_FOREST))
        )));
    }

}