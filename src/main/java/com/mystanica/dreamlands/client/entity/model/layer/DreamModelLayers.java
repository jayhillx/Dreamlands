package com.mystanica.dreamlands.client.entity.model.layer;

import com.mystanica.dreamlands.Dreamlands;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DreamModelLayers {

    public static final ModelLayerLocation FAWN = register("fawn");
    public static final ModelLayerLocation FOREST_FOX = register("forest_fox");
    public static final ModelLayerLocation GNOME = register("gnome");
    public static final ModelLayerLocation COTTON_CANDY_SHEEP = register("cotton_candy_sheep");
    public static final ModelLayerLocation SLEEPING_PLAYER = register("sleeping_player");

    private static ModelLayerLocation register(String path) {
        return new ModelLayerLocation(Dreamlands.modLoc(path), "main");
    }

}