package com.dreamlands.datagen.generator.tag;

import com.dreamlands.Dreamlands;
import com.dreamlands.init.DreamBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public class DreamBlockTags extends BlockTagsProvider {

    public DreamBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, provider, Dreamlands.modId, helper);
    }

    @Override
    protected void addTags(@Nonnull HolderLookup.Provider provider) {
        tag(BlockTags.PLANKS).add(DreamBlocks.EVERGREEN_PLANKS.get(), DreamBlocks.ETHEREAL_PLANKS.get(), DreamBlocks.CANDY_PLANKS.get());
    }

}