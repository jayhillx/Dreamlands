package io.github.jay.dreamlands.common.event;

import io.github.jay.dreamlands.common.capability.DreamingCapability;
import io.github.jay.dreamlands.Dreamlands;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CapabilityEvents {

    @SubscribeEvent
    public void registerCapability(RegisterCapabilitiesEvent event) {
        event.register(DreamingCapability.class);
    }

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            event.addCapability(Dreamlands.modLoc("dreaming"), new DreamingCapability());
        }
    }

}