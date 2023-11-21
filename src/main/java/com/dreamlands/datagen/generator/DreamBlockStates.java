package com.dreamlands.datagen.generator;

import com.dreamlands.Dreamlands;
import com.dreamlands.init.DreamBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DreamBlockStates extends BlockStateProvider {

    public DreamBlockStates(PackOutput output, ExistingFileHelper helper) {
        super(output, Dreamlands.modId, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        planks(DreamBlocks.EVERGREEN_PLANKS.get());
        planks(DreamBlocks.ETHEREAL_PLANKS.get());
        planks(DreamBlocks.CANDY_PLANKS.get());

        planks(DreamBlocks.EBONY_PLANKS.get());
        planks(DreamBlocks.DEAD_PLANKS.get());
        planks(DreamBlocks.BLOODWOOD_PLANKS.get());

        plant(DreamBlocks.DREAMY_MUSHROOM.get());
    }

    private void planks(Block block) {
        this.simpleBlockWithItem(block, models().cubeAll(blockTexture(block).getPath(), blockTexture(block)));
    }

    /** @param block includes flowers, grass, mushrooms, etc. */
    private void plant(Block block) {
        this.simpleBlock(block, models().cross(blockTexture(block).getPath(), blockTexture(block)).renderType("minecraft:cutout"));
    }

}