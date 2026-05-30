package com.mystanica.dreamlands.mixin;

import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.CombatTracker;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.mystanica.dreamlands.handler.DreamingPlayerEvents.isDreaming;

@Mixin(CombatTracker.class)
public abstract class CombatTrackerMixins {
    @Shadow
    @Final
    private LivingEntity mob;

    @Inject(method = "getDeathMessage", at = @At("RETURN"), cancellable = true)
    private void overrideDeathMessage(CallbackInfoReturnable<Component> cir) {
        if (!(this.mob instanceof Player player)) return;

        Component message = cir.getReturnValue();

        if (isDreaming(player)) {
            message = Component.translatable("deathMessage.death.in_dream", message);
        }

        cir.setReturnValue(message);
    }

}