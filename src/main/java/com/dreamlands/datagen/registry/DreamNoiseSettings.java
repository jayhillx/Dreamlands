package com.dreamlands.datagen.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import static com.dreamlands.Dreamlands.createKey;

public class DreamNoiseSettings {

    public static final ResourceKey<NoiseGeneratorSettings> DREAMLAND = createKey(Registries.NOISE_SETTINGS, "dreamland");

    public static void bootstrap(BootstapContext<NoiseGeneratorSettings> context) {
        context.register(DREAMLAND, NoiseGeneratorSettings.overworld(context, false, false));
    }

}