package com.mystanica.dreamlands.init;

import com.mystanica.dreamlands.common.block.util.BlockDataUtils;
import com.mystanica.dreamlands.datagen.DreamBlockFamilies;
import com.mystanica.dreamlands.datagen.DreamBlockFamily;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.block.Block;

public class DreamCompat {

    public static void registerFlammables() {
        DreamBlockFamilies.getAllFamilies().filter(DreamBlockFamily::isFlammable).forEach(DreamCompat::flammableWood);
        flammablePlants(DreamBlocks.DREAMY_GRASS.get());
        flammablePlants(DreamBlocks.TALL_DREAMY_GRASS.get());
        ///flammablePlants(DreamBlocks.FOREST_GRASS.get());
        ///flammablePlants(DreamBlocks.TALL_FOREST_GRASS.get());
        flammableLeaves(DreamBlocks.FOREST_SHRUB_LEAVES.get());
        flammablePlants(DreamBlocks.FOREST_SHRUB.get());
        flammablePlants(DreamBlocks.GROUND_IVY.get());
        flammablePlants(DreamBlocks.CLOVERS.get());
        flammablePlants(DreamBlocks.WHITE_CLOVERS.get());
        flammablePlants(DreamBlocks.PINK_CLOVERS.get());
        flammablePlants(DreamBlocks.PETUNIA.get());
        flammablePlants(DreamBlocks.PERIWINKLE.get());
        ///flammablePlants(DreamBlocks.PINK_PUFFBALL.get());
        flammablePlants(DreamBlocks.PINK_FOXGLOVE.get());
        flammablePlants(DreamBlocks.PINK_HYACINTH.get());
        flammablePlants(DreamBlocks.MAGENTA_HYACINTH.get());
        flammablePlants(DreamBlocks.PURPLE_HYACINTH.get());
        flammablePlants(DreamBlocks.PURPLE_LUPINE.get());
        flammablePlants(DreamBlocks.VIOLETS.get());
        ///////////////////////////////////////
        flammableLeaves(DreamBlocks.DREAMY_LEAVES.get());
        flammableLeaves(DreamBlocks.ASPEN_LEAVES.get());
        flammableLeaves(DreamBlocks.EVERGREEN_LEAVES.get());
        flammableLeaves(DreamBlocks.ETHEREAL_LEAVES.get());
        flammableLeaves(DreamBlocks.LILAC_BUSH_LEAVES.get());
        flammablePlants(DreamBlocks.LILAC_BUSH.get());
        flammableLeaves(DreamBlocks.WISTERIA_LEAVES.get());
        flammableLeaves(DreamBlocks.WISTERIA_BLOSSOMS.get());
        flammablePlants(DreamBlocks.WISTERIA.get());
        flammablePlants(DreamBlocks.WISTERIA_PLANT.get());
        flammablePlants(DreamBlocks.WALL_WISTERIA.get());
        flammableLeaves(DreamBlocks.MYSTICAL_LEAVES.get());
        flammableLeaves(DreamBlocks.FAIRY_ROSE_BUSH_LEAVES.get());
        flammablePlants(DreamBlocks.FAIRY_ROSE_BUSH.get());
        ///////////////////////////////////////
        ///flammableLeaves(DreamBlocks.GLOOMY_LEAVES.get());
        ///flammableLeaves(DreamBlocks.GRIMWOOD_LEAVES.get());
        ///flammableLeaves(DreamBlocks.DEAD_LEAVES.get());
        ///flammableLeaves(DreamBlocks.PINE_LEAVES.get());
        ///flammableLeaves(DreamBlocks.POISED_LEAVES.get());
        ///flammableLeaves(DreamBlocks.BLOODWOOD_LEAVES.get());
        ///flammableLeaves(DreamBlocks.SOUR_LEAVES.get());
    }

    private static void flammableWood(DreamBlockFamily family) {
        family.getVariants().forEach((variant, block) -> {
            switch (variant) {
                case LOG, WOOD, STRIPPED_LOG, STRIPPED_WOOD -> BlockDataUtils.flammable(block, 5, 5);
                case PLANKS, STAIRS, SLAB, FENCE, FENCE_GATE, BUTTON, PRESSURE_PLATE, TRAPDOOR, DOOR, SIGN -> BlockDataUtils.flammable(block, 5, 20);
            }
        });
    }

    private static void flammableLeaves(Block block) {
        BlockDataUtils.flammable(block, 30, 60);
    }

    private static void flammablePlants(Block block) {
        BlockDataUtils.flammable(block, 60, 100);
    }

