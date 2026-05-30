package com.mystanica.dreamlands.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.mystanica.dreamlands.handler.DreamingPlayerEvents.isDreaming;

@Mixin(DeathScreen.class)
public abstract class DeathScreenMixins {

    @Inject(method = "init", at = @At("TAIL"))
    private void init(CallbackInfo ci) {
        DeathScreen screen = (DeathScreen)(Object)this;
        Player player = Minecraft.getInstance().player;

        if (player == null || !isDreaming(player)) return;

        for (Object renderable : screen.renderables) {
            if (renderable instanceof Button button) {
                if (button.getMessage().getString().equals(Component.translatable("deathScreen.respawn").getString())) {
                    button.setMessage(Component.translatable("deathScreen.respawn.wake_up"));
                }
            }
        }
    }

}