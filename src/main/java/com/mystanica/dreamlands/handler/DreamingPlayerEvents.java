package com.mystanica.dreamlands.handler;

import com.mystanica.dreamlands.init.DreamDimensions;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.mystanica.dreamlands.handler.util.SleepingPlayerEntityUtils.*;

/**
 * events for a player that's actively in a dream.
 */
public class DreamingPlayerEvents {

    @SubscribeEvent
    public void effectExpiry(MobEffectEvent.Expired event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            if (player.getServer() != null && isDreaming(player)) {
                sendToDimension(player, player.getServer().overworld());
            }
        }
    }

    @SubscribeEvent
    public void effectRemoved(MobEffectEvent.Remove event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            if (player.getServer() != null && isDreaming(player)) {
                sendToDimension(player, player.getServer().overworld());
            }
        }
    }

    @SubscribeEvent
    public void playerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Player player = event.getEntity();

        if (player.getServer() != null) {
            wakePlayer(player.getServer().overworld(), (ServerPlayer)player);
        }
    }

    public static boolean isDreaming(Player player) {
        ResourceKey<Level> dimension = player.level().dimension();
        return dimension.equals(DreamDimensions.DREAMLAND);
    }

}