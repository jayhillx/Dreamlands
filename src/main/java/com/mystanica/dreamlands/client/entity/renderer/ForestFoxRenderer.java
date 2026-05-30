package com.mystanica.dreamlands.client.entity.renderer;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.client.entity.model.FawnModel;
import com.mystanica.dreamlands.client.entity.model.ForestFoxModel;
import com.mystanica.dreamlands.client.entity.model.layer.DreamModelLayers;
import com.mystanica.dreamlands.common.entity.animal.Fawn;
import com.mystanica.dreamlands.common.entity.animal.ForestFox;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class ForestFoxRenderer extends MobRenderer<ForestFox, ForestFoxModel<ForestFox>> {
    private static final ResourceLocation TEXTURE = Dreamlands.modLoc("textures/entity/forest_fox/forest_fox.png");

    public ForestFoxRenderer(EntityRendererProvider.Context context) {
        super(context, new ForestFoxModel<>(context.bakeLayer(DreamModelLayers.FOREST_FOX)), 0.4F);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull ForestFox fox) {
        return TEXTURE;
    }

}