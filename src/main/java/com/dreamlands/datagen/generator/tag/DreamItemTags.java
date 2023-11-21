package com.dreamlands.datagen.generator.tag;

import com.dreamlands.Dreamlands;
import com.dreamlands.init.DreamItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public class DreamItemTags extends ItemTagsProvider {

    public DreamItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> future, ExistingFileHelper helper) {
        super(output, provider, future, Dreamlands.modId, helper);
    }

    @Override
    protected void addTags(@Nonnull HolderLookup.Provider provider) {
        tag(ItemTags.PLANKS).add(DreamItems.EVERGREEN_PLANKS.get(), DreamItems.ETHEREAL_PLANKS.get(), DreamItems.CANDY_PLANKS.get(), DreamItems.EBONY_PLANKS.get(), DreamItems.DEAD_PLANKS.get(), DreamItems.BLOODWOOD_PLANKS.get());
    }

}