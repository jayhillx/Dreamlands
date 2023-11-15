package com.dreamlands.datagen.generator;

import com.dreamlands.Dreamlands;
import com.dreamlands.init.DreamBlocks;
import com.dreamlands.init.DreamItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class DreamItemModels extends ItemModelProvider {

    public DreamItemModels(PackOutput output, ExistingFileHelper helper) {
        super(output, Dreamlands.modId, helper);
    }

    @Override
    protected void registerModels() {
        basicItem(DreamItems.MARSHMALLOW.get());
        basicItem(DreamItems.TOASTED_MARSHMALLOW.get());
        basicItem(DreamItems.BURNT_MARSHMALLOW.get());
        blockItem(DreamBlocks.DREAMY_MUSHROOM.get());
        basicItem(DreamItems.DREAMY_MUSHROOM_SOUP.get());
    }

    private void blockItem(Block block) {
        this.getBuilder(name(block)).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", Dreamlands.modLoc("block/" + name(block)));
    }

    private String name(Block block) {
        return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
    }

}