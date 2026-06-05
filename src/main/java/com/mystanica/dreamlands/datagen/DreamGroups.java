package com.mystanica.dreamlands.datagen;

import com.mystanica.dreamlands.init.DreamBlocks;

import java.util.*;
import java.util.stream.Stream;

public final class DreamGroups {
    static final Map<DreamGroup.Category, DreamGroup> GROUPS = new LinkedHashMap<>();

    public static final DreamGroup LEAVES = DreamGroup.builder(DreamGroup.Category.LEAVES).entries((entry) -> {
        entry.accept(DreamBlocks.FOREST_SHRUB_LEAVES.get());
        entry.accept(DreamBlocks.DREAMY_LEAVES.get());
        entry.accept(DreamBlocks.ASPEN_LEAVES.get());
        entry.accept(DreamBlocks.EVERGREEN_LEAVES.get());
        entry.accept(DreamBlocks.ETHEREAL_LEAVES.get());
        entry.accept(DreamBlocks.LILAC_BUSH_LEAVES.get());
        entry.accept(DreamBlocks.WISTERIA_LEAVES.get());
        entry.accept(DreamBlocks.WISTERIA_BLOSSOMS.get());
        entry.accept(DreamBlocks.MYSTICAL_LEAVES.get());
        entry.accept(DreamBlocks.FAIRY_ROSE_BUSH_LEAVES.get());
    }).build();

    public static final DreamGroup SAPLINGS = DreamGroup.builder(DreamGroup.Category.SAPLINGS).entries((entry) -> {
        entry.accept(DreamBlocks.FOREST_SHRUB.get());
        entry.accept(DreamBlocks.DREAMY_SAPLING.get());
        entry.accept(DreamBlocks.ASPEN_SAPLING.get());
        entry.accept(DreamBlocks.EVERGREEN_SAPLING.get());
        entry.accept(DreamBlocks.ETHEREAL_SAPLING.get());
        entry.accept(DreamBlocks.LILAC_BUSH.get());
        entry.accept(DreamBlocks.PINK_COTTON_CANDY_SAPLING.get());
        entry.accept(DreamBlocks.BLUE_COTTON_CANDY_SAPLING.get());
        entry.accept(DreamBlocks.WISTERIA_SAPLING.get());
        entry.accept(DreamBlocks.MYSTICAL_SAPLING.get());
        entry.accept(DreamBlocks.FAIRY_ROSE_BUSH.get());
    }).build();

    public static final DreamGroup SMALL_FLOWERS = DreamGroup.builder(DreamGroup.Category.SMALL_FLOWERS).entries((entry) -> {
        entry.accept(DreamBlocks.PERIWINKLE.get());
        entry.accept(DreamBlocks.PETUNIA.get());
        entry.accept(DreamBlocks.PINK_HYACINTH.get());
        entry.accept(DreamBlocks.MAGENTA_HYACINTH.get());
        entry.accept(DreamBlocks.PURPLE_HYACINTH.get());
        entry.accept(DreamBlocks.VIOLETS.get());
    }).build();

    public static final DreamGroup TALL_FLOWERS = DreamGroup.builder(DreamGroup.Category.TALL_FLOWERS).entries((entry) -> {
        ///entry.accept(DreamBlocks.PINK_PUFFBALL.get());
        entry.accept(DreamBlocks.PINK_FOXGLOVE.get());
        entry.accept(DreamBlocks.PURPLE_LUPINE.get());
    }).build();

    public static Stream<DreamGroup> getAllGroups() {
        return GROUPS.values().stream();
    }

    public static DreamGroup get(DreamGroup.Category category) {
        return GROUPS.get(category);
    }

    static void register(DreamGroup.Category category, DreamGroup group) {
        GROUPS.put(category, group);
    }

}