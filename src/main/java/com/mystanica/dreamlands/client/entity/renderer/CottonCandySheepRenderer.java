package com.mystanica.dreamlands.client.entity.renderer;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.client.entity.model.CottonCandySheepModel;
import com.mystanica.dreamlands.client.entity.model.layer.DreamModelLayers;
import com.mystanica.dreamlands.common.entity.animal.CottonCandySheep;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class CottonCandySheepRenderer extends MobRenderer<CottonCandySheep, CottonCandySheepModel<CottonCandySheep>> {
    private static final Map<CottonCandySheep.Type, ResourceLocation> TEXTURES = Util.make(new HashMap<>(), (map) -> {
        map.put(CottonCandySheep.Type.PINK, Dreamlands.modLoc("textures/entity/cotton_candy_sheep/pink.png"));
        map.put(CottonCandySheep.Type.BLUE, Dreamlands.modLoc("textures/entity/cotton_candy_sheep/blue.png"));
    });

    public CottonCandySheepRenderer(EntityRendererProvider.Context context) {
        super(context, new CottonCandySheepModel<>(context.bakeLayer(DreamModelLayers.COTTON_CANDY_SHEEP)), 0.7F);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(CottonCandySheep sheep) {
        return TEXTURES.get(sheep.getVariant());
    }

}