    public static void registerCompostables() {
        BlockDataUtils.compostable(DreamItems.DREAMY_GRASS.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.TALL_DREAMY_GRASS.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.FOREST_SHRUB_LEAVES.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.FOREST_SHRUB.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.FOREST_MOSS_BLOCK.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.FOREST_MOSS_CARPET.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.FOREST_GRASS.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.TALL_FOREST_GRASS.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.FOREST_MUSHROOM_BLOCK.get(), 0.85F);
        BlockDataUtils.compostable(DreamItems.FOREST_MUSHROOM.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.GROUND_IVY.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.CLOVERS.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.WHITE_CLOVERS.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.PINK_CLOVERS.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.PETUNIA.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.PERIWINKLE.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.PINK_PUFFBALL.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.PINK_FOXGLOVE.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.PINK_HYACINTH.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.MAGENTA_HYACINTH.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.PURPLE_HYACINTH.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.PURPLE_LUPINE.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.VIOLETS.get(), 0.3F);
        ///////////////////////////////////////
        BlockDataUtils.compostable(DreamItems.DREAMY_LEAVES.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.DREAMY_SAPLING.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.DREAMY_MUSHROOM_BLOCK.get(), 0.85F);
        BlockDataUtils.compostable(DreamItems.DREAMY_MUSHROOM.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.ASPEN_LEAVES.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.ASPEN_SAPLING.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.EVERGREEN_LEAVES.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.EVERGREEN_SAPLING.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.TOADSTOOL.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.TOADSTOOL_BLOCK.get(), 0.85F);
        BlockDataUtils.compostable(DreamItems.ETHEREAL_LEAVES.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.ETHEREAL_SAPLING.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.LILAC_BUSH_LEAVES.get(), 0.65F);
        BlockDataUtils.compostable(DreamItems.LILAC_BUSH.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.PINK_COTTON_CANDY_SAPLING.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.BLUE_COTTON_CANDY_SAPLING.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.WISTERIA_LEAVES.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.WISTERIA_BLOSSOMS.get(), 0.65F);
        BlockDataUtils.compostable(DreamItems.WISTERIA_SAPLING.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.WISTERIA.get(), 0.65F);
        BlockDataUtils.compostable(DreamItems.MYSTICAL_LEAVES.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.MYSTICAL_SAPLING.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.FAIRY_ROSE_BUSH_LEAVES.get(), 0.65F);
        BlockDataUtils.compostable(DreamItems.FAIRY_ROSE_BUSH.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.PINK_MUSHROOM.get(), 0.3F);
        BlockDataUtils.compostable(DreamItems.PINK_MUSHROOM_BLOCK.get(), 0.85F);
        ///////////////////////////////////////
        ///BlockDataUtils.compostable(DreamItems.GLOOMY_MUSHROOM.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.GLOOMY_MUSHROOM_BLOCK.get(), 0.85F);
        ///BlockDataUtils.compostable(DreamItems.GLOOMY_LEAVES.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.GLOOMY_SAPLING.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.GRIMWOOD_LEAVES.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.GRIMWOOD_SAPLING.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.DEAD_LEAVES.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.DEAD_SAPLING.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.PINE_LEAVES.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.PINE_SAPLING.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.POISED_LEAVES.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.POISED_SAPLING.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.BLOODWOOD_LEAVES.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.BLOODWOOD_SAPLING.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.SOUR_LEAVES.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.SOUR_SAPLING.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.FUNGUS.get(), 0.3F);
        ///BlockDataUtils.compostable(DreamItems.FUNGUS_BLOCK.get(), 0.85F);
    }

