package com.dreamlands.data.generator.tag;

import com.dreamlands.Dreamlands;
import com.dreamlands.init.DreamItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public class DreamItemTags extends ItemTagsProvider {
    public static final TagKey<Item> EVERGREEN_LOGS = ItemTags.create(Dreamlands.modLoc("evergreen_logs"));
    public static final TagKey<Item> ETHEREAL_LOGS = ItemTags.create(Dreamlands.modLoc("ethereal_logs"));
    public static final TagKey<Item> CANDY_LOGS = ItemTags.create(Dreamlands.modLoc("candy_logs"));

    public DreamItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> future, ExistingFileHelper helper) {
        super(output, provider, future, Dreamlands.modId, helper);
    }

    @Override
    protected void addTags(@Nonnull HolderLookup.Provider provider) {
        tag(EVERGREEN_LOGS).add(DreamItems.EVERGREEN_LOG.get(), DreamItems.EVERGREEN_WOOD.get(), DreamItems.STRIPPED_EVERGREEN_LOG.get(), DreamItems.STRIPPED_EVERGREEN_WOOD.get());
        tag(ETHEREAL_LOGS).add(DreamItems.ETHEREAL_LOG.get(), DreamItems.ETHEREAL_WOOD.get(), DreamItems.STRIPPED_ETHEREAL_LOG.get(), DreamItems.STRIPPED_ETHEREAL_WOOD.get());
        tag(CANDY_LOGS).add(DreamItems.CANDY_LOG.get(), DreamItems.CANDY_WOOD.get(), DreamItems.STRIPPED_CANDY_LOG.get(), DreamItems.STRIPPED_CANDY_WOOD.get());
        tag(ItemTags.LOGS_THAT_BURN).addTag(EVERGREEN_LOGS).addTag(ETHEREAL_LOGS).addTag(CANDY_LOGS);
        tag(ItemTags.PLANKS).add(DreamItems.EVERGREEN_PLANKS.get(), DreamItems.ETHEREAL_PLANKS.get(), DreamItems.CANDY_PLANKS.get());
        tag(ItemTags.WOODEN_STAIRS).add(DreamItems.EVERGREEN_STAIRS.get(), DreamItems.ETHEREAL_STAIRS.get(), DreamItems.CANDY_STAIRS.get());
        tag(ItemTags.WOODEN_SLABS).add(DreamItems.EVERGREEN_SLAB.get(), DreamItems.ETHEREAL_SLAB.get(), DreamItems.CANDY_SLAB.get());
        tag(ItemTags.WOODEN_FENCES).add(DreamItems.EVERGREEN_FENCE.get(), DreamItems.ETHEREAL_FENCE.get(), DreamItems.CANDY_FENCE.get());
        tag(ItemTags.FENCE_GATES).add(DreamItems.EVERGREEN_FENCE_GATE.get(), DreamItems.ETHEREAL_FENCE_GATE.get(), DreamItems.CANDY_FENCE_GATE.get());
        tag(ItemTags.WOODEN_BUTTONS).add(DreamItems.EVERGREEN_BUTTON.get(), DreamItems.ETHEREAL_BUTTON.get(), DreamItems.CANDY_BUTTON.get());
        tag(ItemTags.WOODEN_PRESSURE_PLATES).add(DreamItems.EVERGREEN_PRESSURE_PLATE.get(), DreamItems.ETHEREAL_PRESSURE_PLATE.get(), DreamItems.CANDY_PRESSURE_PLATE.get());
        tag(ItemTags.WOODEN_TRAPDOORS).add(DreamItems.EVERGREEN_TRAPDOOR.get(), DreamItems.ETHEREAL_TRAPDOOR.get(), DreamItems.CANDY_TRAPDOOR.get());
        tag(ItemTags.WOODEN_DOORS).add(DreamItems.EVERGREEN_DOOR.get(), DreamItems.ETHEREAL_DOOR.get(), DreamItems.CANDY_DOOR.get());
        tag(ItemTags.SIGNS).add(DreamItems.EVERGREEN_SIGN.get(), DreamItems.ETHEREAL_SIGN.get(), DreamItems.CANDY_SIGN.get());
        tag(ItemTags.HANGING_SIGNS).add(DreamItems.EVERGREEN_HANGING_SIGN.get(), DreamItems.ETHEREAL_HANGING_SIGN.get(), DreamItems.CANDY_HANGING_SIGN.get());
    }

}