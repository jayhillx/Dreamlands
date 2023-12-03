package com.dreamlands.init;

import com.dreamlands.Dreamlands;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DreamTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Dreamlands.modId);

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_TABS.register("tab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.dreamlands.tab")).icon(DreamItems.DREAMY_MUSHROOM.get()::getDefaultInstance).displayItems((parameters, output) -> {
        output.accept(DreamItems.DREAMY_MUSHROOM.get());
        output.accept(DreamItems.DREAMY_MUSHROOM_SOUP.get());
        output.accept(DreamItems.SMORE.get());
        output.accept(DreamItems.MARSHMALLOW.get());
        output.accept(DreamItems.TOASTED_MARSHMALLOW.get());
        output.accept(DreamItems.BURNT_MARSHMALLOW.get());
        output.accept(DreamItems.MARSHMALLOW_ON_A_STICK.get());

        output.accept(DreamItems.EVERGREEN_LOG.get());
        output.accept(DreamItems.STRIPPED_EVERGREEN_LOG.get());
        output.accept(DreamItems.EVERGREEN_WOOD.get());
        output.accept(DreamItems.STRIPPED_EVERGREEN_WOOD.get());
        output.accept(DreamItems.EVERGREEN_PLANKS.get());
        output.accept(DreamItems.EVERGREEN_STAIRS.get());
        output.accept(DreamItems.EVERGREEN_SLAB.get());
        output.accept(DreamItems.EVERGREEN_FENCE.get());
        output.accept(DreamItems.EVERGREEN_FENCE_GATE.get());
        output.accept(DreamItems.EVERGREEN_BUTTON.get());
        output.accept(DreamItems.EVERGREEN_PRESSURE_PLATE.get());
        output.accept(DreamItems.EVERGREEN_TRAPDOOR.get());
        output.accept(DreamItems.EVERGREEN_DOOR.get());
        output.accept(DreamItems.EVERGREEN_SIGN.get());
        output.accept(DreamItems.EVERGREEN_HANGING_SIGN.get());

        output.accept(DreamItems.ETHEREAL_LOG.get());
        output.accept(DreamItems.STRIPPED_ETHEREAL_LOG.get());
        output.accept(DreamItems.ETHEREAL_WOOD.get());
        output.accept(DreamItems.STRIPPED_ETHEREAL_WOOD.get());
        output.accept(DreamItems.ETHEREAL_PLANKS.get());
        output.accept(DreamItems.ETHEREAL_STAIRS.get());
        output.accept(DreamItems.ETHEREAL_SLAB.get());
        output.accept(DreamItems.ETHEREAL_FENCE.get());
        output.accept(DreamItems.ETHEREAL_FENCE_GATE.get());
        output.accept(DreamItems.ETHEREAL_BUTTON.get());
        output.accept(DreamItems.ETHEREAL_PRESSURE_PLATE.get());
        output.accept(DreamItems.ETHEREAL_TRAPDOOR.get());
        output.accept(DreamItems.ETHEREAL_DOOR.get());
        output.accept(DreamItems.ETHEREAL_SIGN.get());
        output.accept(DreamItems.ETHEREAL_HANGING_SIGN.get());

        output.accept(DreamItems.CANDY_LOG.get());
        output.accept(DreamItems.STRIPPED_CANDY_LOG.get());
        output.accept(DreamItems.CANDY_WOOD.get());
        output.accept(DreamItems.STRIPPED_CANDY_WOOD.get());
        output.accept(DreamItems.CANDY_PLANKS.get());
        output.accept(DreamItems.CANDY_STAIRS.get());
        output.accept(DreamItems.CANDY_SLAB.get());
        output.accept(DreamItems.CANDY_FENCE.get());
        output.accept(DreamItems.CANDY_FENCE_GATE.get());
        output.accept(DreamItems.CANDY_BUTTON.get());
        output.accept(DreamItems.CANDY_PRESSURE_PLATE.get());
        output.accept(DreamItems.CANDY_TRAPDOOR.get());
        output.accept(DreamItems.CANDY_DOOR.get());
        output.accept(DreamItems.CANDY_SIGN.get());
        output.accept(DreamItems.CANDY_HANGING_SIGN.get());
    }).build());

}