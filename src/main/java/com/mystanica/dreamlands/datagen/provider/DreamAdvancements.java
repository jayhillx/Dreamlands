package com.mystanica.dreamlands.datagen.provider;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.common.advancement.DreamAdvancementTrigger;
import com.mystanica.dreamlands.init.DreamItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class DreamAdvancements implements ForgeAdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        Advancement root = this.advancement(saver, "root",
                this.builder(null,
                        "root",
                        DreamItems.DREAMY_MUSHROOM.get(),
                        FrameType.TASK,
                        false,
                        false,
                        false
                ).addCriterion("slept_in_bed", PlayerTrigger.TriggerInstance.sleptInBed())
        );
        Advancement induceSleep = this.advancement(saver, "induce_dream",
                this.builder(root,
                                "induce_dream",
                                DreamItems.SMORE.get(),
                                FrameType.TASK,
                                true,
                                false,
                                false
                ).addCriterion("induce_dream", new DreamAdvancementTrigger.Instance(Dreamlands.modLoc("induce_dream"), ContextAwarePredicate.ANY))
        );
        Advancement dreamlandRoot = this.advancement(saver, "enter_dream",
                this.builder(induceSleep,
                        "enter_dream",
                        DreamItems.WISTERIA.get(),
                        FrameType.TASK,
                        true,
                        true,
                        false
                ).addCriterion("enter_dream", new DreamAdvancementTrigger.Instance(Dreamlands.modLoc("enter_dream"), ContextAwarePredicate.ANY))
        );
        this.advancement(saver, "woken_up_from_sleep",
                this.builder(dreamlandRoot, "woken_up_from_sleep", Items.PINK_BED, FrameType.TASK, true, true, true)
                        .addCriterion("woken_up_from_sleep", new DreamAdvancementTrigger.Instance(Dreamlands.modLoc("woken_up_from_sleep"), ContextAwarePredicate.ANY))
        );
    }

    private Advancement.Builder builder(@Nullable Advancement parent, String name, Item displayItem, FrameType frameType, boolean showToast, boolean announceChat, boolean hidden) {
        Advancement.Builder builder = Advancement.Builder.advancement().display(
                displayItem,
                Component.translatable("advancements.dreamlands." + name + ".title"),
                Component.translatable("advancements.dreamlands." + name + ".description"),
                null,
                frameType,
                showToast,
                announceChat,
                hidden
        );

        if (parent != null) {
            builder.parent(parent);
        }

        return builder;
    }

    private Advancement advancement(Consumer<Advancement> saver, String name, Advancement.Builder builder) {
        Advancement advancement = builder.build(Dreamlands.modLoc("dreamlands/" + name));
        saver.accept(advancement);
        return advancement;
    }

}