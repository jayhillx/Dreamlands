package com.mystanica.dreamlands.common.worldgen.placement;

import com.google.common.collect.ImmutableList;
import com.mystanica.dreamlands.common.worldgen.feature.DreamVegetationFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static com.mystanica.dreamlands.init.DreamFeatures.Placed.createKey;

public class DreamVegetationPlacements {

    /// shared
    public static final ResourceKey<PlacedFeature> MUSHROOMS_FOREST = createKey("mushrooms_forest");
    public static final ResourceKey<PlacedFeature> PATCH_FOREST_MUSHROOM = createKey("patch_forest_mushroom");
    public static final ResourceKey<PlacedFeature> PATCH_FOREST_MOSS = createKey("patch_forest_moss");

    public static final ResourceKey<PlacedFeature> PATCH_DREAMY_GRASS = createKey("patch_dreamy_grass");
    public static final ResourceKey<PlacedFeature> PATCH_TALL_DREAMY_GRASS = createKey("patch_tall_dreamy_grass");
    public static final ResourceKey<PlacedFeature> MUSHROOMS_DREAMY = createKey("mushrooms_dreamy");
    public static final ResourceKey<PlacedFeature> PATCH_DREAMY_MUSHROOM = createKey("patch_dreamy_mushroom");

    /// dreamland
    public static final ResourceKey<PlacedFeature> TREES_WILDERNESS = createKey("trees_wilderness");
    public static final ResourceKey<PlacedFeature> SHRUBS_WILDERNESS = createKey("shrubs_wilderness");
    ///public static final ResourceKey<PlacedFeature> FLOWERS_WILDERNESS = createKey("flowers_wilderness");

    public static final ResourceKey<PlacedFeature> PATCH_GROUND_IVY = createKey("patch_ground_ivy");
    public static final ResourceKey<PlacedFeature> PATCH_CLOVERS = createKey("patch_clovers");
    public static final ResourceKey<PlacedFeature> PATCH_WHITE_CLOVERS = createKey("patch_white_clovers");
    public static final ResourceKey<PlacedFeature> PATCH_PINK_CLOVERS = createKey("patch_pink_clovers");
    public static final ResourceKey<PlacedFeature> FLOWER_PETUNIA = createKey("flower_petunia");
    public static final ResourceKey<PlacedFeature> FLOWER_PERIWINKLE = createKey("flower_periwinkle");
    public static final ResourceKey<PlacedFeature> FLOWER_PINK_FOXGLOVE = createKey("flower_pink_foxglove");
    public static final ResourceKey<PlacedFeature> FLOWER_PINK_HYACINTH = createKey("flower_pink_hyacinth");
    public static final ResourceKey<PlacedFeature> FLOWER_MAGENTA_HYACINTH = createKey("flower_magenta_hyacinth");
    public static final ResourceKey<PlacedFeature> FLOWER_PURPLE_HYACINTH = createKey("flower_purple_hyacinth");
    public static final ResourceKey<PlacedFeature> FLOWER_VIOLETS = createKey("flower_violets");

    public static final ResourceKey<PlacedFeature> TREES_EVERGREEN_FOREST = createKey("trees_evergreen_forest");
    public static final ResourceKey<PlacedFeature> SHRUBS_EVERGREEN_FOREST = createKey("shrubs_evergreen_forest");
    public static final ResourceKey<PlacedFeature> MUSHROOMS_TOADSTOOL = createKey("mushrooms_toadstool");
    public static final ResourceKey<PlacedFeature> PATCH_TOADSTOOL = createKey("patch_toadstool");

    public static final ResourceKey<PlacedFeature> TREES_ETHEREAL_FOREST = createKey("trees_ethereal_forest");
    public static final ResourceKey<PlacedFeature> SHRUBS_ETHEREAL_FOREST = createKey("shrubs_ethereal_forest");

    public static final ResourceKey<PlacedFeature> TREES_COTTON_CANDY_FOREST = createKey("trees_cotton_candy_forest");

