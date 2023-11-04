package io.github.jay.dreamlands.core.init;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static io.github.jay.dreamlands.Dreamlands.createKey;

public class DreamBiomes {

    // NIGHTMOOR
    public static final ResourceKey<Biome> ABYSS = createKey(Registries.BIOME, "abyss");
    public static final ResourceKey<Biome> MOONLIGHT_FOREST = createKey(Registries.BIOME, "moonlight_forest");
    public static final ResourceKey<Biome> POISED_SWAMPLANDS = createKey(Registries.BIOME, "poised_swamplands");
    public static final ResourceKey<Biome> FUNGUS_JUNGLE = createKey(Registries.BIOME, "fungus_jungle");

    // DREAMLAND
    public static final ResourceKey<Biome> BUNNY_FIELDS = createKey(Registries.BIOME, "bunny_fields");
    public static final ResourceKey<Biome> ETHEREAL_FOREST = createKey(Registries.BIOME, "ethereal_forest");
    public static final ResourceKey<Biome> EVERGREEN_FOREST = createKey(Registries.BIOME, "evergreen_forest");
    public static final ResourceKey<Biome> COTTON_CANDY_FOREST = createKey(Registries.BIOME, "cotton_candy_forest");

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<ConfiguredWorldCarver<?>> carver = context.lookup(Registries.CONFIGURED_CARVER);
        HolderGetter<PlacedFeature> placedFeature = context.lookup(Registries.PLACED_FEATURE);

        context.register(ABYSS, OverworldBiomes.plains(placedFeature, carver, false, false, false));
        context.register(MOONLIGHT_FOREST, OverworldBiomes.plains(placedFeature, carver, false, false, false));
        context.register(POISED_SWAMPLANDS, OverworldBiomes.plains(placedFeature, carver, false, false, false));
        context.register(FUNGUS_JUNGLE, OverworldBiomes.plains(placedFeature, carver, false, false, false));

        context.register(BUNNY_FIELDS, OverworldBiomes.plains(placedFeature, carver, false, false, false));
        context.register(ETHEREAL_FOREST, OverworldBiomes.plains(placedFeature, carver, false, false, false));
        context.register(EVERGREEN_FOREST, OverworldBiomes.plains(placedFeature, carver, false, false, false));
        context.register(COTTON_CANDY_FOREST, OverworldBiomes.plains(placedFeature, carver, false, false, false));
    }

}