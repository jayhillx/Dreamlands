package com.mystanica.dreamlands.client.entity.renderer;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.client.entity.model.GnomeModel;
import com.mystanica.dreamlands.client.entity.model.layer.DreamModelLayers;
import com.mystanica.dreamlands.common.entity.animal.Gnome;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class GnomeRenderer extends MobRenderer<Gnome, GnomeModel<Gnome>> {
    private static final ResourceLocation TEXTURE = Dreamlands.modLoc("textures/entity/gnome/gnome.png");

    public GnomeRenderer(EntityRendererProvider.Context context) {
        super(context, new GnomeModel<>(context.bakeLayer(DreamModelLayers.GNOME)), 0.4F);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull Gnome gnome) {
        return TEXTURE;
    }

}