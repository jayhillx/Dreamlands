package com.dreamlands.init;

import com.dreamlands.Dreamlands;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public class DreamNoiseSettings {

    public static final ResourceKey<NoiseGeneratorSettings> DREAMLAND = Dreamlands.createKey(Registries.NOISE_SETTINGS, "dreamland");

    public static void bootstrap(BootstapContext<NoiseGeneratorSettings> context) {
        context.register(DREAMLAND, NoiseGeneratorSettings.overworld(context, false, false));
    }

}