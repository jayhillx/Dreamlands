package com.dreamlands.common.block.state;

import com.dreamlands.init.DreamBlocks;
import net.minecraft.data.BlockFamily;

public class DreamBlockFamilies {

    public static final BlockFamily EVERGREEN_PLANKS = new BlockFamily.Builder(DreamBlocks.EVERGREEN_PLANKS.get()).stairs(DreamBlocks.EVERGREEN_STAIRS.get()).slab(DreamBlocks.EVERGREEN_SLAB.get()).fence(DreamBlocks.EVERGREEN_FENCE.get()).fenceGate(DreamBlocks.EVERGREEN_FENCE_GATE.get()).button(DreamBlocks.EVERGREEN_BUTTON.get()).pressurePlate(DreamBlocks.EVERGREEN_PRESSURE_PLATE.get()).trapdoor(DreamBlocks.EVERGREEN_TRAPDOOR.get()).door(DreamBlocks.EVERGREEN_DOOR.get()).sign(DreamBlocks.EVERGREEN_SIGN.get(), DreamBlocks.EVERGREEN_WALL_SIGN.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    public static final BlockFamily ETHEREAL_PLANKS = new BlockFamily.Builder(DreamBlocks.ETHEREAL_PLANKS.get()).stairs(DreamBlocks.ETHEREAL_STAIRS.get()).slab(DreamBlocks.ETHEREAL_SLAB.get()).fence(DreamBlocks.ETHEREAL_FENCE.get()).fenceGate(DreamBlocks.ETHEREAL_FENCE_GATE.get()).button(DreamBlocks.ETHEREAL_BUTTON.get()).pressurePlate(DreamBlocks.ETHEREAL_PRESSURE_PLATE.get()).trapdoor(DreamBlocks.ETHEREAL_TRAPDOOR.get()).door(DreamBlocks.ETHEREAL_DOOR.get()).sign(DreamBlocks.ETHEREAL_SIGN.get(), DreamBlocks.ETHEREAL_WALL_SIGN.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    public static final BlockFamily CANDY_PLANKS = new BlockFamily.Builder(DreamBlocks.CANDY_PLANKS.get()).stairs(DreamBlocks.CANDY_STAIRS.get()).slab(DreamBlocks.CANDY_SLAB.get()).fence(DreamBlocks.CANDY_FENCE.get()).fenceGate(DreamBlocks.CANDY_FENCE_GATE.get()).button(DreamBlocks.CANDY_BUTTON.get()).pressurePlate(DreamBlocks.CANDY_PRESSURE_PLATE.get()).trapdoor(DreamBlocks.CANDY_TRAPDOOR.get()).door(DreamBlocks.CANDY_DOOR.get()).sign(DreamBlocks.CANDY_SIGN.get(), DreamBlocks.CANDY_WALL_SIGN.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();

}