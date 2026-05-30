package com.mystanica.dreamlands.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.mystanica.dreamlands.handler.DreamingPlayerEvents.isDreaming;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixins {

    /**
     * prevent the player from dropping their inventory when they die in a dream, even if keep inventory is off.
     *  > eventually change this to drop and be stored in a grave.
     */
    @Inject(method = "dropAllDeathLoot", at = @At("HEAD"), cancellable = true)
    private void preventInventoryDropInDream(DamageSource source, CallbackInfo ci) {
        LivingEntity entity = (LivingEntity)(Object)this;

        if (entity instanceof Player player && player != null && player.getServer() != null) {
            boolean hasKeepInventory = player.getServer().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY);
            if (isDreaming(player) && !hasKeepInventory) { /// is dreaming and does NOT have keep inventory on.
                ci.cancel(); /// then cancel the drops from happening. (?)
            }
        }
    }

}