    public static final ResourceKey<PlacedFeature> TREES_WISTERIA_GROVE = createKey("trees_wisteria_grove");

    public static final ResourceKey<PlacedFeature> TREES_FAERIE_FOREST = createKey("trees_faerie_forest");
    public static final ResourceKey<PlacedFeature> SHRUBS_FAERIE_FOREST = createKey("shrubs_faerie_forest");
    public static final ResourceKey<PlacedFeature> MUSHROOMS_PINK = createKey("mushrooms_pink");
    public static final ResourceKey<PlacedFeature> PATCH_PINK_MUSHROOM = createKey("patch_pink_mushroom");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> getter = context.lookup(Registries.CONFIGURED_FEATURE);
        ///Holder<ConfiguredFeature<?, ?>> PATCH_FOREST_GRASS = getter.getOrThrow(DreamVegetationFeatures.PATCH_FOREST_GRASS);
        ///Holder<ConfiguredFeature<?, ?>> PATCH_TALL_FOREST_GRASS = getter.getOrThrow(DreamVegetationFeatures.PATCH_TALL_FOREST_GRASS);
        Holder<ConfiguredFeature<?, ?>> MUSHROOMS_FOREST = getter.getOrThrow(DreamVegetationFeatures.MUSHROOMS_FOREST);
        Holder<ConfiguredFeature<?, ?>> PATCH_FOREST_MUSHROOM = getter.getOrThrow(DreamVegetationFeatures.PATCH_FOREST_MUSHROOM);
        Holder<ConfiguredFeature<?, ?>> PATCH_FOREST_MOSS = getter.getOrThrow(DreamVegetationFeatures.PATCH_FOREST_MOSS);
        Holder<ConfiguredFeature<?, ?>> PATCH_DREAMY_GRASS = getter.getOrThrow(DreamVegetationFeatures.PATCH_DREAMY_GRASS);
        Holder<ConfiguredFeature<?, ?>> PATCH_TALL_DREAMY_GRASS = getter.getOrThrow(DreamVegetationFeatures.PATCH_TALL_DREAMY_GRASS);
        Holder<ConfiguredFeature<?, ?>> MUSHROOMS_DREAMY = getter.getOrThrow(DreamVegetationFeatures.MUSHROOMS_DREAMY);
        Holder<ConfiguredFeature<?, ?>> PATCH_DREAMY_MUSHROOM = getter.getOrThrow(DreamVegetationFeatures.PATCH_DREAMY_MUSHROOM);
        Holder<ConfiguredFeature<?, ?>> PATCH_GROUND_IVY = getter.getOrThrow(DreamVegetationFeatures.PATCH_GROUND_IVY);
        Holder<ConfiguredFeature<?, ?>> PATCH_CLOVERS = getter.getOrThrow(DreamVegetationFeatures.PATCH_CLOVERS);
        Holder<ConfiguredFeature<?, ?>> PATCH_WHITE_CLOVERS = getter.getOrThrow(DreamVegetationFeatures.PATCH_WHITE_CLOVERS);
        Holder<ConfiguredFeature<?, ?>> PATCH_PINK_CLOVERS = getter.getOrThrow(DreamVegetationFeatures.PATCH_PINK_CLOVERS);
        Holder<ConfiguredFeature<?, ?>> FLOWER_PETUNIA = getter.getOrThrow(DreamVegetationFeatures.FLOWER_PETUNIA);
        Holder<ConfiguredFeature<?, ?>> FLOWER_PERIWINKLE = getter.getOrThrow(DreamVegetationFeatures.FLOWER_PERIWINKLE);
        Holder<ConfiguredFeature<?, ?>> FLOWER_PINK_FOXGLOVE = getter.getOrThrow(DreamVegetationFeatures.FLOWER_PINK_FOXGLOVE);
        Holder<ConfiguredFeature<?, ?>> FLOWER_PINK_HYACINTH = getter.getOrThrow(DreamVegetationFeatures.FLOWER_PINK_HYACINTH);
        Holder<ConfiguredFeature<?, ?>> FLOWER_MAGENTA_HYACINTH = getter.getOrThrow(DreamVegetationFeatures.FLOWER_MAGENTA_HYACINTH);
        Holder<ConfiguredFeature<?, ?>> FLOWER_PURPLE_HYACINTH = getter.getOrThrow(DreamVegetationFeatures.FLOWER_PURPLE_HYACINTH);
        Holder<ConfiguredFeature<?, ?>> FLOWER_VIOLETS = getter.getOrThrow(DreamVegetationFeatures.FLOWER_VIOLETS);
        Holder<ConfiguredFeature<?, ?>> TREES_WILDERNESS = getter.getOrThrow(DreamVegetationFeatures.TREES_WILDERNESS);
        Holder<ConfiguredFeature<?, ?>> SHRUBS_WILDERNESS = getter.getOrThrow(DreamVegetationFeatures.SHRUBS_WILDERNESS);
        Holder<ConfiguredFeature<?, ?>> TREES_EVERGREEN_FOREST = getter.getOrThrow(DreamVegetationFeatures.TREES_EVERGREEN_FOREST);
        Holder<ConfiguredFeature<?, ?>> SHRUBS_EVERGREEN_FOREST = getter.getOrThrow(DreamVegetationFeatures.SHRUBS_EVERGREEN_FOREST);
        Holder<ConfiguredFeature<?, ?>> MUSHROOMS_TOADSTOOL = getter.getOrThrow(DreamVegetationFeatures.MUSHROOMS_TOADSTOOL);
        Holder<ConfiguredFeature<?, ?>> PATCH_TOADSTOOL = getter.getOrThrow(DreamVegetationFeatures.PATCH_TOADSTOOL);
        Holder<ConfiguredFeature<?, ?>> TREES_ETHEREAL_FOREST = getter.getOrThrow(DreamVegetationFeatures.TREES_ETHEREAL_FOREST);
        Holder<ConfiguredFeature<?, ?>> SHRUBS_ETHEREAL_FOREST = getter.getOrThrow(DreamVegetationFeatures.SHRUBS_ETHEREAL_FOREST);
        Holder<ConfiguredFeature<?, ?>> TREES_COTTON_CANDY_FOREST = getter.getOrThrow(DreamVegetationFeatures.TREES_COTTON_CANDY_FOREST);
        Holder<ConfiguredFeature<?, ?>> TREES_WISTERIA_GROVE = getter.getOrThrow(DreamVegetationFeatures.TREES_WISTERIA_GROVE);
        Holder<ConfiguredFeature<?, ?>> TREES_FAERIE_FOREST = getter.getOrThrow(DreamVegetationFeatures.TREES_FAERIE_FOREST);
        Holder<ConfiguredFeature<?, ?>> SHRUBS_FAERIE_FOREST = getter.getOrThrow(DreamVegetationFeatures.SHRUBS_FAERIE_FOREST);
        Holder<ConfiguredFeature<?, ?>> MUSHROOMS_PINK = getter.getOrThrow(DreamVegetationFeatures.MUSHROOMS_PINK);
        Holder<ConfiguredFeature<?, ?>> PATCH_PINK_MUSHROOM = getter.getOrThrow(DreamVegetationFeatures.PATCH_PINK_MUSHROOM);

