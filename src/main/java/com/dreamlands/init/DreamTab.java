package com.dreamlands.init;

import com.dreamlands.Dreamlands;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DreamTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Dreamlands.modId);

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_TABS.register("tab", DreamTab::tab);

    private static CreativeModeTab tab() {
        return CreativeModeTab.builder().title(Component.translatable("itemGroup.dreamlands.tab")).icon(DreamItems.DREAMY_MUSHROOM.get()::getDefaultInstance).displayItems((parameters, output) -> {
            output.accept(DreamItems.EVERGREEN_PLANKS.get());
            output.accept(DreamItems.ETHEREAL_PLANKS.get());
            output.accept(DreamItems.CANDY_PLANKS.get());
            output.accept(DreamItems.DREAMY_MUSHROOM.get());
            output.accept(DreamItems.DREAMY_MUSHROOM_SOUP.get());
            output.accept(DreamItems.MARSHMALLOW.get());
            output.accept(DreamItems.TOASTED_MARSHMALLOW.get());
            output.accept(DreamItems.BURNT_MARSHMALLOW.get());
        }).build();
    }

}