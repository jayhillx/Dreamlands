package com.dreamlands.datagen.generator;

import com.dreamlands.Dreamlands;
import com.dreamlands.init.DreamBlocks;
import com.dreamlands.init.DreamItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DreamItemModels extends ItemModelProvider {

    public DreamItemModels(PackOutput output, ExistingFileHelper helper) {
        super(output, Dreamlands.modId, helper);
    }

    @Override
    protected void registerModels() {
        basic(DreamItems.MARSHMALLOW.getId());
        basic(DreamItems.TOASTED_MARSHMALLOW.getId());
        basic(DreamItems.BURNT_MARSHMALLOW.getId());
        handheld(DreamItems.MARSHMALLOW_ON_A_STICK.getId());
        handheld(DreamItems.TOASTED_MARSHMALLOW_ON_A_STICK.getId());
        handheld(DreamItems.BURNT_MARSHMALLOW_ON_A_STICK.getId());

        basic(DreamItems.SMORE.getId());
        basic(DreamItems.DREAMY_MUSHROOM_SOUP.getId());

        blockItem(DreamBlocks.DREAMY_MUSHROOM.getId());
    }

    private void basic(ResourceLocation location) {
        this.item(location, "generated");
    }

    private void handheld(ResourceLocation location) {
        this.item(location, "handheld");
    }

    /** @param type either 'generated' or 'handheld'. */
    private void item(ResourceLocation location, String type) {
        this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("item/" + type)).texture("layer0", Dreamlands.modLoc("item/" + location.getPath()));
    }

    private void blockItem(ResourceLocation location) {
        this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", Dreamlands.modLoc("block/" + location.getPath()));
    }

}