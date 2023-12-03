package com.dreamlands.data.generator;

import com.dreamlands.Dreamlands;
import com.dreamlands.init.DreamBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DreamBlockStates extends BlockStateProvider {

    public DreamBlockStates(PackOutput output, ExistingFileHelper helper) {
        super(output, Dreamlands.modId, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.plant(DreamBlocks.DREAMY_MUSHROOM.get());

        this.logBlock((RotatedPillarBlock) DreamBlocks.EVERGREEN_LOG.get());
        this.logBlock((RotatedPillarBlock) DreamBlocks.STRIPPED_EVERGREEN_LOG.get());
        this.fullBlock(DreamBlocks.EVERGREEN_WOOD.get(), DreamBlocks.EVERGREEN_LOG.get());
        this.fullBlock(DreamBlocks.STRIPPED_EVERGREEN_WOOD.get(), DreamBlocks.EVERGREEN_LOG.get());
        this.fullBlock(DreamBlocks.EVERGREEN_PLANKS.get());
        this.stairsBlock((StairBlock) DreamBlocks.EVERGREEN_STAIRS.get(), blockTexture(DreamBlocks.EVERGREEN_PLANKS.get()));
        this.slabBlock((SlabBlock) DreamBlocks.EVERGREEN_SLAB.get(), blockTexture(DreamBlocks.EVERGREEN_PLANKS.get()), blockTexture(DreamBlocks.EVERGREEN_PLANKS.get()));
        this.fenceBlock((FenceBlock) DreamBlocks.EVERGREEN_FENCE.get(), blockTexture(DreamBlocks.EVERGREEN_PLANKS.get()));
        this.fenceGateBlock((FenceGateBlock) DreamBlocks.EVERGREEN_FENCE_GATE.get(), blockTexture(DreamBlocks.EVERGREEN_PLANKS.get()));
        this.buttonBlock((ButtonBlock) DreamBlocks.EVERGREEN_BUTTON.get(), blockTexture(DreamBlocks.EVERGREEN_PLANKS.get()));
        this.pressurePlateBlock((PressurePlateBlock) DreamBlocks.EVERGREEN_PRESSURE_PLATE.get(), blockTexture(DreamBlocks.EVERGREEN_PLANKS.get()));
        this.trapdoorBlock((TrapDoorBlock) DreamBlocks.EVERGREEN_TRAPDOOR.get(), blockTexture(DreamBlocks.EVERGREEN_TRAPDOOR.get()), true);
        this.doorBlock((DoorBlock) DreamBlocks.EVERGREEN_DOOR.get(), modLoc("block/evergreen_door_bottom"), modLoc("block/evergreen_door_top"));
        this.signBlock((StandingSignBlock) DreamBlocks.EVERGREEN_SIGN.get(), (WallSignBlock) DreamBlocks.EVERGREEN_WALL_SIGN.get(), blockTexture(DreamBlocks.EVERGREEN_PLANKS.get()));

        this.logBlock((RotatedPillarBlock) DreamBlocks.ETHEREAL_LOG.get());
        this.logBlock((RotatedPillarBlock) DreamBlocks.STRIPPED_ETHEREAL_LOG.get());
        this.fullBlock(DreamBlocks.ETHEREAL_WOOD.get(), DreamBlocks.ETHEREAL_LOG.get());
        this.fullBlock(DreamBlocks.STRIPPED_ETHEREAL_WOOD.get(), DreamBlocks.ETHEREAL_LOG.get());
        this.fullBlock(DreamBlocks.ETHEREAL_PLANKS.get());
        this.stairsBlock((StairBlock) DreamBlocks.ETHEREAL_STAIRS.get(), blockTexture(DreamBlocks.ETHEREAL_PLANKS.get()));
        this.slabBlock((SlabBlock) DreamBlocks.ETHEREAL_SLAB.get(), blockTexture(DreamBlocks.ETHEREAL_PLANKS.get()), blockTexture(DreamBlocks.ETHEREAL_PLANKS.get()));
        this.fenceBlock((FenceBlock) DreamBlocks.ETHEREAL_FENCE.get(), blockTexture(DreamBlocks.ETHEREAL_PLANKS.get()));
        this.fenceGateBlock((FenceGateBlock) DreamBlocks.ETHEREAL_FENCE_GATE.get(), blockTexture(DreamBlocks.ETHEREAL_PLANKS.get()));
        this.buttonBlock((ButtonBlock) DreamBlocks.ETHEREAL_BUTTON.get(), blockTexture(DreamBlocks.ETHEREAL_PLANKS.get()));
        this.pressurePlateBlock((PressurePlateBlock) DreamBlocks.ETHEREAL_PRESSURE_PLATE.get(), blockTexture(DreamBlocks.ETHEREAL_PLANKS.get()));
        this.trapdoorBlock((TrapDoorBlock) DreamBlocks.ETHEREAL_TRAPDOOR.get(), blockTexture(DreamBlocks.ETHEREAL_TRAPDOOR.get()), true);
        this.doorBlock((DoorBlock) DreamBlocks.ETHEREAL_DOOR.get(), modLoc("block/ethereal_door_bottom"), modLoc("block/ethereal_door_top"));
        this.signBlock((StandingSignBlock) DreamBlocks.ETHEREAL_SIGN.get(), (WallSignBlock) DreamBlocks.ETHEREAL_WALL_SIGN.get(), blockTexture(DreamBlocks.ETHEREAL_PLANKS.get()));

        this.logBlock((RotatedPillarBlock) DreamBlocks.CANDY_LOG.get());
        this.logBlock((RotatedPillarBlock) DreamBlocks.STRIPPED_CANDY_LOG.get());
        this.fullBlock(DreamBlocks.CANDY_WOOD.get(), DreamBlocks.CANDY_LOG.get());
        this.fullBlock(DreamBlocks.STRIPPED_CANDY_WOOD.get(), DreamBlocks.CANDY_LOG.get());
        this.fullBlock(DreamBlocks.CANDY_PLANKS.get());
        this.stairsBlock((StairBlock) DreamBlocks.CANDY_STAIRS.get(), blockTexture(DreamBlocks.CANDY_PLANKS.get()));
        this.slabBlock((SlabBlock) DreamBlocks.CANDY_SLAB.get(), blockTexture(DreamBlocks.CANDY_PLANKS.get()), blockTexture(DreamBlocks.CANDY_PLANKS.get()));
        this.fenceBlock((FenceBlock) DreamBlocks.CANDY_FENCE.get(), blockTexture(DreamBlocks.CANDY_PLANKS.get()));
        this.fenceGateBlock((FenceGateBlock) DreamBlocks.CANDY_FENCE_GATE.get(), blockTexture(DreamBlocks.CANDY_PLANKS.get()));
        this.buttonBlock((ButtonBlock) DreamBlocks.CANDY_BUTTON.get(), blockTexture(DreamBlocks.CANDY_PLANKS.get()));
        this.pressurePlateBlock((PressurePlateBlock) DreamBlocks.CANDY_PRESSURE_PLATE.get(), blockTexture(DreamBlocks.CANDY_PLANKS.get()));
        this.trapdoorBlock((TrapDoorBlock) DreamBlocks.CANDY_TRAPDOOR.get(), blockTexture(DreamBlocks.CANDY_TRAPDOOR.get()), true);
        this.doorBlock((DoorBlock) DreamBlocks.CANDY_DOOR.get(), modLoc("block/candy_door_bottom"), modLoc("block/candy_door_top"));
        this.signBlock((StandingSignBlock) DreamBlocks.CANDY_SIGN.get(), (WallSignBlock) DreamBlocks.CANDY_WALL_SIGN.get(), blockTexture(DreamBlocks.CANDY_PLANKS.get()));
    }

    private void fullBlock(Block block) {
        this.simpleBlockWithItem(block, models().cubeAll(blockTexture(block).getPath(), blockTexture(block)));
    }

    private void fullBlock(Block block, Block texture) {
        this.simpleBlockWithItem(block, models().cubeAll(blockTexture(block).getPath(), blockTexture(texture)));
    }

    /** @param block includes flowers, grass, mushrooms, etc. */
    private void plant(Block block) {
        this.simpleBlock(block, models().cross(blockTexture(block).getPath(), blockTexture(block)).renderType("minecraft:cutout"));
    }

}