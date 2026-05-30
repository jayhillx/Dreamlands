package com.mystanica.dreamlands.common.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseRouterData;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class DreamNoiseRouterData extends NoiseRouterData {

    public static NoiseRouter fromOverworld(HolderGetter<DensityFunction> densityFunctions, HolderGetter<NormalNoise.NoiseParameters> noiseParameters) {
        return overworld(densityFunctions, noiseParameters, false, false);
    }

}