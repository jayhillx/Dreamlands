package com.mystanica.dreamlands.datagen.provider;

import com.mystanica.dreamlands.common.block.HyacinthFlowerBlock;
import com.mystanica.dreamlands.common.block.MushroomBlock;
import com.mystanica.dreamlands.common.block.StackableBlock;
import com.mystanica.dreamlands.datagen.DreamBlockFamilies;
import com.mystanica.dreamlands.datagen.DreamBlockFamily;
import com.mystanica.dreamlands.init.DreamBlocks;
import com.mystanica.dreamlands.init.DreamItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import javax.annotation.Nonnull;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DreamBlockLoot extends BlockLootSubProvider {

    public DreamBlockLoot() {
        super(Stream.of(Items.AIR).map(ItemLike::asItem).collect(Collectors.toSet()), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        DreamBlockFamilies.getAllFamilies().filter(DreamBlockFamily::shouldGenerateModel).forEach(this::generateFor);
        this.createSilkTouchOnlyDrop(DreamBlocks.DREAMY_GRASS_BLOCK.get());
        this.dropOther(DreamBlocks.DREAMY_DIRT_PATH.get(), DreamBlocks.DREAMY_DIRT.get());
        this.dropSelf(DreamBlocks.DREAMY_DIRT.get());
        this.createShearsDrop(DreamBlocks.DREAMY_GRASS.get());
        this.createTallPlantShearsDrop(DreamBlocks.TALL_DREAMY_GRASS.get());
        this.createLeavesAndSaplings(DreamBlocks.FOREST_SHRUB_LEAVES.get(), DreamBlocks.FOREST_SHRUB.get());
        this.dropSelf(DreamBlocks.FOREST_MOSS_BLOCK.get());
        this.dropSelf(DreamBlocks.FOREST_MOSS_CARPET.get());
        this.dropSelf(DreamBlocks.FOREST_MUSHROOM_BLOCK.get());
        this.createMushroomDrop(DreamBlocks.FOREST_MUSHROOM.get());
        this.createFlowerBedDrop(DreamBlocks.GROUND_IVY.get());
        this.createFlowerBedDrop(DreamBlocks.CLOVERS.get());
        this.createFlowerBedDrop(DreamBlocks.WHITE_CLOVERS.get());
        this.createFlowerBedDrop(DreamBlocks.PINK_CLOVERS.get());
        this.dropSelf(DreamBlocks.PETUNIA.get());
        this.dropSelf(DreamBlocks.PERIWINKLE.get());
        ///this.dropSelf(DreamBlocks.PINK_PUFFBALL.get());
        this.createTallPlantDrop(DreamBlocks.PINK_FOXGLOVE.get());
        this.createHyacinthDrop(DreamBlocks.PINK_HYACINTH.get());
        this.createHyacinthDrop(DreamBlocks.MAGENTA_HYACINTH.get());
        this.createHyacinthDrop(DreamBlocks.PURPLE_HYACINTH.get());
        this.createStackablePlantDrop(DreamBlocks.PURPLE_LUPINE.get());
        this.dropSelf(DreamBlocks.VIOLETS.get());
        ///////////////////////////////////////
        this.createLeavesAndSaplings(DreamBlocks.DREAMY_LEAVES.get(), DreamBlocks.DREAMY_SAPLING.get());
        this.dropSelf(DreamBlocks.DREAMY_MUSHROOM_BLOCK.get());
        this.createMushroomDrop(DreamBlocks.DREAMY_MUSHROOM.get());
        this.createLeavesAndSaplings(DreamBlocks.ASPEN_LEAVES.get(), DreamBlocks.ASPEN_SAPLING.get());
        this.createLeavesAndSaplings(DreamBlocks.EVERGREEN_LEAVES.get(), DreamBlocks.EVERGREEN_SAPLING.get());
        this.dropSelf(DreamBlocks.TOADSTOOL_BLOCK.get());
        this.createMushroomDrop(DreamBlocks.TOADSTOOL.get());
        this.createLeavesAndSaplings(DreamBlocks.ETHEREAL_LEAVES.get(), DreamBlocks.ETHEREAL_SAPLING.get());
        this.createLeavesAndSaplings(DreamBlocks.LILAC_BUSH_LEAVES.get(), DreamBlocks.LILAC_BUSH.get());
        this.createLeavesAndSaplings(DreamBlocks.PINK_COTTON_CANDY_BLOCK.get(), DreamBlocks.PINK_COTTON_CANDY_SAPLING.get());
        this.createLeavesAndSaplings(DreamBlocks.BLUE_COTTON_CANDY_BLOCK.get(), DreamBlocks.BLUE_COTTON_CANDY_SAPLING.get());
        this.createLeavesAndSaplings(DreamBlocks.WISTERIA_LEAVES.get(), DreamBlocks.WISTERIA_SAPLING.get());
        this.createLeavesAndSaplings(DreamBlocks.WISTERIA_BLOSSOMS.get(), DreamBlocks.WISTERIA_SAPLING.get());
        this.createWisteriaDrop(DreamBlocks.WISTERIA.get());
        this.createWisteriaDrop(DreamBlocks.WISTERIA_PLANT.get());
        this.createWisteriaDrop(DreamBlocks.WALL_WISTERIA.get());
        this.createLeavesAndSaplings(DreamBlocks.MYSTICAL_LEAVES.get(), DreamBlocks.MYSTICAL_SAPLING.get());
        this.createLeavesAndSaplings(DreamBlocks.FAIRY_ROSE_BUSH_LEAVES.get(), DreamBlocks.FAIRY_ROSE_BUSH.get());
        this.dropSelf(DreamBlocks.PINK_MUSHROOM_BLOCK.get());
        this.createMushroomDrop(DreamBlocks.PINK_MUSHROOM.get());
        ///////////////////////////////////////
        ///this.dropPottedContents(DreamBlocks.POTTED_FOREST_SHRUB.get());
        this.dropPottedContents(DreamBlocks.POTTED_FOREST_MUSHROOM.get());
        this.dropPottedContents(DreamBlocks.POTTED_DREAMY_SAPLING.get());
        this.dropPottedContents(DreamBlocks.POTTED_DREAMY_MUSHROOM.get());
        this.dropPottedContents(DreamBlocks.POTTED_ASPEN_SAPLING.get());
        this.dropPottedContents(DreamBlocks.POTTED_EVERGREEN_SAPLING.get());
        this.dropPottedContents(DreamBlocks.POTTED_TOADSTOOL.get());
        this.dropPottedContents(DreamBlocks.POTTED_ETHEREAL_SAPLING.get());
        ///this.dropPottedContents(DreamBlocks.POTTED_LILAC_BUSH.get());
        this.dropPottedContents(DreamBlocks.POTTED_PINK_COTTON_CANDY_SAPLING.get());
        this.dropPottedContents(DreamBlocks.POTTED_BLUE_COTTON_CANDY_SAPLING.get());
        this.dropPottedContents(DreamBlocks.POTTED_WISTERIA_SAPLING.get());
        this.dropPottedContents(DreamBlocks.POTTED_MYSTICAL_SAPLING.get());
        ///this.dropPottedContents(DreamBlocks.POTTED_FAIRY_ROSE_BUSH.get());
        this.dropPottedContents(DreamBlocks.POTTED_PINK_MUSHROOM.get());
    }

    private void generateFor(DreamBlockFamily family) {
        family.getVariants().forEach((variant, block) -> {
            switch (variant) {
                case SLAB -> this.add(block, this::createSlabItemTable);
                case DOOR -> this.add(block, this::createDoorTable);
                default -> this.dropSelf(block);
            }
        });
    }

    private void createLeavesAndSaplings(Block leaves, Block sapling) {
        this.dropSelf(sapling);
        this.add(leaves, this.createLeavesDrops(leaves, sapling, 0.05F, 0.0625F, 0.083333336F, 0.1F));
    }

    private void createSilkTouchOnlyDrop(Block block) {
        this.add(block, createSilkTouchOnlyTable(block));
    }

    private void createShearsDrop(Block block) {
        this.add(block, createShearsOnlyDrop(block));
    }

    private void createTallPlantShearsDrop(Block block) {
        this.add(block, createDoublePlantShearsDrop(block));
    }

    private void createTallPlantDrop(Block block) {
        this.add(block, state -> this.createSinglePropConditionTable(state, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
    }

    private void createWisteriaDrop(Block block) {
        this.add(block, LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(DreamItems.WISTERIA.get()))
        ));
    }

    private void createMushroomDrop(Block block) {
        this.add(block, LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block)
                        .apply(IntStream.rangeClosed(1, 3).boxed().toList(), i -> SetItemCountFunction.setCount(ConstantValue.exactly((float) i))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MushroomBlock.AMOUNT, i))))))));
    }

    private void createFlowerBedDrop(Block block) {
        this.add(block, this.createPetalsDrops(block));
    }

    private void createHyacinthDrop(Block block) {
        this.add(block, LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block)
                        .apply(IntStream.rangeClosed(1, 3).boxed().toList(), i -> SetItemCountFunction.setCount(ConstantValue.exactly((float) i))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(HyacinthFlowerBlock.AMOUNT, i))))))));
    }

    private void createStackablePlantDrop(Block block) {
        this.add(block, LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block)
                        .apply(IntStream.rangeClosed(1, 3).boxed().toList(), i -> SetItemCountFunction.setCount(ConstantValue.exactly((float) i))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(StackableBlock.AMOUNT, i))))))));
    }

    @Nonnull
    @Override
    public Iterable<Block> getKnownBlocks() {
        return DreamBlocks.BLOCKS.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
    }

}