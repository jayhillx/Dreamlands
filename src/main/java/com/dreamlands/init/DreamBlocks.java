package com.dreamlands.init;

import com.dreamlands.Dreamlands;
import com.dreamlands.common.block.DreamyMushroomBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DreamBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, Dreamlands.modId);

    public static final RegistryObject<Block> EVERGREEN_PLANKS = BLOCKS.register("evergreen_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> ETHEREAL_PLANKS = BLOCKS.register("ethereal_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> CANDY_PLANKS = BLOCKS.register("candy_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_PINK)));

    public static final RegistryObject<Block> EBONY_PLANKS = BLOCKS.register("ebony_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> DEAD_PLANKS = BLOCKS.register("dead_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final RegistryObject<Block> BLOODWOOD_PLANKS = BLOCKS.register("bloodwood_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.TERRACOTTA_RED)));

    public static final RegistryObject<Block> DREAMY_MUSHROOM = BLOCKS.register("dreamy_mushroom", () -> new DreamyMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM)));

}