        PlacementUtils.register(context, DreamVegetationPlacements.MUSHROOMS_FOREST, MUSHROOMS_FOREST, treePlacement(RarityFilter.onAverageOnceEvery(2)));
        PlacementUtils.register(context, DreamVegetationPlacements.PATCH_FOREST_MUSHROOM, PATCH_FOREST_MUSHROOM, basicPlacement(RarityFilter.onAverageOnceEvery(2)));
        PlacementUtils.register(context, DreamVegetationPlacements.PATCH_FOREST_MOSS, PATCH_FOREST_MOSS, basicPlacement(RarityFilter.onAverageOnceEvery(2), CountPlacement.of(2)));

        PlacementUtils.register(context, DreamVegetationPlacements.PATCH_DREAMY_GRASS, PATCH_DREAMY_GRASS, VegetationPlacements.worldSurfaceSquaredWithCount(16));
        PlacementUtils.register(context, DreamVegetationPlacements.PATCH_TALL_DREAMY_GRASS, PATCH_TALL_DREAMY_GRASS, VegetationPlacements.worldSurfaceSquaredWithCount(6));
        PlacementUtils.register(context, DreamVegetationPlacements.MUSHROOMS_DREAMY, MUSHROOMS_DREAMY, treePlacement(PlacementUtils.countExtra(4, 0.1F, 1)));
        PlacementUtils.register(context, DreamVegetationPlacements.PATCH_DREAMY_MUSHROOM, PATCH_DREAMY_MUSHROOM, basicPlacement(RarityFilter.onAverageOnceEvery(2)));

