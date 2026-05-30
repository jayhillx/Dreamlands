package com.mystanica.dreamlands.mixin;

import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Unit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixins {

    @Inject(method = "startSleepInBed", at = @At(value = "HEAD"))
    private void startDreamSleep(BlockPos pos, CallbackInfoReturnable<Either<Player.BedSleepingProblem, Unit>> callback) {

    }

}