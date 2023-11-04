package io.github.jay.dreamlands.common.event;

import io.github.jay.dreamlands.common.capability.DreamingCapability;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DreamingEvents {

    @SubscribeEvent
    public void onConsumeSoup(LivingEntityUseItemEvent.Finish event) {
        if (event.getEntity() instanceof Player player) {

            if (event.getItem().is(Items.MUSHROOM_STEW)) {
                player.getCapability(DreamingCapability.DREAMING_DATA).ifPresent((data) -> {
                    data.setWillHaveDream(true);
                });
            }
        }
    }

    @SubscribeEvent
    public void onSleep(PlayerSleepInBedEvent event) {
        Player player = event.getEntity();

        if (player.getServer() != null) {
            player.getCapability(DreamingCapability.DREAMING_DATA).ifPresent((data) -> {

                if (data.willHaveDream()) {
                    ServerLevel level = player.getServer().getLevel(Level.NETHER);
                    player.changeDimension(level);
                }
            });
        }
    }

}