        PlacementUtils.register(context, DreamVegetationPlacements.PATCH_GROUND_IVY, PATCH_GROUND_IVY, basicPlacement(RarityFilter.onAverageOnceEvery(1), CountPlacement.of(6)));
        PlacementUtils.register(context, DreamVegetationPlacements.PATCH_CLOVERS, PATCH_CLOVERS, basicPlacement(RarityFilter.onAverageOnceEvery(1), CountPlacement.of(6)));
        PlacementUtils.register(context, DreamVegetationPlacements.PATCH_WHITE_CLOVERS, PATCH_WHITE_CLOVERS, basicPlacement(RarityFilter.onAverageOnceEvery(3), CountPlacement.of(4)));
        PlacementUtils.register(context, DreamVegetationPlacements.PATCH_PINK_CLOVERS, PATCH_PINK_CLOVERS, basicPlacement(RarityFilter.onAverageOnceEvery(3), CountPlacement.of(4)));
        PlacementUtils.register(context, DreamVegetationPlacements.FLOWER_PETUNIA, FLOWER_PETUNIA, basicPlacement(RarityFilter.onAverageOnceEvery(1)));
        PlacementUtils.register(context, DreamVegetationPlacements.FLOWER_PERIWINKLE, FLOWER_PERIWINKLE, basicPlacement(RarityFilter.onAverageOnceEvery(2), CountPlacement.of(2)));
        PlacementUtils.register(context, DreamVegetationPlacements.FLOWER_PINK_FOXGLOVE, FLOWER_PINK_FOXGLOVE, basicPlacement(RarityFilter.onAverageOnceEvery(1)));
        PlacementUtils.register(context, DreamVegetationPlacements.FLOWER_PINK_HYACINTH, FLOWER_PINK_HYACINTH, basicPlacement(RarityFilter.onAverageOnceEvery(1)));
        PlacementUtils.register(context, DreamVegetationPlacements.FLOWER_MAGENTA_HYACINTH, FLOWER_MAGENTA_HYACINTH, basicPlacement(RarityFilter.onAverageOnceEvery(1)));
        PlacementUtils.register(context, DreamVegetationPlacements.FLOWER_PURPLE_HYACINTH, FLOWER_PURPLE_HYACINTH, basicPlacement(RarityFilter.onAverageOnceEvery(1)));
        PlacementUtils.register(context, DreamVegetationPlacements.FLOWER_VIOLETS, FLOWER_VIOLETS, basicPlacement(RarityFilter.onAverageOnceEvery(1)));

        PlacementUtils.register(context, DreamVegetationPlacements.TREES_WILDERNESS, TREES_WILDERNESS, treePlacement(RarityFilter.onAverageOnceEvery(2)));
        PlacementUtils.register(context, DreamVegetationPlacements.SHRUBS_WILDERNESS, SHRUBS_WILDERNESS, treePlacement(PlacementUtils.countExtra(32, 0.2F, 1)));

