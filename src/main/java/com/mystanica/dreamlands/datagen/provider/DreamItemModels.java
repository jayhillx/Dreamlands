package com.mystanica.dreamlands.datagen.provider;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.datagen.DreamBlockFamilies;
import com.mystanica.dreamlands.datagen.DreamBlockFamily;
import com.mystanica.dreamlands.init.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DreamItemModels extends ItemModelProvider {

    public DreamItemModels(PackOutput output, ExistingFileHelper helper) {
        super(output, Dreamlands.modId, helper);
    }

    @Override
    protected void registerModels() {
        //DreamBlockFamilies.getAllFamilies().filter(DreamBlockFamily::shouldGenerateModel).forEach(this::generateFor);
        //this.simpleBlockItem(DreamBlocks.DREAMY_GRASS_BLOCK.get());
        //this.simpleBlockItem(DreamBlocks.DREAMY_DIRT_PATH.get());
        //this.simpleBlockItem(DreamBlocks.DREAMY_DIRT.get());
        //this.simpleBlockItem(DreamBlocks.DREAMY_SOIL.get());
        //this.generatedBlockItem(DreamBlocks.DREAMY_GRASS.get());
        //this.generatedBlockItem(DreamBlocks.TALL_DREAMY_GRASS.get(), "_top");
        //this.generatedBlockItem(DreamBlocks.DREAMY_FERN.get());
        //this.generatedBlockItem(DreamBlocks.TALL_DREAMY_FERN.get(), "_top");
        //this.simpleBlockItem(DreamBlocks.FOREST_SHRUB_LEAVES.get());
        //this.simpleBlockItem(DreamBlocks.FOREST_SHRUB.get());
        //this.simpleBlockItem(DreamBlocks.FOREST_MOSS_BLOCK.get());
        //this.simpleBlockItem(DreamBlocks.FOREST_MOSS_CARPET.get());
        //this.generatedBlockItem(DreamBlocks.FOREST_GRASS.get());
        //this.generatedBlockItem(DreamBlocks.TALL_FOREST_GRASS.get(), "_top");
        //this.simpleBlockItem(DreamBlocks.FOREST_MUSHROOM_BLOCK.get());
        //this.generatedBlockItem(DreamBlocks.FOREST_MUSHROOM.get());
        //this.generatedBlockItem(DreamBlocks.GROUND_IVY.get());
        //this.generatedBlockItem(DreamBlocks.CLOVERS.get());
        //this.generatedBlockItem(DreamBlocks.WHITE_CLOVERS.get());
        //this.generatedBlockItem(DreamBlocks.PINK_CLOVERS.get());
        //this.generatedBlockItem(DreamBlocks.PETUNIA.get());
        //this.generatedBlockItem(DreamBlocks.PERIWINKLE.get());
        //this.generatedBlockItem(DreamBlocks.PINK_FOXGLOVE.get());
        //this.generatedBlockItem(DreamBlocks.PINK_HYACINTH.get());
        //this.generatedBlockItem(DreamBlocks.MAGENTA_HYACINTH.get());
        //this.generatedBlockItem(DreamBlocks.PURPLE_HYACINTH.get());
        //this.generatedBlockItem(DreamBlocks.VIOLETS.get());
        ///////////////////////////////////////
        //this.simpleBlockItem(DreamBlocks.DREAMY_LEAVES.get());
        //this.generatedBlockItem(DreamBlocks.DREAMY_SAPLING.get());
        //this.simpleBlockItem(DreamBlocks.DREAMY_MUSHROOM_BLOCK.get());
        //this.generatedBlockItem(DreamBlocks.DREAMY_MUSHROOM.get());
        //this.simpleBlockItem(DreamBlocks.ASPEN_LEAVES.get());
        //this.generatedBlockItem(DreamBlocks.ASPEN_SAPLING.get());
        //this.simpleBlockItem(DreamBlocks.EVERGREEN_LEAVES.get());
        //this.generatedBlockItem(DreamBlocks.EVERGREEN_SAPLING.get());
        //this.simpleBlockItem(DreamBlocks.TOADSTOOL_BLOCK.get());
        //this.generatedBlockItem(DreamBlocks.TOADSTOOL.get());
        //this.simpleBlockItem(DreamBlocks.ETHEREAL_LEAVES.get());
        //this.simpleBlockItem(DreamBlocks.ETHEREAL_BLOSSOMS.get());
        //this.generatedBlockItem(DreamBlocks.ETHEREAL_SAPLING.get());
        //this.simpleBlockItem(DreamBlocks.LILAC_BUSH_LEAVES.get());
        //this.simpleBlockItem(DreamBlocks.LILAC_BUSH.get());
        //this.simpleBlockItem(DreamBlocks.PINK_COTTON_CANDY_BLOCK.get());
        //this.generatedBlockItem(DreamBlocks.PINK_COTTON_CANDY_SAPLING.get());
        //this.simpleBlockItem(DreamBlocks.BLUE_COTTON_CANDY_BLOCK.get());
        //this.generatedBlockItem(DreamBlocks.BLUE_COTTON_CANDY_SAPLING.get());
        //this.simpleBlockItem(DreamBlocks.WISTERIA_LEAVES.get());
        //this.simpleBlockItem(DreamBlocks.WISTERIA_BLOSSOMS.get());
        //this.generatedBlockItem(DreamBlocks.WISTERIA_SAPLING.get());
        //this.generatedBlockItem(DreamBlocks.WISTERIA.get(), "_leafy");
        //this.simpleBlockItem(DreamBlocks.MYSTICAL_LEAVES.get());
        //this.generatedBlockItem(DreamBlocks.MYSTICAL_SAPLING.get());
        //this.simpleBlockItem(DreamBlocks.FAIRY_ROSE_BUSH_LEAVES.get());
        //this.simpleBlockItem(DreamBlocks.FAIRY_ROSE_BUSH.get());
        //this.simpleBlockItem(DreamBlocks.PINK_MUSHROOM_BLOCK.get());
        //this.generatedBlockItem(DreamBlocks.PINK_MUSHROOM.get());
        ///////////////////////////////////////
        //this.simpleBlockItem(DreamBlocks.GLOOMY_LEAVES.get());
        //this.generatedBlockItem(DreamBlocks.GLOOMY_SAPLING.get());
        //this.simpleBlockItem(DreamBlocks.GLOOMY_MUSHROOM_BLOCK.get());
        //this.generatedBlockItem(DreamBlocks.GLOOMY_MUSHROOM.get());
        //this.simpleBlockItem(DreamBlocks.GRIMWOOD_LEAVES.get());
        //this.generatedBlockItem(DreamBlocks.GRIMWOOD_SAPLING.get());
        //this.simpleBlockItem(DreamBlocks.DEAD_LEAVES.get());
        //this.generatedBlockItem(DreamBlocks.DEAD_SAPLING.get());
        //this.simpleBlockItem(DreamBlocks.PINE_LEAVES.get());
        //this.generatedBlockItem(DreamBlocks.PINE_SAPLING.get());
        //this.simpleBlockItem(DreamBlocks.POISED_LEAVES.get());
        //this.generatedBlockItem(DreamBlocks.POISED_SAPLING.get());
        //this.simpleBlockItem(DreamBlocks.BLOODWOOD_LEAVES.get());
        //this.generatedBlockItem(DreamBlocks.BLOODWOOD_SAPLING.get());
        //this.simpleBlockItem(DreamBlocks.SOUR_LEAVES.get());
        //this.generatedBlockItem(DreamBlocks.SOUR_SAPLING.get());
        //this.simpleBlockItem(DreamBlocks.FUNGUS_BLOCK.get());
        //this.generatedBlockItem(DreamBlocks.FUNGUS.get());
        ///////////////////////////////////////
        //this.basicItem(DreamItems.DREAMY_BOAT.get());
        //this.basicItem(DreamItems.DREAMY_CHEST_BOAT.get());
        //this.basicItem(DreamItems.ASPEN_BOAT.get());
        //this.basicItem(DreamItems.ASPEN_CHEST_BOAT.get());
        //this.basicItem(DreamItems.EVERGREEN_BOAT.get());
        //this.basicItem(DreamItems.EVERGREEN_CHEST_BOAT.get());
        //this.basicItem(DreamItems.ETHEREAL_BOAT.get());
        //this.basicItem(DreamItems.ETHEREAL_CHEST_BOAT.get());
        //this.basicItem(DreamItems.CANDY_BOAT.get());
        //this.basicItem(DreamItems.CANDY_CHEST_BOAT.get());
        //this.basicItem(DreamItems.WISTERIA_BOAT.get());
        //this.basicItem(DreamItems.WISTERIA_CHEST_BOAT.get());
        //this.basicItem(DreamItems.MYSTICAL_BOAT.get());
        //this.basicItem(DreamItems.MYSTICAL_CHEST_BOAT.get());
        //this.basicItem(DreamItems.MUSHROOM_BOAT.get());
        //this.basicItem(DreamItems.MUSHROOM_CHEST_BOAT.get());
        //this.basicItem(DreamItems.GLOOMY_BOAT.get());
        //this.basicItem(DreamItems.GLOOMY_CHEST_BOAT.get());
        //this.basicItem(DreamItems.GRIMWOOD_BOAT.get());
        //this.basicItem(DreamItems.GRIMWOOD_CHEST_BOAT.get());
        //this.basicItem(DreamItems.PINE_BOAT.get());
        //this.basicItem(DreamItems.PINE_CHEST_BOAT.get());
        //this.basicItem(DreamItems.POISED_BOAT.get());
        //this.basicItem(DreamItems.POISED_CHEST_BOAT.get());
        //this.basicItem(DreamItems.DEAD_BOAT.get());
        //this.basicItem(DreamItems.DEAD_CHEST_BOAT.get());
        //this.basicItem(DreamItems.BLOODWOOD_BOAT.get());
        //this.basicItem(DreamItems.BLOODWOOD_CHEST_BOAT.get());
        //this.basicItem(DreamItems.SOUR_BOAT.get());
        //this.basicItem(DreamItems.SOUR_CHEST_BOAT.get());
        //this.basicItem(DreamItems.FUNGUS_BOAT.get());
        //this.basicItem(DreamItems.FUNGUS_CHEST_BOAT.get());
    }

    private void generateFor(DreamBlockFamily family) {
        //family.getVariants().forEach((variant, block) -> {
        //    switch (variant) {
        //        case FENCE -> this.fenceInventory(key(block).getPath(), texture(family.getBaseBlock()));
        //        case BUTTON -> this.buttonInventory(key(block).getPath(), texture(family.getBaseBlock()));
        //        case TRAPDOOR -> this.withExistingParent(key(block).getPath(), texture(block, "_bottom"));
        //        case DOOR, SIGN, HANGING_SIGN -> this.basicItem(block.asItem());
        //        case WALL -> this.wallInventory(key(block).getPath(), texture(family.getBaseBlock()));
        //        default -> this.simpleBlockItem(block);
        //    }
        //});
    }

    private void generatedBlockItem(Block block) {
        this.generatedBlockItem(block, texture(block));
    }

    private void generatedBlockItem(Block block, String suffix) {
        this.generatedBlockItem(block, texture(block, suffix));
    }

    private void generatedBlockItem(Block block, ResourceLocation texture) {
        this.getBuilder(key(block).getPath())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", texture);
    }

    private static ResourceLocation texture(Block block) {
        return Dreamlands.modLoc("block/" + key(block).getPath());
    }

    private static ResourceLocation texture(Block block, String suffix) {
        return Dreamlands.modLoc("block/" + key(block).withSuffix(suffix).getPath());
    }

    private static ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

}