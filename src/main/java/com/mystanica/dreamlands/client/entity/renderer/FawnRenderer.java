package com.mystanica.dreamlands.client.entity.renderer;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.client.entity.model.FawnModel;
import com.mystanica.dreamlands.client.entity.model.layer.DreamModelLayers;
import com.mystanica.dreamlands.common.entity.animal.Fawn;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class FawnRenderer extends MobRenderer<Fawn, FawnModel<Fawn>> {
    private static final ResourceLocation TEXTURE = Dreamlands.modLoc("textures/entity/fawn/fawn.png");

    public FawnRenderer(EntityRendererProvider.Context context) {
        super(context, new FawnModel<>(context.bakeLayer(DreamModelLayers.FAWN)), 0.4F);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull Fawn fawn) {
        return TEXTURE;
    }

}