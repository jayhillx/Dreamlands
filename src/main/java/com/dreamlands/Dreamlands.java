package com.dreamlands;

import com.dreamlands.init.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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
        DreamItems.ITEMS.register(bus);
        DreamTab.CREATIVE_TABS.register(bus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            DreamVanillaCompat.Common.registerFlammables();
            DreamVanillaCompat.Common.registerCompostables();
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

}