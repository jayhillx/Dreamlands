package com.dreamlands.init;

import com.dreamlands.Dreamlands;
import com.dreamlands.common.block.*;
import com.dreamlands.common.block.state.DreamBlockSetTypes;
import com.dreamlands.common.block.state.DreamWoodTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.dreamlands.common.block.BlockTemplate.*;

public class DreamBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, Dreamlands.modId);

    public static final RegistryObject<Block> DREAMY_MUSHROOM = BLOCKS.register("dreamy_mushroom", () -> new DreamyMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM)));

    public static final RegistryObject<Block> STRIPPED_EVERGREEN_LOG = BLOCKS.register("stripped_evergreen_log", () -> strippedLog(MapColor.COLOR_GREEN));
    public static final RegistryObject<Block> EVERGREEN_LOG = BLOCKS.register("evergreen_log", () -> log(STRIPPED_EVERGREEN_LOG.get(), MapColor.COLOR_GREEN, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> STRIPPED_EVERGREEN_WOOD = BLOCKS.register("stripped_evergreen_wood", () -> strippedLog(MapColor.COLOR_GREEN));
    public static final RegistryObject<Block> EVERGREEN_WOOD = BLOCKS.register("evergreen_wood", () -> log(STRIPPED_EVERGREEN_WOOD.get(), MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> EVERGREEN_PLANKS = BLOCKS.register("evergreen_planks", () -> planks(MapColor.COLOR_GREEN));
    public static final RegistryObject<Block> EVERGREEN_STAIRS = BLOCKS.register("evergreen_stairs", () -> stairs(EVERGREEN_PLANKS.get()));
    public static final RegistryObject<Block> EVERGREEN_SLAB = BLOCKS.register("evergreen_slab", () -> slab(EVERGREEN_PLANKS.get()));
    public static final RegistryObject<Block> EVERGREEN_FENCE = BLOCKS.register("evergreen_fence", () -> fence(EVERGREEN_PLANKS.get()));
    public static final RegistryObject<Block> EVERGREEN_FENCE_GATE = BLOCKS.register("evergreen_fence_gate", () -> fenceGate(EVERGREEN_PLANKS.get(), DreamWoodTypes.EVERGREEN));
    public static final RegistryObject<Block> EVERGREEN_BUTTON = BLOCKS.register("evergreen_button", () -> button(DreamBlockSetTypes.EVERGREEN));
    public static final RegistryObject<Block> EVERGREEN_PRESSURE_PLATE = BLOCKS.register("evergreen_pressure_plate", () -> pressurePlate(EVERGREEN_PLANKS.get(), DreamBlockSetTypes.EVERGREEN));
    public static final RegistryObject<Block> EVERGREEN_TRAPDOOR = BLOCKS.register("evergreen_trapdoor", () -> trapdoor(EVERGREEN_PLANKS.get(), DreamBlockSetTypes.EVERGREEN));
    public static final RegistryObject<Block> EVERGREEN_DOOR = BLOCKS.register("evergreen_door", () -> door(EVERGREEN_PLANKS.get(), DreamBlockSetTypes.EVERGREEN));
    public static final RegistryObject<Block> EVERGREEN_SIGN = BLOCKS.register("evergreen_sign", () -> sign(EVERGREEN_PLANKS.get(), DreamWoodTypes.EVERGREEN));
    public static final RegistryObject<Block> EVERGREEN_WALL_SIGN = BLOCKS.register("evergreen_wall_sign", () -> wallSign(EVERGREEN_PLANKS.get(), DreamWoodTypes.EVERGREEN));
    public static final RegistryObject<Block> EVERGREEN_HANGING_SIGN = BLOCKS.register("evergreen_hanging_sign", () -> hangingSign(EVERGREEN_PLANKS.get(), DreamWoodTypes.EVERGREEN));
    public static final RegistryObject<Block> EVERGREEN_WALL_HANGING_SIGN = BLOCKS.register("evergreen_wall_hanging_sign", () -> wallHangingSign(EVERGREEN_PLANKS.get(), DreamWoodTypes.EVERGREEN));

    public static final RegistryObject<Block> STRIPPED_ETHEREAL_LOG = BLOCKS.register("stripped_ethereal_log", () -> strippedLog(MapColor.COLOR_CYAN));
    public static final RegistryObject<Block> ETHEREAL_LOG = BLOCKS.register("ethereal_log", () -> log(STRIPPED_ETHEREAL_LOG.get(), MapColor.COLOR_CYAN, MapColor.TERRACOTTA_CYAN));
    public static final RegistryObject<Block> STRIPPED_ETHEREAL_WOOD = BLOCKS.register("stripped_ethereal_wood", () -> strippedLog(MapColor.COLOR_CYAN));
    public static final RegistryObject<Block> ETHEREAL_WOOD = BLOCKS.register("ethereal_wood", () -> log(STRIPPED_ETHEREAL_WOOD.get(), MapColor.TERRACOTTA_CYAN, MapColor.TERRACOTTA_CYAN));
    public static final RegistryObject<Block> ETHEREAL_PLANKS = BLOCKS.register("ethereal_planks", () -> planks(MapColor.COLOR_CYAN));
    public static final RegistryObject<Block> ETHEREAL_STAIRS = BLOCKS.register("ethereal_stairs", () -> stairs(ETHEREAL_PLANKS.get()));
    public static final RegistryObject<Block> ETHEREAL_SLAB = BLOCKS.register("ethereal_slab", () -> slab(ETHEREAL_PLANKS.get()));
    public static final RegistryObject<Block> ETHEREAL_FENCE = BLOCKS.register("ethereal_fence", () -> fence(ETHEREAL_PLANKS.get()));
    public static final RegistryObject<Block> ETHEREAL_FENCE_GATE = BLOCKS.register("ethereal_fence_gate", () -> fenceGate(ETHEREAL_PLANKS.get(), DreamWoodTypes.ETHEREAL));
    public static final RegistryObject<Block> ETHEREAL_BUTTON = BLOCKS.register("ethereal_button", () -> button(DreamBlockSetTypes.ETHEREAL));
    public static final RegistryObject<Block> ETHEREAL_PRESSURE_PLATE = BLOCKS.register("ethereal_pressure_plate", () -> pressurePlate(ETHEREAL_PLANKS.get(), DreamBlockSetTypes.ETHEREAL));
    public static final RegistryObject<Block> ETHEREAL_TRAPDOOR = BLOCKS.register("ethereal_trapdoor", () -> trapdoor(ETHEREAL_PLANKS.get(), DreamBlockSetTypes.ETHEREAL));
    public static final RegistryObject<Block> ETHEREAL_DOOR = BLOCKS.register("ethereal_door", () -> door(ETHEREAL_PLANKS.get(), DreamBlockSetTypes.ETHEREAL));
    public static final RegistryObject<Block> ETHEREAL_SIGN = BLOCKS.register("ethereal_sign", () -> sign(ETHEREAL_PLANKS.get(), DreamWoodTypes.ETHEREAL));
    public static final RegistryObject<Block> ETHEREAL_WALL_SIGN = BLOCKS.register("ethereal_wall_sign", () -> wallSign(ETHEREAL_PLANKS.get(), DreamWoodTypes.ETHEREAL));
    public static final RegistryObject<Block> ETHEREAL_HANGING_SIGN = BLOCKS.register("ethereal_hanging_sign", () -> hangingSign(ETHEREAL_PLANKS.get(), DreamWoodTypes.ETHEREAL));
    public static final RegistryObject<Block> ETHEREAL_WALL_HANGING_SIGN = BLOCKS.register("ethereal_wall_hanging_sign", () -> wallHangingSign(ETHEREAL_PLANKS.get(), DreamWoodTypes.ETHEREAL));

    public static final RegistryObject<Block> STRIPPED_CANDY_LOG = BLOCKS.register("stripped_candy_log", () -> strippedLog(MapColor.COLOR_PINK));
    public static final RegistryObject<Block> CANDY_LOG = BLOCKS.register("candy_log", () -> log(STRIPPED_CANDY_LOG.get(), MapColor.COLOR_PINK, MapColor.QUARTZ));
    public static final RegistryObject<Block> STRIPPED_CANDY_WOOD = BLOCKS.register("stripped_candy_wood", () -> strippedLog(MapColor.COLOR_PINK));
    public static final RegistryObject<Block> CANDY_WOOD = BLOCKS.register("candy_wood", () -> log(STRIPPED_CANDY_WOOD.get(), MapColor.QUARTZ, MapColor.QUARTZ));
    public static final RegistryObject<Block> CANDY_PLANKS = BLOCKS.register("candy_planks", () -> planks(MapColor.COLOR_PINK));
    public static final RegistryObject<Block> CANDY_STAIRS = BLOCKS.register("candy_stairs", () -> stairs(CANDY_PLANKS.get()));
    public static final RegistryObject<Block> CANDY_SLAB = BLOCKS.register("candy_slab", () -> slab(CANDY_PLANKS.get()));
    public static final RegistryObject<Block> CANDY_FENCE = BLOCKS.register("candy_fence", () -> fence(CANDY_PLANKS.get()));
    public static final RegistryObject<Block> CANDY_FENCE_GATE = BLOCKS.register("candy_fence_gate", () -> fenceGate(CANDY_PLANKS.get(), DreamWoodTypes.CANDY));
    public static final RegistryObject<Block> CANDY_BUTTON = BLOCKS.register("candy_button", () -> button(DreamBlockSetTypes.CANDY));
    public static final RegistryObject<Block> CANDY_PRESSURE_PLATE = BLOCKS.register("candy_pressure_plate", () -> pressurePlate(CANDY_PLANKS.get(), DreamBlockSetTypes.CANDY));
    public static final RegistryObject<Block> CANDY_TRAPDOOR = BLOCKS.register("candy_trapdoor", () -> trapdoor(CANDY_PLANKS.get(), DreamBlockSetTypes.CANDY));
    public static final RegistryObject<Block> CANDY_DOOR = BLOCKS.register("candy_door", () -> door(CANDY_PLANKS.get(), DreamBlockSetTypes.CANDY));
    public static final RegistryObject<Block> CANDY_SIGN = BLOCKS.register("candy_sign", () -> sign(CANDY_PLANKS.get(), DreamWoodTypes.CANDY));
    public static final RegistryObject<Block> CANDY_WALL_SIGN = BLOCKS.register("candy_wall_sign", () -> wallSign(CANDY_PLANKS.get(), DreamWoodTypes.CANDY));
    public static final RegistryObject<Block> CANDY_HANGING_SIGN = BLOCKS.register("candy_hanging_sign", () -> hangingSign(CANDY_PLANKS.get(), DreamWoodTypes.CANDY));
    public static final RegistryObject<Block> CANDY_WALL_HANGING_SIGN = BLOCKS.register("candy_wall_hanging_sign", () -> wallHangingSign(CANDY_PLANKS.get(), DreamWoodTypes.CANDY));

}