package com.mystanica.dreamlands.common.worldgen.biome;

import com.mystanica.dreamlands.common.worldgen.placement.DreamVegetationPlacements;
import com.mystanica.dreamlands.init.DreamEntities;
import net.minecraft.core.HolderGetter;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class DreamlandBiomes {

    public static Biome wilderness(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 100, 4, 8)); /// change to bunny

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.TREES_WILDERNESS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.SHRUBS_WILDERNESS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.FLOWER_PERIWINKLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.FLOWER_VIOLETS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_CLOVERS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_WHITE_CLOVERS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_DREAMY_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_TALL_DREAMY_GRASS);

        return BiomeTemplate.biome(
                true,
                0.95F,
                0.5F,
                8108719,
                7058332,
                9883614,
                13299180,
                7962936,
                7962936,
                mobBuilder,
                biomeBuilder
        );
    }

    public static Biome evergreenForest(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(DreamEntities.FAWN.get(), 40, 1, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(DreamEntities.FOREST_FOX.get(), 40, 1, 4));

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.TREES_EVERGREEN_FOREST);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.SHRUBS_EVERGREEN_FOREST);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.MUSHROOMS_TOADSTOOL);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_TOADSTOOL);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_FOREST_MOSS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_FOREST_MUSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_CLOVERS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_DREAMY_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_TALL_DREAMY_GRASS);

        return BiomeTemplate.biome(
                true,
                0.5F,
                0.4F,
                3775899,
                5801581,
                9883614,
                13097419,
                6979906,
                7962936,
                mobBuilder,
                biomeBuilder
        );
    }

    public static Biome etherealForest(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(DreamEntities.GNOME.get(), 40, 2, 4));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 100, 4, 8)); /// change to bunny

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.TREES_ETHEREAL_FOREST);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.SHRUBS_ETHEREAL_FOREST);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.MUSHROOMS_DREAMY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.FLOWER_PETUNIA);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_GROUND_IVY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_DREAMY_MUSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_DREAMY_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_TALL_DREAMY_GRASS);

        return BiomeTemplate.biome(
                false,
                0.85F,
                0.0F,
                4819325,
                9332896,
                11067361,
                14207977,
                6787440, //6457704,
                7508581,
                mobBuilder,
                biomeBuilder
        );
    }

    public static Biome cottonCandyForest(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(DreamEntities.COTTON_CANDY_SHEEP.get(), 70, 2, 4));

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.TREES_COTTON_CANDY_FOREST);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.FLOWER_PINK_HYACINTH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_DREAMY_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_TALL_DREAMY_GRASS);

        return BiomeTemplate.biome(
                false,
                0.8F,
                0.0F,
                7325878,
                7189423,
                13101815,
                15913457,
                8694636,
                8694636,
                mobBuilder,
                biomeBuilder
        );
    }

    public static Biome wisteriaGrove(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 100, 4, 8)); /// change to bunny

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.TREES_WISTERIA_GROVE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.FLOWER_MAGENTA_HYACINTH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.FLOWER_PURPLE_HYACINTH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.FLOWER_PERIWINKLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.FLOWER_VIOLETS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_GROUND_IVY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_DREAMY_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_TALL_DREAMY_GRASS);

        return BiomeTemplate.biome(
                false,
                0.7F,
                0.0F,
                7319724,
                11903205,
                9883614,
                12247002,
                9020015,
                9020015,
                mobBuilder,
                biomeBuilder
        );
    }

    public static Biome faerieForest(HolderGetter<PlacedFeature> feature, HolderGetter<ConfiguredWorldCarver<?>> carver) {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(feature, carver);

        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 100, 4, 8)); /// change to bunny

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.TREES_FAERIE_FOREST);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.SHRUBS_FAERIE_FOREST);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.MUSHROOMS_PINK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.FLOWER_PINK_FOXGLOVE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_PINK_MUSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_FOREST_MOSS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_CLOVERS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_DREAMY_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamVegetationPlacements.PATCH_TALL_DREAMY_GRASS);

        return BiomeTemplate.biome(
                false,
                0.6F,
                0.5F,
                7719644,
                9985446,
                9883614,
                14670317,
                7569731,
                7569731,
                mobBuilder,
                biomeBuilder
        );
    }

}