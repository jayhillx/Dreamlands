package com.mystanica.dreamlands.datagen.provider.tag;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.datagen.DreamBlockFamilies;
import com.mystanica.dreamlands.datagen.DreamBlockFamily;
import com.mystanica.dreamlands.datagen.DreamGroup;
import com.mystanica.dreamlands.datagen.DreamGroups;
import com.mystanica.dreamlands.init.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public class DreamItemTags extends ItemTagsProvider {
    public static final TagKey<Item> DREAMY_LOGS = ItemTags.create(Dreamlands.modLoc("dreamy_logs"));
    public static final TagKey<Item> ASPEN_LOGS = ItemTags.create(Dreamlands.modLoc("aspen_logs"));
    public static final TagKey<Item> EVERGREEN_LOGS = ItemTags.create(Dreamlands.modLoc("evergreen_logs"));
    public static final TagKey<Item> ETHEREAL_LOGS = ItemTags.create(Dreamlands.modLoc("ethereal_logs"));
    public static final TagKey<Item> CANDY_LOGS = ItemTags.create(Dreamlands.modLoc("candy_logs"));
    public static final TagKey<Item> WISTERIA_LOGS = ItemTags.create(Dreamlands.modLoc("wisteria_logs"));
    public static final TagKey<Item> MYSTICAL_LOGS = ItemTags.create(Dreamlands.modLoc("mystical_logs"));
    public static final TagKey<Item> MUSHROOM_STEMS = ItemTags.create(Dreamlands.modLoc("mushroom_stems"));

    public DreamItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, provider, blockTags);
    }

    @Override
    protected void addTags(@Nonnull HolderLookup.Provider provider) {
        DreamBlockFamilies.getAllFamilies().filter(DreamBlockFamily::shouldGenerateModel).forEach(this::generateFor);
        DreamGroups.getAllGroups().forEach(this::generateForGroups);
        this.copy(DreamBlockTags.DREAMY_LOGS, DreamItemTags.DREAMY_LOGS);
        this.copy(DreamBlockTags.ASPEN_LOGS, DreamItemTags.ASPEN_LOGS);
        this.copy(DreamBlockTags.EVERGREEN_LOGS, DreamItemTags.EVERGREEN_LOGS);
        this.copy(DreamBlockTags.ETHEREAL_LOGS, DreamItemTags.ETHEREAL_LOGS);
        this.copy(DreamBlockTags.CANDY_LOGS, DreamItemTags.CANDY_LOGS);
        this.copy(DreamBlockTags.WISTERIA_LOGS, DreamItemTags.WISTERIA_LOGS);
        this.copy(DreamBlockTags.MYSTICAL_LOGS, DreamItemTags.MYSTICAL_LOGS);
        this.copy(DreamBlockTags.MUSHROOM_STEMS, DreamItemTags.MUSHROOM_STEMS);

        this.tag(ItemTags.LOGS_THAT_BURN)
                .addTag(DREAMY_LOGS)
                .addTag(ASPEN_LOGS)
                .addTag(EVERGREEN_LOGS)
                .addTag(ETHEREAL_LOGS)
                .addTag(CANDY_LOGS)
                .addTag(WISTERIA_LOGS)
                .addTag(MYSTICAL_LOGS)
                .addTag(MUSHROOM_STEMS)
                .replace(false);
        this.tag(ItemTags.DIRT).add(
                DreamItems.DREAMY_GRASS_BLOCK.get(),
                DreamItems.DREAMY_DIRT.get(),
                DreamItems.FOREST_MOSS_BLOCK.get()
        ).replace(false);
    }

    private void generateFor(DreamBlockFamily family) {
        family.getVariants().forEach((variant, block) -> {
            boolean flag = family.isFlammable();
            switch (variant) {
                case PLANKS -> this.tag(ItemTags.PLANKS).add(block.asItem());
                case STAIRS -> this.tag(flag ? ItemTags.WOODEN_STAIRS : ItemTags.STAIRS).add(block.asItem());
                case SLAB -> this.tag(flag ? ItemTags.WOODEN_SLABS : ItemTags.SLABS).add(block.asItem());
                case FENCE -> this.tag(flag ? ItemTags.WOODEN_FENCES : ItemTags.FENCES).add(block.asItem());
                case FENCE_GATE -> this.tag(ItemTags.FENCE_GATES).add(block.asItem());
                case BUTTON -> this.tag(flag ? ItemTags.WOODEN_BUTTONS : ItemTags.STONE_BUTTONS).add(block.asItem());
                case PRESSURE_PLATE -> {
                    if (flag) {
                        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(block.asItem());
                    }
                }
                case TRAPDOOR -> this.tag(flag ? ItemTags.WOODEN_TRAPDOORS : ItemTags.TRAPDOORS).add(block.asItem());
                case DOOR -> this.tag(flag ? ItemTags.WOODEN_DOORS : ItemTags.DOORS).add(block.asItem());
                case SIGN -> this.tag(ItemTags.SIGNS).add(block.asItem());
                case HANGING_SIGN -> this.tag(ItemTags.HANGING_SIGNS).add(block.asItem());
                case WALL -> this.tag(ItemTags.WALLS).add(block.asItem());
            }
        });
    }

    private void generateForGroups(DreamGroup group) {
        for (DreamGroup.Entry entry : group.entries()) {
            Item item = entry.asItem();
            switch (group.getCategory()) {
                case LEAVES -> this.tag(ItemTags.LEAVES).add(item);
                case SAPLINGS, SHRUBS -> this.tag(ItemTags.SAPLINGS).add(item);
                case SMALL_FLOWERS -> this.tag(ItemTags.SMALL_FLOWERS).add(item);
                case TALL_FLOWERS -> this.tag(ItemTags.TALL_FLOWERS).add(item);
            }
        }
    }

}