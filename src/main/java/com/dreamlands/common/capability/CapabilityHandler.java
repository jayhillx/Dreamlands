package com.dreamlands.common.capability;

import com.dreamlands.Dreamlands;
import com.dreamlands.common.capability.player.DreamingCapability;
import com.dreamlands.common.capability.player.DreamingInformation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CapabilityHandler {

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

    @SubscribeEvent
    public void cloneCapability(PlayerEvent.Clone event) {
        LazyOptional<DreamingInformation> capability = event.getOriginal().getCapability(DreamingCapability.DREAMING_DATA);
        capability.ifPresent(oldStore -> event.getEntity().getCapability(DreamingCapability.DREAMING_DATA).ifPresent(newStore -> newStore.clone(oldStore)));
    }

}