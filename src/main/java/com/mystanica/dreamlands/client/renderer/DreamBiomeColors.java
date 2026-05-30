package com.mystanica.dreamlands.client.renderer;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DreamBiomeColors {

    public static int getDefaultFoliageColor() {
        return 0x828649;
    }

    public static int getDefaultGrassColor() {
        return 0x798138;
    }

    public static int getDefaultDirtColor() {
        return 0x876548;
    }

}