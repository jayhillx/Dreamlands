package com.dreamlands.datagen.registry;

import com.dreamlands.common.biome.DreamlandBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static com.dreamlands.Dreamlands.createKey;

public class DreamBiomes {

    public static final ResourceKey<Biome> EVERGREEN_FOREST = createKey(Registries.BIOME, "evergreen_forest");
    public static final ResourceKey<Biome> ETHEREAL_FOREST = createKey(Registries.BIOME, "ethereal_forest");
    public static final ResourceKey<Biome> COTTON_CANDY_FOREST = createKey(Registries.BIOME, "cotton_candy_forest");

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> feature = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> carver = context.lookup(Registries.CONFIGURED_CARVER);
        context.register(EVERGREEN_FOREST, DreamlandBiomes.evergreenForest(feature, carver));
        context.register(ETHEREAL_FOREST, DreamlandBiomes.etherealForest(feature, carver));
        context.register(COTTON_CANDY_FOREST, DreamlandBiomes.cottonCandyForest(feature, carver));
    }

}