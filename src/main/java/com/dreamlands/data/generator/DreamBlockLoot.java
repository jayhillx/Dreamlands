package com.dreamlands.data.generator;

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
        this.dropSelf(DreamBlocks.DREAMY_MUSHROOM.get());

        this.dropSelf(DreamBlocks.EVERGREEN_LOG.get());
        this.dropSelf(DreamBlocks.STRIPPED_EVERGREEN_LOG.get());
        this.dropSelf(DreamBlocks.EVERGREEN_WOOD.get());
        this.dropSelf(DreamBlocks.STRIPPED_EVERGREEN_WOOD.get());
        this.dropSelf(DreamBlocks.EVERGREEN_PLANKS.get());
        this.dropSelf(DreamBlocks.EVERGREEN_STAIRS.get());
        this.add(DreamBlocks.EVERGREEN_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(DreamBlocks.EVERGREEN_FENCE.get());
        this.dropSelf(DreamBlocks.EVERGREEN_FENCE_GATE.get());
        this.dropSelf(DreamBlocks.EVERGREEN_BUTTON.get());
        this.dropSelf(DreamBlocks.EVERGREEN_PRESSURE_PLATE.get());
        this.dropSelf(DreamBlocks.EVERGREEN_TRAPDOOR.get());
        this.add(DreamBlocks.EVERGREEN_DOOR.get(), this::createDoorTable);
        this.dropSelf(DreamBlocks.EVERGREEN_SIGN.get());
        this.dropSelf(DreamBlocks.EVERGREEN_WALL_SIGN.get());
        this.dropSelf(DreamBlocks.EVERGREEN_HANGING_SIGN.get());
        this.dropSelf(DreamBlocks.EVERGREEN_WALL_HANGING_SIGN.get());

        this.dropSelf(DreamBlocks.ETHEREAL_LOG.get());
        this.dropSelf(DreamBlocks.STRIPPED_ETHEREAL_LOG.get());
        this.dropSelf(DreamBlocks.ETHEREAL_WOOD.get());
        this.dropSelf(DreamBlocks.STRIPPED_ETHEREAL_WOOD.get());
        this.dropSelf(DreamBlocks.ETHEREAL_PLANKS.get());
        this.dropSelf(DreamBlocks.ETHEREAL_STAIRS.get());
        this.add(DreamBlocks.ETHEREAL_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(DreamBlocks.ETHEREAL_FENCE.get());
        this.dropSelf(DreamBlocks.ETHEREAL_FENCE_GATE.get());
        this.dropSelf(DreamBlocks.ETHEREAL_BUTTON.get());
        this.dropSelf(DreamBlocks.ETHEREAL_PRESSURE_PLATE.get());
        this.dropSelf(DreamBlocks.ETHEREAL_TRAPDOOR.get());
        this.add(DreamBlocks.ETHEREAL_DOOR.get(), this::createDoorTable);
        this.dropSelf(DreamBlocks.ETHEREAL_SIGN.get());
        this.dropSelf(DreamBlocks.ETHEREAL_WALL_SIGN.get());
        this.dropSelf(DreamBlocks.ETHEREAL_HANGING_SIGN.get());
        this.dropSelf(DreamBlocks.ETHEREAL_WALL_HANGING_SIGN.get());

        this.dropSelf(DreamBlocks.CANDY_LOG.get());
        this.dropSelf(DreamBlocks.STRIPPED_CANDY_LOG.get());
        this.dropSelf(DreamBlocks.CANDY_WOOD.get());
        this.dropSelf(DreamBlocks.STRIPPED_CANDY_WOOD.get());
        this.dropSelf(DreamBlocks.CANDY_PLANKS.get());
        this.dropSelf(DreamBlocks.CANDY_STAIRS.get());
        this.add(DreamBlocks.CANDY_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(DreamBlocks.CANDY_FENCE.get());
        this.dropSelf(DreamBlocks.CANDY_FENCE_GATE.get());
        this.dropSelf(DreamBlocks.CANDY_BUTTON.get());
        this.dropSelf(DreamBlocks.CANDY_PRESSURE_PLATE.get());
        this.dropSelf(DreamBlocks.CANDY_TRAPDOOR.get());
        this.add(DreamBlocks.CANDY_DOOR.get(), this::createDoorTable);
        this.dropSelf(DreamBlocks.CANDY_SIGN.get());
        this.dropSelf(DreamBlocks.CANDY_WALL_SIGN.get());
        this.dropSelf(DreamBlocks.CANDY_HANGING_SIGN.get());
        this.dropSelf(DreamBlocks.CANDY_WALL_HANGING_SIGN.get());
    }

    @Override
    @Nonnull
    public Iterable<Block> getKnownBlocks() {
        return DreamBlocks.BLOCKS.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
    }

}