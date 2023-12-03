package com.dreamlands.data.generator;

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
        this.generated(DreamItems.MARSHMALLOW.getId());
        this.generated(DreamItems.TOASTED_MARSHMALLOW.getId());
        this.generated(DreamItems.BURNT_MARSHMALLOW.getId());
        this.handheld(DreamItems.MARSHMALLOW_ON_A_STICK.getId());
        this.handheld(DreamItems.TOASTED_MARSHMALLOW_ON_A_STICK.getId());
        this.handheld(DreamItems.BURNT_MARSHMALLOW_ON_A_STICK.getId());
        this.generated(DreamItems.SMORE.getId());

        this.item(DreamBlocks.DREAMY_MUSHROOM.getId());
        this.generated(DreamItems.DREAMY_MUSHROOM_SOUP.getId());

        this.blockItem(DreamBlocks.EVERGREEN_LOG.getId());
        this.blockItem(DreamBlocks.STRIPPED_EVERGREEN_LOG.getId());
        this.blockItem(DreamBlocks.EVERGREEN_WOOD.getId());
        this.blockItem(DreamBlocks.STRIPPED_EVERGREEN_WOOD.getId());
        this.blockItem(DreamBlocks.EVERGREEN_PLANKS.getId());
        this.blockItem(DreamBlocks.EVERGREEN_STAIRS.getId());
        this.blockItem(DreamBlocks.EVERGREEN_SLAB.getId());
        this.fenceInventory(DreamBlocks.EVERGREEN_FENCE.getId().getPath(), modLoc("block/evergreen_planks"));
        this.blockItem(DreamBlocks.EVERGREEN_FENCE_GATE.getId());
        this.buttonInventory(DreamBlocks.EVERGREEN_BUTTON.getId().getPath(), modLoc("block/evergreen_planks"));
        this.blockItem(DreamBlocks.EVERGREEN_PRESSURE_PLATE.getId());
        this.blockItem(DreamBlocks.EVERGREEN_TRAPDOOR.getId(), "_bottom");
        this.generated(DreamBlocks.EVERGREEN_DOOR.getId());
        this.generated(DreamBlocks.EVERGREEN_SIGN.getId());
        this.generated(DreamBlocks.EVERGREEN_HANGING_SIGN.getId());

        this.blockItem(DreamBlocks.ETHEREAL_LOG.getId());
        this.blockItem(DreamBlocks.STRIPPED_ETHEREAL_LOG.getId());
        this.blockItem(DreamBlocks.ETHEREAL_WOOD.getId());
        this.blockItem(DreamBlocks.STRIPPED_ETHEREAL_WOOD.getId());
        this.blockItem(DreamBlocks.ETHEREAL_PLANKS.getId());
        this.blockItem(DreamBlocks.ETHEREAL_STAIRS.getId());
        this.blockItem(DreamBlocks.ETHEREAL_SLAB.getId());
        this.fenceInventory(DreamBlocks.ETHEREAL_FENCE.getId().getPath(), modLoc("block/ethereal_planks"));
        this.blockItem(DreamBlocks.ETHEREAL_FENCE_GATE.getId());
        this.buttonInventory(DreamBlocks.ETHEREAL_BUTTON.getId().getPath(), modLoc("block/ethereal_planks"));
        this.blockItem(DreamBlocks.ETHEREAL_PRESSURE_PLATE.getId());
        this.blockItem(DreamBlocks.ETHEREAL_TRAPDOOR.getId(), "_bottom");
        this.generated(DreamBlocks.ETHEREAL_DOOR.getId());
        this.generated(DreamBlocks.ETHEREAL_SIGN.getId());
        this.generated(DreamBlocks.ETHEREAL_HANGING_SIGN.getId());

        this.blockItem(DreamBlocks.CANDY_LOG.getId());
        this.blockItem(DreamBlocks.STRIPPED_CANDY_LOG.getId());
        this.blockItem(DreamBlocks.CANDY_WOOD.getId());
        this.blockItem(DreamBlocks.STRIPPED_CANDY_WOOD.getId());
        this.blockItem(DreamBlocks.CANDY_PLANKS.getId());
        this.blockItem(DreamBlocks.CANDY_STAIRS.getId());
        this.blockItem(DreamBlocks.CANDY_SLAB.getId());
        this.fenceInventory(DreamBlocks.CANDY_FENCE.getId().getPath(), modLoc("block/candy_planks"));
        this.blockItem(DreamBlocks.CANDY_FENCE_GATE.getId());
        this.buttonInventory(DreamBlocks.CANDY_BUTTON.getId().getPath(), modLoc("block/candy_planks"));
        this.blockItem(DreamBlocks.CANDY_PRESSURE_PLATE.getId());
        this.blockItem(DreamBlocks.CANDY_TRAPDOOR.getId(), "_bottom");
        this.generated(DreamBlocks.CANDY_DOOR.getId());
        this.generated(DreamBlocks.CANDY_SIGN.getId());
        this.generated(DreamBlocks.CANDY_HANGING_SIGN.getId());
    }

    private void generated(ResourceLocation location) {
        this.item(location, "generated");
    }

    private void handheld(ResourceLocation location) {
        this.item(location, "handheld");
    }

    /** @param type either 'generated' or 'handheld'. */
    private void item(ResourceLocation location, String type) {
        this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("item/" + type)).texture("layer0", Dreamlands.modLoc("item/" + location.getPath()));
    }

    private void item(ResourceLocation location) {
        this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", Dreamlands.modLoc("block/" + location.getPath()));
    }

    private void blockItem(ResourceLocation location) {
        this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile(Dreamlands.modLoc("block/" + location.getPath())));
    }

    private void blockItem(ResourceLocation location, String suffix) {
        this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile(Dreamlands.modLoc("block/" + location.getPath() + suffix)));
    }

}