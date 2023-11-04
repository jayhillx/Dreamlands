package io.github.jay.dreamlands;

import io.github.jay.dreamlands.common.event.CapabilityEvents;
import io.github.jay.dreamlands.common.event.DreamingEvents;
import io.github.jay.dreamlands.core.init.DreamBlocks;
import io.github.jay.dreamlands.core.init.DreamEntities;
import io.github.jay.dreamlands.core.init.DreamItems;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("dreamlands")
public class Dreamlands {
    public static final String modId = "dreamlands";

    public static ResourceLocation modLoc(String path) {
        return new ResourceLocation(modId, path);
    }

    public static <T> ResourceKey<T> createKey(ResourceKey<Registry<T>> registry, String name) {
        return ResourceKey.create(registry, modLoc(name));
    }

    public Dreamlands() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);

        DreamBlocks.BLOCKS.register(bus);
        DreamEntities.ENTITIES.register(bus);
        DreamItems.ITEMS.register(bus);

        MinecraftForge.EVENT_BUS.register(new CapabilityEvents());
        MinecraftForge.EVENT_BUS.register(new DreamingEvents());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

}