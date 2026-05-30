package com.mystanica.dreamlands.client.entity.renderer;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mystanica.dreamlands.common.entity.misc.SleepingPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class SleepingPlayerRenderer extends LivingEntityRenderer<SleepingPlayer, PlayerModel<SleepingPlayer>> {

    public SleepingPlayerRenderer(EntityRendererProvider.Context context, boolean slim) {
        super(context, new PlayerModel<>(context.bakeLayer(slim ? ModelLayers.PLAYER_SLIM : ModelLayers.PLAYER), slim), 0.5F);
        this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidArmorModel<>(context.bakeLayer(slim ? ModelLayers.PLAYER_SLIM_INNER_ARMOR : ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidArmorModel(context.bakeLayer(slim ? ModelLayers.PLAYER_SLIM_OUTER_ARMOR : ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
        this.addLayer(new ArrowLayer<>(context, this));
        this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
        this.addLayer(new BeeStingerLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(SleepingPlayer player) {
        GameProfile profile = player.getGameProfile();
        if (profile != null) {
            Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> map = Minecraft.getInstance().getSkinManager().getInsecureSkinInformation(profile);
            MinecraftProfileTexture texture = map.get(MinecraftProfileTexture.Type.SKIN);

            if (texture != null) {
                return Minecraft.getInstance().getSkinManager().registerTexture(texture, MinecraftProfileTexture.Type.SKIN);
            } else {
                return DefaultPlayerSkin.getDefaultSkin(profile.getId());
            }
        } else {
            return DefaultPlayerSkin.getDefaultSkin(player.getUUID());
        }
    }

    @Override
    protected void scale(SleepingPlayer player, PoseStack poseStack, float amount) {
        poseStack.scale(0.9375F, 0.9375F, 0.9375F);
    }

}