    public static void registerStrippables() {
        BlockDataUtils.strippable(DreamBlocks.DREAMY_LOG.get(), DreamBlocks.STRIPPED_DREAMY_LOG.get());
        BlockDataUtils.strippable(DreamBlocks.DREAMY_WOOD.get(), DreamBlocks.STRIPPED_DREAMY_WOOD.get());
        BlockDataUtils.strippable(DreamBlocks.ASPEN_LOG.get(), DreamBlocks.STRIPPED_ASPEN_LOG.get());
        BlockDataUtils.strippable(DreamBlocks.ASPEN_WOOD.get(), DreamBlocks.STRIPPED_ASPEN_WOOD.get());
        BlockDataUtils.strippable(DreamBlocks.EVERGREEN_LOG.get(), DreamBlocks.STRIPPED_EVERGREEN_LOG.get());
        BlockDataUtils.strippable(DreamBlocks.EVERGREEN_WOOD.get(), DreamBlocks.STRIPPED_EVERGREEN_WOOD.get());
        BlockDataUtils.strippable(DreamBlocks.ETHEREAL_LOG.get(), DreamBlocks.STRIPPED_ETHEREAL_LOG.get());
        BlockDataUtils.strippable(DreamBlocks.ETHEREAL_WOOD.get(), DreamBlocks.STRIPPED_ETHEREAL_WOOD.get());
        BlockDataUtils.strippable(DreamBlocks.CANDY_LOG.get(), DreamBlocks.STRIPPED_CANDY_LOG.get());
        BlockDataUtils.strippable(DreamBlocks.CANDY_WOOD.get(), DreamBlocks.STRIPPED_CANDY_WOOD.get());
        BlockDataUtils.strippable(DreamBlocks.WISTERIA_LOG.get(), DreamBlocks.STRIPPED_WISTERIA_LOG.get());
        BlockDataUtils.strippable(DreamBlocks.WISTERIA_WOOD.get(), DreamBlocks.STRIPPED_WISTERIA_WOOD.get());
        BlockDataUtils.strippable(DreamBlocks.MYSTICAL_LOG.get(), DreamBlocks.STRIPPED_MYSTICAL_LOG.get());
        BlockDataUtils.strippable(DreamBlocks.MYSTICAL_WOOD.get(), DreamBlocks.STRIPPED_MYSTICAL_WOOD.get());
        BlockDataUtils.strippable(DreamBlocks.MUSHROOM_STEM.get(), DreamBlocks.STRIPPED_MUSHROOM_STEM.get());
        BlockDataUtils.strippable(DreamBlocks.MUSHROOM_HYPHAE.get(), DreamBlocks.STRIPPED_MUSHROOM_HYPHAE.get());
        ///BlockDataUtils.strippable(DreamBlocks.GLOOMY_LOG.get(), DreamBlocks.STRIPPED_GLOOMY_LOG.get());
        ///BlockDataUtils.strippable(DreamBlocks.GLOOMY_WOOD.get(), DreamBlocks.STRIPPED_GLOOMY_WOOD.get());
        ///BlockDataUtils.strippable(DreamBlocks.GRIMWOOD_LOG.get(), DreamBlocks.STRIPPED_GRIMWOOD_LOG.get());
        ///BlockDataUtils.strippable(DreamBlocks.GRIMWOOD_WOOD.get(), DreamBlocks.STRIPPED_GRIMWOOD_WOOD.get());
        ///BlockDataUtils.strippable(DreamBlocks.DEAD_LOG.get(), DreamBlocks.STRIPPED_DEAD_LOG.get());
        ///BlockDataUtils.strippable(DreamBlocks.DEAD_WOOD.get(), DreamBlocks.STRIPPED_DEAD_WOOD.get());
        ///BlockDataUtils.strippable(DreamBlocks.PINE_LOG.get(), DreamBlocks.STRIPPED_PINE_LOG.get());
        ///BlockDataUtils.strippable(DreamBlocks.PINE_WOOD.get(), DreamBlocks.STRIPPED_PINE_WOOD.get());
        ///BlockDataUtils.strippable(DreamBlocks.POISED_LOG.get(), DreamBlocks.STRIPPED_POISED_LOG.get());
        ///BlockDataUtils.strippable(DreamBlocks.POISED_WOOD.get(), DreamBlocks.STRIPPED_POISED_WOOD.get());
        ///BlockDataUtils.strippable(DreamBlocks.BLOODWOOD_LOG.get(), DreamBlocks.STRIPPED_BLOODWOOD_LOG.get());
        ///BlockDataUtils.strippable(DreamBlocks.BLOODWOOD_WOOD.get(), DreamBlocks.STRIPPED_BLOODWOOD_WOOD.get());
        ///BlockDataUtils.strippable(DreamBlocks.SOUR_LOG.get(), DreamBlocks.STRIPPED_SOUR_LOG.get());
        ///BlockDataUtils.strippable(DreamBlocks.SOUR_WOOD.get(), DreamBlocks.STRIPPED_SOUR_WOOD.get());
        ///BlockDataUtils.strippable(DreamBlocks.FUNGUS_STEM.get(), DreamBlocks.STRIPPED_FUNGUS_STEM.get());
        ///BlockDataUtils.strippable(DreamBlocks.FUNGUS_HYPHAE.get(), DreamBlocks.STRIPPED_FUNGUS_HYPHAE.get());
    }

    public static void registerRenderLayers() {
        BlockEntityRenderers.register(DreamBlockEntities.SIGN.get(), SignRenderer::new);
        BlockEntityRenderers.register(DreamBlockEntities.HANGING_SIGN.get(), HangingSignRenderer::new);
    }

}