package com.dreamlands.common.event;

import com.dreamlands.common.capability.player.DreamingCapability;
import com.dreamlands.common.util.TeleporterUtils;
import com.dreamlands.datagen.registry.DreamDimensions;
import com.dreamlands.init.DreamItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

public class SleepEvents {

    public void onConsumeSoup(LivingEntityUseItemEvent.Finish event) {
        if (event.getEntity() instanceof Player player) {
            if (player.getUseItem().is(DreamItems.DREAMY_MUSHROOM_SOUP.get())) {
                player.getCapability(DreamingCapability.DREAMING_DATA).ifPresent((dreaming) -> {
                    dreaming.setWillHaveDream(true);
                });
            }
        }
    }

    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        if (event.phase == TickEvent.Phase.START && player.getServer() != null) {
            player.getCapability(DreamingCapability.DREAMING_DATA).ifPresent((dreaming) -> {
                ServerLevel level = player.getServer().getLevel(DreamDimensions.DREAMLAND);

                if (player.isSleepingLongEnough() && dreaming.willHaveDream() && level != null) {
                    player.changeDimension(level, new TeleporterUtils());
                }

                if (player.level().dimension() == DreamDimensions.DREAMLAND && player.getServer().overworld().isDay()) {
                    player.changeDimension(player.getServer().overworld(), new TeleporterUtils());
                    dreaming.setWillHaveDream(false);
                }
            });
        }
    }

}