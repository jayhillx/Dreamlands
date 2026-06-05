package com.mystanica.dreamlands.init;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.common.block.*;
import com.mystanica.dreamlands.common.block.MushroomBlock;
import com.mystanica.dreamlands.common.block.grower.DreamMegaTreeGrowers;
import com.mystanica.dreamlands.common.block.grower.DreamTreeGrowers;
import com.mystanica.dreamlands.common.block.state.DreamBlockSetTypes;
import com.mystanica.dreamlands.common.block.state.DreamWoodTypes;
import com.mystanica.dreamlands.common.worldgen.feature.DreamTreeFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * todo: DREAMLAND
 * SHARED BLOCKS
 *  forest grass block
 *  forest grass
 *  tall forest grass
 *  forest mushroom
 *  forest moss
 *
 *  dreamy grass block
 *  dreamy dirt
 *  dreamy soil
 *  dreamy grass
 *  tall dreamy grass
 *  dreamy fern
 *  tall dreamy fern
 *  dreamy mushroom
 *
 *  clovers
 *  white clovers
 *  ground ivy
 *  ivy
 *
 * DREAMLAND BLOCKS
 *  dreamstone
 *  mossy dreamstone
 *  dreamstone bricks
 *  mossy dreamstone bricks
 *  cracked dreamstone bricks
 *  chiseled dreamstone bricks
 *  dreamy trees
 *  dreamy shrubs
 *  dreamy wood type (warm brown oak like)
 *
 *  pink clovers
 *
 * WILDERNESS (DREAMLAND)
 *  wild grass
 *  tall wild grass
 *  white puffball flowers (like a round allium)
 *  bluebell flowers
 *  bunnies
 *  catscout campgrounds
 *
 * ASPEN FOREST
 *  aspen trees
 *  aspen wood type (birch like)
 *  magenta puffball flowers
 *  ...should have more
 *
 * EVERGREEN FOREST
 *  evergreen trees
 *  evergreen wood type (forest green)
 *  toadstool
 *  fawn & deer
 *  forest fox
 *  snail
 *
 * ETHEREAL FOREST
 *  ethereal trees
 *  ethereal wood type (cyan)
 *  dreamy mushrooms
 *  lilac bush
 *  petunia flowers
 *  gnomes
 *  mushroom towns
 *
 * COTTON CANDY FOREST
 *  pink cotton candy trees
 *  blue cotton candy trees
 *  candy wood type (light pink)
 *  pink puffball flowers
 *  cotton candy sheep
 *
 * WISTERIA GROVE
 *  wisteria trees
 *  wisteria wood type (light lavender)
 *  hanging wisteria
 *  wall wisteria
 *  wisteria petals
 *
 * FAERIE FOREST
 *  mystical trees
 *  mystical wood type (dark magenta)
 *  pink mushrooms
 *  faeries
 *  ...should have more
 *
 * FLOWER FIELDS
 *  pink zinnia flowers
 *  magenta zinnia flowers
 *  orange zinnia flowers
 *  yellow zinnia flowers
 *  white zinnia flowers
 *  foxglove flowers
 *  catnip bushes
 *  cat villagers
 *  cat towns
 *
 * NIGHTMOOR BLOCKS
 *  grimstone
 *  mossy grimstone
 *  grimstone bricks
 *  mossy grimstone bricks
 *  cracked grimstone bricks
 *  chiseled grimstone bricks
 *  gloomy trees
 *  gloomy shrubs
 *  gloomy wood type (dark desaturated brown)
 *
 *  tree branch/twigs
 *  thorn bush
 *  mold
 *  poison ivy
 *  creeping ivy
 *
 * WILDERNESS (NIGHTMOOR)
 *  wild grass
 *  tall wild grass
 *  ...should have more...made as the opposite as the dream counterpart
 *
 * GRAVEYARD
 *  grave dirt
 *  gravestones
 *  wilted rose
 *  crows
 *  corpses
 *  maggots
 *  mausoleums
 *  ...should have more
 *
 * WASTELAND
 *  dead trees
 *  dead wood type (desaturated gray)
 *  dried grass block
 *  dried grass
 *  tall dried grass
 *  ...should have more
 *
 * WOODS
 *  grimwood trees
 *  grimwood wood type (dark brown?)
 *  elderberry bush
 *  fox villagers
 *  fox dens
 *  ...should have more
 *
 * PINE FOREST
 *  pine trees
 *  pine wood type (dark olive)
 *  death caps
 *  ...should have more
 *
 * POISED SWAMPLANDS
 *  poised trees
 *  poised wood type (deep purple)
 *  poised water
 *  leeches
 *  ...should have more
 *
 * BLOODWOOD FOREST
 *  bloodwood trees
 *  bloodwood wood type (deep mulberry)
 *  bleeding heart flowers
 *  ...should have more
 *
 * FUNGUS JUNGLE
 *  sour jungle trees
 *  sour wood type (pale green)
 *  fungus
 *  fungus wood type (sickly beige)
 *  jungle shrub
 *  jungle grass
 *  tall jungle grass
 *  jungle vine
 */
