package com.mystanica.dreamlands.common.worldgen.feature;

import com.mystanica.dreamlands.common.block.CloverBlock;
import com.mystanica.dreamlands.common.block.DirectionalBlock;
import com.mystanica.dreamlands.common.block.HyacinthFlowerBlock;
import com.mystanica.dreamlands.common.block.StackableBlock;
import com.mystanica.dreamlands.common.worldgen.feature.config.*;
import com.mystanica.dreamlands.common.worldgen.placement.DreamTreePlacements;
import com.mystanica.dreamlands.init.DreamBlocks;
import com.mystanica.dreamlands.init.DreamFeatures;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

import static com.mystanica.dreamlands.init.DreamFeatures.Configured.createKey;

public class DreamVegetationFeatures {

    /// shared
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DREAMY_GRASS = createKey("patch_dreamy_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_DREAMY_GRASS = createKey("patch_tall_dreamy_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUSHROOMS_DREAMY = createKey("mushrooms_dreamy");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DREAMY_MUSHROOM = createKey("patch_dreamy_mushroom");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MUSHROOMS_FOREST = createKey("mushrooms_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_FOREST_MUSHROOM = createKey("patch_forest_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_FOREST_MOSS = createKey("patch_forest_moss");

    /// dreamland
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GROUND_IVY = createKey("patch_ground_ivy");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_CLOVERS = createKey("patch_clovers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WHITE_CLOVERS = createKey("patch_white_clovers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_PINK_CLOVERS = createKey("patch_pink_clovers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_PETUNIA = createKey("flower_petunia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_PERIWINKLE = createKey("flower_periwinkle");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_PINK_FOXGLOVE = createKey("flower_pink_foxglove");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_PINK_HYACINTH = createKey("flower_pink_hyacinth");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_MAGENTA_HYACINTH = createKey("flower_magenta_hyacinth");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_PURPLE_HYACINTH = createKey("flower_purple_hyacinth");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_PURPLE_LUPINE = createKey("flower_purple_lupine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_VIOLETS = createKey("flower_violets");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_WILDERNESS = createKey("trees_wilderness");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHRUBS_WILDERNESS = createKey("shrubs_wilderness");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_ASPEN_FOREST = createKey("trees_aspen_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHRUBS_ASPEN_FOREST = createKey("shrubs_aspen_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_EVERGREEN_FOREST = createKey("trees_evergreen_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHRUBS_EVERGREEN_FOREST = createKey("shrubs_evergreen_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUSHROOMS_TOADSTOOL = createKey("mushrooms_toadstool");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TOADSTOOL = createKey("patch_toadstool");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_ETHEREAL_FOREST = createKey("trees_ethereal_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHRUBS_ETHEREAL_FOREST = createKey("shrubs_ethereal_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_COTTON_CANDY_FOREST = createKey("trees_cotton_candy_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_WISTERIA_GROVE = createKey("trees_wisteria_grove");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_FAERIE_FOREST = createKey("trees_faerie_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHRUBS_FAERIE_FOREST = createKey("shrubs_faerie_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUSHROOMS_PINK = createKey("mushrooms_pink");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_PINK_MUSHROOM = createKey("patch_pink_mushroom");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> getter = context.lookup(Registries.PLACED_FEATURE);
        Holder<PlacedFeature> FOREST_SHRUB_CHECKED = getter.getOrThrow(DreamTreePlacements.FOREST_SHRUB_CHECKED);
        Holder<PlacedFeature> FOREST_MUSHROOM_CHECKED = getter.getOrThrow(DreamTreePlacements.FOREST_MUSHROOM_CHECKED);
        Holder<PlacedFeature> LARGE_FOREST_MUSHROOM_CHECKED = getter.getOrThrow(DreamTreePlacements.LARGE_FOREST_MUSHROOM_CHECKED);
        Holder<PlacedFeature> DREAMY_TREE_CHECKED = getter.getOrThrow(DreamTreePlacements.DREAMY_TREE_CHECKED);
        Holder<PlacedFeature> DREAMY_SHRUB_CHECKED = getter.getOrThrow(DreamTreePlacements.DREAMY_SHRUB_CHECKED);
        Holder<PlacedFeature> LARGE_DREAMY_SHRUB_CHECKED = getter.getOrThrow(DreamTreePlacements.LARGE_DREAMY_SHRUB_CHECKED);
        Holder<PlacedFeature> DREAMY_MUSHROOM_CHECKED = getter.getOrThrow(DreamTreePlacements.DREAMY_MUSHROOM_CHECKED);
        Holder<PlacedFeature> LARGE_DREAMY_MUSHROOM_CHECKED = getter.getOrThrow(DreamTreePlacements.LARGE_DREAMY_MUSHROOM_CHECKED);
        Holder<PlacedFeature> ASPEN_TREE_CHECKED = getter.getOrThrow(DreamTreePlacements.ASPEN_TREE_CHECKED);
        Holder<PlacedFeature> TALL_ASPEN_TREE_CHECKED = getter.getOrThrow(DreamTreePlacements.TALL_ASPEN_TREE_CHECKED);
        Holder<PlacedFeature> EVERGREEN_TREE_CHECKED = getter.getOrThrow(DreamTreePlacements.EVERGREEN_TREE_CHECKED);
        Holder<PlacedFeature> LARGE_EVERGREEN_TREE_CHECKED = getter.getOrThrow(DreamTreePlacements.LARGE_EVERGREEN_TREE_CHECKED);
        Holder<PlacedFeature> TOADSTOOL_CHECKED = getter.getOrThrow(DreamTreePlacements.TOADSTOOL_CHECKED);
        Holder<PlacedFeature> LARGE_TOADSTOOL_CHECKED = getter.getOrThrow(DreamTreePlacements.LARGE_TOADSTOOL_CHECKED);
        Holder<PlacedFeature> ETHEREAL_TREE_CHECKED = getter.getOrThrow(DreamTreePlacements.ETHEREAL_TREE_CHECKED);
        Holder<PlacedFeature> LILAC_BUSH_CHECKED = getter.getOrThrow(DreamTreePlacements.LILAC_BUSH_CHECKED);
        Holder<PlacedFeature> PINK_COTTON_CANDY_TREE_CHECKED = getter.getOrThrow(DreamTreePlacements.PINK_COTTON_CANDY_TREE_CHECKED);
        Holder<PlacedFeature> BLUE_COTTON_CANDY_TREE_CHECKED = getter.getOrThrow(DreamTreePlacements.BLUE_COTTON_CANDY_TREE_CHECKED);
        Holder<PlacedFeature> WISTERIA_TREE_CHECKED = getter.getOrThrow(DreamTreePlacements.WISTERIA_TREE_CHECKED);
        Holder<PlacedFeature> MYSTICAL_TREE_CHECKED = getter.getOrThrow(DreamTreePlacements.MYSTICAL_TREE_CHECKED);
        Holder<PlacedFeature> FAIRY_ROSE_BUSH_CHECKED = getter.getOrThrow(DreamTreePlacements.FAIRY_ROSE_BUSH_CHECKED);
        Holder<PlacedFeature> PINK_MUSHROOM_CHECKED = getter.getOrThrow(DreamTreePlacements.PINK_MUSHROOM_CHECKED);
        Holder<PlacedFeature> LARGE_PINK_MUSHROOM_CHECKED = getter.getOrThrow(DreamTreePlacements.LARGE_PINK_MUSHROOM_CHECKED);

        FeatureUtils.register(context, MUSHROOMS_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(FOREST_MUSHROOM_CHECKED, 0.4F),
                new WeightedPlacedFeature(LARGE_FOREST_MUSHROOM_CHECKED, 0.4F)), FOREST_MUSHROOM_CHECKED)
        );
        FeatureUtils.register(context, PATCH_FOREST_MUSHROOM, Feature.RANDOM_PATCH, plantPatch(48, 4, DreamBlocks.FOREST_MUSHROOM.get()));
        FeatureUtils.register(context, PATCH_FOREST_MOSS, DreamFeatures.MOSS_PATCH.get(), new MossPatchConfiguration(BlockStateProvider.simple(DreamBlocks.FOREST_MOSS_BLOCK.get()), BlockStateProvider.simple(DreamBlocks.FOREST_MOSS_CARPET.get()), 8, 300));
        FeatureUtils.register(context, PATCH_DREAMY_GRASS, Feature.RANDOM_PATCH, grassPatch(DreamBlocks.DREAMY_GRASS.get()));
        FeatureUtils.register(context, PATCH_TALL_DREAMY_GRASS, Feature.RANDOM_PATCH, grassPatch(DreamBlocks.TALL_DREAMY_GRASS.get()));
        FeatureUtils.register(context, MUSHROOMS_DREAMY, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(DREAMY_MUSHROOM_CHECKED, 0.2F),
                new WeightedPlacedFeature(LARGE_DREAMY_MUSHROOM_CHECKED, 0.6F)), DREAMY_MUSHROOM_CHECKED)
        );
        FeatureUtils.register(context, PATCH_DREAMY_MUSHROOM, Feature.RANDOM_PATCH, plantPatch(48, 4, DreamBlocks.DREAMY_MUSHROOM.get()));

        FeatureUtils.register(context, PATCH_GROUND_IVY, Feature.RANDOM_PATCH, cloverPatch(DreamBlocks.GROUND_IVY.get()));
        FeatureUtils.register(context, PATCH_CLOVERS, Feature.RANDOM_PATCH, cloverPatch(DreamBlocks.CLOVERS.get()));
        FeatureUtils.register(context, PATCH_WHITE_CLOVERS, Feature.RANDOM_PATCH, cloverPatch(DreamBlocks.WHITE_CLOVERS.get()));
        FeatureUtils.register(context, PATCH_PINK_CLOVERS, Feature.RANDOM_PATCH, cloverPatch(DreamBlocks.PINK_CLOVERS.get()));
        FeatureUtils.register(context, FLOWER_PETUNIA, Feature.RANDOM_PATCH, plantPatch(82, 7, DreamBlocks.PETUNIA.get()));
        FeatureUtils.register(context, FLOWER_PERIWINKLE, Feature.RANDOM_PATCH, plantPatch(82, 7, DreamBlocks.PERIWINKLE.get()));
        FeatureUtils.register(context, FLOWER_PINK_FOXGLOVE, Feature.RANDOM_PATCH, plantPatch(96, 7, DreamBlocks.PINK_FOXGLOVE.get()));
        FeatureUtils.register(context, FLOWER_PINK_HYACINTH, Feature.RANDOM_PATCH, hyacinthPatch(DreamBlocks.PINK_HYACINTH.get()));
        FeatureUtils.register(context, FLOWER_MAGENTA_HYACINTH, Feature.RANDOM_PATCH, hyacinthPatch(DreamBlocks.MAGENTA_HYACINTH.get()));
        FeatureUtils.register(context, FLOWER_PURPLE_HYACINTH, Feature.RANDOM_PATCH, hyacinthPatch(DreamBlocks.PURPLE_HYACINTH.get()));
        FeatureUtils.register(context, FLOWER_PURPLE_LUPINE, Feature.RANDOM_PATCH, stackableFlowerPatch(DreamBlocks.PURPLE_LUPINE.get()));
        FeatureUtils.register(context, FLOWER_VIOLETS, Feature.RANDOM_PATCH, plantPatch(96, 7, DreamBlocks.VIOLETS.get()));

        FeatureUtils.register(context, TREES_WILDERNESS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(DREAMY_TREE_CHECKED, 0.5F)), DREAMY_TREE_CHECKED)
        );
        FeatureUtils.register(context, SHRUBS_WILDERNESS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(DREAMY_SHRUB_CHECKED, 0.5F),
                new WeightedPlacedFeature(LARGE_DREAMY_SHRUB_CHECKED, 0.6F)), DREAMY_SHRUB_CHECKED)
        );

        FeatureUtils.register(context, TREES_ASPEN_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(ASPEN_TREE_CHECKED, 0.5F),
                new WeightedPlacedFeature(TALL_ASPEN_TREE_CHECKED, 0.3F)), ASPEN_TREE_CHECKED)
        );
        FeatureUtils.register(context, SHRUBS_ASPEN_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(DREAMY_SHRUB_CHECKED, 1.0F)), DREAMY_SHRUB_CHECKED)
        );

        FeatureUtils.register(context, TREES_EVERGREEN_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(EVERGREEN_TREE_CHECKED, 0.5F),
                new WeightedPlacedFeature(LARGE_EVERGREEN_TREE_CHECKED, 0.4F)), EVERGREEN_TREE_CHECKED)
        );
        FeatureUtils.register(context, SHRUBS_EVERGREEN_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(FOREST_SHRUB_CHECKED, 0.4F),
                new WeightedPlacedFeature(DREAMY_SHRUB_CHECKED, 0.5F),
                new WeightedPlacedFeature(LARGE_DREAMY_SHRUB_CHECKED, 0.3F)), FOREST_SHRUB_CHECKED)
        );
        FeatureUtils.register(context, MUSHROOMS_TOADSTOOL, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(TOADSTOOL_CHECKED, 0.4F),
                new WeightedPlacedFeature(LARGE_TOADSTOOL_CHECKED, 0.4F)), TOADSTOOL_CHECKED)
        );
        FeatureUtils.register(context, PATCH_TOADSTOOL, Feature.RANDOM_PATCH, plantPatch(48, 4, DreamBlocks.TOADSTOOL.get()));
        FeatureUtils.register(context, TREES_ETHEREAL_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(ETHEREAL_TREE_CHECKED, 0.4F)), ETHEREAL_TREE_CHECKED)
        );
        FeatureUtils.register(context, SHRUBS_ETHEREAL_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(LILAC_BUSH_CHECKED, 0.3F),
                new WeightedPlacedFeature(FOREST_SHRUB_CHECKED, 0.5F),
                new WeightedPlacedFeature(DREAMY_SHRUB_CHECKED, 0.2F),
                new WeightedPlacedFeature(LARGE_DREAMY_SHRUB_CHECKED, 0.8F)), DREAMY_SHRUB_CHECKED)
        );
        FeatureUtils.register(context, TREES_COTTON_CANDY_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PINK_COTTON_CANDY_TREE_CHECKED, 0.4F),
                new WeightedPlacedFeature(BLUE_COTTON_CANDY_TREE_CHECKED, 0.7F)), PINK_COTTON_CANDY_TREE_CHECKED)
        );
        FeatureUtils.register(context, TREES_WISTERIA_GROVE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(WISTERIA_TREE_CHECKED, 0.4F)), WISTERIA_TREE_CHECKED)
        );
        FeatureUtils.register(context, TREES_FAERIE_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(MYSTICAL_TREE_CHECKED, 0.5F)), MYSTICAL_TREE_CHECKED)
        );
        FeatureUtils.register(context, SHRUBS_FAERIE_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(FAIRY_ROSE_BUSH_CHECKED, 0.3F),
                new WeightedPlacedFeature(FOREST_SHRUB_CHECKED, 0.5F),
                new WeightedPlacedFeature(DREAMY_SHRUB_CHECKED, 0.2F),
                new WeightedPlacedFeature(LARGE_DREAMY_SHRUB_CHECKED, 0.8F)), DREAMY_SHRUB_CHECKED)
        );
        FeatureUtils.register(context, MUSHROOMS_PINK, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PINK_MUSHROOM_CHECKED, 0.3F),
                new WeightedPlacedFeature(LARGE_PINK_MUSHROOM_CHECKED, 0.7F)), PINK_MUSHROOM_CHECKED)
        );
        FeatureUtils.register(context, PATCH_PINK_MUSHROOM, Feature.RANDOM_PATCH, plantPatch(48, 4, DreamBlocks.PINK_MUSHROOM.get()));
    }

    private static RandomPatchConfiguration cloverPatch(Block block) {
        SimpleWeightedRandomList.Builder<BlockState> builder = SimpleWeightedRandomList.builder();
        for (int i = 1; i <= 4; i++) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                builder.add(block.defaultBlockState()
                                .setValue(CloverBlock.AMOUNT, i)
                                .setValue(CloverBlock.FACING, direction),
                        1);
            }
        }

        return plantPatch(144, 5, new WeightedStateProvider(builder));
    }

    private static RandomPatchConfiguration hyacinthPatch(Block block) {
        SimpleWeightedRandomList.Builder<BlockState> builder = SimpleWeightedRandomList.builder();
        for (int i = 1; i <= 3; i++) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                builder.add(block.defaultBlockState()
                                .setValue(HyacinthFlowerBlock.AMOUNT, i)
                                .setValue(HyacinthFlowerBlock.FACING, direction),
                        1);
            }
        }

        return plantPatch(128, 4, new WeightedStateProvider(builder));
    }

    private static RandomPatchConfiguration stackableFlowerPatch(Block block) {
        SimpleWeightedRandomList.Builder<BlockState> builder = SimpleWeightedRandomList.builder();
        for (int i = 1; i <= 3; i++) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                builder.add(block.defaultBlockState()
                                .setValue(StackableBlock.AMOUNT, i)
                                .setValue(DirectionalBlock.FACING, direction),
                        1);
            }
        }

        return plantPatch(144, 7, new WeightedStateProvider(builder));
    }

    private static RandomPatchConfiguration plantPatch(Block block) {
        return plantPatch(64, 7, BlockStateProvider.simple(block));
    }

    private static RandomPatchConfiguration plantPatch(int tries, int xzSpread, Block block) {
        return plantPatch(tries, xzSpread, BlockStateProvider.simple(block));
    }

    private static RandomPatchConfiguration plantPatch(int tries, int xzSpread, BlockStateProvider provider) {
        return randomPatch(
                tries,
                xzSpread,
                3,
                provider,
                BlockPredicate.allOf(
                        BlockPredicate.anyOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.replaceable()),
                        BlockPredicate.matchesBlocks(Direction.UP.getNormal(), Blocks.AIR),
                        BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), grasses()),
                        BlockPredicate.noFluid(),
                        BlockPredicate.not(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), DreamBlocks.FOREST_MOSS_BLOCK.get()))
                )
        );
    }

    private static RandomPatchConfiguration grassPatch(Block block) {
        return randomPatch(
                300,
                7,
                3,
                BlockStateProvider.simple(block),
                BlockPredicate.allOf(
                        BlockPredicate.ONLY_IN_AIR_PREDICATE,
                        BlockPredicate.matchesBlocks(Direction.UP.getNormal(), Blocks.AIR),
                        BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), grasses()),
                        BlockPredicate.noFluid(),
                        BlockPredicate.not(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), DreamBlocks.FOREST_MOSS_BLOCK.get()))
                )
        );
    }

    private static RandomPatchConfiguration randomPatch(int tries, int xzSpread, int ySpread, BlockStateProvider provider, BlockPredicate predicate) {
        return new RandomPatchConfiguration(
                tries,
                xzSpread,
                ySpread,
                PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(provider), predicate)
        );
    }

    private static List<Block> grasses() {
        return List.of(Blocks.GRASS_BLOCK, DreamBlocks.DREAMY_GRASS_BLOCK.get());
    }

}