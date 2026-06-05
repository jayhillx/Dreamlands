package com.mystanica.dreamlands.init;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.common.worldgen.biome.DreamlandBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class DreamBiomes {

    public static final ResourceKey<Biome> WILDERNESS = createKey("wilderness");
    public static final ResourceKey<Biome> ASPEN_FOREST = createKey("aspen_forest");
    public static final ResourceKey<Biome> EVERGREEN_FOREST = createKey("evergreen_forest");
    public static final ResourceKey<Biome> ETHEREAL_FOREST = createKey("ethereal_forest");
    public static final ResourceKey<Biome> COTTON_CANDY_FOREST = createKey("cotton_candy_forest");
    public static final ResourceKey<Biome> WISTERIA_GROVE = createKey("wisteria_grove");
    public static final ResourceKey<Biome> FAERIE_FOREST = createKey("faerie_forest");
    ///public static final ResourceKey<Biome> FLOWER_FIELDS = createKey("flower_fields");
    ///public static final ResourceKey<Biome> GRAVEYARD = createKey("graveyard");
    ///public static final ResourceKey<Biome> WASTELAND = createKey("wasteland");
    ///public static final ResourceKey<Biome> WOODS = createKey("woods");
    ///public static final ResourceKey<Biome> BLOODWOOD_FOREST = createKey("bloodwood_forest");
    ///public static final ResourceKey<Biome> PINE_FOREST = createKey("pine_forest");
    ///public static final ResourceKey<Biome> POISED_SWAMPLANDS = createKey("poised_swamplands");
    ///public static final ResourceKey<Biome> FUNGUS_JUNGLE = createKey("fungus_jungle");

    private static ResourceKey<Biome> createKey(String path) {
        return ResourceKey.create(Registries.BIOME, Dreamlands.modLoc(path));
    }

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> feature = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> carver = context.lookup(Registries.CONFIGURED_CARVER);

        context.register(WILDERNESS, DreamlandBiomes.wilderness(feature, carver));
        context.register(ASPEN_FOREST, DreamlandBiomes.aspenForest(feature, carver));
        context.register(EVERGREEN_FOREST, DreamlandBiomes.evergreenForest(feature, carver));
        context.register(ETHEREAL_FOREST, DreamlandBiomes.etherealForest(feature, carver));
        context.register(COTTON_CANDY_FOREST, DreamlandBiomes.cottonCandyForest(feature, carver));
        context.register(WISTERIA_GROVE, DreamlandBiomes.wisteriaGrove(feature, carver));
        context.register(FAERIE_FOREST, DreamlandBiomes.faerieForest(feature, carver));
        ///context.register(FLOWER_FIELDS, DreamlandBiomes.flowerFields(feature, carver));
        ///context.register(GRAVEYARD, NightmoorBiomes.graveyard(feature, carver));
        ///context.register(WASTELAND, NightmoorBiomes.wasteland(feature, carver));
        ///context.register(WOODS, NightmoorBiomes.woods(feature, carver));
        ///context.register(PINE_FOREST, NightmoorBiomes.deadForest(feature, carver));
        ///context.register(BLOODWOOD_FOREST, NightmoorBiomes.bloodwoodForest(feature, carver));
        ///context.register(FUNGUS_JUNGLE, NightmoorBiomes.fungusJungle(feature, carver));
        ///context.register(POISED_SWAMPLANDS, NightmoorBiomes.poisedSwamplands(feature, carver));
    }

}