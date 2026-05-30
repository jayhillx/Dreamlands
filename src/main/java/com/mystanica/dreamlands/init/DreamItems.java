package com.mystanica.dreamlands.init;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.common.entity.vehicle.DreamBoat;
import com.mystanica.dreamlands.common.item.DreamBoatItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DreamItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Dreamlands.modId);

    /// shared nature stuff
    public static final RegistryObject<Item> DREAMY_GRASS_BLOCK = ITEMS.register("dreamy_grass_block", () -> blockItem(DreamBlocks.DREAMY_GRASS_BLOCK.get()));
    public static final RegistryObject<Item> DREAMY_DIRT = ITEMS.register("dreamy_dirt", () -> blockItem(DreamBlocks.DREAMY_DIRT.get()));
    public static final RegistryObject<Item> DREAMY_DIRT_PATH = ITEMS.register("dreamy_dirt_path", () -> blockItem(DreamBlocks.DREAMY_DIRT_PATH.get()));
    public static final RegistryObject<Item> DREAMY_GRASS = ITEMS.register("dreamy_grass", () -> blockItem(DreamBlocks.DREAMY_GRASS.get()));
    public static final RegistryObject<Item> TALL_DREAMY_GRASS = ITEMS.register("tall_dreamy_grass", () -> blockItem(DreamBlocks.TALL_DREAMY_GRASS.get()));
    public static final RegistryObject<Item> DREAMY_MUSHROOM_BLOCK = ITEMS.register("dreamy_mushroom_block", () -> blockItem(DreamBlocks.DREAMY_MUSHROOM_BLOCK.get()));
    public static final RegistryObject<Item> DREAMY_MUSHROOM = ITEMS.register("dreamy_mushroom", () -> blockItem(DreamBlocks.DREAMY_MUSHROOM.get()));

    public static final RegistryObject<Item> FOREST_SHRUB_LEAVES = ITEMS.register("forest_shrub_leaves", () -> blockItem(DreamBlocks.FOREST_SHRUB_LEAVES.get()));
    public static final RegistryObject<Item> FOREST_SHRUB = ITEMS.register("forest_shrub", () -> blockItem(DreamBlocks.FOREST_SHRUB.get()));
    public static final RegistryObject<Item> FOREST_MOSS_BLOCK = ITEMS.register("forest_moss_block", () -> blockItem(DreamBlocks.FOREST_MOSS_BLOCK.get()));
    public static final RegistryObject<Item> FOREST_MOSS_CARPET = ITEMS.register("forest_moss_carpet", () -> blockItem(DreamBlocks.FOREST_MOSS_CARPET.get()));
    ///public static final RegistryObject<Item> FOREST_GRASS = ITEMS.register("forest_grass", () -> blockItem(DreamBlocks.FOREST_GRASS.get()));
    ///public static final RegistryObject<Item> TALL_FOREST_GRASS = ITEMS.register("tall_forest_grass", () -> blockItem(DreamBlocks.TALL_FOREST_GRASS.get()));
    public static final RegistryObject<Item> FOREST_MUSHROOM_BLOCK = ITEMS.register("forest_mushroom_block", () -> blockItem(DreamBlocks.FOREST_MUSHROOM_BLOCK.get()));
    public static final RegistryObject<Item> FOREST_MUSHROOM = ITEMS.register("forest_mushroom", () -> blockItem(DreamBlocks.FOREST_MUSHROOM.get()));

    public static final RegistryObject<Item> GROUND_IVY = ITEMS.register("ground_ivy", () -> blockItem(DreamBlocks.GROUND_IVY.get()));
    public static final RegistryObject<Item> CLOVERS = ITEMS.register("clovers", () -> blockItem(DreamBlocks.CLOVERS.get()));
    public static final RegistryObject<Item> WHITE_CLOVERS = ITEMS.register("white_clovers", () -> blockItem(DreamBlocks.WHITE_CLOVERS.get()));
    public static final RegistryObject<Item> PINK_CLOVERS = ITEMS.register("pink_clovers", () -> blockItem(DreamBlocks.PINK_CLOVERS.get()));
    public static final RegistryObject<Item> PETUNIA = ITEMS.register("petunia", () -> blockItem(DreamBlocks.PETUNIA.get()));
    public static final RegistryObject<Item> PERIWINKLE = ITEMS.register("periwinkle", () -> blockItem(DreamBlocks.PERIWINKLE.get()));
    public static final RegistryObject<Item> PINK_FOXGLOVE = ITEMS.register("pink_foxglove", () -> blockItem(DreamBlocks.PINK_FOXGLOVE.get()));
    public static final RegistryObject<Item> PINK_HYACINTH = ITEMS.register("pink_hyacinth", () -> blockItem(DreamBlocks.PINK_HYACINTH.get()));
    public static final RegistryObject<Item> MAGENTA_HYACINTH = ITEMS.register("magenta_hyacinth", () -> blockItem(DreamBlocks.MAGENTA_HYACINTH.get()));
    public static final RegistryObject<Item> PURPLE_HYACINTH = ITEMS.register("purple_hyacinth", () -> blockItem(DreamBlocks.PURPLE_HYACINTH.get()));
    public static final RegistryObject<Item> VIOLETS = ITEMS.register("violets", () -> blockItem(DreamBlocks.VIOLETS.get()));

    /// dreamstone
    public static final RegistryObject<Item> DREAMSTONE = ITEMS.register("dreamstone", () -> blockItem(DreamBlocks.DREAMSTONE.get()));
    public static final RegistryObject<Item> DREAMSTONE_STAIRS = ITEMS.register("dreamstone_stairs", () -> blockItem(DreamBlocks.DREAMSTONE_STAIRS.get()));
    public static final RegistryObject<Item> DREAMSTONE_SLAB = ITEMS.register("dreamstone_slab", () -> blockItem(DreamBlocks.DREAMSTONE_SLAB.get()));
    public static final RegistryObject<Item> DREAMSTONE_PRESSURE_PLATE = ITEMS.register("dreamstone_pressure_plate", () -> blockItem(DreamBlocks.DREAMSTONE_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> DREAMSTONE_BUTTON = ITEMS.register("dreamstone_button", () -> blockItem(DreamBlocks.DREAMSTONE_BUTTON.get()));
    public static final RegistryObject<Item> DREAMSTONE_WALL = ITEMS.register("dreamstone_wall", () -> blockItem(DreamBlocks.DREAMSTONE_WALL.get()));
    public static final RegistryObject<Item> COBBLED_DREAMSTONE = ITEMS.register("cobbled_dreamstone", () -> blockItem(DreamBlocks.COBBLED_DREAMSTONE.get()));
    public static final RegistryObject<Item> COBBLED_DREAMSTONE_STAIRS = ITEMS.register("cobbled_dreamstone_stairs", () -> blockItem(DreamBlocks.COBBLED_DREAMSTONE_STAIRS.get()));
    public static final RegistryObject<Item> COBBLED_DREAMSTONE_SLAB = ITEMS.register("cobbled_dreamstone_slab", () -> blockItem(DreamBlocks.COBBLED_DREAMSTONE_SLAB.get()));
    public static final RegistryObject<Item> COBBLED_DREAMSTONE_WALL = ITEMS.register("cobbled_dreamstone_wall", () -> blockItem(DreamBlocks.COBBLED_DREAMSTONE_WALL.get()));
    public static final RegistryObject<Item> MOSSY_COBBLED_DREAMSTONE = ITEMS.register("mossy_cobbled_dreamstone", () -> blockItem(DreamBlocks.MOSSY_COBBLED_DREAMSTONE.get()));
    public static final RegistryObject<Item> MOSSY_COBBLED_DREAMSTONE_STAIRS = ITEMS.register("mossy_cobbled_dreamstone_stairs", () -> blockItem(DreamBlocks.MOSSY_COBBLED_DREAMSTONE_STAIRS.get()));
    public static final RegistryObject<Item> MOSSY_COBBLED_DREAMSTONE_SLAB = ITEMS.register("mossy_cobbled_dreamstone_slab", () -> blockItem(DreamBlocks.MOSSY_COBBLED_DREAMSTONE_SLAB.get()));
    public static final RegistryObject<Item> MOSSY_COBBLED_DREAMSTONE_WALL = ITEMS.register("mossy_cobbled_dreamstone_wall", () -> blockItem(DreamBlocks.MOSSY_COBBLED_DREAMSTONE_WALL.get()));
    public static final RegistryObject<Item> DREAMSTONE_BRICKS = ITEMS.register("dreamstone_bricks", () -> blockItem(DreamBlocks.DREAMSTONE_BRICKS.get()));
    public static final RegistryObject<Item> DREAMSTONE_BRICK_STAIRS = ITEMS.register("dreamstone_brick_stairs", () -> blockItem(DreamBlocks.DREAMSTONE_BRICK_STAIRS.get()));
    public static final RegistryObject<Item> DREAMSTONE_BRICK_SLAB = ITEMS.register("dreamstone_brick_slab", () -> blockItem(DreamBlocks.DREAMSTONE_BRICK_SLAB.get()));
    public static final RegistryObject<Item> DREAMSTONE_BRICK_WALL = ITEMS.register("dreamstone_brick_wall", () -> blockItem(DreamBlocks.DREAMSTONE_BRICK_WALL.get()));
    public static final RegistryObject<Item> CRACKED_DREAMSTONE_BRICKS = ITEMS.register("cracked_dreamstone_bricks", () -> blockItem(DreamBlocks.CRACKED_DREAMSTONE_BRICKS.get()));
    public static final RegistryObject<Item> CHISELED_DREAMSTONE_BRICKS = ITEMS.register("chiseled_dreamstone_bricks", () -> blockItem(DreamBlocks.CHISELED_DREAMSTONE_BRICKS.get()));
    public static final RegistryObject<Item> MOSSY_DREAMSTONE_BRICKS = ITEMS.register("mossy_dreamstone_bricks", () -> blockItem(DreamBlocks.MOSSY_DREAMSTONE_BRICKS.get()));
    public static final RegistryObject<Item> MOSSY_DREAMSTONE_BRICK_STAIRS = ITEMS.register("mossy_dreamstone_stairs", () -> blockItem(DreamBlocks.MOSSY_DREAMSTONE_BRICK_STAIRS.get()));
    public static final RegistryObject<Item> MOSSY_DREAMSTONE_BRICK_SLAB = ITEMS.register("mossy_dreamstone_brick_slab", () -> blockItem(DreamBlocks.MOSSY_DREAMSTONE_BRICK_SLAB.get()));
    public static final RegistryObject<Item> MOSSY_DREAMSTONE_BRICK_WALL = ITEMS.register("mossy_dreamstone_brick_wall", () -> blockItem(DreamBlocks.MOSSY_DREAMSTONE_BRICK_WALL.get()));

    /// dreamy wood
    public static final RegistryObject<Item> DREAMY_LEAVES = ITEMS.register("dreamy_leaves", () -> blockItem(DreamBlocks.DREAMY_LEAVES.get()));
    public static final RegistryObject<Item> DREAMY_SAPLING = ITEMS.register("dreamy_sapling", () -> blockItem(DreamBlocks.DREAMY_SAPLING.get()));
    public static final RegistryObject<Item> DREAMY_LOG = ITEMS.register("dreamy_log", () -> blockItem(DreamBlocks.DREAMY_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_DREAMY_LOG = ITEMS.register("stripped_dreamy_log", () -> blockItem(DreamBlocks.STRIPPED_DREAMY_LOG.get()));
    public static final RegistryObject<Item> DREAMY_WOOD = ITEMS.register("dreamy_wood", () -> blockItem(DreamBlocks.DREAMY_WOOD.get()));
    public static final RegistryObject<Item> STRIPPED_DREAMY_WOOD = ITEMS.register("stripped_dreamy_wood", () -> blockItem(DreamBlocks.STRIPPED_DREAMY_WOOD.get()));
    public static final RegistryObject<Item> DREAMY_PLANKS = ITEMS.register("dreamy_planks", () -> blockItem(DreamBlocks.DREAMY_PLANKS.get()));
    public static final RegistryObject<Item> DREAMY_STAIRS = ITEMS.register("dreamy_stairs", () -> blockItem(DreamBlocks.DREAMY_STAIRS.get()));
    public static final RegistryObject<Item> DREAMY_SLAB = ITEMS.register("dreamy_slab", () -> blockItem(DreamBlocks.DREAMY_SLAB.get()));
    public static final RegistryObject<Item> DREAMY_FENCE = ITEMS.register("dreamy_fence", () -> blockItem(DreamBlocks.DREAMY_FENCE.get()));
    public static final RegistryObject<Item> DREAMY_FENCE_GATE = ITEMS.register("dreamy_fence_gate", () -> blockItem(DreamBlocks.DREAMY_FENCE_GATE.get()));
    public static final RegistryObject<Item> DREAMY_BUTTON = ITEMS.register("dreamy_button", () -> blockItem(DreamBlocks.DREAMY_BUTTON.get()));
    public static final RegistryObject<Item> DREAMY_PRESSURE_PLATE = ITEMS.register("dreamy_pressure_plate", () -> blockItem(DreamBlocks.DREAMY_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> DREAMY_TRAPDOOR = ITEMS.register("dreamy_trapdoor", () -> blockItem(DreamBlocks.DREAMY_TRAPDOOR.get()));
    public static final RegistryObject<Item> DREAMY_DOOR = ITEMS.register("dreamy_door", () -> blockItem(DreamBlocks.DREAMY_DOOR.get()));
    public static final RegistryObject<Item> DREAMY_SIGN = ITEMS.register("dreamy_sign", () -> signItem(DreamBlocks.DREAMY_SIGN.get(), DreamBlocks.DREAMY_WALL_SIGN.get()));
    public static final RegistryObject<Item> DREAMY_HANGING_SIGN = ITEMS.register("dreamy_hanging_sign", () -> hangingSignItem(DreamBlocks.DREAMY_HANGING_SIGN.get(), DreamBlocks.DREAMY_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> DREAMY_BOAT = ITEMS.register("dreamy_boat", () -> boatItem(DreamBoat.Type.DREAMY));
    public static final RegistryObject<Item> DREAMY_CHEST_BOAT = ITEMS.register("dreamy_chest_boat", () -> chestBoatItem(DreamBoat.Type.DREAMY));

    /// aspen forest
    ///public static final RegistryObject<Item> ASPEN_LEAVES = ITEMS.register("aspen_leaves", () -> blockItem(DreamBlocks.ASPEN_LEAVES.get()));
    ///public static final RegistryObject<Item> ASPEN_SAPLING = ITEMS.register("aspen_sapling", () -> blockItem(DreamBlocks.ASPEN_SAPLING.get()));
    ///public static final RegistryObject<Item> ASPEN_LOG = ITEMS.register("aspen_log", () -> blockItem(DreamBlocks.ASPEN_LOG.get()));
    ///public static final RegistryObject<Item> STRIPPED_ASPEN_LOG = ITEMS.register("stripped_aspen_log", () -> blockItem(DreamBlocks.STRIPPED_ASPEN_LOG.get()));
    ///public static final RegistryObject<Item> ASPEN_WOOD = ITEMS.register("aspen_wood", () -> blockItem(DreamBlocks.ASPEN_WOOD.get()));
    ///public static final RegistryObject<Item> STRIPPED_ASPEN_WOOD = ITEMS.register("stripped_aspen_wood", () -> blockItem(DreamBlocks.STRIPPED_ASPEN_WOOD.get()));
    ///public static final RegistryObject<Item> ASPEN_PLANKS = ITEMS.register("aspen_planks", () -> blockItem(DreamBlocks.ASPEN_PLANKS.get()));
    ///public static final RegistryObject<Item> ASPEN_STAIRS = ITEMS.register("aspen_stairs", () -> blockItem(DreamBlocks.ASPEN_STAIRS.get()));
    ///public static final RegistryObject<Item> ASPEN_SLAB = ITEMS.register("aspen_slab", () -> blockItem(DreamBlocks.ASPEN_SLAB.get()));
    ///public static final RegistryObject<Item> ASPEN_FENCE = ITEMS.register("aspen_fence", () -> blockItem(DreamBlocks.ASPEN_FENCE.get()));
    ///public static final RegistryObject<Item> ASPEN_FENCE_GATE = ITEMS.register("aspen_fence_gate", () -> blockItem(DreamBlocks.ASPEN_FENCE_GATE.get()));
    ///public static final RegistryObject<Item> ASPEN_BUTTON = ITEMS.register("aspen_button", () -> blockItem(DreamBlocks.ASPEN_BUTTON.get()));
    ///public static final RegistryObject<Item> ASPEN_PRESSURE_PLATE = ITEMS.register("aspen_pressure_plate", () -> blockItem(DreamBlocks.ASPEN_PRESSURE_PLATE.get()));
    ///public static final RegistryObject<Item> ASPEN_TRAPDOOR = ITEMS.register("aspen_trapdoor", () -> blockItem(DreamBlocks.ASPEN_TRAPDOOR.get()));
    ///public static final RegistryObject<Item> ASPEN_DOOR = ITEMS.register("aspen_door", () -> blockItem(DreamBlocks.ASPEN_DOOR.get()));
    ///public static final RegistryObject<Item> ASPEN_SIGN = ITEMS.register("aspen_sign", () -> signItem(DreamBlocks.ASPEN_SIGN.get(), DreamBlocks.ASPEN_WALL_SIGN.get()));
    ///public static final RegistryObject<Item> ASPEN_HANGING_SIGN = ITEMS.register("aspen_hanging_sign", () -> hangingSignItem(DreamBlocks.ASPEN_HANGING_SIGN.get(), DreamBlocks.ASPEN_WALL_HANGING_SIGN.get()));
    ///public static final RegistryObject<Item> ASPEN_BOAT = ITEMS.register("aspen_boat", () -> boatItem(DreamBoat.Type.ASPEN));
    ///public static final RegistryObject<Item> ASPEN_CHEST_BOAT = ITEMS.register("aspen_chest_boat", () -> chestBoatItem(DreamBoat.Type.ASPEN));

    /// evergreen forest
    public static final RegistryObject<Item> EVERGREEN_LEAVES = ITEMS.register("evergreen_leaves", () -> blockItem(DreamBlocks.EVERGREEN_LEAVES.get()));
    public static final RegistryObject<Item> EVERGREEN_SAPLING = ITEMS.register("evergreen_sapling", () -> blockItem(DreamBlocks.EVERGREEN_SAPLING.get()));
    public static final RegistryObject<Item> EVERGREEN_LOG = ITEMS.register("evergreen_log", () -> blockItem(DreamBlocks.EVERGREEN_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_EVERGREEN_LOG = ITEMS.register("stripped_evergreen_log", () -> blockItem(DreamBlocks.STRIPPED_EVERGREEN_LOG.get()));
    public static final RegistryObject<Item> EVERGREEN_WOOD = ITEMS.register("evergreen_wood", () -> blockItem(DreamBlocks.EVERGREEN_WOOD.get()));
    public static final RegistryObject<Item> STRIPPED_EVERGREEN_WOOD = ITEMS.register("stripped_evergreen_wood", () -> blockItem(DreamBlocks.STRIPPED_EVERGREEN_WOOD.get()));
    public static final RegistryObject<Item> EVERGREEN_PLANKS = ITEMS.register("evergreen_planks", () -> blockItem(DreamBlocks.EVERGREEN_PLANKS.get()));
    public static final RegistryObject<Item> EVERGREEN_STAIRS = ITEMS.register("evergreen_stairs", () -> blockItem(DreamBlocks.EVERGREEN_STAIRS.get()));
    public static final RegistryObject<Item> EVERGREEN_SLAB = ITEMS.register("evergreen_slab", () -> blockItem(DreamBlocks.EVERGREEN_SLAB.get()));
    public static final RegistryObject<Item> EVERGREEN_FENCE = ITEMS.register("evergreen_fence", () -> blockItem(DreamBlocks.EVERGREEN_FENCE.get()));
    public static final RegistryObject<Item> EVERGREEN_FENCE_GATE = ITEMS.register("evergreen_fence_gate", () -> blockItem(DreamBlocks.EVERGREEN_FENCE_GATE.get()));
    public static final RegistryObject<Item> EVERGREEN_BUTTON = ITEMS.register("evergreen_button", () -> blockItem(DreamBlocks.EVERGREEN_BUTTON.get()));
    public static final RegistryObject<Item> EVERGREEN_PRESSURE_PLATE = ITEMS.register("evergreen_pressure_plate", () -> blockItem(DreamBlocks.EVERGREEN_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> EVERGREEN_TRAPDOOR = ITEMS.register("evergreen_trapdoor", () -> blockItem(DreamBlocks.EVERGREEN_TRAPDOOR.get()));
    public static final RegistryObject<Item> EVERGREEN_DOOR = ITEMS.register("evergreen_door", () -> blockItem(DreamBlocks.EVERGREEN_DOOR.get()));
    public static final RegistryObject<Item> EVERGREEN_SIGN = ITEMS.register("evergreen_sign", () -> signItem(DreamBlocks.EVERGREEN_SIGN.get(), DreamBlocks.EVERGREEN_WALL_SIGN.get()));
    public static final RegistryObject<Item> EVERGREEN_HANGING_SIGN = ITEMS.register("evergreen_hanging_sign", () -> hangingSignItem(DreamBlocks.EVERGREEN_HANGING_SIGN.get(), DreamBlocks.EVERGREEN_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> EVERGREEN_BOAT = ITEMS.register("evergreen_boat", () -> boatItem(DreamBoat.Type.EVERGREEN));
    public static final RegistryObject<Item> EVERGREEN_CHEST_BOAT = ITEMS.register("evergreen_chest_boat", () -> chestBoatItem(DreamBoat.Type.EVERGREEN));

    public static final RegistryObject<Item> TOADSTOOL_BLOCK = ITEMS.register("toadstool_block", () -> blockItem(DreamBlocks.TOADSTOOL_BLOCK.get()));
    public static final RegistryObject<Item> TOADSTOOL = ITEMS.register("toadstool", () -> blockItem(DreamBlocks.TOADSTOOL.get()));

    /// ethereal forest
    public static final RegistryObject<Item> ETHEREAL_LEAVES = ITEMS.register("ethereal_leaves", () -> blockItem(DreamBlocks.ETHEREAL_LEAVES.get()));
    public static final RegistryObject<Item> ETHEREAL_SAPLING = ITEMS.register("ethereal_sapling", () -> blockItem(DreamBlocks.ETHEREAL_SAPLING.get()));
    public static final RegistryObject<Item> ETHEREAL_LOG = ITEMS.register("ethereal_log", () -> blockItem(DreamBlocks.ETHEREAL_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_ETHEREAL_LOG = ITEMS.register("stripped_ethereal_log", () -> blockItem(DreamBlocks.STRIPPED_ETHEREAL_LOG.get()));
    public static final RegistryObject<Item> ETHEREAL_WOOD = ITEMS.register("ethereal_wood", () -> blockItem(DreamBlocks.ETHEREAL_WOOD.get()));
    public static final RegistryObject<Item> STRIPPED_ETHEREAL_WOOD = ITEMS.register("stripped_ethereal_wood", () -> blockItem(DreamBlocks.STRIPPED_ETHEREAL_WOOD.get()));
    public static final RegistryObject<Item> ETHEREAL_PLANKS = ITEMS.register("ethereal_planks", () -> blockItem(DreamBlocks.ETHEREAL_PLANKS.get()));
    public static final RegistryObject<Item> ETHEREAL_STAIRS = ITEMS.register("ethereal_stairs", () -> blockItem(DreamBlocks.ETHEREAL_STAIRS.get()));
    public static final RegistryObject<Item> ETHEREAL_SLAB = ITEMS.register("ethereal_slab", () -> blockItem(DreamBlocks.ETHEREAL_SLAB.get()));
    public static final RegistryObject<Item> ETHEREAL_FENCE = ITEMS.register("ethereal_fence", () -> blockItem(DreamBlocks.ETHEREAL_FENCE.get()));
    public static final RegistryObject<Item> ETHEREAL_FENCE_GATE = ITEMS.register("ethereal_fence_gate", () -> blockItem(DreamBlocks.ETHEREAL_FENCE_GATE.get()));
    public static final RegistryObject<Item> ETHEREAL_BUTTON = ITEMS.register("ethereal_button", () -> blockItem(DreamBlocks.ETHEREAL_BUTTON.get()));
    public static final RegistryObject<Item> ETHEREAL_PRESSURE_PLATE = ITEMS.register("ethereal_pressure_plate", () -> blockItem(DreamBlocks.ETHEREAL_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> ETHEREAL_TRAPDOOR = ITEMS.register("ethereal_trapdoor", () -> blockItem(DreamBlocks.ETHEREAL_TRAPDOOR.get()));
    public static final RegistryObject<Item> ETHEREAL_DOOR = ITEMS.register("ethereal_door", () -> blockItem(DreamBlocks.ETHEREAL_DOOR.get()));
    public static final RegistryObject<Item> ETHEREAL_SIGN = ITEMS.register("ethereal_sign", () -> signItem(DreamBlocks.ETHEREAL_SIGN.get(), DreamBlocks.ETHEREAL_WALL_SIGN.get()));
    public static final RegistryObject<Item> ETHEREAL_HANGING_SIGN = ITEMS.register("ethereal_hanging_sign", () -> hangingSignItem(DreamBlocks.ETHEREAL_HANGING_SIGN.get(), DreamBlocks.ETHEREAL_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> ETHEREAL_BOAT = ITEMS.register("ethereal_boat", () -> boatItem(DreamBoat.Type.ETHEREAL));
    public static final RegistryObject<Item> ETHEREAL_CHEST_BOAT = ITEMS.register("ethereal_chest_boat", () -> chestBoatItem(DreamBoat.Type.ETHEREAL));

    public static final RegistryObject<Item> LILAC_BUSH_LEAVES = ITEMS.register("lilac_bush_leaves", () -> blockItem(DreamBlocks.LILAC_BUSH_LEAVES.get()));
    public static final RegistryObject<Item> LILAC_BUSH = ITEMS.register("lilac_bush", () -> blockItem(DreamBlocks.LILAC_BUSH.get()));

    /// cotton candy forest
    public static final RegistryObject<Item> PINK_COTTON_CANDY_BLOCK = ITEMS.register("pink_cotton_candy_block", () -> blockItem(DreamBlocks.PINK_COTTON_CANDY_BLOCK.get()));
    public static final RegistryObject<Item> PINK_COTTON_CANDY_SAPLING = ITEMS.register("pink_cotton_candy_sapling", () -> blockItem(DreamBlocks.PINK_COTTON_CANDY_SAPLING.get()));
    public static final RegistryObject<Item> BLUE_COTTON_CANDY_BLOCK = ITEMS.register("blue_cotton_candy_block", () -> blockItem(DreamBlocks.BLUE_COTTON_CANDY_BLOCK.get()));
    public static final RegistryObject<Item> BLUE_COTTON_CANDY_SAPLING = ITEMS.register("blue_cotton_candy_sapling", () -> blockItem(DreamBlocks.BLUE_COTTON_CANDY_SAPLING.get()));
    public static final RegistryObject<Item> CANDY_LOG = ITEMS.register("candy_log", () -> blockItem(DreamBlocks.CANDY_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_CANDY_LOG = ITEMS.register("stripped_candy_log", () -> blockItem(DreamBlocks.STRIPPED_CANDY_LOG.get()));
    public static final RegistryObject<Item> CANDY_WOOD = ITEMS.register("candy_wood", () -> blockItem(DreamBlocks.CANDY_WOOD.get()));
    public static final RegistryObject<Item> STRIPPED_CANDY_WOOD = ITEMS.register("stripped_candy_wood", () -> blockItem(DreamBlocks.STRIPPED_CANDY_WOOD.get()));
    public static final RegistryObject<Item> CANDY_PLANKS = ITEMS.register("candy_planks", () -> blockItem(DreamBlocks.CANDY_PLANKS.get()));
    public static final RegistryObject<Item> CANDY_STAIRS = ITEMS.register("candy_stairs", () -> blockItem(DreamBlocks.CANDY_STAIRS.get()));
    public static final RegistryObject<Item> CANDY_SLAB = ITEMS.register("candy_slab", () -> blockItem(DreamBlocks.CANDY_SLAB.get()));
    public static final RegistryObject<Item> CANDY_FENCE = ITEMS.register("candy_fence", () -> blockItem(DreamBlocks.CANDY_FENCE.get()));
    public static final RegistryObject<Item> CANDY_FENCE_GATE = ITEMS.register("candy_fence_gate", () -> blockItem(DreamBlocks.CANDY_FENCE_GATE.get()));
    public static final RegistryObject<Item> CANDY_BUTTON = ITEMS.register("candy_button", () -> blockItem(DreamBlocks.CANDY_BUTTON.get()));
    public static final RegistryObject<Item> CANDY_PRESSURE_PLATE = ITEMS.register("candy_pressure_plate", () -> blockItem(DreamBlocks.CANDY_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> CANDY_TRAPDOOR = ITEMS.register("candy_trapdoor", () -> blockItem(DreamBlocks.CANDY_TRAPDOOR.get()));
    public static final RegistryObject<Item> CANDY_DOOR = ITEMS.register("candy_door", () -> blockItem(DreamBlocks.CANDY_DOOR.get()));
    public static final RegistryObject<Item> CANDY_SIGN = ITEMS.register("candy_sign", () -> signItem(DreamBlocks.CANDY_SIGN.get(), DreamBlocks.CANDY_WALL_SIGN.get()));
    public static final RegistryObject<Item> CANDY_HANGING_SIGN = ITEMS.register("candy_hanging_sign", () -> hangingSignItem(DreamBlocks.CANDY_HANGING_SIGN.get(), DreamBlocks.CANDY_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> CANDY_BOAT = ITEMS.register("candy_boat", () -> boatItem(DreamBoat.Type.CANDY));
    public static final RegistryObject<Item> CANDY_CHEST_BOAT = ITEMS.register("candy_chest_boat", () -> chestBoatItem(DreamBoat.Type.CANDY));

    /// wisteria grove
    public static final RegistryObject<Item> WISTERIA_LEAVES = ITEMS.register("wisteria_leaves", () -> blockItem(DreamBlocks.WISTERIA_LEAVES.get()));
    public static final RegistryObject<Item> WISTERIA_BLOSSOMS = ITEMS.register("wisteria_blossoms", () -> blockItem(DreamBlocks.WISTERIA_BLOSSOMS.get()));
    public static final RegistryObject<Item> WISTERIA_SAPLING = ITEMS.register("wisteria_sapling", () -> blockItem(DreamBlocks.WISTERIA_SAPLING.get()));
    public static final RegistryObject<Item> WISTERIA_LOG = ITEMS.register("wisteria_log", () -> blockItem(DreamBlocks.WISTERIA_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_WISTERIA_LOG = ITEMS.register("stripped_wisteria_log", () -> blockItem(DreamBlocks.STRIPPED_WISTERIA_LOG.get()));
    public static final RegistryObject<Item> WISTERIA_WOOD = ITEMS.register("wisteria_wood", () -> blockItem(DreamBlocks.WISTERIA_WOOD.get()));
    public static final RegistryObject<Item> STRIPPED_WISTERIA_WOOD = ITEMS.register("stripped_wisteria_wood", () -> blockItem(DreamBlocks.STRIPPED_WISTERIA_WOOD.get()));
    public static final RegistryObject<Item> WISTERIA_PLANKS = ITEMS.register("wisteria_planks", () -> blockItem(DreamBlocks.WISTERIA_PLANKS.get()));
    public static final RegistryObject<Item> WISTERIA_STAIRS = ITEMS.register("wisteria_stairs", () -> blockItem(DreamBlocks.WISTERIA_STAIRS.get()));
    public static final RegistryObject<Item> WISTERIA_SLAB = ITEMS.register("wisteria_slab", () -> blockItem(DreamBlocks.WISTERIA_SLAB.get()));
    public static final RegistryObject<Item> WISTERIA_FENCE = ITEMS.register("wisteria_fence", () -> blockItem(DreamBlocks.WISTERIA_FENCE.get()));
    public static final RegistryObject<Item> WISTERIA_FENCE_GATE = ITEMS.register("wisteria_fence_gate", () -> blockItem(DreamBlocks.WISTERIA_FENCE_GATE.get()));
    public static final RegistryObject<Item> WISTERIA_BUTTON = ITEMS.register("wisteria_button", () -> blockItem(DreamBlocks.WISTERIA_BUTTON.get()));
    public static final RegistryObject<Item> WISTERIA_PRESSURE_PLATE = ITEMS.register("wisteria_pressure_plate", () -> blockItem(DreamBlocks.WISTERIA_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> WISTERIA_TRAPDOOR = ITEMS.register("wisteria_trapdoor", () -> blockItem(DreamBlocks.WISTERIA_TRAPDOOR.get()));
    public static final RegistryObject<Item> WISTERIA_DOOR = ITEMS.register("wisteria_door", () -> blockItem(DreamBlocks.WISTERIA_DOOR.get()));
    public static final RegistryObject<Item> WISTERIA_SIGN = ITEMS.register("wisteria_sign", () -> signItem(DreamBlocks.WISTERIA_SIGN.get(), DreamBlocks.WISTERIA_WALL_SIGN.get()));
    public static final RegistryObject<Item> WISTERIA_HANGING_SIGN = ITEMS.register("wisteria_hanging_sign", () -> hangingSignItem(DreamBlocks.WISTERIA_HANGING_SIGN.get(), DreamBlocks.WISTERIA_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> WISTERIA_BOAT = ITEMS.register("wisteria_boat", () -> boatItem(DreamBoat.Type.WISTERIA));
    public static final RegistryObject<Item> WISTERIA_CHEST_BOAT = ITEMS.register("wisteria_chest_boat", () -> chestBoatItem(DreamBoat.Type.WISTERIA));

    public static final RegistryObject<Item> WISTERIA = ITEMS.register("wisteria", () -> new ItemNameBlockItem(DreamBlocks.WISTERIA.get(), new Item.Properties()));

    /// flower fields

    /// faerie forest
    public static final RegistryObject<Item> MYSTICAL_LEAVES = ITEMS.register("mystical_leaves", () -> blockItem(DreamBlocks.MYSTICAL_LEAVES.get()));
    public static final RegistryObject<Item> MYSTICAL_SAPLING = ITEMS.register("mystical_sapling", () -> blockItem(DreamBlocks.MYSTICAL_SAPLING.get()));
    public static final RegistryObject<Item> MYSTICAL_LOG = ITEMS.register("mystical_log", () -> blockItem(DreamBlocks.MYSTICAL_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_MYSTICAL_LOG = ITEMS.register("stripped_mystical_log", () -> blockItem(DreamBlocks.STRIPPED_MYSTICAL_LOG.get()));
    public static final RegistryObject<Item> MYSTICAL_WOOD = ITEMS.register("mystical_wood", () -> blockItem(DreamBlocks.MYSTICAL_WOOD.get()));
    public static final RegistryObject<Item> STRIPPED_MYSTICAL_WOOD = ITEMS.register("stripped_mystical_wood", () -> blockItem(DreamBlocks.STRIPPED_MYSTICAL_WOOD.get()));
    public static final RegistryObject<Item> MYSTICAL_PLANKS = ITEMS.register("mystical_planks", () -> blockItem(DreamBlocks.MYSTICAL_PLANKS.get()));
    public static final RegistryObject<Item> MYSTICAL_STAIRS = ITEMS.register("mystical_stairs", () -> blockItem(DreamBlocks.MYSTICAL_STAIRS.get()));
    public static final RegistryObject<Item> MYSTICAL_SLAB = ITEMS.register("mystical_slab", () -> blockItem(DreamBlocks.MYSTICAL_SLAB.get()));
    public static final RegistryObject<Item> MYSTICAL_FENCE = ITEMS.register("mystical_fence", () -> blockItem(DreamBlocks.MYSTICAL_FENCE.get()));
    public static final RegistryObject<Item> MYSTICAL_FENCE_GATE = ITEMS.register("mystical_fence_gate", () -> blockItem(DreamBlocks.MYSTICAL_FENCE_GATE.get()));
    public static final RegistryObject<Item> MYSTICAL_BUTTON = ITEMS.register("mystical_button", () -> blockItem(DreamBlocks.MYSTICAL_BUTTON.get()));
    public static final RegistryObject<Item> MYSTICAL_PRESSURE_PLATE = ITEMS.register("mystical_pressure_plate", () -> blockItem(DreamBlocks.MYSTICAL_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> MYSTICAL_TRAPDOOR = ITEMS.register("mystical_trapdoor", () -> blockItem(DreamBlocks.MYSTICAL_TRAPDOOR.get()));
    public static final RegistryObject<Item> MYSTICAL_DOOR = ITEMS.register("mystical_door", () -> blockItem(DreamBlocks.MYSTICAL_DOOR.get()));
    public static final RegistryObject<Item> MYSTICAL_SIGN = ITEMS.register("mystical_sign", () -> signItem(DreamBlocks.MYSTICAL_SIGN.get(), DreamBlocks.MYSTICAL_WALL_SIGN.get()));
    public static final RegistryObject<Item> MYSTICAL_HANGING_SIGN = ITEMS.register("mystical_hanging_sign", () -> hangingSignItem(DreamBlocks.MYSTICAL_HANGING_SIGN.get(), DreamBlocks.MYSTICAL_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> MYSTICAL_BOAT = ITEMS.register("mystical_boat", () -> boatItem(DreamBoat.Type.MYSTICAL));
    public static final RegistryObject<Item> MYSTICAL_CHEST_BOAT = ITEMS.register("mystical_chest_boat", () -> chestBoatItem(DreamBoat.Type.MYSTICAL));

    public static final RegistryObject<Item> FAIRY_ROSE_BUSH_LEAVES = ITEMS.register("fairy_rose_bush_leaves", () -> blockItem(DreamBlocks.FAIRY_ROSE_BUSH_LEAVES.get()));
    public static final RegistryObject<Item> FAIRY_ROSE_BUSH = ITEMS.register("fairy_rose_bush", () -> blockItem(DreamBlocks.FAIRY_ROSE_BUSH.get()));

    public static final RegistryObject<Item> PINK_MUSHROOM_BLOCK = ITEMS.register("pink_mushroom_block", () -> blockItem(DreamBlocks.PINK_MUSHROOM_BLOCK.get()));
    public static final RegistryObject<Item> PINK_MUSHROOM = ITEMS.register("pink_mushroom", () -> blockItem(DreamBlocks.PINK_MUSHROOM.get()));

    /// mushroom wood
    public static final RegistryObject<Item> MUSHROOM_STEM = ITEMS.register("mushroom_stem", () -> blockItem(DreamBlocks.MUSHROOM_STEM.get()));
    public static final RegistryObject<Item> STRIPPED_MUSHROOM_STEM = ITEMS.register("stripped_mushroom_stem", () -> blockItem(DreamBlocks.STRIPPED_MUSHROOM_STEM.get()));
    public static final RegistryObject<Item> MUSHROOM_HYPHAE = ITEMS.register("mushroom_hyphae", () -> blockItem(DreamBlocks.MUSHROOM_HYPHAE.get()));
    public static final RegistryObject<Item> STRIPPED_MUSHROOM_HYPHAE = ITEMS.register("stripped_mushroom_hyphae", () -> blockItem(DreamBlocks.STRIPPED_MUSHROOM_HYPHAE.get()));
    public static final RegistryObject<Item> MUSHROOM_PLANKS = ITEMS.register("mushroom_planks", () -> blockItem(DreamBlocks.MUSHROOM_PLANKS.get()));
    public static final RegistryObject<Item> MUSHROOM_STAIRS = ITEMS.register("mushroom_stairs", () -> blockItem(DreamBlocks.MUSHROOM_STAIRS.get()));
    public static final RegistryObject<Item> MUSHROOM_SLAB = ITEMS.register("mushroom_slab", () -> blockItem(DreamBlocks.MUSHROOM_SLAB.get()));
    public static final RegistryObject<Item> MUSHROOM_FENCE = ITEMS.register("mushroom_fence", () -> blockItem(DreamBlocks.MUSHROOM_FENCE.get()));
    public static final RegistryObject<Item> MUSHROOM_FENCE_GATE = ITEMS.register("mushroom_fence_gate", () -> blockItem(DreamBlocks.MUSHROOM_FENCE_GATE.get()));
    public static final RegistryObject<Item> MUSHROOM_BUTTON = ITEMS.register("mushroom_button", () -> blockItem(DreamBlocks.MUSHROOM_BUTTON.get()));
    public static final RegistryObject<Item> MUSHROOM_PRESSURE_PLATE = ITEMS.register("mushroom_pressure_plate", () -> blockItem(DreamBlocks.MUSHROOM_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> MUSHROOM_TRAPDOOR = ITEMS.register("mushroom_trapdoor", () -> blockItem(DreamBlocks.MUSHROOM_TRAPDOOR.get()));
    public static final RegistryObject<Item> MUSHROOM_DOOR = ITEMS.register("mushroom_door", () -> blockItem(DreamBlocks.MUSHROOM_DOOR.get()));
    public static final RegistryObject<Item> MUSHROOM_SIGN = ITEMS.register("mushroom_sign", () -> signItem(DreamBlocks.MUSHROOM_SIGN.get(), DreamBlocks.MUSHROOM_WALL_SIGN.get()));
    public static final RegistryObject<Item> MUSHROOM_HANGING_SIGN = ITEMS.register("mushroom_hanging_sign", () -> hangingSignItem(DreamBlocks.MUSHROOM_HANGING_SIGN.get(), DreamBlocks.MUSHROOM_WALL_HANGING_SIGN.get()));
    public static final RegistryObject<Item> MUSHROOM_BOAT = ITEMS.register("mushroom_boat", () -> boatItem(DreamBoat.Type.MUSHROOM));
    public static final RegistryObject<Item> MUSHROOM_CHEST_BOAT = ITEMS.register("mushroom_chest_boat", () -> chestBoatItem(DreamBoat.Type.MUSHROOM));

    ///public static final RegistryObject<Item> GRIMSTONE = ITEMS.register("grimstone", () -> blockItem(DreamBlocks.GRIMSTONE.get()));
    ///public static final RegistryObject<Item> GRIMSTONE_STAIRS = ITEMS.register("grimstone_stairs", () -> blockItem(DreamBlocks.GRIMSTONE_STAIRS.get()));
    ///public static final RegistryObject<Item> GRIMSTONE_SLAB = ITEMS.register("grimstone_slab", () -> blockItem(DreamBlocks.GRIMSTONE_SLAB.get()));
    ///public static final RegistryObject<Item> GRIMSTONE_PRESSURE_PLATE = ITEMS.register("grimstone_pressure_plate", () -> blockItem(DreamBlocks.GRIMSTONE_PRESSURE_PLATE.get()));
    ///public static final RegistryObject<Item> GRIMSTONE_BUTTON = ITEMS.register("grimstone_button", () -> blockItem(DreamBlocks.GRIMSTONE_BUTTON.get()));
    ///public static final RegistryObject<Item> GRIMSTONE_WALL = ITEMS.register("grimstone_wall", () -> blockItem(DreamBlocks.GRIMSTONE_WALL.get()));
    ///public static final RegistryObject<Item> COBBLED_GRIMSTONE = ITEMS.register("cobbled_grimstone", () -> blockItem(DreamBlocks.COBBLED_GRIMSTONE.get()));
    ///public static final RegistryObject<Item> COBBLED_GRIMSTONE_STAIRS = ITEMS.register("cobbled_grimstone_stairs", () -> blockItem(DreamBlocks.COBBLED_GRIMSTONE_STAIRS.get()));
    ///public static final RegistryObject<Item> COBBLED_GRIMSTONE_SLAB = ITEMS.register("cobbled_grimstone_slab", () -> blockItem(DreamBlocks.COBBLED_GRIMSTONE_SLAB.get()));
    ///public static final RegistryObject<Item> COBBLED_GRIMSTONE_WALL = ITEMS.register("cobbled_grimstone_wall", () -> blockItem(DreamBlocks.COBBLED_GRIMSTONE_WALL.get()));
    ///public static final RegistryObject<Item> MOSSY_COBBLED_GRIMSTONE = ITEMS.register("mossy_cobbled_grimstone", () -> blockItem(DreamBlocks.MOSSY_COBBLED_GRIMSTONE.get()));
    ///public static final RegistryObject<Item> MOSSY_COBBLED_GRIMSTONE_STAIRS = ITEMS.register("mossy_cobbled_grimstone_stairs", () -> blockItem(DreamBlocks.MOSSY_COBBLED_GRIMSTONE_STAIRS.get()));
    ///public static final RegistryObject<Item> MOSSY_COBBLED_GRIMSTONE_SLAB = ITEMS.register("mossy_cobbled_grimstone_slab", () -> blockItem(DreamBlocks.MOSSY_COBBLED_GRIMSTONE_SLAB.get()));
    ///public static final RegistryObject<Item> MOSSY_COBBLED_GRIMSTONE_WALL = ITEMS.register("mossy_cobbled_grimstone_wall", () -> blockItem(DreamBlocks.MOSSY_COBBLED_GRIMSTONE_WALL.get()));
    ///public static final RegistryObject<Item> GRIMSTONE_BRICKS = ITEMS.register("grimstone_bricks", () -> blockItem(DreamBlocks.GRIMSTONE_BRICKS.get()));
    ///public static final RegistryObject<Item> GRIMSTONE_BRICK_STAIRS = ITEMS.register("grimstone_brick_stairs", () -> blockItem(DreamBlocks.GRIMSTONE_BRICK_STAIRS.get()));
    ///public static final RegistryObject<Item> GRIMSTONE_BRICK_SLAB = ITEMS.register("grimstone_brick_slab", () -> blockItem(DreamBlocks.GRIMSTONE_BRICK_SLAB.get()));
    ///public static final RegistryObject<Item> GRIMSTONE_BRICK_WALL = ITEMS.register("grimstone_brick_wall", () -> blockItem(DreamBlocks.GRIMSTONE_BRICK_WALL.get()));
    ///public static final RegistryObject<Item> CRACKED_GRIMSTONE_BRICKS = ITEMS.register("cracked_grimstone_bricks", () -> blockItem(DreamBlocks.CRACKED_GRIMSTONE_BRICKS.get()));
    ///public static final RegistryObject<Item> CHISELED_GRIMSTONE_BRICKS = ITEMS.register("chiseled_grimstone_bricks", () -> blockItem(DreamBlocks.CHISELED_GRIMSTONE_BRICKS.get()));
    ///public static final RegistryObject<Item> MOSSY_GRIMSTONE_BRICKS = ITEMS.register("mossy_grimstone_bricks", () -> blockItem(DreamBlocks.MOSSY_GRIMSTONE_BRICKS.get()));
    ///public static final RegistryObject<Item> MOSSY_GRIMSTONE_BRICK_STAIRS = ITEMS.register("mossy_grimstone_stairs", () -> blockItem(DreamBlocks.MOSSY_GRIMSTONE_BRICK_STAIRS.get()));
    ///public static final RegistryObject<Item> MOSSY_GRIMSTONE_BRICK_SLAB = ITEMS.register("mossy_grimstone_brick_slab", () -> blockItem(DreamBlocks.MOSSY_GRIMSTONE_BRICK_SLAB.get()));
    ///public static final RegistryObject<Item> MOSSY_GRIMSTONE_BRICK_WALL = ITEMS.register("mossy_grimstone_brick_wall", () -> blockItem(DreamBlocks.MOSSY_GRIMSTONE_BRICK_WALL.get()));

    ///public static final RegistryObject<Item> GLOOMY_MUSHROOM_BLOCK = ITEMS.register("gloomy_mushroom_block", () -> blockItem(DreamBlocks.GLOOMY_MUSHROOM_BLOCK.get()));
    ///public static final RegistryObject<Item> GLOOMY_MUSHROOM = ITEMS.register("gloomy_mushroom", () -> blockItem(DreamBlocks.GLOOMY_MUSHROOM.get()));

    ///public static final RegistryObject<Item> GLOOMY_LEAVES = ITEMS.register("gloomy_leaves", () -> blockItem(DreamBlocks.GLOOMY_LEAVES.get()));
    ///public static final RegistryObject<Item> GLOOMY_SAPLING = ITEMS.register("gloomy_sapling", () -> blockItem(DreamBlocks.GLOOMY_SAPLING.get()));
    ///public static final RegistryObject<Item> GLOOMY_LOG = ITEMS.register("gloomy_log", () -> blockItem(DreamBlocks.GLOOMY_LOG.get()));
    ///public static final RegistryObject<Item> STRIPPED_GLOOMY_LOG = ITEMS.register("stripped_gloomy_log", () -> blockItem(DreamBlocks.STRIPPED_GLOOMY_LOG.get()));
    ///public static final RegistryObject<Item> GLOOMY_WOOD = ITEMS.register("gloomy_wood", () -> blockItem(DreamBlocks.GLOOMY_WOOD.get()));
    ///public static final RegistryObject<Item> STRIPPED_GLOOMY_WOOD = ITEMS.register("stripped_gloomy_wood", () -> blockItem(DreamBlocks.STRIPPED_GLOOMY_WOOD.get()));
    ///public static final RegistryObject<Item> GLOOMY_PLANKS = ITEMS.register("gloomy_planks", () -> blockItem(DreamBlocks.GLOOMY_PLANKS.get()));
    ///public static final RegistryObject<Item> GLOOMY_STAIRS = ITEMS.register("gloomy_stairs", () -> blockItem(DreamBlocks.GLOOMY_STAIRS.get()));
    ///public static final RegistryObject<Item> GLOOMY_SLAB = ITEMS.register("gloomy_slab", () -> blockItem(DreamBlocks.GLOOMY_SLAB.get()));
    ///public static final RegistryObject<Item> GLOOMY_FENCE = ITEMS.register("gloomy_fence", () -> blockItem(DreamBlocks.GLOOMY_FENCE.get()));
    ///public static final RegistryObject<Item> GLOOMY_FENCE_GATE = ITEMS.register("gloomy_fence_gate", () -> blockItem(DreamBlocks.GLOOMY_FENCE_GATE.get()));
    ///public static final RegistryObject<Item> GLOOMY_BUTTON = ITEMS.register("gloomy_button", () -> blockItem(DreamBlocks.GLOOMY_BUTTON.get()));
    ///public static final RegistryObject<Item> GLOOMY_PRESSURE_PLATE = ITEMS.register("gloomy_pressure_plate", () -> blockItem(DreamBlocks.GLOOMY_PRESSURE_PLATE.get()));
    ///public static final RegistryObject<Item> GLOOMY_TRAPDOOR = ITEMS.register("gloomy_trapdoor", () -> blockItem(DreamBlocks.GLOOMY_TRAPDOOR.get()));
    ///public static final RegistryObject<Item> GLOOMY_DOOR = ITEMS.register("gloomy_door", () -> blockItem(DreamBlocks.GLOOMY_DOOR.get()));
    ///public static final RegistryObject<Item> GLOOMY_SIGN = ITEMS.register("gloomy_sign", () -> signItem(DreamBlocks.GLOOMY_SIGN.get(), DreamBlocks.GLOOMY_WALL_SIGN.get()));
    ///public static final RegistryObject<Item> GLOOMY_HANGING_SIGN = ITEMS.register("gloomy_hanging_sign", () -> hangingSignItem(DreamBlocks.GLOOMY_HANGING_SIGN.get(), DreamBlocks.GLOOMY_WALL_HANGING_SIGN.get()));
    ///public static final RegistryObject<Item> GLOOMY_BOAT = ITEMS.register("gloomy_boat", () -> boatItem(DreamBoat.Type.GLOOMY));
    ///public static final RegistryObject<Item> GLOOMY_CHEST_BOAT = ITEMS.register("gloomy_chest_boat", () -> chestBoatItem(DreamBoat.Type.GLOOMY));

    ///public static final RegistryObject<Item> GRIMWOOD_LEAVES = ITEMS.register("grimwood_leaves", () -> blockItem(DreamBlocks.GRIMWOOD_LEAVES.get()));
    ///public static final RegistryObject<Item> GRIMWOOD_SAPLING = ITEMS.register("grimwood_sapling", () -> blockItem(DreamBlocks.GRIMWOOD_SAPLING.get()));
    ///public static final RegistryObject<Item> GRIMWOOD_LOG = ITEMS.register("grimwood_log", () -> blockItem(DreamBlocks.GRIMWOOD_LOG.get()));
    ///public static final RegistryObject<Item> STRIPPED_GRIMWOOD_LOG = ITEMS.register("stripped_grimwood_log", () -> blockItem(DreamBlocks.STRIPPED_GRIMWOOD_LOG.get()));
    ///public static final RegistryObject<Item> GRIMWOOD_WOOD = ITEMS.register("grimwood_wood", () -> blockItem(DreamBlocks.GRIMWOOD_WOOD.get()));
    ///public static final RegistryObject<Item> STRIPPED_GRIMWOOD_WOOD = ITEMS.register("stripped_grimwood_wood", () -> blockItem(DreamBlocks.STRIPPED_GRIMWOOD_WOOD.get()));
    ///public static final RegistryObject<Item> GRIMWOOD_PLANKS = ITEMS.register("grimwood_planks", () -> blockItem(DreamBlocks.GRIMWOOD_PLANKS.get()));
    ///public static final RegistryObject<Item> GRIMWOOD_STAIRS = ITEMS.register("grimwood_stairs", () -> blockItem(DreamBlocks.GRIMWOOD_STAIRS.get()));
    ///public static final RegistryObject<Item> GRIMWOOD_SLAB = ITEMS.register("grimwood_slab", () -> blockItem(DreamBlocks.GRIMWOOD_SLAB.get()));
    ///public static final RegistryObject<Item> GRIMWOOD_FENCE = ITEMS.register("grimwood_fence", () -> blockItem(DreamBlocks.GRIMWOOD_FENCE.get()));
    ///public static final RegistryObject<Item> GRIMWOOD_FENCE_GATE = ITEMS.register("grimwood_fence_gate", () -> blockItem(DreamBlocks.GRIMWOOD_FENCE_GATE.get()));
    ///public static final RegistryObject<Item> GRIMWOOD_BUTTON = ITEMS.register("grimwood_button", () -> blockItem(DreamBlocks.GRIMWOOD_BUTTON.get()));
    ///public static final RegistryObject<Item> GRIMWOOD_PRESSURE_PLATE = ITEMS.register("grimwood_pressure_plate", () -> blockItem(DreamBlocks.GRIMWOOD_PRESSURE_PLATE.get()));
    ///public static final RegistryObject<Item> GRIMWOOD_TRAPDOOR = ITEMS.register("grimwood_trapdoor", () -> blockItem(DreamBlocks.GRIMWOOD_TRAPDOOR.get()));
    ///public static final RegistryObject<Item> GRIMWOOD_DOOR = ITEMS.register("grimwood_door", () -> blockItem(DreamBlocks.GRIMWOOD_DOOR.get()));
    ///public static final RegistryObject<Item> GRIMWOOD_SIGN = ITEMS.register("grimwood_sign", () -> signItem(DreamBlocks.GRIMWOOD_SIGN.get(), DreamBlocks.GRIMWOOD_WALL_SIGN.get()));
    ///public static final RegistryObject<Item> GRIMWOOD_HANGING_SIGN = ITEMS.register("grimwood_hanging_sign", () -> hangingSignItem(DreamBlocks.GRIMWOOD_HANGING_SIGN.get(), DreamBlocks.GRIMWOOD_WALL_HANGING_SIGN.get()));
    ///public static final RegistryObject<Item> GRIMWOOD_BOAT = ITEMS.register("grimwood_boat", () -> boatItem(DreamBoat.Type.GRIMWOOD));
    ///public static final RegistryObject<Item> GRIMWOOD_CHEST_BOAT = ITEMS.register("grimwood_chest_boat", () -> chestBoatItem(DreamBoat.Type.GRIMWOOD));

    ///public static final RegistryObject<Item> DEAD_LEAVES = ITEMS.register("dead_leaves", () -> blockItem(DreamBlocks.DEAD_LEAVES.get()));
    ///public static final RegistryObject<Item> DEAD_SAPLING = ITEMS.register("dead_sapling", () -> blockItem(DreamBlocks.DEAD_SAPLING.get()));
    ///public static final RegistryObject<Item> DEAD_LOG = ITEMS.register("dead_log", () -> blockItem(DreamBlocks.DEAD_LOG.get()));
    ///public static final RegistryObject<Item> STRIPPED_DEAD_LOG = ITEMS.register("stripped_dead_log", () -> blockItem(DreamBlocks.STRIPPED_DEAD_LOG.get()));
    ///public static final RegistryObject<Item> DEAD_WOOD = ITEMS.register("dead_wood", () -> blockItem(DreamBlocks.DEAD_WOOD.get()));
    ///public static final RegistryObject<Item> STRIPPED_DEAD_WOOD = ITEMS.register("stripped_dead_wood", () -> blockItem(DreamBlocks.STRIPPED_DEAD_WOOD.get()));
    ///public static final RegistryObject<Item> DEAD_PLANKS = ITEMS.register("dead_planks", () -> blockItem(DreamBlocks.DEAD_PLANKS.get()));
    ///public static final RegistryObject<Item> DEAD_STAIRS = ITEMS.register("dead_stairs", () -> blockItem(DreamBlocks.DEAD_STAIRS.get()));
    ///public static final RegistryObject<Item> DEAD_SLAB = ITEMS.register("dead_slab", () -> blockItem(DreamBlocks.DEAD_SLAB.get()));
    ///public static final RegistryObject<Item> DEAD_FENCE = ITEMS.register("dead_fence", () -> blockItem(DreamBlocks.DEAD_FENCE.get()));
    ///public static final RegistryObject<Item> DEAD_FENCE_GATE = ITEMS.register("dead_fence_gate", () -> blockItem(DreamBlocks.DEAD_FENCE_GATE.get()));
    ///public static final RegistryObject<Item> DEAD_BUTTON = ITEMS.register("dead_button", () -> blockItem(DreamBlocks.DEAD_BUTTON.get()));
    ///public static final RegistryObject<Item> DEAD_PRESSURE_PLATE = ITEMS.register("dead_pressure_plate", () -> blockItem(DreamBlocks.DEAD_PRESSURE_PLATE.get()));
    ///public static final RegistryObject<Item> DEAD_TRAPDOOR = ITEMS.register("dead_trapdoor", () -> blockItem(DreamBlocks.DEAD_TRAPDOOR.get()));
    ///public static final RegistryObject<Item> DEAD_DOOR = ITEMS.register("dead_door", () -> blockItem(DreamBlocks.DEAD_DOOR.get()));
    ///public static final RegistryObject<Item> DEAD_SIGN = ITEMS.register("dead_sign", () -> signItem(DreamBlocks.DEAD_SIGN.get(), DreamBlocks.DEAD_WALL_SIGN.get()));
    ///public static final RegistryObject<Item> DEAD_HANGING_SIGN = ITEMS.register("dead_hanging_sign", () -> hangingSignItem(DreamBlocks.DEAD_HANGING_SIGN.get(), DreamBlocks.DEAD_WALL_HANGING_SIGN.get()));
    ///public static final RegistryObject<Item> DEAD_BOAT = ITEMS.register("dead_boat", () -> boatItem(DreamBoat.Type.DEAD));
    ///public static final RegistryObject<Item> DEAD_CHEST_BOAT = ITEMS.register("dead_chest_boat", () -> chestBoatItem(DreamBoat.Type.DEAD));

    ///public static final RegistryObject<Item> PINE_LEAVES = ITEMS.register("pine_leaves", () -> blockItem(DreamBlocks.PINE_LEAVES.get()));
    ///public static final RegistryObject<Item> PINE_SAPLING = ITEMS.register("pine_sapling", () -> blockItem(DreamBlocks.PINE_SAPLING.get()));
    ///public static final RegistryObject<Item> PINE_LOG = ITEMS.register("pine_log", () -> blockItem(DreamBlocks.PINE_LOG.get()));
    ///public static final RegistryObject<Item> STRIPPED_PINE_LOG = ITEMS.register("stripped_pine_log", () -> blockItem(DreamBlocks.STRIPPED_PINE_LOG.get()));
    ///public static final RegistryObject<Item> PINE_WOOD = ITEMS.register("pine_wood", () -> blockItem(DreamBlocks.PINE_WOOD.get()));
    ///public static final RegistryObject<Item> STRIPPED_PINE_WOOD = ITEMS.register("stripped_pine_wood", () -> blockItem(DreamBlocks.STRIPPED_PINE_WOOD.get()));
    ///public static final RegistryObject<Item> PINE_PLANKS = ITEMS.register("pine_planks", () -> blockItem(DreamBlocks.PINE_PLANKS.get()));
    ///public static final RegistryObject<Item> PINE_STAIRS = ITEMS.register("pine_stairs", () -> blockItem(DreamBlocks.PINE_STAIRS.get()));
    ///public static final RegistryObject<Item> PINE_SLAB = ITEMS.register("pine_slab", () -> blockItem(DreamBlocks.PINE_SLAB.get()));
    ///public static final RegistryObject<Item> PINE_FENCE = ITEMS.register("pine_fence", () -> blockItem(DreamBlocks.PINE_FENCE.get()));
    ///public static final RegistryObject<Item> PINE_FENCE_GATE = ITEMS.register("pine_fence_gate", () -> blockItem(DreamBlocks.PINE_FENCE_GATE.get()));
    ///public static final RegistryObject<Item> PINE_BUTTON = ITEMS.register("pine_button", () -> blockItem(DreamBlocks.PINE_BUTTON.get()));
    ///public static final RegistryObject<Item> PINE_PRESSURE_PLATE = ITEMS.register("pine_pressure_plate", () -> blockItem(DreamBlocks.PINE_PRESSURE_PLATE.get()));
    ///public static final RegistryObject<Item> PINE_TRAPDOOR = ITEMS.register("pine_trapdoor", () -> blockItem(DreamBlocks.PINE_TRAPDOOR.get()));
    ///public static final RegistryObject<Item> PINE_DOOR = ITEMS.register("pine_door", () -> blockItem(DreamBlocks.PINE_DOOR.get()));
    ///public static final RegistryObject<Item> PINE_SIGN = ITEMS.register("pine_sign", () -> signItem(DreamBlocks.PINE_SIGN.get(), DreamBlocks.PINE_WALL_SIGN.get()));
    ///public static final RegistryObject<Item> PINE_HANGING_SIGN = ITEMS.register("pine_hanging_sign", () -> hangingSignItem(DreamBlocks.PINE_HANGING_SIGN.get(), DreamBlocks.PINE_WALL_HANGING_SIGN.get()));
    ///public static final RegistryObject<Item> PINE_BOAT = ITEMS.register("pine_boat", () -> boatItem(DreamBoat.Type.PINE));
    ///public static final RegistryObject<Item> PINE_CHEST_BOAT = ITEMS.register("pine_chest_boat", () -> chestBoatItem(DreamBoat.Type.PINE));

    ///public static final RegistryObject<Item> POISED_LEAVES = ITEMS.register("poised_leaves", () -> blockItem(DreamBlocks.POISED_LEAVES.get()));
    ///public static final RegistryObject<Item> POISED_SAPLING = ITEMS.register("poised_sapling", () -> blockItem(DreamBlocks.POISED_SAPLING.get()));
    ///public static final RegistryObject<Item> POISED_LOG = ITEMS.register("poised_log", () -> blockItem(DreamBlocks.POISED_LOG.get()));
    ///public static final RegistryObject<Item> STRIPPED_POISED_LOG = ITEMS.register("stripped_poised_log", () -> blockItem(DreamBlocks.STRIPPED_POISED_LOG.get()));
    ///public static final RegistryObject<Item> POISED_WOOD = ITEMS.register("poised_wood", () -> blockItem(DreamBlocks.POISED_WOOD.get()));
    ///public static final RegistryObject<Item> STRIPPED_POISED_WOOD = ITEMS.register("stripped_poised_wood", () -> blockItem(DreamBlocks.STRIPPED_POISED_WOOD.get()));
    ///public static final RegistryObject<Item> POISED_PLANKS = ITEMS.register("poised_planks", () -> blockItem(DreamBlocks.POISED_PLANKS.get()));
    ///public static final RegistryObject<Item> POISED_STAIRS = ITEMS.register("poised_stairs", () -> blockItem(DreamBlocks.POISED_STAIRS.get()));
    ///public static final RegistryObject<Item> POISED_SLAB = ITEMS.register("poised_slab", () -> blockItem(DreamBlocks.POISED_SLAB.get()));
    ///public static final RegistryObject<Item> POISED_FENCE = ITEMS.register("poised_fence", () -> blockItem(DreamBlocks.POISED_FENCE.get()));
    ///public static final RegistryObject<Item> POISED_FENCE_GATE = ITEMS.register("poised_fence_gate", () -> blockItem(DreamBlocks.POISED_FENCE_GATE.get()));
    ///public static final RegistryObject<Item> POISED_BUTTON = ITEMS.register("poised_button", () -> blockItem(DreamBlocks.POISED_BUTTON.get()));
    ///public static final RegistryObject<Item> POISED_PRESSURE_PLATE = ITEMS.register("poised_pressure_plate", () -> blockItem(DreamBlocks.POISED_PRESSURE_PLATE.get()));
    ///public static final RegistryObject<Item> POISED_TRAPDOOR = ITEMS.register("poised_trapdoor", () -> blockItem(DreamBlocks.POISED_TRAPDOOR.get()));
    ///public static final RegistryObject<Item> POISED_DOOR = ITEMS.register("poised_door", () -> blockItem(DreamBlocks.POISED_DOOR.get()));
    ///public static final RegistryObject<Item> POISED_SIGN = ITEMS.register("poised_sign", () -> signItem(DreamBlocks.POISED_SIGN.get(), DreamBlocks.POISED_WALL_SIGN.get()));
    ///public static final RegistryObject<Item> POISED_HANGING_SIGN = ITEMS.register("poised_hanging_sign", () -> hangingSignItem(DreamBlocks.POISED_HANGING_SIGN.get(), DreamBlocks.POISED_WALL_HANGING_SIGN.get()));
    ///public static final RegistryObject<Item> POISED_BOAT = ITEMS.register("poised_boat", () -> boatItem(DreamBoat.Type.POISED));
    ///public static final RegistryObject<Item> POISED_CHEST_BOAT = ITEMS.register("poised_chest_boat", () -> chestBoatItem(DreamBoat.Type.POISED));

    ///public static final RegistryObject<Item> BLOODWOOD_LEAVES = ITEMS.register("bloodwood_leaves", () -> blockItem(DreamBlocks.BLOODWOOD_LEAVES.get()));
    ///public static final RegistryObject<Item> BLOODWOOD_SAPLING = ITEMS.register("bloodwood_sapling", () -> blockItem(DreamBlocks.BLOODWOOD_SAPLING.get()));
    ///public static final RegistryObject<Item> BLOODWOOD_LOG = ITEMS.register("bloodwood_log", () -> blockItem(DreamBlocks.BLOODWOOD_LOG.get()));
    ///public static final RegistryObject<Item> STRIPPED_BLOODWOOD_LOG = ITEMS.register("stripped_bloodwood_log", () -> blockItem(DreamBlocks.STRIPPED_BLOODWOOD_LOG.get()));
    ///public static final RegistryObject<Item> BLOODWOOD_WOOD = ITEMS.register("bloodwood_wood", () -> blockItem(DreamBlocks.BLOODWOOD_WOOD.get()));
    ///public static final RegistryObject<Item> STRIPPED_BLOODWOOD_WOOD = ITEMS.register("stripped_bloodwood_wood", () -> blockItem(DreamBlocks.STRIPPED_BLOODWOOD_WOOD.get()));
    ///public static final RegistryObject<Item> BLOODWOOD_PLANKS = ITEMS.register("bloodwood_planks", () -> blockItem(DreamBlocks.BLOODWOOD_PLANKS.get()));
    ///public static final RegistryObject<Item> BLOODWOOD_STAIRS = ITEMS.register("bloodwood_stairs", () -> blockItem(DreamBlocks.BLOODWOOD_STAIRS.get()));
    ///public static final RegistryObject<Item> BLOODWOOD_SLAB = ITEMS.register("bloodwood_slab", () -> blockItem(DreamBlocks.BLOODWOOD_SLAB.get()));
    ///public static final RegistryObject<Item> BLOODWOOD_FENCE = ITEMS.register("bloodwood_fence", () -> blockItem(DreamBlocks.BLOODWOOD_FENCE.get()));
    ///public static final RegistryObject<Item> BLOODWOOD_FENCE_GATE = ITEMS.register("bloodwood_fence_gate", () -> blockItem(DreamBlocks.BLOODWOOD_FENCE_GATE.get()));
    ///public static final RegistryObject<Item> BLOODWOOD_BUTTON = ITEMS.register("bloodwood_button", () -> blockItem(DreamBlocks.BLOODWOOD_BUTTON.get()));
    ///public static final RegistryObject<Item> BLOODWOOD_PRESSURE_PLATE = ITEMS.register("bloodwood_pressure_plate", () -> blockItem(DreamBlocks.BLOODWOOD_PRESSURE_PLATE.get()));
    ///public static final RegistryObject<Item> BLOODWOOD_TRAPDOOR = ITEMS.register("bloodwood_trapdoor", () -> blockItem(DreamBlocks.BLOODWOOD_TRAPDOOR.get()));
    ///public static final RegistryObject<Item> BLOODWOOD_DOOR = ITEMS.register("bloodwood_door", () -> blockItem(DreamBlocks.BLOODWOOD_DOOR.get()));
    ///public static final RegistryObject<Item> BLOODWOOD_SIGN = ITEMS.register("bloodwood_sign", () -> signItem(DreamBlocks.BLOODWOOD_SIGN.get(), DreamBlocks.BLOODWOOD_WALL_SIGN.get()));
    ///public static final RegistryObject<Item> BLOODWOOD_HANGING_SIGN = ITEMS.register("bloodwood_hanging_sign", () -> hangingSignItem(DreamBlocks.BLOODWOOD_HANGING_SIGN.get(), DreamBlocks.BLOODWOOD_WALL_HANGING_SIGN.get()));
    ///public static final RegistryObject<Item> BLOODWOOD_BOAT = ITEMS.register("bloodwood_boat", () -> boatItem(DreamBoat.Type.BLOODWOOD));
    ///public static final RegistryObject<Item> BLOODWOOD_CHEST_BOAT = ITEMS.register("bloodwood_chest_boat", () -> chestBoatItem(DreamBoat.Type.BLOODWOOD));

    ///public static final RegistryObject<Item> SOUR_LEAVES = ITEMS.register("sour_leaves", () -> blockItem(DreamBlocks.SOUR_LEAVES.get()));
    ///public static final RegistryObject<Item> SOUR_SAPLING = ITEMS.register("sour_sapling", () -> blockItem(DreamBlocks.SOUR_SAPLING.get()));
    ///public static final RegistryObject<Item> SOUR_LOG = ITEMS.register("sour_log", () -> blockItem(DreamBlocks.SOUR_LOG.get()));
    ///public static final RegistryObject<Item> STRIPPED_SOUR_LOG = ITEMS.register("stripped_sour_log", () -> blockItem(DreamBlocks.STRIPPED_SOUR_LOG.get()));
    ///public static final RegistryObject<Item> SOUR_WOOD = ITEMS.register("sour_wood", () -> blockItem(DreamBlocks.SOUR_WOOD.get()));
    ///public static final RegistryObject<Item> STRIPPED_SOUR_WOOD = ITEMS.register("stripped_sour_wood", () -> blockItem(DreamBlocks.STRIPPED_SOUR_WOOD.get()));
    ///public static final RegistryObject<Item> SOUR_PLANKS = ITEMS.register("sour_planks", () -> blockItem(DreamBlocks.SOUR_PLANKS.get()));
    ///public static final RegistryObject<Item> SOUR_STAIRS = ITEMS.register("sour_stairs", () -> blockItem(DreamBlocks.SOUR_STAIRS.get()));
    ///public static final RegistryObject<Item> SOUR_SLAB = ITEMS.register("sour_slab", () -> blockItem(DreamBlocks.SOUR_SLAB.get()));
    ///public static final RegistryObject<Item> SOUR_FENCE = ITEMS.register("sour_fence", () -> blockItem(DreamBlocks.SOUR_FENCE.get()));
    ///public static final RegistryObject<Item> SOUR_FENCE_GATE = ITEMS.register("sour_fence_gate", () -> blockItem(DreamBlocks.SOUR_FENCE_GATE.get()));
    ///public static final RegistryObject<Item> SOUR_BUTTON = ITEMS.register("sour_button", () -> blockItem(DreamBlocks.SOUR_BUTTON.get()));
    ///public static final RegistryObject<Item> SOUR_PRESSURE_PLATE = ITEMS.register("sour_pressure_plate", () -> blockItem(DreamBlocks.SOUR_PRESSURE_PLATE.get()));
    ///public static final RegistryObject<Item> SOUR_TRAPDOOR = ITEMS.register("sour_trapdoor", () -> blockItem(DreamBlocks.SOUR_TRAPDOOR.get()));
    ///public static final RegistryObject<Item> SOUR_DOOR = ITEMS.register("sour_door", () -> blockItem(DreamBlocks.SOUR_DOOR.get()));
    ///public static final RegistryObject<Item> SOUR_SIGN = ITEMS.register("sour_sign", () -> signItem(DreamBlocks.SOUR_SIGN.get(), DreamBlocks.SOUR_WALL_SIGN.get()));
    ///public static final RegistryObject<Item> SOUR_HANGING_SIGN = ITEMS.register("sour_hanging_sign", () -> hangingSignItem(DreamBlocks.SOUR_HANGING_SIGN.get(), DreamBlocks.SOUR_WALL_HANGING_SIGN.get()));
    ///public static final RegistryObject<Item> SOUR_BOAT = ITEMS.register("sour_boat", () -> boatItem(DreamBoat.Type.SOUR));
    ///public static final RegistryObject<Item> SOUR_CHEST_BOAT = ITEMS.register("sour_chest_boat", () -> chestBoatItem(DreamBoat.Type.SOUR));

    ///public static final RegistryObject<Item> FUNGUS_BLOCK = ITEMS.register("fungus_block", () -> blockItem(DreamBlocks.FUNGUS_BLOCK.get()));
    ///public static final RegistryObject<Item> FUNGUS = ITEMS.register("fungus", () -> blockItem(DreamBlocks.FUNGUS.get()));
    ///public static final RegistryObject<Item> FUNGUS_STEM = ITEMS.register("fungus_stem", () -> blockItem(DreamBlocks.FUNGUS_STEM.get()));
    ///public static final RegistryObject<Item> STRIPPED_FUNGUS_STEM = ITEMS.register("stripped_fungus_stem", () -> blockItem(DreamBlocks.STRIPPED_FUNGUS_STEM.get()));
    ///public static final RegistryObject<Item> FUNGUS_HYPHAE = ITEMS.register("fungus_hyphae", () -> blockItem(DreamBlocks.FUNGUS_HYPHAE.get()));
    ///public static final RegistryObject<Item> STRIPPED_FUNGUS_HYPHAE = ITEMS.register("stripped_fungus_hyphae", () -> blockItem(DreamBlocks.STRIPPED_FUNGUS_HYPHAE.get()));
    ///public static final RegistryObject<Item> FUNGUS_PLANKS = ITEMS.register("fungus_planks", () -> blockItem(DreamBlocks.FUNGUS_PLANKS.get()));
    ///public static final RegistryObject<Item> FUNGUS_STAIRS = ITEMS.register("fungus_stairs", () -> blockItem(DreamBlocks.FUNGUS_STAIRS.get()));
    ///public static final RegistryObject<Item> FUNGUS_SLAB = ITEMS.register("fungus_slab", () -> blockItem(DreamBlocks.FUNGUS_SLAB.get()));
    ///public static final RegistryObject<Item> FUNGUS_FENCE = ITEMS.register("fungus_fence", () -> blockItem(DreamBlocks.FUNGUS_FENCE.get()));
    ///public static final RegistryObject<Item> FUNGUS_FENCE_GATE = ITEMS.register("fungus_fence_gate", () -> blockItem(DreamBlocks.FUNGUS_FENCE_GATE.get()));
    ///public static final RegistryObject<Item> FUNGUS_BUTTON = ITEMS.register("fungus_button", () -> blockItem(DreamBlocks.FUNGUS_BUTTON.get()));
    ///public static final RegistryObject<Item> FUNGUS_PRESSURE_PLATE = ITEMS.register("fungus_pressure_plate", () -> blockItem(DreamBlocks.FUNGUS_PRESSURE_PLATE.get()));
    ///public static final RegistryObject<Item> FUNGUS_TRAPDOOR = ITEMS.register("fungus_trapdoor", () -> blockItem(DreamBlocks.FUNGUS_TRAPDOOR.get()));
    ///public static final RegistryObject<Item> FUNGUS_DOOR = ITEMS.register("fungus_door", () -> blockItem(DreamBlocks.FUNGUS_DOOR.get()));
    ///public static final RegistryObject<Item> FUNGUS_SIGN = ITEMS.register("fungus_sign", () -> signItem(DreamBlocks.FUNGUS_SIGN.get(), DreamBlocks.FUNGUS_WALL_SIGN.get()));
    ///public static final RegistryObject<Item> FUNGUS_HANGING_SIGN = ITEMS.register("fungus_hanging_sign", () -> hangingSignItem(DreamBlocks.FUNGUS_HANGING_SIGN.get(), DreamBlocks.FUNGUS_WALL_HANGING_SIGN.get()));
    ///public static final RegistryObject<Item> FUNGUS_BOAT = ITEMS.register("fungus_boat", () -> boatItem(DreamBoat.Type.FUNGUS));
    ///public static final RegistryObject<Item> FUNGUS_CHEST_BOAT = ITEMS.register("fungus_chest_boat", () -> chestBoatItem(DreamBoat.Type.FUNGUS));

    /**
     * todo: CAMPING
     * s'mores
     * marshmallow
     * toasted marshmallow
     * burnt marshmallow
     * bug spray
     * notebook
     */

    /**
     * todo: DREAM ITEMS
     * nature tools
     * nature armor
     */

    public static final RegistryObject<Item> DREAMY_MUSHROOM_SOUP = ITEMS.register("dreamy_mushroom_soup", () -> new Item(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(6).effect(() -> new MobEffectInstance(DreamEffects.DREAMING.get(), 6000), 1.0F).build())));
    public static final RegistryObject<Item> MARSHMALLOW = ITEMS.register("marshmallow", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).build())));
    public static final RegistryObject<Item> SMORE = ITEMS.register("smore", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).effect(() -> new MobEffectInstance(DreamEffects.SLEEPY.get(), 1200), 1.0F).build())));

    public static final RegistryObject<Item> FAWN_SPAWN_EGG = ITEMS.register("fawn_spawn_egg", () -> new ForgeSpawnEggItem(DreamEntities.FAWN, 9067055, 13942172, new Item.Properties()));
    public static final RegistryObject<Item> FOREST_FOX_SPAWN_EGG = ITEMS.register("forest_fox_spawn_egg", () -> new ForgeSpawnEggItem(DreamEntities.FOREST_FOX, 13337415, 15778937, new Item.Properties()));
    public static final RegistryObject<Item> GNOME_SPAWN_EGG = ITEMS.register("gnome_spawn_egg", () -> new ForgeSpawnEggItem(DreamEntities.GNOME, 14711153, 12642510, new Item.Properties()));
    public static final RegistryObject<Item> COTTON_CANDY_SHEEP_SPAWN_EGG = ITEMS.register("cotton_candy_sheep_spawn_egg", () -> new ForgeSpawnEggItem(DreamEntities.COTTON_CANDY_SHEEP, 10676660, 16035526, new Item.Properties()));

    static BlockItem blockItem(Block block) {
        return new BlockItem(block, new Item.Properties());
    }

    static Item signItem(Block sign, Block wallSign) {
        return new SignItem(new Item.Properties().stacksTo(16), sign, wallSign);
    }

    static Item hangingSignItem(Block sign, Block wallSign) {
        return new HangingSignItem(sign, wallSign, new Item.Properties().stacksTo(16));
    }

    static Item boatItem(DreamBoat.Type type) {
        return new DreamBoatItem(false, type, new Item.Properties().stacksTo(1));
    }

    static Item chestBoatItem(DreamBoat.Type type) {
        return new DreamBoatItem(true, type, new Item.Properties().stacksTo(1));
    }
    
}