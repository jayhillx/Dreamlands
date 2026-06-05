package com.mystanica.dreamlands.datagen.provider.tag;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.datagen.*;
import com.mystanica.dreamlands.init.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public class DreamBlockTags extends BlockTagsProvider {
    public static final TagKey<Block> DREAMY_LOGS = BlockTags.create(Dreamlands.modLoc("dreamy_logs"));
    public static final TagKey<Block> ASPEN_LOGS = BlockTags.create(Dreamlands.modLoc("aspen_logs"));
    public static final TagKey<Block> EVERGREEN_LOGS = BlockTags.create(Dreamlands.modLoc("evergreen_logs"));
    public static final TagKey<Block> ETHEREAL_LOGS = BlockTags.create(Dreamlands.modLoc("ethereal_logs"));
    public static final TagKey<Block> CANDY_LOGS = BlockTags.create(Dreamlands.modLoc("candy_logs"));
    public static final TagKey<Block> WISTERIA_LOGS = BlockTags.create(Dreamlands.modLoc("wisteria_logs"));
    public static final TagKey<Block> MYSTICAL_LOGS = BlockTags.create(Dreamlands.modLoc("mystical_logs"));
    public static final TagKey<Block> MUSHROOM_STEMS = BlockTags.create(Dreamlands.modLoc("mushroom_stems"));

    public DreamBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, provider, Dreamlands.modId, helper);
    }

    @Override
    protected void addTags(@Nonnull HolderLookup.Provider provider) {
        DreamBlockFamilies.getAllFamilies().filter(DreamBlockFamily::shouldGenerateModel).forEach(this::generateFor);
        DreamGroups.getAllGroups().forEach(this::generateForGroups);
        this.tag(DREAMY_LOGS).add(
                DreamBlocks.DREAMY_LOG.get(),
                DreamBlocks.DREAMY_WOOD.get(),
                DreamBlocks.STRIPPED_DREAMY_LOG.get(),
                DreamBlocks.STRIPPED_DREAMY_WOOD.get()
        );
        this.tag(ASPEN_LOGS).add(
                DreamBlocks.ASPEN_LOG.get(),
                DreamBlocks.ASPEN_WOOD.get(),
                DreamBlocks.STRIPPED_ASPEN_LOG.get(),
                DreamBlocks.STRIPPED_ASPEN_WOOD.get()
        );
        this.tag(EVERGREEN_LOGS).add(
                DreamBlocks.EVERGREEN_LOG.get(),
                DreamBlocks.EVERGREEN_WOOD.get(),
                DreamBlocks.STRIPPED_EVERGREEN_LOG.get(),
                DreamBlocks.STRIPPED_EVERGREEN_WOOD.get()
        );
        this.tag(ETHEREAL_LOGS).add(
                DreamBlocks.ETHEREAL_LOG.get(),
                DreamBlocks.ETHEREAL_WOOD.get(),
                DreamBlocks.STRIPPED_ETHEREAL_LOG.get(),
                DreamBlocks.STRIPPED_ETHEREAL_WOOD.get()
        );
        this.tag(CANDY_LOGS).add(
                DreamBlocks.CANDY_LOG.get(),
                DreamBlocks.CANDY_WOOD.get(),
                DreamBlocks.STRIPPED_CANDY_LOG.get(),
                DreamBlocks.STRIPPED_CANDY_WOOD.get()
        );
        this.tag(WISTERIA_LOGS).add(
                DreamBlocks.WISTERIA_LOG.get(),
                DreamBlocks.WISTERIA_WOOD.get(),
                DreamBlocks.STRIPPED_WISTERIA_LOG.get(),
                DreamBlocks.STRIPPED_WISTERIA_WOOD.get()
        );
        this.tag(MYSTICAL_LOGS).add(
                DreamBlocks.MYSTICAL_LOG.get(),
                DreamBlocks.MYSTICAL_WOOD.get(),
                DreamBlocks.STRIPPED_MYSTICAL_LOG.get(),
                DreamBlocks.STRIPPED_MYSTICAL_WOOD.get()
        );
        this.tag(MUSHROOM_STEMS).add(
                DreamBlocks.MUSHROOM_STEM.get(),
                DreamBlocks.MUSHROOM_HYPHAE.get(),
                DreamBlocks.STRIPPED_MUSHROOM_STEM.get(),
                DreamBlocks.STRIPPED_MUSHROOM_HYPHAE.get()
        );
        this.tag(BlockTags.LOGS_THAT_BURN)
                .addTag(DREAMY_LOGS)
                .addTag(ASPEN_LOGS)
                .addTag(EVERGREEN_LOGS)
                .addTag(ETHEREAL_LOGS)
                .addTag(CANDY_LOGS)
                .addTag(WISTERIA_LOGS)
                .addTag(MYSTICAL_LOGS)
                .addTag(MUSHROOM_STEMS)
                .replace(false);
        this.tag(BlockTags.DIRT).add(
                DreamBlocks.DREAMY_GRASS_BLOCK.get(),
                DreamBlocks.DREAMY_DIRT.get(),
                DreamBlocks.FOREST_MOSS_BLOCK.get()
        ).replace(false);
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                DreamBlocks.DREAMSTONE.get(),
                DreamBlocks.DREAMSTONE_STAIRS.get(),
                DreamBlocks.DREAMSTONE_SLAB.get(),
                DreamBlocks.DREAMSTONE_PRESSURE_PLATE.get(),
                DreamBlocks.DREAMSTONE_BUTTON.get(),
                DreamBlocks.DREAMSTONE_WALL.get(),
                DreamBlocks.COBBLED_DREAMSTONE.get(),
                DreamBlocks.COBBLED_DREAMSTONE_STAIRS.get(),
                DreamBlocks.COBBLED_DREAMSTONE_SLAB.get(),
                DreamBlocks.COBBLED_DREAMSTONE_WALL.get(),
                DreamBlocks.MOSSY_COBBLED_DREAMSTONE.get(),
                DreamBlocks.MOSSY_COBBLED_DREAMSTONE_STAIRS.get(),
                DreamBlocks.MOSSY_COBBLED_DREAMSTONE_SLAB.get(),
                DreamBlocks.MOSSY_COBBLED_DREAMSTONE_WALL.get(),
                DreamBlocks.DREAMSTONE_BRICKS.get(),
                DreamBlocks.DREAMSTONE_BRICK_STAIRS.get(),
                DreamBlocks.DREAMSTONE_BRICK_SLAB.get(),
                DreamBlocks.DREAMSTONE_BRICK_WALL.get(),
                DreamBlocks.CRACKED_DREAMSTONE_BRICKS.get(),
                DreamBlocks.CHISELED_DREAMSTONE_BRICKS.get(),
                DreamBlocks.MOSSY_DREAMSTONE_BRICKS.get(),
                DreamBlocks.MOSSY_DREAMSTONE_BRICK_STAIRS.get(),
                DreamBlocks.MOSSY_DREAMSTONE_BRICK_SLAB.get(),
                DreamBlocks.MOSSY_DREAMSTONE_BRICK_WALL.get()
        ).replace(false);
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                DreamBlocks.DREAMY_GRASS_BLOCK.get(),
                DreamBlocks.DREAMY_DIRT.get(),
                DreamBlocks.DREAMY_DIRT_PATH.get()
        ).replace(false);
        this.tag(BlockTags.REPLACEABLE_BY_TREES).add(
                DreamBlocks.DREAMY_GRASS.get(),
                DreamBlocks.TALL_DREAMY_GRASS.get(),
                DreamBlocks.GROUND_IVY.get(),
                DreamBlocks.CLOVERS.get(),
                DreamBlocks.WHITE_CLOVERS.get(),
                DreamBlocks.PINK_CLOVERS.get()
        ).replace(false);
        this.tag(BlockTags.ANIMALS_SPAWNABLE_ON).add(
                DreamBlocks.DREAMY_GRASS_BLOCK.get()
        ).replace(false);
    }

    private void generateFor(DreamBlockFamily family) {
        family.getVariants().forEach((variant, block) -> {
            boolean flag = family.isFlammable();
            switch (variant) {
                case PLANKS -> this.tag(BlockTags.PLANKS).add(block);
                case STAIRS -> this.tag(flag ? BlockTags.WOODEN_STAIRS : BlockTags.STAIRS).add(block);
                case SLAB -> this.tag(flag ? BlockTags.WOODEN_SLABS : BlockTags.SLABS).add(block);
                case FENCE -> this.tag(flag ? BlockTags.WOODEN_FENCES : BlockTags.FENCES).add(block);
                case FENCE_GATE -> this.tag(BlockTags.FENCE_GATES).add(block);
                case BUTTON -> this.tag(flag ? BlockTags.WOODEN_BUTTONS : BlockTags.STONE_BUTTONS).add(block);
                case PRESSURE_PLATE -> this.tag(flag ? BlockTags.WOODEN_PRESSURE_PLATES : BlockTags.STONE_PRESSURE_PLATES).add(block);
                case TRAPDOOR -> this.tag(flag ? BlockTags.WOODEN_TRAPDOORS : BlockTags.TRAPDOORS).add(block);
                case DOOR -> this.tag(flag ? BlockTags.WOODEN_DOORS : BlockTags.DOORS).add(block);
                case SIGN -> this.tag(BlockTags.STANDING_SIGNS).add(block);
                case WALL_SIGN -> this.tag(BlockTags.WALL_SIGNS).add(block);
                case HANGING_SIGN -> this.tag(BlockTags.CEILING_HANGING_SIGNS).add(block);
                case WALL_HANGING_SIGN -> this.tag(BlockTags.WALL_HANGING_SIGNS).add(block);
                case WALL -> this.tag(BlockTags.WALLS).add(block);
            }
        });
    }

    private void generateForGroups(DreamGroup group) {
        for (DreamGroup.Entry entry : group.entries()) {
            Block block = entry.asBlock();
            switch (group.getCategory()) {
                case LEAVES -> {
                    this.tag(BlockTags.LEAVES).add(block);
                    this.tag(BlockTags.REPLACEABLE_BY_TREES).add(block);
                }
                case SAPLINGS, SHRUBS -> this.tag(BlockTags.SAPLINGS).add(block);
                case SMALL_FLOWERS -> this.tag(BlockTags.SMALL_FLOWERS).add(block);
                case TALL_FLOWERS -> this.tag(BlockTags.TALL_FLOWERS).add(block);
            }
        }
    }

}