package com.mystanica.dreamlands.init;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.common.worldgen.DreamNoiseRouterData;
import com.mystanica.dreamlands.common.worldgen.DreamSurfaceRuleData;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseSettings;

public class DreamNoiseSettings {

    public static final ResourceKey<NoiseGeneratorSettings> DREAMLAND = createKey("dreamland");
    ///public static final ResourceKey<NoiseGeneratorSettings> NIGHTMOOR = createKey("nightmoor");

    private static ResourceKey<NoiseGeneratorSettings> createKey(String path) {
        return ResourceKey.create(Registries.NOISE_SETTINGS, Dreamlands.modLoc(path));
    }

    public static void bootstrap(BootstapContext<NoiseGeneratorSettings> context) {
        context.register(DREAMLAND, createNoiseSettings(context, DreamBlocks.DREAMSTONE.get()));
        ///context.register(NIGHTMOOR, createNoiseSettings(context, DreamBlocks.GRIMSTONE.get()));
    }

    public static NoiseGeneratorSettings createNoiseSettings(BootstapContext<?> context, Block stone) {
        return new NoiseGeneratorSettings(
                NoiseSettings.create(-64, 384, 1, 2),
                stone.defaultBlockState(),
                Blocks.WATER.defaultBlockState(),
                DreamNoiseRouterData.fromOverworld(context.lookup(Registries.DENSITY_FUNCTION), context.lookup(Registries.NOISE)),
                DreamSurfaceRuleData.overworldLike(),
                new OverworldBiomeBuilder().spawnTarget(), 63, false, true, true, false);
    }

}