public class DreamBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, Dreamlands.modId);

    /// shared nature stuff
    public static final RegistryObject<Block> DREAMY_GRASS_BLOCK = BLOCKS.register("dreamy_grass_block", () -> new DreamGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).randomTicks().strength(0.6F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> DREAMY_DIRT_PATH = BLOCKS.register("dreamy_dirt_path", () -> new DreamDirtPathBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.65F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> DREAMY_DIRT = BLOCKS.register("dreamy_dirt", () -> new DreamDirtBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));

    public static final RegistryObject<Block> DREAMY_GRASS = BLOCKS.register("dreamy_grass", DreamBlocks::plant);
    public static final RegistryObject<Block> TALL_DREAMY_GRASS = BLOCKS.register("tall_dreamy_grass", DreamBlocks::doublePlant);
    ///public static final RegistryObject<Block> FOREST_GRASS = BLOCKS.register("forest_grass", DreamBlocks::plant);
    ///public static final RegistryObject<Block> TALL_FOREST_GRASS = BLOCKS.register("tall_forest_grass", DreamBlocks::doublePlant);
    public static final RegistryObject<Block> FOREST_MOSS_BLOCK = BLOCKS.register("forest_moss_block", () -> new DreamMossBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(0.1F).sound(SoundType.MOSS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> FOREST_MOSS_CARPET = BLOCKS.register("forest_moss_carpet", () -> new CarpetBlock(copy(FOREST_MOSS_BLOCK.get()).sound(SoundType.MOSS_CARPET)));
    public static final RegistryObject<Block> FOREST_SHRUB_LEAVES = BLOCKS.register("forest_shrub_leaves", DreamBlocks::leaves);
    public static final RegistryObject<Block> FOREST_SHRUB = BLOCKS.register("forest_shrub", () -> shrub(new DreamTreeGrowers(DreamTreeFeatures.FOREST_SHRUB)));

    public static final RegistryObject<Block> FAIRY_ROSE_BUSH_LEAVES = BLOCKS.register("fairy_rose_bush_leaves", () -> new FloweringBushLeavesBlock(leafProperties()));
    public static final RegistryObject<Block> FAIRY_ROSE_BUSH = BLOCKS.register("fairy_rose_bush", () -> shrub(new DreamTreeGrowers(DreamTreeFeatures.FAIRY_ROSE_BUSH)));
    public static final RegistryObject<Block> LILAC_BUSH_LEAVES = BLOCKS.register("lilac_bush_leaves", () -> new FloweringBushLeavesBlock(leafProperties()));
    public static final RegistryObject<Block> LILAC_BUSH = BLOCKS.register("lilac_bush", () -> shrub(new DreamTreeGrowers(DreamTreeFeatures.LILAC_BUSH)));

    ///public static final RegistryObject<Block> IVY = BLOCKS.register("ivy", () -> new IvyBlock(copy(DREAMY_GRASS.get())));
    public static final RegistryObject<Block> GROUND_IVY = BLOCKS.register("ground_ivy", () -> new CloverBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().sound(SoundType.PINK_PETALS).replaceable().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CLOVERS = BLOCKS.register("clovers", () -> new CloverBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().sound(SoundType.PINK_PETALS).replaceable().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WHITE_CLOVERS = BLOCKS.register("white_clovers", () -> new CloverBlock(copy(CLOVERS.get())));
    public static final RegistryObject<Block> PINK_CLOVERS = BLOCKS.register("pink_clovers", () -> new CloverBlock(copy(CLOVERS.get())));
    public static final RegistryObject<Block> PETUNIA = BLOCKS.register("petunia", DreamBlocks::flower);
    public static final RegistryObject<Block> PERIWINKLE = BLOCKS.register("periwinkle", () -> new PeriwinkleFlowerBlock(flowerProperties(false)));
    ///public static final RegistryObject<Block> PINK_PUFFBALL = BLOCKS.register("pink_puffball", DreamBlocks::flower);
    public static final RegistryObject<Block> PINK_FOXGLOVE = BLOCKS.register("pink_foxglove", () -> new FoxgloveFlowerBlock(flowerProperties()));
    public static final RegistryObject<Block> PINK_HYACINTH = BLOCKS.register("pink_hyacinth", () -> new HyacinthFlowerBlock(flowerProperties()));
    public static final RegistryObject<Block> MAGENTA_HYACINTH = BLOCKS.register("magenta_hyacinth", () -> new HyacinthFlowerBlock(flowerProperties()));
    public static final RegistryObject<Block> PURPLE_HYACINTH = BLOCKS.register("purple_hyacinth", () -> new HyacinthFlowerBlock(flowerProperties()));
    public static final RegistryObject<Block> PURPLE_LUPINE = BLOCKS.register("purple_lupine", () -> new StackableFlowerBlock(flowerProperties()));
    public static final RegistryObject<Block> VIOLETS = BLOCKS.register("violets", DreamBlocks::flower);
    public static final RegistryObject<Block> WISTERIA = BLOCKS.register("wisteria", () -> new WisteriaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).noCollission().sound(SoundType.FLOWERING_AZALEA).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WISTERIA_PLANT = BLOCKS.register("wisteria_plant", () -> new WisteriaPlantBlock(copy(WISTERIA.get())));
    public static final RegistryObject<Block> WALL_WISTERIA = BLOCKS.register("wall_wisteria", () -> new WallWisteriaBlock(copy(WISTERIA.get())));
    ///public static final RegistryObject<Block> WISTERIA_PETALS = BLOCKS.register("wisteria_petals", () -> new CloverBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().sound(SoundType.PINK_PETALS).replaceable().pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> DREAMY_MUSHROOM_BLOCK = BLOCKS.register("dreamy_mushroom_block", () -> mushroomBlock(MapColor.COLOR_MAGENTA));
    public static final RegistryObject<Block> DREAMY_MUSHROOM = BLOCKS.register("dreamy_mushroom", () -> mushroom(DreamTreeFeatures.DREAMY_MUSHROOM, MapColor.COLOR_MAGENTA));
    public static final RegistryObject<Block> FOREST_MUSHROOM_BLOCK = BLOCKS.register("forest_mushroom_block", () -> mushroomBlock(MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> FOREST_MUSHROOM = BLOCKS.register("forest_mushroom", () -> mushroom(DreamTreeFeatures.FOREST_MUSHROOM, MapColor.COLOR_BROWN));
    ///public static final RegistryObject<Block> WILD_MUSHROOM_BLOCK = BLOCKS.register("wild_mushroom_block", () -> mushroomBlock(MapColor.COLOR_ORANGE));
    ///public static final RegistryObject<Block> WILD_MUSHROOM = BLOCKS.register("wild_mushroom", () -> mushroom(new DreamMegaTreeGrowers(DreamTreeFeatures.PINK_MUSHROOM, MapColor.COLOR_ORANGE));
    public static final RegistryObject<Block> PINK_MUSHROOM_BLOCK = BLOCKS.register("pink_mushroom_block", () -> mushroomBlock(MapColor.COLOR_PINK));
    public static final RegistryObject<Block> PINK_MUSHROOM = BLOCKS.register("pink_mushroom", () -> mushroom(DreamTreeFeatures.PINK_MUSHROOM, MapColor.COLOR_PINK));
    public static final RegistryObject<Block> TOADSTOOL_BLOCK = BLOCKS.register("toadstool_block", () -> mushroomBlock(MapColor.WOOD));
    public static final RegistryObject<Block> TOADSTOOL = BLOCKS.register("toadstool", () -> mushroom(DreamTreeFeatures.TOADSTOOL, MapColor.WOOD));

    /// dreamstone
    public static final RegistryObject<Block> DREAMSTONE = BLOCKS.register("dreamstone", () -> stone(MapColor.STONE));
    public static final RegistryObject<Block> DREAMSTONE_STAIRS = BLOCKS.register("dreamstone_stairs", () -> stoneStairs(DREAMSTONE.get()));
    public static final RegistryObject<Block> DREAMSTONE_SLAB = BLOCKS.register("dreamstone_slab", () -> slab(DREAMSTONE.get()));
    public static final RegistryObject<Block> DREAMSTONE_PRESSURE_PLATE = BLOCKS.register("dreamstone_pressure_plate", () -> stonePressurePlate(DREAMSTONE.get(), DreamBlockSetTypes.DREAMSTONE));
    public static final RegistryObject<Block> DREAMSTONE_BUTTON = BLOCKS.register("dreamstone_button", () -> stoneButton(DreamBlockSetTypes.DREAMSTONE));
    public static final RegistryObject<Block> DREAMSTONE_WALL = BLOCKS.register("dreamstone_wall", () -> wall(DREAMSTONE.get()));
    public static final RegistryObject<Block> COBBLED_DREAMSTONE = BLOCKS.register("cobbled_dreamstone", () -> stone(MapColor.STONE));
    public static final RegistryObject<Block> COBBLED_DREAMSTONE_STAIRS = BLOCKS.register("cobbled_dreamstone_stairs", () -> stoneStairs(COBBLED_DREAMSTONE.get()));
    public static final RegistryObject<Block> COBBLED_DREAMSTONE_SLAB = BLOCKS.register("cobbled_dreamstone_slab", () -> slab(COBBLED_DREAMSTONE.get()));
    public static final RegistryObject<Block> COBBLED_DREAMSTONE_WALL = BLOCKS.register("cobbled_dreamstone_wall", () -> wall(COBBLED_DREAMSTONE.get()));
    public static final RegistryObject<Block> MOSSY_COBBLED_DREAMSTONE = BLOCKS.register("mossy_cobbled_dreamstone", () -> fromBlock(DREAMSTONE.get()));
    public static final RegistryObject<Block> MOSSY_COBBLED_DREAMSTONE_STAIRS = BLOCKS.register("mossy_cobbled_dreamstone_stairs", () -> stoneStairs(MOSSY_COBBLED_DREAMSTONE.get()));
    public static final RegistryObject<Block> MOSSY_COBBLED_DREAMSTONE_SLAB = BLOCKS.register("mossy_cobbled_dreamstone_slab", () -> slab(MOSSY_COBBLED_DREAMSTONE.get()));
    public static final RegistryObject<Block> MOSSY_COBBLED_DREAMSTONE_WALL = BLOCKS.register("mossy_cobbled_dreamstone_wall", () -> wall(MOSSY_COBBLED_DREAMSTONE.get()));
    public static final RegistryObject<Block> DREAMSTONE_BRICKS = BLOCKS.register("dreamstone_bricks", () -> fromBlock(DREAMSTONE.get()));
    public static final RegistryObject<Block> DREAMSTONE_BRICK_STAIRS = BLOCKS.register("dreamstone_brick_stairs", () -> stoneStairs(DREAMSTONE_BRICKS.get()));
    public static final RegistryObject<Block> DREAMSTONE_BRICK_SLAB = BLOCKS.register("dreamstone_brick_slab", () -> slab(DREAMSTONE_BRICKS.get()));
    public static final RegistryObject<Block> DREAMSTONE_BRICK_WALL = BLOCKS.register("dreamstone_brick_wall", () -> wall(DREAMSTONE_BRICKS.get()));
    public static final RegistryObject<Block> CRACKED_DREAMSTONE_BRICKS = BLOCKS.register("cracked_dreamstone_bricks", () -> fromBlock(DREAMSTONE.get()));
    public static final RegistryObject<Block> CHISELED_DREAMSTONE_BRICKS = BLOCKS.register("chiseled_dreamstone_bricks", () -> fromBlock(DREAMSTONE.get()));
    public static final RegistryObject<Block> MOSSY_DREAMSTONE_BRICKS = BLOCKS.register("mossy_dreamstone_bricks", () -> fromBlock(DREAMSTONE.get()));
    public static final RegistryObject<Block> MOSSY_DREAMSTONE_BRICK_STAIRS = BLOCKS.register("mossy_dreamstone_stairs", () -> stoneStairs(DREAMSTONE.get()));
    public static final RegistryObject<Block> MOSSY_DREAMSTONE_BRICK_SLAB = BLOCKS.register("mossy_dreamstone_brick_slab", () -> slab(MOSSY_DREAMSTONE_BRICKS.get()));
    public static final RegistryObject<Block> MOSSY_DREAMSTONE_BRICK_WALL = BLOCKS.register("mossy_dreamstone_brick_wall", () -> wall(MOSSY_DREAMSTONE_BRICKS.get()));

    /// dreamy wood
    public static final RegistryObject<Block> DREAMY_LEAVES = BLOCKS.register("dreamy_leaves", DreamBlocks::leaves);
    public static final RegistryObject<Block> DREAMY_SAPLING = BLOCKS.register("dreamy_sapling", () -> sapling(new DreamTreeGrowers(DreamTreeFeatures.DREAMY_TREE)));
    public static final RegistryObject<Block> DREAMY_LOG = BLOCKS.register("dreamy_log", () -> log(MapColor.WOOD, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> STRIPPED_DREAMY_LOG = BLOCKS.register("stripped_dreamy_log", () -> log(MapColor.WOOD));
    public static final RegistryObject<Block> DREAMY_WOOD = BLOCKS.register("dreamy_wood", () -> log(MapColor.WOOD));
    public static final RegistryObject<Block> STRIPPED_DREAMY_WOOD = BLOCKS.register("stripped_dreamy_wood", () -> log(MapColor.WOOD));
    public static final RegistryObject<Block> DREAMY_PLANKS = BLOCKS.register("dreamy_planks", () -> planks(MapColor.WOOD));
    public static final RegistryObject<Block> DREAMY_STAIRS = BLOCKS.register("dreamy_stairs", () -> stairs(DREAMY_PLANKS.get()));
    public static final RegistryObject<Block> DREAMY_SLAB = BLOCKS.register("dreamy_slab", () -> slab(DREAMY_PLANKS.get()));
    public static final RegistryObject<Block> DREAMY_FENCE = BLOCKS.register("dreamy_fence", () -> fence(DREAMY_PLANKS.get()));
    public static final RegistryObject<Block> DREAMY_FENCE_GATE = BLOCKS.register("dreamy_fence_gate", () -> fenceGate(DREAMY_PLANKS.get(), DreamWoodTypes.DREAMY));
    public static final RegistryObject<Block> DREAMY_BUTTON = BLOCKS.register("dreamy_button", () -> button(DreamBlockSetTypes.DREAMY));
    public static final RegistryObject<Block> DREAMY_PRESSURE_PLATE = BLOCKS.register("dreamy_pressure_plate", () -> pressurePlate(DREAMY_PLANKS.get(), DreamBlockSetTypes.DREAMY));
    public static final RegistryObject<Block> DREAMY_TRAPDOOR = BLOCKS.register("dreamy_trapdoor", () -> trapdoor(DREAMY_PLANKS.get(), DreamBlockSetTypes.DREAMY));
    public static final RegistryObject<Block> DREAMY_DOOR = BLOCKS.register("dreamy_door", () -> door(DREAMY_PLANKS.get(), DreamBlockSetTypes.DREAMY));
    public static final RegistryObject<Block> DREAMY_SIGN = BLOCKS.register("dreamy_sign", () -> sign(DREAMY_PLANKS.get(), DreamWoodTypes.DREAMY));
    public static final RegistryObject<Block> DREAMY_WALL_SIGN = BLOCKS.register("dreamy_wall_sign", () -> wallSign(DREAMY_SIGN.get(), DreamWoodTypes.DREAMY));
    public static final RegistryObject<Block> DREAMY_HANGING_SIGN = BLOCKS.register("dreamy_hanging_sign", () -> hangingSign(DREAMY_PLANKS.get(), DreamWoodTypes.DREAMY));
    public static final RegistryObject<Block> DREAMY_WALL_HANGING_SIGN = BLOCKS.register("dreamy_wall_hanging_sign", () -> wallHangingSign(DREAMY_HANGING_SIGN.get(), DreamWoodTypes.DREAMY));

    /// aspen forest
    public static final RegistryObject<Block> ASPEN_LEAVES = BLOCKS.register("aspen_leaves", DreamBlocks::leaves);
    public static final RegistryObject<Block> ASPEN_SAPLING = BLOCKS.register("aspen_sapling", () -> sapling(new DreamTreeGrowers(DreamTreeFeatures.ASPEN_TREE)));
    public static final RegistryObject<Block> ASPEN_LOG = BLOCKS.register("aspen_log", () -> log(MapColor.SAND, MapColor.QUARTZ));
    public static final RegistryObject<Block> STRIPPED_ASPEN_LOG = BLOCKS.register("stripped_aspen_log", () -> log(MapColor.SAND));
    public static final RegistryObject<Block> ASPEN_WOOD = BLOCKS.register("aspen_wood", () -> log(MapColor.SAND));
    public static final RegistryObject<Block> STRIPPED_ASPEN_WOOD = BLOCKS.register("stripped_aspen_wood", () -> log(MapColor.SAND));
    public static final RegistryObject<Block> ASPEN_PLANKS = BLOCKS.register("aspen_planks", () -> planks(MapColor.SAND));
    public static final RegistryObject<Block> ASPEN_STAIRS = BLOCKS.register("aspen_stairs", () -> stairs(ASPEN_PLANKS.get()));
    public static final RegistryObject<Block> ASPEN_SLAB = BLOCKS.register("aspen_slab", () -> slab(ASPEN_PLANKS.get()));
    public static final RegistryObject<Block> ASPEN_FENCE = BLOCKS.register("aspen_fence", () -> fence(ASPEN_PLANKS.get()));
    public static final RegistryObject<Block> ASPEN_FENCE_GATE = BLOCKS.register("aspen_fence_gate", () -> fenceGate(ASPEN_PLANKS.get(), DreamWoodTypes.ASPEN));
    public static final RegistryObject<Block> ASPEN_BUTTON = BLOCKS.register("aspen_button", () -> button(DreamBlockSetTypes.ASPEN));
    public static final RegistryObject<Block> ASPEN_PRESSURE_PLATE = BLOCKS.register("aspen_pressure_plate", () -> pressurePlate(ASPEN_PLANKS.get(), DreamBlockSetTypes.ASPEN));
    public static final RegistryObject<Block> ASPEN_TRAPDOOR = BLOCKS.register("aspen_trapdoor", () -> trapdoor(ASPEN_PLANKS.get(), DreamBlockSetTypes.ASPEN));
    public static final RegistryObject<Block> ASPEN_DOOR = BLOCKS.register("aspen_door", () -> door(ASPEN_PLANKS.get(), DreamBlockSetTypes.ASPEN));
    public static final RegistryObject<Block> ASPEN_SIGN = BLOCKS.register("aspen_sign", () -> sign(ASPEN_PLANKS.get(), DreamWoodTypes.ASPEN));
    public static final RegistryObject<Block> ASPEN_WALL_SIGN = BLOCKS.register("aspen_wall_sign", () -> wallSign(ASPEN_SIGN.get(), DreamWoodTypes.ASPEN));
    public static final RegistryObject<Block> ASPEN_HANGING_SIGN = BLOCKS.register("aspen_hanging_sign", () -> hangingSign(ASPEN_PLANKS.get(), DreamWoodTypes.ASPEN));
    public static final RegistryObject<Block> ASPEN_WALL_HANGING_SIGN = BLOCKS.register("aspen_wall_hanging_sign", () -> wallHangingSign(ASPEN_HANGING_SIGN.get(), DreamWoodTypes.ASPEN));

    /// evergreen forest
    public static final RegistryObject<Block> EVERGREEN_LEAVES = BLOCKS.register("evergreen_leaves", DreamBlocks::leaves);
    public static final RegistryObject<Block> EVERGREEN_SAPLING = BLOCKS.register("evergreen_sapling", () -> sapling(new DreamMegaTreeGrowers(DreamTreeFeatures.EVERGREEN_TREE, DreamTreeFeatures.LARGE_EVERGREEN_TREE)));
    public static final RegistryObject<Block> EVERGREEN_LOG = BLOCKS.register("evergreen_log", () -> log(MapColor.TERRACOTTA_GREEN, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> STRIPPED_EVERGREEN_LOG = BLOCKS.register("stripped_evergreen_log", () -> log(MapColor.TERRACOTTA_GREEN));
    public static final RegistryObject<Block> EVERGREEN_WOOD = BLOCKS.register("evergreen_wood", () -> log(MapColor.TERRACOTTA_GREEN));
    public static final RegistryObject<Block> STRIPPED_EVERGREEN_WOOD = BLOCKS.register("stripped_evergreen_wood", () -> log(MapColor.TERRACOTTA_GREEN));
    public static final RegistryObject<Block> EVERGREEN_PLANKS = BLOCKS.register("evergreen_planks", () -> planks(MapColor.TERRACOTTA_GREEN));
    public static final RegistryObject<Block> EVERGREEN_STAIRS = BLOCKS.register("evergreen_stairs", () -> stairs(EVERGREEN_PLANKS.get()));
    public static final RegistryObject<Block> EVERGREEN_SLAB = BLOCKS.register("evergreen_slab", () -> slab(EVERGREEN_PLANKS.get()));
    public static final RegistryObject<Block> EVERGREEN_FENCE = BLOCKS.register("evergreen_fence", () -> fence(EVERGREEN_PLANKS.get()));
    public static final RegistryObject<Block> EVERGREEN_FENCE_GATE = BLOCKS.register("evergreen_fence_gate", () -> fenceGate(EVERGREEN_PLANKS.get(), DreamWoodTypes.EVERGREEN));
    public static final RegistryObject<Block> EVERGREEN_BUTTON = BLOCKS.register("evergreen_button", () -> button(DreamBlockSetTypes.EVERGREEN));
    public static final RegistryObject<Block> EVERGREEN_PRESSURE_PLATE = BLOCKS.register("evergreen_pressure_plate", () -> pressurePlate(EVERGREEN_PLANKS.get(), DreamBlockSetTypes.EVERGREEN));
    public static final RegistryObject<Block> EVERGREEN_TRAPDOOR = BLOCKS.register("evergreen_trapdoor", () -> trapdoor(EVERGREEN_PLANKS.get(), DreamBlockSetTypes.EVERGREEN));
    public static final RegistryObject<Block> EVERGREEN_DOOR = BLOCKS.register("evergreen_door", () -> door(EVERGREEN_PLANKS.get(), DreamBlockSetTypes.EVERGREEN));
    public static final RegistryObject<Block> EVERGREEN_SIGN = BLOCKS.register("evergreen_sign", () -> sign(EVERGREEN_PLANKS.get(), DreamWoodTypes.EVERGREEN));
    public static final RegistryObject<Block> EVERGREEN_WALL_SIGN = BLOCKS.register("evergreen_wall_sign", () -> wallSign(EVERGREEN_SIGN.get(), DreamWoodTypes.EVERGREEN));
    public static final RegistryObject<Block> EVERGREEN_HANGING_SIGN = BLOCKS.register("evergreen_hanging_sign", () -> hangingSign(EVERGREEN_PLANKS.get(), DreamWoodTypes.EVERGREEN));
    public static final RegistryObject<Block> EVERGREEN_WALL_HANGING_SIGN = BLOCKS.register("evergreen_wall_hanging_sign", () -> wallHangingSign(EVERGREEN_HANGING_SIGN.get(), DreamWoodTypes.EVERGREEN));

    /// ethereal forest
    public static final RegistryObject<Block> ETHEREAL_LEAVES = BLOCKS.register("ethereal_leaves", () -> new FloweringLeavesBlock(leafProperties()));
    public static final RegistryObject<Block> ETHEREAL_SAPLING = BLOCKS.register("ethereal_sapling", () -> sapling(new DreamMegaTreeGrowers(DreamTreeFeatures.ETHEREAL_TREE, DreamTreeFeatures.ETHEREAL_TREE)));
    public static final RegistryObject<Block> ETHEREAL_LOG = BLOCKS.register("ethereal_log", () -> log(MapColor.COLOR_CYAN, MapColor.TERRACOTTA_BLUE));
    public static final RegistryObject<Block> STRIPPED_ETHEREAL_LOG = BLOCKS.register("stripped_ethereal_log", () -> log(MapColor.COLOR_CYAN));
    public static final RegistryObject<Block> ETHEREAL_WOOD = BLOCKS.register("ethereal_wood", () -> log(MapColor.COLOR_CYAN));
    public static final RegistryObject<Block> STRIPPED_ETHEREAL_WOOD = BLOCKS.register("stripped_ethereal_wood", () -> log(MapColor.COLOR_CYAN));
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
    public static final RegistryObject<Block> ETHEREAL_WALL_SIGN = BLOCKS.register("ethereal_wall_sign", () -> wallSign(ETHEREAL_SIGN.get(), DreamWoodTypes.ETHEREAL));
    public static final RegistryObject<Block> ETHEREAL_HANGING_SIGN = BLOCKS.register("ethereal_hanging_sign", () -> hangingSign(ETHEREAL_PLANKS.get(), DreamWoodTypes.ETHEREAL));
    public static final RegistryObject<Block> ETHEREAL_WALL_HANGING_SIGN = BLOCKS.register("ethereal_wall_hanging_sign", () -> wallHangingSign(ETHEREAL_HANGING_SIGN.get(), DreamWoodTypes.ETHEREAL));

    /// cotton candy forest
    public static final RegistryObject<Block> PINK_COTTON_CANDY_BLOCK = BLOCKS.register("pink_cotton_candy_block", DreamBlocks::leaves);
    public static final RegistryObject<Block> PINK_COTTON_CANDY_SAPLING = BLOCKS.register("pink_cotton_candy_sapling", () -> sapling(new DreamTreeGrowers(DreamTreeFeatures.PINK_COTTON_CANDY_TREE)));
    public static final RegistryObject<Block> BLUE_COTTON_CANDY_BLOCK = BLOCKS.register("blue_cotton_candy_block", DreamBlocks::leaves);
    public static final RegistryObject<Block> BLUE_COTTON_CANDY_SAPLING = BLOCKS.register("blue_cotton_candy_sapling", () -> sapling(new DreamTreeGrowers(DreamTreeFeatures.BLUE_COTTON_CANDY_TREE)));
    public static final RegistryObject<Block> CANDY_LOG = BLOCKS.register("candy_log", () -> log(MapColor.COLOR_PINK, MapColor.QUARTZ));
    public static final RegistryObject<Block> STRIPPED_CANDY_LOG = BLOCKS.register("stripped_candy_log", () -> log(MapColor.COLOR_PINK));
    public static final RegistryObject<Block> CANDY_WOOD = BLOCKS.register("candy_wood", () -> log(MapColor.COLOR_PINK));
    public static final RegistryObject<Block> STRIPPED_CANDY_WOOD = BLOCKS.register("stripped_candy_wood", () -> log(MapColor.COLOR_PINK));
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
    public static final RegistryObject<Block> CANDY_WALL_SIGN = BLOCKS.register("candy_wall_sign", () -> wallSign(CANDY_SIGN.get(), DreamWoodTypes.CANDY));
    public static final RegistryObject<Block> CANDY_HANGING_SIGN = BLOCKS.register("candy_hanging_sign", () -> hangingSign(CANDY_PLANKS.get(), DreamWoodTypes.CANDY));
    public static final RegistryObject<Block> CANDY_WALL_HANGING_SIGN = BLOCKS.register("candy_wall_hanging_sign", () -> wallHangingSign(CANDY_HANGING_SIGN.get(), DreamWoodTypes.CANDY));

    /// wisteria grove
    public static final RegistryObject<Block> WISTERIA_LEAVES = BLOCKS.register("wisteria_leaves", () -> new FloweringLeavesBlock(leafProperties()));
    public static final RegistryObject<Block> WISTERIA_BLOSSOMS = BLOCKS.register("wisteria_blossoms", DreamBlocks::leaves);
    public static final RegistryObject<Block> WISTERIA_SAPLING = BLOCKS.register("wisteria_sapling", () -> sapling(new DreamTreeGrowers(DreamTreeFeatures.WISTERIA_TREE)));
    public static final RegistryObject<Block> WISTERIA_LOG = BLOCKS.register("wisteria_log", () -> log(MapColor.COLOR_PURPLE, MapColor.TERRACOTTA_LIGHT_GRAY));
    public static final RegistryObject<Block> STRIPPED_WISTERIA_LOG = BLOCKS.register("stripped_wisteria_log", () -> log(MapColor.COLOR_PURPLE));
    public static final RegistryObject<Block> WISTERIA_WOOD = BLOCKS.register("wisteria_wood", () -> log(MapColor.COLOR_PURPLE));
    public static final RegistryObject<Block> STRIPPED_WISTERIA_WOOD = BLOCKS.register("stripped_wisteria_wood", () -> log(MapColor.COLOR_PURPLE));
    public static final RegistryObject<Block> WISTERIA_PLANKS = BLOCKS.register("wisteria_planks", () -> planks(MapColor.COLOR_PURPLE));
    public static final RegistryObject<Block> WISTERIA_STAIRS = BLOCKS.register("wisteria_stairs", () -> stairs(WISTERIA_PLANKS.get()));
    public static final RegistryObject<Block> WISTERIA_SLAB = BLOCKS.register("wisteria_slab", () -> slab(WISTERIA_PLANKS.get()));
    public static final RegistryObject<Block> WISTERIA_FENCE = BLOCKS.register("wisteria_fence", () -> fence(WISTERIA_PLANKS.get()));
    public static final RegistryObject<Block> WISTERIA_FENCE_GATE = BLOCKS.register("wisteria_fence_gate", () -> fenceGate(WISTERIA_PLANKS.get(), DreamWoodTypes.WISTERIA));
    public static final RegistryObject<Block> WISTERIA_BUTTON = BLOCKS.register("wisteria_button", () -> button(DreamBlockSetTypes.WISTERIA));
    public static final RegistryObject<Block> WISTERIA_PRESSURE_PLATE = BLOCKS.register("wisteria_pressure_plate", () -> pressurePlate(WISTERIA_PLANKS.get(), DreamBlockSetTypes.WISTERIA));
    public static final RegistryObject<Block> WISTERIA_TRAPDOOR = BLOCKS.register("wisteria_trapdoor", () -> trapdoor(WISTERIA_PLANKS.get(), DreamBlockSetTypes.WISTERIA));
    public static final RegistryObject<Block> WISTERIA_DOOR = BLOCKS.register("wisteria_door", () -> door(WISTERIA_PLANKS.get(), DreamBlockSetTypes.WISTERIA));
    public static final RegistryObject<Block> WISTERIA_SIGN = BLOCKS.register("wisteria_sign", () -> sign(WISTERIA_PLANKS.get(), DreamWoodTypes.WISTERIA));
    public static final RegistryObject<Block> WISTERIA_WALL_SIGN = BLOCKS.register("wisteria_wall_sign", () -> wallSign(WISTERIA_SIGN.get(), DreamWoodTypes.WISTERIA));
    public static final RegistryObject<Block> WISTERIA_HANGING_SIGN = BLOCKS.register("wisteria_hanging_sign", () -> hangingSign(WISTERIA_PLANKS.get(), DreamWoodTypes.WISTERIA));
    public static final RegistryObject<Block> WISTERIA_WALL_HANGING_SIGN = BLOCKS.register("wisteria_wall_hanging_sign", () -> wallHangingSign(WISTERIA_HANGING_SIGN.get(), DreamWoodTypes.WISTERIA));

    /// mystical forest
    public static final RegistryObject<Block> MYSTICAL_LEAVES = BLOCKS.register("mystical_leaves", DreamBlocks::leaves);
    public static final RegistryObject<Block> MYSTICAL_SAPLING = BLOCKS.register("mystical_sapling", () -> sapling(new DreamMegaTreeGrowers(DreamTreeFeatures.MYSTICAL_TREE, DreamTreeFeatures.MYSTICAL_TREE)));
    public static final RegistryObject<Block> MYSTICAL_LOG = BLOCKS.register("mystical_log", () -> log(MapColor.TERRACOTTA_MAGENTA, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> STRIPPED_MYSTICAL_LOG = BLOCKS.register("stripped_mystical_log", () -> log(MapColor.TERRACOTTA_MAGENTA));
    public static final RegistryObject<Block> MYSTICAL_WOOD = BLOCKS.register("mystical_wood", () -> log(MapColor.TERRACOTTA_MAGENTA));
    public static final RegistryObject<Block> STRIPPED_MYSTICAL_WOOD = BLOCKS.register("stripped_mystical_wood", () -> log(MapColor.TERRACOTTA_MAGENTA));
    public static final RegistryObject<Block> MYSTICAL_PLANKS = BLOCKS.register("mystical_planks", () -> planks(MapColor.TERRACOTTA_MAGENTA));
    public static final RegistryObject<Block> MYSTICAL_STAIRS = BLOCKS.register("mystical_stairs", () -> stairs(MYSTICAL_PLANKS.get()));
    public static final RegistryObject<Block> MYSTICAL_SLAB = BLOCKS.register("mystical_slab", () -> slab(MYSTICAL_PLANKS.get()));
    public static final RegistryObject<Block> MYSTICAL_FENCE = BLOCKS.register("mystical_fence", () -> fence(MYSTICAL_PLANKS.get()));
    public static final RegistryObject<Block> MYSTICAL_FENCE_GATE = BLOCKS.register("mystical_fence_gate", () -> fenceGate(MYSTICAL_PLANKS.get(), DreamWoodTypes.MYSTICAL));
    public static final RegistryObject<Block> MYSTICAL_BUTTON = BLOCKS.register("mystical_button", () -> button(DreamBlockSetTypes.MYSTICAL));
    public static final RegistryObject<Block> MYSTICAL_PRESSURE_PLATE = BLOCKS.register("mystical_pressure_plate", () -> pressurePlate(MYSTICAL_PLANKS.get(), DreamBlockSetTypes.MYSTICAL));
    public static final RegistryObject<Block> MYSTICAL_TRAPDOOR = BLOCKS.register("mystical_trapdoor", () -> trapdoor(MYSTICAL_PLANKS.get(), DreamBlockSetTypes.MYSTICAL));
    public static final RegistryObject<Block> MYSTICAL_DOOR = BLOCKS.register("mystical_door", () -> door(MYSTICAL_PLANKS.get(), DreamBlockSetTypes.MYSTICAL));
    public static final RegistryObject<Block> MYSTICAL_SIGN = BLOCKS.register("mystical_sign", () -> sign(MYSTICAL_PLANKS.get(), DreamWoodTypes.MYSTICAL));
    public static final RegistryObject<Block> MYSTICAL_WALL_SIGN = BLOCKS.register("mystical_wall_sign", () -> wallSign(MYSTICAL_SIGN.get(), DreamWoodTypes.MYSTICAL));
    public static final RegistryObject<Block> MYSTICAL_HANGING_SIGN = BLOCKS.register("mystical_hanging_sign", () -> hangingSign(MYSTICAL_PLANKS.get(), DreamWoodTypes.MYSTICAL));
    public static final RegistryObject<Block> MYSTICAL_WALL_HANGING_SIGN = BLOCKS.register("mystical_wall_hanging_sign", () -> wallHangingSign(MYSTICAL_HANGING_SIGN.get(), DreamWoodTypes.MYSTICAL));

    /// mushroom
    public static final RegistryObject<Block> MUSHROOM_STEM = BLOCKS.register("mushroom_stem", () -> log(MapColor.QUARTZ, MapColor.TERRACOTTA_WHITE));
    public static final RegistryObject<Block> STRIPPED_MUSHROOM_STEM = BLOCKS.register("stripped_mushroom_stem", () -> log(MapColor.QUARTZ));
    public static final RegistryObject<Block> MUSHROOM_HYPHAE = BLOCKS.register("mushroom_hyphae", () -> log(MapColor.QUARTZ));
    public static final RegistryObject<Block> STRIPPED_MUSHROOM_HYPHAE = BLOCKS.register("stripped_mushroom_hyphae", () -> log(MapColor.QUARTZ));
    public static final RegistryObject<Block> MUSHROOM_PLANKS = BLOCKS.register("mushroom_planks", () -> planks(MapColor.QUARTZ));
    public static final RegistryObject<Block> MUSHROOM_STAIRS = BLOCKS.register("mushroom_stairs", () -> stairs(MUSHROOM_PLANKS.get()));
    public static final RegistryObject<Block> MUSHROOM_SLAB = BLOCKS.register("mushroom_slab", () -> slab(MUSHROOM_PLANKS.get()));
    public static final RegistryObject<Block> MUSHROOM_FENCE = BLOCKS.register("mushroom_fence", () -> fence(MUSHROOM_PLANKS.get()));
    public static final RegistryObject<Block> MUSHROOM_FENCE_GATE = BLOCKS.register("mushroom_fence_gate", () -> fenceGate(MUSHROOM_PLANKS.get(), DreamWoodTypes.MUSHROOM));
    public static final RegistryObject<Block> MUSHROOM_BUTTON = BLOCKS.register("mushroom_button", () -> button(DreamBlockSetTypes.MUSHROOM));
    public static final RegistryObject<Block> MUSHROOM_PRESSURE_PLATE = BLOCKS.register("mushroom_pressure_plate", () -> pressurePlate(MUSHROOM_PLANKS.get(), DreamBlockSetTypes.MUSHROOM));
    public static final RegistryObject<Block> MUSHROOM_TRAPDOOR = BLOCKS.register("mushroom_trapdoor", () -> trapdoor(MUSHROOM_PLANKS.get(), DreamBlockSetTypes.MUSHROOM));
    public static final RegistryObject<Block> MUSHROOM_DOOR = BLOCKS.register("mushroom_door", () -> door(MUSHROOM_PLANKS.get(), DreamBlockSetTypes.MUSHROOM));
    public static final RegistryObject<Block> MUSHROOM_SIGN = BLOCKS.register("mushroom_sign", () -> sign(MUSHROOM_PLANKS.get(), DreamWoodTypes.MUSHROOM));
    public static final RegistryObject<Block> MUSHROOM_WALL_SIGN = BLOCKS.register("mushroom_wall_sign", () -> wallSign(MUSHROOM_SIGN.get(), DreamWoodTypes.MUSHROOM));
    public static final RegistryObject<Block> MUSHROOM_HANGING_SIGN = BLOCKS.register("mushroom_hanging_sign", () -> hangingSign(MUSHROOM_PLANKS.get(), DreamWoodTypes.MUSHROOM));
    public static final RegistryObject<Block> MUSHROOM_WALL_HANGING_SIGN = BLOCKS.register("mushroom_wall_hanging_sign", () -> wallHangingSign(MUSHROOM_HANGING_SIGN.get(), DreamWoodTypes.MUSHROOM));

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /// nightmoor
    ///public static final RegistryObject<Block> GRIMSTONE = BLOCKS.register("grimstone", () -> stone(MapColor.DEEPSLATE));
    ///public static final RegistryObject<Block> GRIMSTONE_STAIRS = BLOCKS.register("grimstone_stairs", () -> stoneStairs(GRIMSTONE.get()));
    ///public static final RegistryObject<Block> GRIMSTONE_SLAB = BLOCKS.register("grimstone_slab", () -> slab(GRIMSTONE.get()));
    ///public static final RegistryObject<Block> GRIMSTONE_PRESSURE_PLATE = BLOCKS.register("grimstone_pressure_plate", () -> stonePressurePlate(GRIMSTONE.get(), DreamBlockSetTypes.GRIMSTONE));
    ///public static final RegistryObject<Block> GRIMSTONE_BUTTON = BLOCKS.register("grimstone_button", () -> stoneButton(DreamBlockSetTypes.GRIMSTONE));
    ///public static final RegistryObject<Block> GRIMSTONE_WALL = BLOCKS.register("grimstone_wall", () -> wall(GRIMSTONE.get()));
    ///public static final RegistryObject<Block> COBBLED_GRIMSTONE = BLOCKS.register("cobbled_grimstone", () -> stone(MapColor.DEEPSLATE));
    ///public static final RegistryObject<Block> COBBLED_GRIMSTONE_STAIRS = BLOCKS.register("cobbled_grimstone_stairs", () -> stoneStairs(COBBLED_GRIMSTONE.get()));
    ///public static final RegistryObject<Block> COBBLED_GRIMSTONE_SLAB = BLOCKS.register("cobbled_grimstone_slab", () -> slab(COBBLED_GRIMSTONE.get()));
    ///public static final RegistryObject<Block> COBBLED_GRIMSTONE_WALL = BLOCKS.register("cobbled_grimstone_wall", () -> wall(COBBLED_GRIMSTONE.get()));
    ///public static final RegistryObject<Block> MOSSY_COBBLED_GRIMSTONE = BLOCKS.register("mossy_cobbled_grimstone", () -> fromBlock(GRIMSTONE.get()));
    ///public static final RegistryObject<Block> MOSSY_COBBLED_GRIMSTONE_STAIRS = BLOCKS.register("mossy_cobbled_grimstone_stairs", () -> stoneStairs(MOSSY_COBBLED_GRIMSTONE.get()));
    ///public static final RegistryObject<Block> MOSSY_COBBLED_GRIMSTONE_SLAB = BLOCKS.register("mossy_cobbled_grimstone_slab", () -> slab(MOSSY_COBBLED_GRIMSTONE.get()));
    ///public static final RegistryObject<Block> MOSSY_COBBLED_GRIMSTONE_WALL = BLOCKS.register("mossy_cobbled_grimstone_wall", () -> wall(MOSSY_COBBLED_GRIMSTONE.get()));
    ///public static final RegistryObject<Block> GRIMSTONE_BRICKS = BLOCKS.register("grimstone_bricks", () -> fromBlock(GRIMSTONE.get()));
    ///public static final RegistryObject<Block> GRIMSTONE_BRICK_STAIRS = BLOCKS.register("grimstone_brick_stairs", () -> stoneStairs(GRIMSTONE_BRICKS.get()));
    ///public static final RegistryObject<Block> GRIMSTONE_BRICK_SLAB = BLOCKS.register("grimstone_brick_slab", () -> slab(GRIMSTONE_BRICKS.get()));
    ///public static final RegistryObject<Block> GRIMSTONE_BRICK_WALL = BLOCKS.register("grimstone_brick_wall", () -> wall(GRIMSTONE_BRICKS.get()));
    ///public static final RegistryObject<Block> CRACKED_GRIMSTONE_BRICKS = BLOCKS.register("cracked_grimstone_bricks", () -> fromBlock(GRIMSTONE.get()));
    ///public static final RegistryObject<Block> CHISELED_GRIMSTONE_BRICKS = BLOCKS.register("chiseled_grimstone_bricks", () -> fromBlock(GRIMSTONE.get()));
    ///public static final RegistryObject<Block> MOSSY_GRIMSTONE_BRICKS = BLOCKS.register("mossy_grimstone_bricks", () -> fromBlock(GRIMSTONE.get()));
    ///public static final RegistryObject<Block> MOSSY_GRIMSTONE_BRICK_STAIRS = BLOCKS.register("mossy_grimstone_stairs", () -> stoneStairs(GRIMSTONE.get()));
    ///public static final RegistryObject<Block> MOSSY_GRIMSTONE_BRICK_SLAB = BLOCKS.register("mossy_grimstone_brick_slab", () -> slab(MOSSY_GRIMSTONE_BRICKS.get()));
    ///public static final RegistryObject<Block> MOSSY_GRIMSTONE_BRICK_WALL = BLOCKS.register("mossy_grimstone_brick_wall", () -> wall(MOSSY_GRIMSTONE_BRICKS.get()));
    ///
    ///public static final RegistryObject<Block> GLOOMY_MUSHROOM_BLOCK = BLOCKS.register("gloomy_mushroom_block", () -> mushroomBlock(MapColor.COLOR_GRAY));
    ///public static final RegistryObject<Block> GLOOMY_MUSHROOM = BLOCKS.register("gloomy_mushroom", () -> mushroom(new DreamMegaTreeGrowers(DreamTreeFeatures.GLOOMY_MUSHROOM, MapColor.COLOR_GRAY));
    ///
    ///public static final RegistryObject<Block> GLOOMY_LEAVES = BLOCKS.register("gloomy_leaves", DreamBlocks::leaves);
    ///public static final RegistryObject<Block> GLOOMY_SAPLING = BLOCKS.register("gloomy_sapling", () -> sapling(new DreamMegaTreeGrowers(DreamTreeFeatures.GLOOMY));
    ///public static final RegistryObject<Block> GLOOMY_LOG = BLOCKS.register("gloomy_log", () -> log(MapColor.COLOR_BROWN, MapColor.TERRACOTTA_BROWN));
    ///public static final RegistryObject<Block> STRIPPED_GLOOMY_LOG = BLOCKS.register("stripped_gloomy_log", () -> log(MapColor.COLOR_BROWN));
    ///public static final RegistryObject<Block> GLOOMY_WOOD = BLOCKS.register("gloomy_wood", () -> log(MapColor.COLOR_BROWN));
    ///public static final RegistryObject<Block> STRIPPED_GLOOMY_WOOD = BLOCKS.register("stripped_gloomy_wood", () -> log(MapColor.COLOR_BROWN));
    ///public static final RegistryObject<Block> GLOOMY_PLANKS = BLOCKS.register("gloomy_planks", () -> planks(MapColor.COLOR_BROWN));
    ///public static final RegistryObject<Block> GLOOMY_STAIRS = BLOCKS.register("gloomy_stairs", () -> stairs(GLOOMY_PLANKS.get()));
    ///public static final RegistryObject<Block> GLOOMY_SLAB = BLOCKS.register("gloomy_slab", () -> slab(GLOOMY_PLANKS.get()));
    ///public static final RegistryObject<Block> GLOOMY_FENCE = BLOCKS.register("gloomy_fence", () -> fence(GLOOMY_PLANKS.get()));
    ///public static final RegistryObject<Block> GLOOMY_FENCE_GATE = BLOCKS.register("gloomy_fence_gate", () -> fenceGate(GLOOMY_PLANKS.get(), DreamWoodTypes.GLOOMY));
    ///public static final RegistryObject<Block> GLOOMY_BUTTON = BLOCKS.register("gloomy_button", () -> button(DreamBlockSetTypes.GLOOMY));
    ///public static final RegistryObject<Block> GLOOMY_PRESSURE_PLATE = BLOCKS.register("gloomy_pressure_plate", () -> pressurePlate(GLOOMY_PLANKS.get(), DreamBlockSetTypes.GLOOMY));
    ///public static final RegistryObject<Block> GLOOMY_TRAPDOOR = BLOCKS.register("gloomy_trapdoor", () -> trapdoor(GLOOMY_PLANKS.get(), DreamBlockSetTypes.GLOOMY));
    ///public static final RegistryObject<Block> GLOOMY_DOOR = BLOCKS.register("gloomy_door", () -> door(GLOOMY_PLANKS.get(), DreamBlockSetTypes.GLOOMY));
    ///public static final RegistryObject<Block> GLOOMY_SIGN = BLOCKS.register("gloomy_sign", () -> sign(GLOOMY_PLANKS.get(), DreamWoodTypes.GLOOMY));
    ///public static final RegistryObject<Block> GLOOMY_WALL_SIGN = BLOCKS.register("gloomy_wall_sign", () -> wallSign(GLOOMY_SIGN.get(), DreamWoodTypes.GLOOMY));
    ///public static final RegistryObject<Block> GLOOMY_HANGING_SIGN = BLOCKS.register("gloomy_hanging_sign", () -> hangingSign(GLOOMY_PLANKS.get(), DreamWoodTypes.GLOOMY));
    ///public static final RegistryObject<Block> GLOOMY_WALL_HANGING_SIGN = BLOCKS.register("gloomy_wall_hanging_sign", () -> wallHangingSign(GLOOMY_HANGING_SIGN.get(), DreamWoodTypes.GLOOMY));
    ///
    ///public static final RegistryObject<Block> GRIMWOOD_LEAVES = BLOCKS.register("grimwood_leaves", DreamBlocks::leaves);
    ///public static final RegistryObject<Block> GRIMWOOD_SAPLING = BLOCKS.register("grimwood_sapling", () -> sapling(new DreamMegaTreeGrowers(DreamTreeFeatures.GRIMWOOD));
    ///public static final RegistryObject<Block> GRIMWOOD_LOG = BLOCKS.register("grimwood_log", () -> log(MapColor.TERRACOTTA_BLACK, MapColor.TERRACOTTA_BROWN));
    ///public static final RegistryObject<Block> STRIPPED_GRIMWOOD_LOG = BLOCKS.register("stripped_grimwood_log", () -> log(MapColor.TERRACOTTA_BLACK));
    ///public static final RegistryObject<Block> GRIMWOOD_WOOD = BLOCKS.register("grimwood_wood", () -> log(MapColor.TERRACOTTA_BLACK));
    ///public static final RegistryObject<Block> STRIPPED_GRIMWOOD_WOOD = BLOCKS.register("stripped_grimwood_wood", () -> log(MapColor.TERRACOTTA_BLACK));
    ///public static final RegistryObject<Block> GRIMWOOD_PLANKS = BLOCKS.register("grimwood_planks", () -> planks(MapColor.TERRACOTTA_BLACK));
    ///public static final RegistryObject<Block> GRIMWOOD_STAIRS = BLOCKS.register("grimwood_stairs", () -> stairs(GRIMWOOD_PLANKS.get()));
    ///public static final RegistryObject<Block> GRIMWOOD_SLAB = BLOCKS.register("grimwood_slab", () -> slab(GRIMWOOD_PLANKS.get()));
    ///public static final RegistryObject<Block> GRIMWOOD_FENCE = BLOCKS.register("grimwood_fence", () -> fence(GRIMWOOD_PLANKS.get()));
    ///public static final RegistryObject<Block> GRIMWOOD_FENCE_GATE = BLOCKS.register("grimwood_fence_gate", () -> fenceGate(GRIMWOOD_PLANKS.get(), DreamWoodTypes.GRIMWOOD));
    ///public static final RegistryObject<Block> GRIMWOOD_BUTTON = BLOCKS.register("grimwood_button", () -> button(DreamBlockSetTypes.GRIMWOOD));
    ///public static final RegistryObject<Block> GRIMWOOD_PRESSURE_PLATE = BLOCKS.register("grimwood_pressure_plate", () -> pressurePlate(GRIMWOOD_PLANKS.get(), DreamBlockSetTypes.GRIMWOOD));
    ///public static final RegistryObject<Block> GRIMWOOD_TRAPDOOR = BLOCKS.register("grimwood_trapdoor", () -> trapdoor(GRIMWOOD_PLANKS.get(), DreamBlockSetTypes.GRIMWOOD));
    ///public static final RegistryObject<Block> GRIMWOOD_DOOR = BLOCKS.register("grimwood_door", () -> door(GRIMWOOD_PLANKS.get(), DreamBlockSetTypes.GRIMWOOD));
    ///public static final RegistryObject<Block> GRIMWOOD_SIGN = BLOCKS.register("grimwood_sign", () -> sign(GRIMWOOD_PLANKS.get(), DreamWoodTypes.GRIMWOOD));
    ///public static final RegistryObject<Block> GRIMWOOD_WALL_SIGN = BLOCKS.register("grimwood_wall_sign", () -> wallSign(GRIMWOOD_SIGN.get(), DreamWoodTypes.GRIMWOOD));
    ///public static final RegistryObject<Block> GRIMWOOD_HANGING_SIGN = BLOCKS.register("grimwood_hanging_sign", () -> hangingSign(GRIMWOOD_PLANKS.get(), DreamWoodTypes.GRIMWOOD));
    ///public static final RegistryObject<Block> GRIMWOOD_WALL_HANGING_SIGN = BLOCKS.register("grimwood_wall_hanging_sign", () -> wallHangingSign(GRIMWOOD_HANGING_SIGN.get(), DreamWoodTypes.GRIMWOOD));
    ///
    ///public static final RegistryObject<Block> DEAD_LEAVES = BLOCKS.register("dead_leaves", DreamBlocks::leaves);
    ///public static final RegistryObject<Block> DEAD_SAPLING = BLOCKS.register("dead_sapling", () -> sapling(new DreamMegaTreeGrowers(DreamTreeFeatures.DEAD));
    ///public static final RegistryObject<Block> DEAD_LOG = BLOCKS.register("dead_log", () -> log(MapColor.TERRACOTTA_GRAY, MapColor.TERRACOTTA_BROWN));
    ///public static final RegistryObject<Block> STRIPPED_DEAD_LOG = BLOCKS.register("stripped_dead_log", () -> log(MapColor.TERRACOTTA_GRAY));
    ///public static final RegistryObject<Block> DEAD_WOOD = BLOCKS.register("dead_wood", () -> log(MapColor.TERRACOTTA_GRAY));
    ///public static final RegistryObject<Block> STRIPPED_DEAD_WOOD = BLOCKS.register("stripped_dead_wood", () -> log(MapColor.TERRACOTTA_GRAY));
    ///public static final RegistryObject<Block> DEAD_PLANKS = BLOCKS.register("dead_planks", () -> planks(MapColor.TERRACOTTA_GRAY));
    ///public static final RegistryObject<Block> DEAD_STAIRS = BLOCKS.register("dead_stairs", () -> stairs(DEAD_PLANKS.get()));
    ///public static final RegistryObject<Block> DEAD_SLAB = BLOCKS.register("dead_slab", () -> slab(DEAD_PLANKS.get()));
    ///public static final RegistryObject<Block> DEAD_FENCE = BLOCKS.register("dead_fence", () -> fence(DEAD_PLANKS.get()));
    ///public static final RegistryObject<Block> DEAD_FENCE_GATE = BLOCKS.register("dead_fence_gate", () -> fenceGate(DEAD_PLANKS.get(), DreamWoodTypes.DEAD));
    ///public static final RegistryObject<Block> DEAD_BUTTON = BLOCKS.register("dead_button", () -> button(DreamBlockSetTypes.DEAD));
    ///public static final RegistryObject<Block> DEAD_PRESSURE_PLATE = BLOCKS.register("dead_pressure_plate", () -> pressurePlate(DEAD_PLANKS.get(), DreamBlockSetTypes.DEAD));
    ///public static final RegistryObject<Block> DEAD_TRAPDOOR = BLOCKS.register("dead_trapdoor", () -> trapdoor(DEAD_PLANKS.get(), DreamBlockSetTypes.DEAD));
    ///public static final RegistryObject<Block> DEAD_DOOR = BLOCKS.register("dead_door", () -> door(DEAD_PLANKS.get(), DreamBlockSetTypes.DEAD));
    ///public static final RegistryObject<Block> DEAD_SIGN = BLOCKS.register("dead_sign", () -> sign(DEAD_PLANKS.get(), DreamWoodTypes.DEAD));
    ///public static final RegistryObject<Block> DEAD_WALL_SIGN = BLOCKS.register("dead_wall_sign", () -> wallSign(DEAD_SIGN.get(), DreamWoodTypes.DEAD));
    ///public static final RegistryObject<Block> DEAD_HANGING_SIGN = BLOCKS.register("dead_hanging_sign", () -> hangingSign(DEAD_PLANKS.get(), DreamWoodTypes.DEAD));
    ///public static final RegistryObject<Block> DEAD_WALL_HANGING_SIGN = BLOCKS.register("dead_wall_hanging_sign", () -> wallHangingSign(DEAD_HANGING_SIGN.get(), DreamWoodTypes.DEAD));
    ///
    ///public static final RegistryObject<Block> PINE_LEAVES = BLOCKS.register("pine_leaves", DreamBlocks::leaves);
    ///public static final RegistryObject<Block> PINE_SAPLING = BLOCKS.register("pine_sapling", () -> sapling(new DreamMegaTreeGrowers(DreamTreeFeatures.PINE));
    ///public static final RegistryObject<Block> PINE_LOG = BLOCKS.register("pine_log", () -> log(MapColor.COLOR_GREEN, MapColor.COLOR_BROWN));
    ///public static final RegistryObject<Block> STRIPPED_PINE_LOG = BLOCKS.register("stripped_pine_log", () -> log(MapColor.COLOR_GREEN));
    ///public static final RegistryObject<Block> PINE_WOOD = BLOCKS.register("pine_wood", () -> log(MapColor.COLOR_GREEN));
    ///public static final RegistryObject<Block> STRIPPED_PINE_WOOD = BLOCKS.register("stripped_pine_wood", () -> log(MapColor.COLOR_GREEN));
    ///public static final RegistryObject<Block> PINE_PLANKS = BLOCKS.register("pine_planks", () -> planks(MapColor.COLOR_GREEN));
    ///public static final RegistryObject<Block> PINE_STAIRS = BLOCKS.register("pine_stairs", () -> stairs(PINE_PLANKS.get()));
    ///public static final RegistryObject<Block> PINE_SLAB = BLOCKS.register("pine_slab", () -> slab(PINE_PLANKS.get()));
    ///public static final RegistryObject<Block> PINE_FENCE = BLOCKS.register("pine_fence", () -> fence(PINE_PLANKS.get()));
    ///public static final RegistryObject<Block> PINE_FENCE_GATE = BLOCKS.register("pine_fence_gate", () -> fenceGate(PINE_PLANKS.get(), DreamWoodTypes.PINE));
    ///public static final RegistryObject<Block> PINE_BUTTON = BLOCKS.register("pine_button", () -> button(DreamBlockSetTypes.PINE));
    ///public static final RegistryObject<Block> PINE_PRESSURE_PLATE = BLOCKS.register("pine_pressure_plate", () -> pressurePlate(PINE_PLANKS.get(), DreamBlockSetTypes.PINE));
    ///public static final RegistryObject<Block> PINE_TRAPDOOR = BLOCKS.register("pine_trapdoor", () -> trapdoor(PINE_PLANKS.get(), DreamBlockSetTypes.PINE));
    ///public static final RegistryObject<Block> PINE_DOOR = BLOCKS.register("pine_door", () -> door(PINE_PLANKS.get(), DreamBlockSetTypes.PINE));
    ///public static final RegistryObject<Block> PINE_SIGN = BLOCKS.register("pine_sign", () -> sign(PINE_PLANKS.get(), DreamWoodTypes.PINE));
    ///public static final RegistryObject<Block> PINE_WALL_SIGN = BLOCKS.register("pine_wall_sign", () -> wallSign(PINE_SIGN.get(), DreamWoodTypes.PINE));
    ///public static final RegistryObject<Block> PINE_HANGING_SIGN = BLOCKS.register("pine_hanging_sign", () -> hangingSign(PINE_PLANKS.get(), DreamWoodTypes.PINE));
    ///public static final RegistryObject<Block> PINE_WALL_HANGING_SIGN = BLOCKS.register("pine_wall_hanging_sign", () -> wallHangingSign(PINE_HANGING_SIGN.get(), DreamWoodTypes.PINE));
    ///
    ///public static final RegistryObject<Block> POISED_LEAVES = BLOCKS.register("poised_leaves", DreamBlocks::leaves);
    ///public static final RegistryObject<Block> POISED_SAPLING = BLOCKS.register("poised_sapling", () -> sapling(new DreamMegaTreeGrowers(DreamTreeFeatures.POISED));
    ///public static final RegistryObject<Block> POISED_LOG = BLOCKS.register("poised_log", () -> log(MapColor.TERRACOTTA_PURPLE, MapColor.COLOR_BROWN));
    ///public static final RegistryObject<Block> STRIPPED_POISED_LOG = BLOCKS.register("stripped_poised_log", () -> log(MapColor.TERRACOTTA_PURPLE));
    ///public static final RegistryObject<Block> POISED_WOOD = BLOCKS.register("poised_wood", () -> log(MapColor.TERRACOTTA_PURPLE));
    ///public static final RegistryObject<Block> STRIPPED_POISED_WOOD = BLOCKS.register("stripped_poised_wood", () -> log(MapColor.TERRACOTTA_PURPLE));
    ///public static final RegistryObject<Block> POISED_PLANKS = BLOCKS.register("poised_planks", () -> planks(MapColor.TERRACOTTA_PURPLE));
    ///public static final RegistryObject<Block> POISED_STAIRS = BLOCKS.register("poised_stairs", () -> stairs(POISED_PLANKS.get()));
    ///public static final RegistryObject<Block> POISED_SLAB = BLOCKS.register("poised_slab", () -> slab(POISED_PLANKS.get()));
    ///public static final RegistryObject<Block> POISED_FENCE = BLOCKS.register("poised_fence", () -> fence(POISED_PLANKS.get()));
    ///public static final RegistryObject<Block> POISED_FENCE_GATE = BLOCKS.register("poised_fence_gate", () -> fenceGate(POISED_PLANKS.get(), DreamWoodTypes.POISED));
    ///public static final RegistryObject<Block> POISED_BUTTON = BLOCKS.register("poised_button", () -> button(DreamBlockSetTypes.POISED));
    ///public static final RegistryObject<Block> POISED_PRESSURE_PLATE = BLOCKS.register("poised_pressure_plate", () -> pressurePlate(POISED_PLANKS.get(), DreamBlockSetTypes.POISED));
    ///public static final RegistryObject<Block> POISED_TRAPDOOR = BLOCKS.register("poised_trapdoor", () -> trapdoor(POISED_PLANKS.get(), DreamBlockSetTypes.POISED));
    ///public static final RegistryObject<Block> POISED_DOOR = BLOCKS.register("poised_door", () -> door(POISED_PLANKS.get(), DreamBlockSetTypes.POISED));
    ///public static final RegistryObject<Block> POISED_SIGN = BLOCKS.register("poised_sign", () -> sign(POISED_PLANKS.get(), DreamWoodTypes.POISED));
    ///public static final RegistryObject<Block> POISED_WALL_SIGN = BLOCKS.register("poised_wall_sign", () -> wallSign(POISED_SIGN.get(), DreamWoodTypes.POISED));
    ///public static final RegistryObject<Block> POISED_HANGING_SIGN = BLOCKS.register("poised_hanging_sign", () -> hangingSign(POISED_PLANKS.get(), DreamWoodTypes.POISED));
    ///public static final RegistryObject<Block> POISED_WALL_HANGING_SIGN = BLOCKS.register("poised_wall_hanging_sign", () -> wallHangingSign(POISED_HANGING_SIGN.get(), DreamWoodTypes.POISED));
    ///
    ///public static final RegistryObject<Block> BLOODWOOD_LEAVES = BLOCKS.register("bloodwood_leaves", DreamBlocks::leaves);
    ///public static final RegistryObject<Block> BLOODWOOD_SAPLING = BLOCKS.register("bloodwood_sapling", () -> sapling(new DreamMegaTreeGrowers(DreamTreeFeatures.BLOODWOOD));
    ///public static final RegistryObject<Block> BLOODWOOD_LOG = BLOCKS.register("bloodwood_log", () -> log(MapColor.TERRACOTTA_RED, MapColor.COLOR_BROWN));
    ///public static final RegistryObject<Block> STRIPPED_BLOODWOOD_LOG = BLOCKS.register("stripped_bloodwood_log", () -> log(MapColor.TERRACOTTA_RED));
    ///public static final RegistryObject<Block> BLOODWOOD_WOOD = BLOCKS.register("bloodwood_wood", () -> log(MapColor.TERRACOTTA_RED));
    ///public static final RegistryObject<Block> STRIPPED_BLOODWOOD_WOOD = BLOCKS.register("stripped_bloodwood_wood", () -> log(MapColor.TERRACOTTA_RED));
    ///public static final RegistryObject<Block> BLOODWOOD_PLANKS = BLOCKS.register("bloodwood_planks", () -> planks(MapColor.TERRACOTTA_RED));
    ///public static final RegistryObject<Block> BLOODWOOD_STAIRS = BLOCKS.register("bloodwood_stairs", () -> stairs(BLOODWOOD_PLANKS.get()));
    ///public static final RegistryObject<Block> BLOODWOOD_SLAB = BLOCKS.register("bloodwood_slab", () -> slab(BLOODWOOD_PLANKS.get()));
    ///public static final RegistryObject<Block> BLOODWOOD_FENCE = BLOCKS.register("bloodwood_fence", () -> fence(BLOODWOOD_PLANKS.get()));
    ///public static final RegistryObject<Block> BLOODWOOD_FENCE_GATE = BLOCKS.register("bloodwood_fence_gate", () -> fenceGate(BLOODWOOD_PLANKS.get(), DreamWoodTypes.BLOODWOOD));
    ///public static final RegistryObject<Block> BLOODWOOD_BUTTON = BLOCKS.register("bloodwood_button", () -> button(DreamBlockSetTypes.BLOODWOOD));
    ///public static final RegistryObject<Block> BLOODWOOD_PRESSURE_PLATE = BLOCKS.register("bloodwood_pressure_plate", () -> pressurePlate(BLOODWOOD_PLANKS.get(), DreamBlockSetTypes.BLOODWOOD));
    ///public static final RegistryObject<Block> BLOODWOOD_TRAPDOOR = BLOCKS.register("bloodwood_trapdoor", () -> trapdoor(BLOODWOOD_PLANKS.get(), DreamBlockSetTypes.BLOODWOOD));
    ///public static final RegistryObject<Block> BLOODWOOD_DOOR = BLOCKS.register("bloodwood_door", () -> door(BLOODWOOD_PLANKS.get(), DreamBlockSetTypes.BLOODWOOD));
    ///public static final RegistryObject<Block> BLOODWOOD_SIGN = BLOCKS.register("bloodwood_sign", () -> sign(BLOODWOOD_PLANKS.get(), DreamWoodTypes.BLOODWOOD));
    ///public static final RegistryObject<Block> BLOODWOOD_WALL_SIGN = BLOCKS.register("bloodwood_wall_sign", () -> wallSign(BLOODWOOD_SIGN.get(), DreamWoodTypes.BLOODWOOD));
    ///public static final RegistryObject<Block> BLOODWOOD_HANGING_SIGN = BLOCKS.register("bloodwood_hanging_sign", () -> hangingSign(BLOODWOOD_PLANKS.get(), DreamWoodTypes.BLOODWOOD));
    ///public static final RegistryObject<Block> BLOODWOOD_WALL_HANGING_SIGN = BLOCKS.register("bloodwood_wall_hanging_sign", () -> wallHangingSign(BLOODWOOD_HANGING_SIGN.get(), DreamWoodTypes.BLOODWOOD));
    ///
    ///public static final RegistryObject<Block> SOUR_LEAVES = BLOCKS.register("sour_leaves", DreamBlocks::leaves);
    ///public static final RegistryObject<Block> SOUR_SAPLING = BLOCKS.register("sour_sapling", () -> sapling(new DreamMegaTreeGrowers(DreamTreeFeatures.SOUR));
    ///public static final RegistryObject<Block> SOUR_LOG = BLOCKS.register("sour_log", () -> log(MapColor.TERRACOTTA_LIGHT_GREEN, MapColor.COLOR_BROWN));
    ///public static final RegistryObject<Block> STRIPPED_SOUR_LOG = BLOCKS.register("stripped_sour_log", () -> log(MapColor.TERRACOTTA_LIGHT_GREEN));
    ///public static final RegistryObject<Block> SOUR_WOOD = BLOCKS.register("sour_wood", () -> log(MapColor.TERRACOTTA_LIGHT_GREEN));
    ///public static final RegistryObject<Block> STRIPPED_SOUR_WOOD = BLOCKS.register("stripped_sour_wood", () -> log(MapColor.TERRACOTTA_LIGHT_GREEN));
    ///public static final RegistryObject<Block> SOUR_PLANKS = BLOCKS.register("sour_planks", () -> planks(MapColor.TERRACOTTA_LIGHT_GREEN));
    ///public static final RegistryObject<Block> SOUR_STAIRS = BLOCKS.register("sour_stairs", () -> stairs(SOUR_PLANKS.get()));
    ///public static final RegistryObject<Block> SOUR_SLAB = BLOCKS.register("sour_slab", () -> slab(SOUR_PLANKS.get()));
    ///public static final RegistryObject<Block> SOUR_FENCE = BLOCKS.register("sour_fence", () -> fence(SOUR_PLANKS.get()));
    ///public static final RegistryObject<Block> SOUR_FENCE_GATE = BLOCKS.register("sour_fence_gate", () -> fenceGate(SOUR_PLANKS.get(), DreamWoodTypes.SOUR));
    ///public static final RegistryObject<Block> SOUR_BUTTON = BLOCKS.register("sour_button", () -> button(DreamBlockSetTypes.SOUR));
    ///public static final RegistryObject<Block> SOUR_PRESSURE_PLATE = BLOCKS.register("sour_pressure_plate", () -> pressurePlate(SOUR_PLANKS.get(), DreamBlockSetTypes.SOUR));
    ///public static final RegistryObject<Block> SOUR_TRAPDOOR = BLOCKS.register("sour_trapdoor", () -> trapdoor(SOUR_PLANKS.get(), DreamBlockSetTypes.SOUR));
    ///public static final RegistryObject<Block> SOUR_DOOR = BLOCKS.register("sour_door", () -> door(SOUR_PLANKS.get(), DreamBlockSetTypes.SOUR));
    ///public static final RegistryObject<Block> SOUR_SIGN = BLOCKS.register("sour_sign", () -> sign(SOUR_PLANKS.get(), DreamWoodTypes.SOUR));
    ///public static final RegistryObject<Block> SOUR_WALL_SIGN = BLOCKS.register("sour_wall_sign", () -> wallSign(SOUR_SIGN.get(), DreamWoodTypes.SOUR));
    ///public static final RegistryObject<Block> SOUR_HANGING_SIGN = BLOCKS.register("sour_hanging_sign", () -> hangingSign(SOUR_PLANKS.get(), DreamWoodTypes.SOUR));
    ///public static final RegistryObject<Block> SOUR_WALL_HANGING_SIGN = BLOCKS.register("sour_wall_hanging_sign", () -> wallHangingSign(SOUR_HANGING_SIGN.get(), DreamWoodTypes.SOUR));
    ///
    ///public static final RegistryObject<Block> FUNGUS_BLOCK = BLOCKS.register("fungus_block", () -> mushroomBlock(MapColor.COLOR_LIGHT_GRAY));
    ///public static final RegistryObject<Block> FUNGUS = BLOCKS.register("fungus", () -> mushroom(new DreamMegaTreeGrowers(DreamTreeFeatures.FUNGUS, MapColor.COLOR_LIGHT_GRAY));
    ///public static final RegistryObject<Block> FUNGUS_STEM = BLOCKS.register("fungus_stem", () -> log(MapColor.COLOR_LIGHT_GRAY, MapColor.TERRACOTTA_WHITE));
    ///public static final RegistryObject<Block> STRIPPED_FUNGUS_STEM = BLOCKS.register("stripped_fungus_stem", () -> log(MapColor.COLOR_LIGHT_GRAY));
    ///public static final RegistryObject<Block> FUNGUS_HYPHAE = BLOCKS.register("fungus_hyphae", () -> log(MapColor.COLOR_LIGHT_GRAY));
    ///public static final RegistryObject<Block> STRIPPED_FUNGUS_HYPHAE = BLOCKS.register("stripped_fungus_hyphae", () -> log(MapColor.COLOR_LIGHT_GRAY));
    ///public static final RegistryObject<Block> FUNGUS_PLANKS = BLOCKS.register("fungus_planks", () -> planks(MapColor.COLOR_LIGHT_GRAY));
    ///public static final RegistryObject<Block> FUNGUS_STAIRS = BLOCKS.register("fungus_stairs", () -> stairs(FUNGUS_PLANKS.get()));
    ///public static final RegistryObject<Block> FUNGUS_SLAB = BLOCKS.register("fungus_slab", () -> slab(FUNGUS_PLANKS.get()));
    ///public static final RegistryObject<Block> FUNGUS_FENCE = BLOCKS.register("fungus_fence", () -> fence(FUNGUS_PLANKS.get()));
    ///public static final RegistryObject<Block> FUNGUS_FENCE_GATE = BLOCKS.register("fungus_fence_gate", () -> fenceGate(FUNGUS_PLANKS.get(), DreamWoodTypes.FUNGUS));
    ///public static final RegistryObject<Block> FUNGUS_BUTTON = BLOCKS.register("fungus_button", () -> button(DreamBlockSetTypes.FUNGUS));
    ///public static final RegistryObject<Block> FUNGUS_PRESSURE_PLATE = BLOCKS.register("fungus_pressure_plate", () -> pressurePlate(FUNGUS_PLANKS.get(), DreamBlockSetTypes.FUNGUS));
    ///public static final RegistryObject<Block> FUNGUS_TRAPDOOR = BLOCKS.register("fungus_trapdoor", () -> trapdoor(FUNGUS_PLANKS.get(), DreamBlockSetTypes.FUNGUS));
    ///public static final RegistryObject<Block> FUNGUS_DOOR = BLOCKS.register("fungus_door", () -> door(FUNGUS_PLANKS.get(), DreamBlockSetTypes.FUNGUS));
    ///public static final RegistryObject<Block> FUNGUS_SIGN = BLOCKS.register("fungus_sign", () -> sign(FUNGUS_PLANKS.get(), DreamWoodTypes.FUNGUS));
    ///public static final RegistryObject<Block> FUNGUS_WALL_SIGN = BLOCKS.register("fungus_wall_sign", () -> wallSign(FUNGUS_SIGN.get(), DreamWoodTypes.FUNGUS));
    ///public static final RegistryObject<Block> FUNGUS_HANGING_SIGN = BLOCKS.register("fungus_hanging_sign", () -> hangingSign(FUNGUS_PLANKS.get(), DreamWoodTypes.FUNGUS));
    ///public static final RegistryObject<Block> FUNGUS_WALL_HANGING_SIGN = BLOCKS.register("fungus_wall_hanging_sign", () -> wallHangingSign(FUNGUS_HANGING_SIGN.get(), DreamWoodTypes.FUNGUS));

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ///public static final RegistryObject<Block> POTTED_FOREST_SHRUB = BLOCKS.register("potted_forest_shrub", () -> potted(FOREST_SHRUB.get()));
    public static final RegistryObject<Block> POTTED_FOREST_MUSHROOM = BLOCKS.register("potted_forest_mushroom", () -> potted(FOREST_MUSHROOM.get()));
    public static final RegistryObject<Block> POTTED_DREAMY_SAPLING = BLOCKS.register("potted_dreamy_sapling", () -> potted(DREAMY_SAPLING.get()));
    public static final RegistryObject<Block> POTTED_DREAMY_MUSHROOM = BLOCKS.register("potted_dreamy_mushroom", () -> potted(DREAMY_MUSHROOM.get()));
    public static final RegistryObject<Block> POTTED_ASPEN_SAPLING = BLOCKS.register("potted_aspen_sapling", () -> potted(ASPEN_SAPLING.get()));
    public static final RegistryObject<Block> POTTED_EVERGREEN_SAPLING = BLOCKS.register("potted_evergreen_sapling", () -> potted(EVERGREEN_SAPLING.get()));
    public static final RegistryObject<Block> POTTED_TOADSTOOL = BLOCKS.register("potted_toadstool", () -> potted(TOADSTOOL.get()));
    public static final RegistryObject<Block> POTTED_ETHEREAL_SAPLING = BLOCKS.register("potted_ethereal_sapling", () -> potted(ETHEREAL_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_LILAC_BUSH = BLOCKS.register("potted_lilac_bush", () -> potted(LILAC_BUSH.get()));
    public static final RegistryObject<Block> POTTED_PINK_COTTON_CANDY_SAPLING = BLOCKS.register("potted_pink_cotton_candy_sapling", () -> potted(PINK_COTTON_CANDY_SAPLING.get()));
    public static final RegistryObject<Block> POTTED_BLUE_COTTON_CANDY_SAPLING = BLOCKS.register("potted_blue_cotton_candy_sapling", () -> potted(BLUE_COTTON_CANDY_SAPLING.get()));
    public static final RegistryObject<Block> POTTED_WISTERIA_SAPLING = BLOCKS.register("potted_wisteria_sapling", () -> potted(WISTERIA_SAPLING.get()));
    public static final RegistryObject<Block> POTTED_MYSTICAL_SAPLING = BLOCKS.register("potted_mystical_sapling", () -> potted(MYSTICAL_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_FAIRY_ROSE_BUSH = BLOCKS.register("potted_fairy_rose_bush", () -> potted(FAIRY_ROSE_BUSH.get()));
    public static final RegistryObject<Block> POTTED_PINK_MUSHROOM = BLOCKS.register("potted_pink_mushroom", () -> potted(PINK_MUSHROOM.get()));
    ///public static final RegistryObject<Block> POTTED_GLOOMY_SAPLING = BLOCKS.register("potted_gloomy_sapling", () -> potted(GLOOMY_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_GLOOMY_MUSHROOM = BLOCKS.register("potted_gloomy_mushroom", () -> potted(GLOOMY_MUSHROOM.get()));
    ///public static final RegistryObject<Block> POTTED_GRIMWOOD_SAPLING = BLOCKS.register("potted_grimwood_sapling", () -> potted(GRIMWOOD_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_DEAD_SAPLING = BLOCKS.register("potted_dead_sapling", () -> potted(DEAD_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_PINE_SAPLING = BLOCKS.register("potted_pine_sapling", () -> potted(PINE_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_POISED_SAPLING = BLOCKS.register("potted_poised_sapling", () -> potted(POISED_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_BLOODWOOD_SAPLING = BLOCKS.register("potted_bloodwood_sapling", () -> potted(BLOODWOOD_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_SOUR_SAPLING = BLOCKS.register("potted_sour_sapling", () -> potted(SOUR_SAPLING.get()));
    ///public static final RegistryObject<Block> POTTED_FUNGUS = BLOCKS.register("potted_fungus", () -> potted(FUNGUS.get()));

    private static Block fromBlock(Block block) {
        return new Block(copy(block));
    }

    private static Block stone(MapColor mapColor) {
        return new Block(BlockBehaviour.Properties.of().mapColor(mapColor).strength(1.5F, 6.0F).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
    }

    private static Block log(MapColor mapColor) {
        return log(mapColor, mapColor);
    }

    private static Block log(MapColor yColor, MapColor xzColor) {
        return new RotatedPillarBlock(logProperties(yColor, xzColor));
    }

    private static Block planks(MapColor mapColor) {
        return new Block(BlockBehaviour.Properties.of().mapColor(mapColor).sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava().instrument(NoteBlockInstrument.BASS));
    }

    private static Block stairs(Block baseBlock) {
        return new StairBlock(baseBlock.defaultBlockState(), copy(baseBlock));
    }

    private static Block stoneStairs(Block baseBlock) {
        return new StairBlock(baseBlock.defaultBlockState(), copy(baseBlock).strength(2.0F, 6.0F));
    }

    private static Block slab(Block baseBlock) {
        return new SlabBlock(copy(baseBlock));
    }

    private static Block fence(Block baseBlock) {
        return new FenceBlock(copy(baseBlock).forceSolidOn());
    }

    private static Block fenceGate(Block baseBlock, WoodType woodType) {
        return new FenceGateBlock(copy(baseBlock).forceSolidOn(), woodType);
    }

    private static Block button(BlockSetType setType) {
        return new ButtonBlock(buttonProperties(), setType, 30, true);
    }

    private static Block stoneButton(BlockSetType setType) {
        return new ButtonBlock(buttonProperties(), setType, 20, true);
    }

    private static Block pressurePlate(Block baseBlock, BlockSetType setType) {
        return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, pressurePlateProperties(baseBlock.defaultMapColor()).instrument(NoteBlockInstrument.BASS), setType);
    }

    private static Block stonePressurePlate(Block baseBlock, BlockSetType setType) {
        return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, pressurePlateProperties(baseBlock.defaultMapColor()).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM), setType);
    }

    private static Block trapdoor(Block baseBlock, BlockSetType setType) {
        return new TrapDoorBlock(doorProperties(baseBlock.defaultMapColor()).isValidSpawn(DreamBlocks::never), setType);
    }

    private static Block door(Block baseBlock, BlockSetType setType) {
        return new DoorBlock(doorProperties(baseBlock.defaultMapColor()).pushReaction(PushReaction.DESTROY), setType);
    }

    private static Block sign(Block block, WoodType woodType) {
        return new DreamStandingSignBlock(woodType, signProperties(block.defaultMapColor()));
    }

    private static Block wallSign(Block signBlock, WoodType woodType) {
        return new DreamWallSignBlock(woodType, copy(signBlock).lootFrom(() -> signBlock));
    }

    private static Block hangingSign(Block block, WoodType woodType) {
        return new DreamCeilingHangingSignBlock(woodType, signProperties(block.defaultMapColor()));
    }

    private static Block wallHangingSign(Block hangingSignBlock, WoodType woodType) {
        return new DreamWallHangingSignBlock(woodType, copy(hangingSignBlock).lootFrom(() -> hangingSignBlock));
    }

    private static Block wall(Block block) {
        return new WallBlock(copy(block).forceSolidOn());
    }

    private static Block leaves() {
        return new DreamLeavesBlock(leafProperties());
    }

    private static Block sapling(AbstractTreeGrower grower) {
        return new SaplingBlock(grower, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).randomTicks().noCollission().instabreak().pushReaction(PushReaction.DESTROY));
    }

    private static Block shrub(AbstractTreeGrower grower) {
        return new ShrubBlock(grower, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.AZALEA).noOcclusion().instabreak().forceSolidOff().pushReaction(PushReaction.DESTROY));
    }

    private static Block plant() {
        return new DreamPlantBlock(grassProperties());
    }

    private static Block doublePlant() {
        return new DreamTallPlantBlock(grassProperties());
    }

    private static Block flower() {
        return new DreamFlowerBlock(DreamEffects.DREAMING, 5, flowerProperties());
    }

    private static Block tallFlower() {
        return new DreamTallFlowerBlock(flowerProperties());
    }

    private static Block mushroom(ResourceKey<ConfiguredFeature<?, ?>> feature, MapColor mapColor) {
        return new MushroomBlock(feature, BlockBehaviour.Properties.of().mapColor(mapColor).sound(SoundType.GRASS).randomTicks().instabreak().noCollission().hasPostProcess(DreamBlocks::always).pushReaction(PushReaction.DESTROY));
    }

    private static Block mushroomBlock(MapColor mapColor) {
        return new HugeMushroomBlock(BlockBehaviour.Properties.of().mapColor(mapColor).sound(SoundType.WOOD).strength(0.2F).ignitedByLava().instrument(NoteBlockInstrument.BASS));
    }

    private static Block potted(Block block) {
        return new FlowerPotBlock(null, () -> block, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
    }

    private static BlockBehaviour.Properties copy(Block block) {
        return BlockBehaviour.Properties.copy(block);
    }

    private static BlockBehaviour.Properties waterProperties() {
        return BlockBehaviour.Properties.of().mapColor(MapColor.WATER).sound(SoundType.EMPTY).strength(100.0F).replaceable().noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties leafProperties() {
        return BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).strength(0.2F).ignitedByLava().randomTicks().noOcclusion().isValidSpawn(DreamBlocks::ocelotOrParrot).isViewBlocking(DreamBlocks::never).isSuffocating(DreamBlocks::never).isRedstoneConductor(DreamBlocks::never).pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties logProperties(MapColor yColor, MapColor xzColor) {
        return BlockBehaviour.Properties.of().mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? yColor : xzColor).sound(SoundType.WOOD).strength(2.0F).ignitedByLava().instrument(NoteBlockInstrument.BASS);
    }

    private static BlockBehaviour.Properties buttonProperties() {
        return BlockBehaviour.Properties.of().strength(0.5F).noCollission().pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties pressurePlateProperties(MapColor mapColor) {
        return BlockBehaviour.Properties.of().mapColor(mapColor).strength(0.5F).noCollission().forceSolidOn().pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties doorProperties(MapColor mapColor) {
        return BlockBehaviour.Properties.of().mapColor(mapColor).strength(3.0F).noOcclusion().ignitedByLava().instrument(NoteBlockInstrument.BASS);
    }

    private static BlockBehaviour.Properties signProperties(MapColor mapColor) {
        return BlockBehaviour.Properties.of().mapColor(mapColor).strength(1.0F).noCollission().forceSolidOn().ignitedByLava().instrument(NoteBlockInstrument.BASS);
    }

    private static BlockBehaviour.Properties grassProperties() {
        return BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).sound(SoundType.GRASS).instabreak().ignitedByLava().replaceable().noCollission().offsetType(BlockBehaviour.OffsetType.XYZ).pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties flowerProperties() {
        return flowerProperties(true);
    }

    private static BlockBehaviour.Properties flowerProperties(boolean hasOffset) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).instabreak().noCollission().pushReaction(PushReaction.DESTROY);
        if (hasOffset) {
            properties.offsetType(BlockBehaviour.OffsetType.XZ);
        }

        return properties;
    }

    private static Boolean ocelotOrParrot(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entityType) {
        return entityType == EntityType.OCELOT || entityType == EntityType.PARROT;
    }

    private static Boolean never(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entityType) {
        return false;
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return false;
    }

    private static boolean always(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return true;
    }

}