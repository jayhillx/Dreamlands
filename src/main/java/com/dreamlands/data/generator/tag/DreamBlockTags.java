package com.dreamlands.data.generator.tag;

import com.dreamlands.Dreamlands;
import com.dreamlands.init.DreamBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public class DreamBlockTags extends BlockTagsProvider {
    public static final TagKey<Block> EVERGREEN_LOGS = BlockTags.create(Dreamlands.modLoc("evergreen_logs"));
    public static final TagKey<Block> ETHEREAL_LOGS = BlockTags.create(Dreamlands.modLoc("ethereal_logs"));
    public static final TagKey<Block> CANDY_LOGS = BlockTags.create(Dreamlands.modLoc("candy_logs"));

    public DreamBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, provider, Dreamlands.modId, helper);
    }

    @Override
    protected void addTags(@Nonnull HolderLookup.Provider provider) {
        tag(EVERGREEN_LOGS).add(DreamBlocks.EVERGREEN_LOG.get(), DreamBlocks.EVERGREEN_WOOD.get(), DreamBlocks.STRIPPED_EVERGREEN_LOG.get(), DreamBlocks.STRIPPED_EVERGREEN_WOOD.get());
        tag(ETHEREAL_LOGS).add(DreamBlocks.ETHEREAL_LOG.get(), DreamBlocks.ETHEREAL_WOOD.get(), DreamBlocks.STRIPPED_ETHEREAL_LOG.get(), DreamBlocks.STRIPPED_ETHEREAL_WOOD.get());
        tag(CANDY_LOGS).add(DreamBlocks.CANDY_LOG.get(), DreamBlocks.CANDY_WOOD.get(), DreamBlocks.STRIPPED_CANDY_LOG.get(), DreamBlocks.STRIPPED_CANDY_WOOD.get());
        tag(BlockTags.LOGS_THAT_BURN).addTag(EVERGREEN_LOGS).addTag(ETHEREAL_LOGS).addTag(CANDY_LOGS);
        tag(BlockTags.PLANKS).add(DreamBlocks.EVERGREEN_PLANKS.get(), DreamBlocks.ETHEREAL_PLANKS.get(), DreamBlocks.CANDY_PLANKS.get());
        tag(BlockTags.WOODEN_STAIRS).add(DreamBlocks.EVERGREEN_STAIRS.get(), DreamBlocks.ETHEREAL_STAIRS.get(), DreamBlocks.CANDY_STAIRS.get());
        tag(BlockTags.WOODEN_SLABS).add(DreamBlocks.EVERGREEN_SLAB.get(), DreamBlocks.ETHEREAL_SLAB.get(), DreamBlocks.CANDY_SLAB.get());
        tag(BlockTags.WOODEN_FENCES).add(DreamBlocks.EVERGREEN_FENCE.get(), DreamBlocks.ETHEREAL_FENCE.get(), DreamBlocks.CANDY_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(DreamBlocks.EVERGREEN_FENCE_GATE.get(), DreamBlocks.ETHEREAL_FENCE_GATE.get(), DreamBlocks.CANDY_FENCE_GATE.get());
        tag(BlockTags.WOODEN_BUTTONS).add(DreamBlocks.EVERGREEN_BUTTON.get(), DreamBlocks.ETHEREAL_BUTTON.get(), DreamBlocks.CANDY_BUTTON.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(DreamBlocks.EVERGREEN_PRESSURE_PLATE.get(), DreamBlocks.ETHEREAL_PRESSURE_PLATE.get(), DreamBlocks.CANDY_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_TRAPDOORS).add(DreamBlocks.EVERGREEN_TRAPDOOR.get(), DreamBlocks.ETHEREAL_TRAPDOOR.get(), DreamBlocks.CANDY_TRAPDOOR.get());
        tag(BlockTags.WOODEN_DOORS).add(DreamBlocks.EVERGREEN_DOOR.get(), DreamBlocks.ETHEREAL_DOOR.get(), DreamBlocks.CANDY_DOOR.get());
        tag(BlockTags.STANDING_SIGNS).add(DreamBlocks.EVERGREEN_SIGN.get(), DreamBlocks.ETHEREAL_SIGN.get(), DreamBlocks.CANDY_SIGN.get());
        tag(BlockTags.WALL_SIGNS).add(DreamBlocks.EVERGREEN_WALL_SIGN.get(), DreamBlocks.ETHEREAL_WALL_SIGN.get(), DreamBlocks.CANDY_WALL_SIGN.get());
        tag(BlockTags.CEILING_HANGING_SIGNS).add(DreamBlocks.EVERGREEN_HANGING_SIGN.get(), DreamBlocks.ETHEREAL_HANGING_SIGN.get(), DreamBlocks.CANDY_HANGING_SIGN.get());
        tag(BlockTags.WALL_HANGING_SIGNS).add(DreamBlocks.EVERGREEN_WALL_HANGING_SIGN.get(), DreamBlocks.ETHEREAL_WALL_HANGING_SIGN.get(), DreamBlocks.CANDY_WALL_HANGING_SIGN.get());
    }

}