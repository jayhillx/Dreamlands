package com.mystanica.dreamlands.datagen.provider;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.common.block.*;
import com.mystanica.dreamlands.common.block.MushroomBlock;
import com.mystanica.dreamlands.datagen.*;
import com.mystanica.dreamlands.init.DreamBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DreamBlockModels extends BlockStateProvider {

    public DreamBlockModels(PackOutput output, ExistingFileHelper helper) {
        super(output, Dreamlands.modId, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        ///DreamBlockFamilies.getAllFamilies().filter(DreamBlockFamily::shouldGenerateModel).forEach(this::generateFor);
        ///this.createGrassBlock(DreamBlocks.DREAMY_GRASS_BLOCK.get(), DreamBlocks.DREAMY_DIRT.get());
        ///this.createGrassBlock(DreamBlocks.DREAMY_DIRT_PATH.get(), DreamBlocks.DREAMY_DIRT.get());
        ///this.createCubeBlock(DreamBlocks.DREAMY_DIRT.get());
        ///this.createCrossBlock(DreamBlocks.DREAMY_GRASS.get(), 3);
        ///this.createTallPlantBlock(DreamBlocks.TALL_DREAMY_GRASS.get(), 2);
        ///this.createCrossBlock(DreamBlocks.DREAMY_FERN.get());
        ///this.createTallPlantBlock(DreamBlocks.TALL_DREAMY_FERN.get());
        ///this.createLeavesBlock(DreamBlocks.FOREST_SHRUB_LEAVES.get());
        ///this.createShrubBlock(DreamBlocks.FOREST_SHRUB.get());
        ///this.createFullAndCarpetBlocks(DreamBlocks.FOREST_MOSS_BLOCK.get(), DreamBlocks.FOREST_MOSS_CARPET.get());
        ///this.createCrossBlock(DreamBlocks.FOREST_GRASS.get());
        ///this.createTallPlantBlock(DreamBlocks.TALL_FOREST_GRASS.get());
        ///this.createCubeBlock(DreamBlocks.FOREST_MUSHROOM_BLOCK.get());
        ///this.createMushroomBlock(DreamBlocks.FOREST_MUSHROOM.get());
        ///this.createFlowerBedBlock(DreamBlocks.GROUND_IVY.get());
        ///this.createFlowerBedBlock(DreamBlocks.CLOVERS.get());
        ///this.createFlowerBedBlock(DreamBlocks.WHITE_CLOVERS.get(), DreamBlocks.CLOVERS.get());
        ///this.createFlowerBedBlock(DreamBlocks.PINK_CLOVERS.get(), DreamBlocks.CLOVERS.get());
        ///this.createCrossBlock(DreamBlocks.PETUNIA.get(), 2);
        ///this.createFlowerBedBlock(DreamBlocks.PERIWINKLE.get());
        ///this.createPuffballBlock(DreamBlocks.PINK_PUFFBALL.get(), 3);
        ///this.createCrossBlock(DreamBlocks.PINK_FOXGLOVE.get());
        ///this.createHyacinthBlock(DreamBlocks.PINK_HYACINTH.get());
        ///this.createHyacinthBlock(DreamBlocks.MAGENTA_HYACINTH.get());
        ///this.createHyacinthBlock(DreamBlocks.PURPLE_HYACINTH.get());
        ///this.createStackableFlowerBlock(DreamBlocks.PURPLE_LUPINE.get());
        ///this.createCrossBlock(DreamBlocks.VIOLETS.get());
        ///////////////////////////////////////
        ///this.createLeavesBlock(DreamBlocks.DREAMY_LEAVES.get());
        ///this.createCrossBlock(DreamBlocks.DREAMY_SAPLING.get());
        ///this.createCubeBlock(DreamBlocks.DREAMY_MUSHROOM_BLOCK.get());
        ///this.createMushroomBlock(DreamBlocks.DREAMY_MUSHROOM.get());
        ///this.createLeavesBlock(DreamBlocks.EVERGREEN_LEAVES.get());
        ///this.createCrossBlock(DreamBlocks.EVERGREEN_SAPLING.get());
        ///this.createCubeBlock(DreamBlocks.TOADSTOOL_BLOCK.get());
        ///this.createMushroomBlock(DreamBlocks.TOADSTOOL.get());
        ///this.createBushyLeavesBlock(DreamBlocks.ETHEREAL_LEAVES.get());
        ///this.createCrossBlock(DreamBlocks.ETHEREAL_SAPLING.get());
        ///this.createBushyLeavesBlock(DreamBlocks.LILAC_BUSH_FLOWERS.get(), 2);
        ///this.createBushyFloweringLeavesBlock(DreamBlocks.LILAC_BUSH_LEAVES.get(), DreamBlocks.LILAC_BUSH_FLOWERS.get(), 2);
        ///this.createShrubBlock(DreamBlocks.LILAC_BUSH.get());
        ///this.createCubeBlock(DreamBlocks.PINK_COTTON_CANDY_BLOCK.get());
        ///this.createCrossBlock(DreamBlocks.PINK_COTTON_CANDY_SAPLING.get());
        ///this.createCubeBlock(DreamBlocks.BLUE_COTTON_CANDY_BLOCK.get());
        ///this.createCrossBlock(DreamBlocks.BLUE_COTTON_CANDY_SAPLING.get());
        ///this.createBushyFloweringLeavesBlock(DreamBlocks.WISTERIA_LEAVES.get(), DreamBlocks.WISTERIA_BLOSSOMS.get());
        ///this.createBushyLeavesBlock(DreamBlocks.WISTERIA_BLOSSOMS.get());
        ///this.createCrossBlock(DreamBlocks.WISTERIA_SAPLING.get());
        ///this.createWisteriaBlock(DreamBlocks.WISTERIA.get());
        ///this.createWisteriaBlock(DreamBlocks.WISTERIA_PLANT.get());
        ///this.createLeavesBlock(DreamBlocks.MYSTICAL_LEAVES.get());
        ///this.createCrossBlock(DreamBlocks.MYSTICAL_SAPLING.get());
        ///this.createLeavesBlock(DreamBlocks.FAIRY_ROSE_BUSH_LEAVES.get(), 4);
        ///this.createShrubBlock(DreamBlocks.FAIRY_ROSE_BUSH.get());
        ///this.createCubeBlock(DreamBlocks.PINK_MUSHROOM_BLOCK.get());
        ///this.createMushroomBlock(DreamBlocks.PINK_MUSHROOM.get());
        ///////////////////////////////////////
        ///this.createPottedShrubBlock(DreamBlocks.POTTED_FOREST_SHRUB.get());
        ///this.createPottedPlantBlock(DreamBlocks.POTTED_FOREST_MUSHROOM.get());
        ///this.createPottedPlantBlock(DreamBlocks.POTTED_DREAMY_SAPLING.get());
        ///this.createPottedPlantBlock(DreamBlocks.POTTED_DREAMY_MUSHROOM.get());
        ///this.createPottedPlantBlock(DreamBlocks.POTTED_EVERGREEN_SAPLING.get());
        ///this.createPottedPlantBlock(DreamBlocks.POTTED_TOADSTOOL.get());
        ///this.createPottedPlantBlock(DreamBlocks.POTTED_ETHEREAL_SAPLING.get());
        ///this.createPottedPlantBlock(DreamBlocks.POTTED_LILAC_BUSH.get());
        ///this.createPottedPlantBlock(DreamBlocks.POTTED_PINK_COTTON_CANDY_SAPLING.get());
        ///this.createPottedPlantBlock(DreamBlocks.POTTED_BLUE_COTTON_CANDY_SAPLING.get());
        ///this.createPottedPlantBlock(DreamBlocks.POTTED_WISTERIA_SAPLING.get());
        ///this.createPottedPlantBlock(DreamBlocks.POTTED_MYSTICAL_SAPLING.get());
        ///this.createPottedPlantBlock(DreamBlocks.POTTED_FAIRY_ROSE_BUSH.get());
        ///this.createPottedPlantBlock(DreamBlocks.POTTED_PINK_MUSHROOM.get());
    }

    private void generateFor(DreamBlockFamily family) {
        family.getVariants().forEach((variant, block) -> {
            Block base = family.getBaseBlock();
            Block source = family.get(variant.source());
            switch (variant) {
                case LOG, STRIPPED_LOG -> this.logBlock((RotatedPillarBlock)block);
                case WOOD, STRIPPED_WOOD -> this.axisBlock((RotatedPillarBlock)block, texture(source), texture(source));
                case STAIRS -> this.stairsBlock((StairBlock)block, texture(base));
                case SLAB -> this.slabBlock((SlabBlock)block, texture(base), texture(base));
                case FENCE -> this.fenceBlock((FenceBlock)block, texture(base));
                case FENCE_GATE -> this.fenceGateBlock((FenceGateBlock)block, texture(base));
                case BUTTON -> this.buttonBlock((ButtonBlock)block, texture(base));
                case PRESSURE_PLATE -> this.pressurePlateBlock((PressurePlateBlock)block, texture(base));
                case TRAPDOOR -> this.trapdoorBlockWithRenderType((TrapDoorBlock)block, texture(block), true, mcLoc("cutout"));
                case DOOR -> this.doorBlockWithRenderType((DoorBlock)block, texture(block, "_bottom"), texture(block, "_top"), mcLoc("cutout"));
                case SIGN -> this.signBlock((StandingSignBlock)block, (WallSignBlock)source, texture(base));
                case WALL -> this.wallBlock((WallBlock)block, texture(base));
                default -> {
                    if (variant != DreamBlockFamily.Variant.WALL_SIGN && variant != DreamBlockFamily.Variant.WALL_HANGING_SIGN) {
                        this.simpleBlock(block);
                    }
                }
            }
        });
    }

    private void createCubeBlock(Block block) {
        this.simpleBlock(block, this.cubeAll(block));
    }

    private void createGrassBlock(Block block, Block dirtBlock) {
        this.simpleBlock(block, this.models()
                .cubeBottomTop(name(block), texture(block, "_side"), texture(dirtBlock), texture(block, "_top"))
        );
    }

    private void createFullAndCarpetBlocks(Block block, Block carpetBlock) {
        this.simpleBlock(block, this.cubeAll(block));
        this.createCarpetBlock(carpetBlock, block);
    }

    private void createCarpetBlock(Block block, Block texture) {
        this.simpleBlock(block, this.models()
                .carpet(name(block), texture(texture))
        );
    }

    private void createLeavesBlock(Block block) {
        this.simpleBlock(block, this.leavesModel(texture(block)));
    }

    private void createLeavesBlock(Block block, int variantCount) {
        this.createBlockWithVariants(block, variantCount, this::leavesModelBuilder);
    }

    private void createBushyLeavesBlock(Block block) {
        this.simpleBlock(block, this.bushyLeavesModel(texture(block)));
    }

    private void createBushyLeavesBlock(Block block, int variantCount) {
        ModelFile[] models = new ModelFile[variantCount];

        for (int i = 0; i < variantCount; i++) {
            models[i] = this.bushyLeavesBuilder(texture(block), i);
        }

        this.getVariantBuilder(block).partialState().addModels(modelFromList(List.of(models)));
    }

    private void createFloweringLeavesBlock(Block block, Block blossomBlock) {
        this.simpleBlock(block, this.floweringLeavesModel(texture(block), texture(blossomBlock)));
    }

    private void createBushyFloweringLeavesBlock(Block block, Block blossomBlock) {
        this.simpleBlock(block, this.bushyFloweringLeavesModel(texture(block), texture(blossomBlock)));
    }

    private void createBushyFloweringLeavesBlock(Block block, Block blossomBlock, int variantCount) {
        ModelFile[] leavesModels = new ModelFile[variantCount];
        ModelFile[] flowerModels = new ModelFile[variantCount];

        for (int i = 0; i < variantCount; i++) {
            leavesModels[i] = this.bushyLeavesBuilder(texture(block), i);
            flowerModels[i] = this.bushyFloweringLeavesBuilder(texture(block), texture(blossomBlock), i);
        }

        this.getVariantBuilder(block)
                .partialState().with(FloweringLeavesBlock.FLOWERING, false).addModels(modelFromList(List.of(leavesModels)))
                .partialState().with(FloweringLeavesBlock.FLOWERING, true).addModels(modelFromList(List.of(flowerModels)));
    }

    private void createWisteriaBlock(Block block) {
        this.getVariantBuilder(block)
                .partialState().with(Wisteria.LEAFY, false).addModels(this.wisteriaModel(texture(block)))
                .partialState().with(Wisteria.LEAFY, true).addModels(this.wisteriaModel(texture(block, "_leafy")));
    }

    private void createShrubBlock(Block block) {
        this.simpleBlock(block, this.models()
                .withExistingParent(name(block), modLoc("block/template_bush"))
                .texture("top", texture(block, "_top"))
                .texture("side", texture(block, "_side"))
                .texture("plant", texture(block, "_plant"))
                .renderType("cutout")
        );
    }

    private void createPottedShrubBlock(Block block) {
        this.simpleBlock(block, this.models()
                .withExistingParent(name(block), mcLoc("block/template_potted_azalea_bush"))
                .texture("plant", texture(block))
                .texture("particle", texture(block))
                .renderType("cutout")
        );
    }

    private void createPottedPlantBlock(Block block) {
        this.simpleBlock(block, this.models()
                .withExistingParent(name(block), mcLoc("block/flower_pot_cross"))
                .texture("plant", texture(block))
                .renderType("cutout")
        );
    }

    private void createPuffballBlock(Block block, int variantCount) {
        ConfiguredModel[] models = new ConfiguredModel[variantCount];
        for (int i = 0; i < variantCount; i++) {
            models[i] = new ConfiguredModel(this.puffballModelBuilder(block, i));
        }

        this.getVariantBuilder(block)
                .partialState().addModels(models);
    }

    private void createHyacinthBlock(Block block) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            for (int amount = 1; amount <= 3; amount++) {
                this.getVariantBuilder(block).partialState()
                        .with(HyacinthFlowerBlock.FACING, direction)
                        .with(HyacinthFlowerBlock.AMOUNT, amount)
                        .modelForState()
                        .modelFile(this.hyacinthModelBuilder(block, amount))
                        .rotationY(facingRotation(direction))
                        .addModel()
                ;
            }
        }
    }

    private void createStackableFlowerBlock(Block block) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            for (int amount = 1; amount <= 3; amount++) {
                this.getVariantBuilder(block).partialState()
                        .with(StackableFlowerBlock.FACING, direction)
                        .with(StackableFlowerBlock.AMOUNT, amount)
                        .modelForState()
                        .modelFile(this.lupineModelBuilder(block, amount))
                        .rotationY(facingRotation(direction))
                        .addModel();
            }
        }
    }

    private void createMushroomBlock(Block block) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            for (int amount = 1; amount <= 3; amount++) {
                this.getVariantBuilder(block).partialState()
                        .with(MushroomBlock.FACING, direction)
                        .with(MushroomBlock.AMOUNT, amount)
                        .with(MushroomBlock.SHELF, false)
                        .modelForState()
                        .modelFile(this.mushroomModelBuilder(block, amount))
                        .rotationY(facingRotation(direction))
                        .addModel();

                this.getVariantBuilder(block).partialState()
                        .with(MushroomBlock.FACING, direction)
                        .with(MushroomBlock.AMOUNT, amount)
                        .with(MushroomBlock.SHELF, true)
                        .modelForState()
                        .modelFile(this.wallMushroomModelBuilder(block, amount))
                        .rotationY(facingRotation(direction))
                        .addModel();
            }
        }
    }

    private void createFlowerBedBlock(Block block) {
        this.createFlowerBedBlock(block, block);
    }

    private void createFlowerBedBlock(Block block, Block stem) {
        this.createMultipartPlantBlock(block, (amount) -> this.flowerBedModelBuilder(block, stem, amount));
    }

    private void createMultipartPlantBlock(Block block, Function<Integer, BlockModelBuilder> modelFactory) {
        ModelFile[] models = {
                modelFactory.apply(1),
                modelFactory.apply(2),
                modelFactory.apply(3),
                modelFactory.apply(4)
        };
        Integer[][] flowerAmounts = {{1, 2, 3, 4}, {2, 3, 4}, {3, 4}, {4}};

        for (int modelIndex = 0; modelIndex < models.length; modelIndex++) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                this.getMultipartBuilder(block).part()
                        .modelFile(models[modelIndex])
                        .rotationY(facingRotation(direction))
                        .addModel()
                        .condition(BlockStateProperties.FLOWER_AMOUNT, flowerAmounts[modelIndex])
                        .condition(BlockStateProperties.HORIZONTAL_FACING, direction)
                        .end();
            }
        }
    }

    private void createCrossBlock(Block block) {
        this.createCrossBlock(block, 1);
    }

    private void createCrossBlock(Block block, int variantCount) {
        this.createBlockWithVariants(block, variantCount, this::crossModelBuilder);
    }

    private void createTallPlantBlock(Block block) {
        this.createTallPlantBlock(block, 1);
    }

    private void createTallPlantBlock(Block block, int variantCount) {
        ModelFile[] lowerModels = new ModelFile[variantCount];
        ModelFile[] upperModels = new ModelFile[variantCount];

        for (int i = 0; i < variantCount; i++) {
            lowerModels[i] = this.crossModelBuilder(texture(block, "_bottom" + variantSuffix(i)));
            upperModels[i] = this.crossModelBuilder(texture(block, "_top" + variantSuffix(i)));
        }

        this.createTallPlantWithVariants(block, List.of(lowerModels), List.of(upperModels));
    }

    private void createTallPlantWithVariants(Block block, List<ModelFile> lowerModel, List<ModelFile> upperModel) {
        this.getVariantBuilder(block)
                .partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).addModels(modelFromList(lowerModel))
                .partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).addModels(modelFromList(upperModel));
    }

    private void createBlockWithModelVariants(Block block, int variantCount, Function<ResourceLocation, ModelFile> model) {
        List<ModelFile> models = new ArrayList<>();
        for (int i = 0; i < variantCount; i++) {
            models.add(model.apply(texture(block)));
        }

        this.getVariantBuilder(block)
                .partialState().addModels(modelFromList(models));
    }

    private void createBlockWithVariants(Block block, int variantCount, Function<ResourceLocation, ModelFile> model) {
        List<ModelFile> models = new ArrayList<>();
        for (int i = 0; i < variantCount; i++) {
            models.add(model.apply(texture(block, variantSuffix(i))));
        }

        this.getVariantBuilder(block)
                .partialState().addModels(modelFromList(models));
    }

    private static ConfiguredModel[] modelFromList(List<ModelFile> models) {
        return models.stream().map(ConfiguredModel::new).toArray(ConfiguredModel[]::new);
    }

    private static String variantSuffix(int i) {
        return switch (i) {
            case 0 -> "";
            case 1 -> "_variant";
            default -> "_variant" + i;
        };
    }

    private static int facingRotation(Direction direction) {
        return switch (direction) {
            case EAST  -> 90;
            case SOUTH -> 180;
            case WEST  -> 270;
            default -> 0;
        };
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private ConfiguredModel leavesModel(ResourceLocation texture) {
        return new ConfiguredModel(this.models()
                .leaves(texture.getPath(), texture)
                .renderType("cutout_mipped"));
    }

    private ConfiguredModel floweringLeavesModel(ResourceLocation texture, ResourceLocation blossoms) {
        return new ConfiguredModel(this.models()
                .cubeBottomTop(texture.getPath(), texture.withSuffix("_side"), blossoms, texture.withSuffix("_top"))
                .renderType("cutout_mipped"));
    }

    private ConfiguredModel bushyLeavesModel(ResourceLocation texture) {
        return new ConfiguredModel(this.bushyLeavesBuilder(texture, 0));
    }

    private ConfiguredModel bushyFloweringLeavesModel(ResourceLocation texture, ResourceLocation blossoms) {
        return new ConfiguredModel(this.bushyFloweringLeavesBuilder(texture, blossoms, 0));
    }

    private ConfiguredModel wisteriaModel(ResourceLocation texture) {
        return new ConfiguredModel(this.models()
                .withExistingParent(texture.getPath(), modLoc("block/template_wisteria"))
                .texture("plant", texture)
                .renderType("cutout"));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private BlockModelBuilder crossModelBuilder(ResourceLocation texture) {
        return this.models()
                .cross(texture.getPath(), texture)
                .renderType("cutout");
    }

    private BlockModelBuilder leavesModelBuilder(ResourceLocation texture) {
        return this.models()
                .leaves(texture.getPath(), texture)
                .renderType("cutout_mipped");
    }

    private BlockModelBuilder bushyLeavesBuilder(ResourceLocation texture, int variantCount) {
        return this.models()
                .withExistingParent(texture.getPath() + variantSuffix(variantCount), modLoc("block/template_bushy_leaves" + variantSuffix(variantCount)))
                .texture("all", texture)
                .texture("bushy", texture.withSuffix("_bushy"))
                .renderType("cutout_mipped");
    }

    private BlockModelBuilder bushyFloweringLeavesBuilder(ResourceLocation texture, ResourceLocation blossoms, int variantCount) {
        return this.models()
                .withExistingParent(texture.withSuffix("_flowering").getPath() + variantSuffix(variantCount), modLoc("block/template_bushy_leaves0" + variantSuffix(variantCount)))
                .texture("top", texture)
                .texture("side", texture.withSuffix("_flowering"))
                .texture("bottom", blossoms)
                .texture("bushy", texture.withSuffix("_flowering_bushy"))
                .renderType("cutout_mipped");
    }

    private BlockModelBuilder flowerBedModelBuilder(Block block, Block stem, int amount) {
        return this.models().withExistingParent(name(block) + "_" + amount, modLoc("block/template_flowerbed_" + amount))
                .texture("flowerbed", texture(block))
                .texture("stem", texture(stem, "_stem"))
                .renderType("cutout");
    }

    private BlockModelBuilder puffballModelBuilder(Block block, int variantCount) {
        return this.models().withExistingParent(name(block) + variantSuffix(variantCount), modLoc("block/template_puffball" + variantSuffix(variantCount)))
                .texture("flower", texture(block, "_flower"))
                .renderType("cutout");
    }

    private BlockModelBuilder hyacinthModelBuilder(Block block, int amount) {
        return this.models().withExistingParent(name(block) + "_" + amount, modLoc("block/template_hyacinth_" + amount))
                .texture("flower", texture(block, "_flower"))
                .renderType("cutout");
    }

    private BlockModelBuilder lupineModelBuilder(Block block, int amount) {
        return this.models().withExistingParent(name(block) + "_" + amount, modLoc("block/template_lupine_" + amount))
                .texture("flower", texture(block, "_flower"))
                .renderType("cutout");
    }

    private BlockModelBuilder mushroomModelBuilder(Block block, int amount) {
        return this.models().withExistingParent(name(block) + "_" + amount, modLoc("block/template_mushroom_" + amount))
                .texture("plant", texture(block, "1"))
                .renderType("cutout");
    }

    private BlockModelBuilder wallMushroomModelBuilder(Block block, int amount) {
        return this.models().withExistingParent(name(block) + "_shelf_" + amount, modLoc("block/template_wall_mushroom_" + amount))
                .texture("plant", texture(block, "1"))
                .renderType("cutout");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static ResourceLocation tintTexture(Block block) {
        return Dreamlands.modLoc("block/tint/" + name(block, "_tint"));
    }

    private static ResourceLocation texture(Block block) {
        return Dreamlands.modLoc("block/" + name(block));
    }

    private static ResourceLocation texture(Block block, String suffix) {
        return Dreamlands.modLoc("block/" + name(block, suffix));
    }

    private static String name(Block block) {
        return key(block).getPath();
    }

    private static String name(Block block, String suffix) {
        return key(block).withSuffix(suffix).getPath();
    }

    private static ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

}