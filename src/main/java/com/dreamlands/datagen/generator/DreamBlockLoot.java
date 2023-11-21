package com.dreamlands.datagen.generator;

import com.dreamlands.init.DreamBlocks;
import com.dreamlands.init.DreamItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nonnull;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DreamBlockLoot extends BlockLootSubProvider {
    private static final Set<Item> EXPLOSION_RESISTANT = Stream.of(DreamItems.MARSHMALLOW.get()).map(ItemLike::asItem).collect(Collectors.toSet());

    public DreamBlockLoot() {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(DreamBlocks.EVERGREEN_PLANKS.get());
        dropSelf(DreamBlocks.ETHEREAL_PLANKS.get());
        dropSelf(DreamBlocks.CANDY_PLANKS.get());

        dropSelf(DreamBlocks.DREAMY_MUSHROOM.get());
    }

    @Override
    @Nonnull
    public Iterable<Block> getKnownBlocks() {
        return DreamBlocks.BLOCKS.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
    }

}