        PlacementUtils.register(context, DreamVegetationPlacements.TREES_EVERGREEN_FOREST, TREES_EVERGREEN_FOREST, treePlacement(PlacementUtils.countExtra(3, 0.2F, 1)));
        PlacementUtils.register(context, DreamVegetationPlacements.SHRUBS_EVERGREEN_FOREST, SHRUBS_EVERGREEN_FOREST, treePlacement(PlacementUtils.countExtra(64, 0.2F, 1)));
        PlacementUtils.register(context, DreamVegetationPlacements.MUSHROOMS_TOADSTOOL, MUSHROOMS_TOADSTOOL, treePlacement(PlacementUtils.countExtra(3, 0.2F, 1)));
        PlacementUtils.register(context, DreamVegetationPlacements.PATCH_TOADSTOOL, PATCH_TOADSTOOL, basicPlacement(RarityFilter.onAverageOnceEvery(1)));

        PlacementUtils.register(context, DreamVegetationPlacements.TREES_ETHEREAL_FOREST, TREES_ETHEREAL_FOREST, treePlacement(PlacementUtils.countExtra(7, 0.2F, 1)));
        PlacementUtils.register(context, DreamVegetationPlacements.SHRUBS_ETHEREAL_FOREST, SHRUBS_ETHEREAL_FOREST, treePlacement(PlacementUtils.countExtra(64, 0.2F, 1)));

        PlacementUtils.register(context, DreamVegetationPlacements.TREES_COTTON_CANDY_FOREST, TREES_COTTON_CANDY_FOREST, treePlacement(PlacementUtils.countExtra(6, 0.2F, 1)));

        PlacementUtils.register(context, DreamVegetationPlacements.TREES_WISTERIA_GROVE, TREES_WISTERIA_GROVE, treePlacement(PlacementUtils.countExtra(6, 0.2F, 1)));

        PlacementUtils.register(context, DreamVegetationPlacements.TREES_FAERIE_FOREST, TREES_FAERIE_FOREST, treePlacement(RarityFilter.onAverageOnceEvery(1)));
        PlacementUtils.register(context, DreamVegetationPlacements.SHRUBS_FAERIE_FOREST, SHRUBS_FAERIE_FOREST, treePlacement(PlacementUtils.countExtra(64, 0.2F, 1)));
        PlacementUtils.register(context, DreamVegetationPlacements.MUSHROOMS_PINK, MUSHROOMS_PINK, treePlacement(PlacementUtils.countExtra(4, 0.2F, 1)));
        PlacementUtils.register(context, DreamVegetationPlacements.PATCH_PINK_MUSHROOM, PATCH_PINK_MUSHROOM, basicPlacement(RarityFilter.onAverageOnceEvery(1)));
    }

    private static List<PlacementModifier> basicPlacement(PlacementModifier... placements) {
        return ImmutableList.<PlacementModifier>builder()
                .add(placements)
                .add(InSquarePlacement.spread())
                .add(PlacementUtils.HEIGHTMAP)
                .add(BiomeFilter.biome())
                .build();
    }

    private static List<PlacementModifier> treePlacement(PlacementModifier placement) {
        return treePlacementBase(placement).build();
    }

    private static List<PlacementModifier> treePlacement(PlacementModifier placement, Block saplingBlock) {
        return treePlacementBase(placement)
                .add(BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(saplingBlock.defaultBlockState(), BlockPos.ZERO)))
                .build();
    }

    private static ImmutableList.Builder<PlacementModifier> treePlacementBase(PlacementModifier placement) {
        return ImmutableList.<PlacementModifier>builder()
                .add(placement)
                .add(InSquarePlacement.spread())
                .add(SurfaceWaterDepthFilter.forMaxDepth(0))
                .add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR)
                .add(BiomeFilter.biome());
    }

}