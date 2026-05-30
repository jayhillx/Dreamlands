package com.mystanica.dreamlands.common.worldgen.placement;

import com.google.common.collect.ImmutableList;
import com.mystanica.dreamlands.common.worldgen.feature.DreamTreeFeatures;
import com.mystanica.dreamlands.init.DreamBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static com.mystanica.dreamlands.init.DreamFeatures.Placed.createKey;

public class DreamTreePlacements {

    public static final ResourceKey<PlacedFeature> FOREST_SHRUB_CHECKED = createKey("forest_shrub_checked");
    public static final ResourceKey<PlacedFeature> FOREST_MUSHROOM_CHECKED = createKey("forest_mushroom_checked");
    public static final ResourceKey<PlacedFeature> LARGE_FOREST_MUSHROOM_CHECKED = createKey("large_forest_mushroom_checked");

    public static final ResourceKey<PlacedFeature> DREAMY_TREE_CHECKED = createKey("dreamy_tree_checked");
    public static final ResourceKey<PlacedFeature> DREAMY_SHRUB_CHECKED = createKey("dreamy_shrub_checked");
    public static final ResourceKey<PlacedFeature> LARGE_DREAMY_SHRUB_CHECKED = createKey("large_dreamy_shrub_checked");
    public static final ResourceKey<PlacedFeature> DREAMY_MUSHROOM_CHECKED = createKey("dreamy_mushroom_checked");
    public static final ResourceKey<PlacedFeature> LARGE_DREAMY_MUSHROOM_CHECKED = createKey("large_dreamy_mushroom_checked");
    ///public static final ResourceKey<PlacedFeature> ASPEN_TREE_CHECKED = createKey("aspen_tree_checked");
    ///public static final ResourceKey<PlacedFeature> TALL_ASPEN_TREE_CHECKED = createKey("tall_aspen_tree_checked");
    public static final ResourceKey<PlacedFeature> EVERGREEN_TREE_CHECKED = createKey("evergreen_tree_checked");
    public static final ResourceKey<PlacedFeature> LARGE_EVERGREEN_TREE_CHECKED = createKey("large_evergreen_tree_checked");
    public static final ResourceKey<PlacedFeature> TOADSTOOL_CHECKED = createKey("toadstool_checked");
    public static final ResourceKey<PlacedFeature> LARGE_TOADSTOOL_CHECKED = createKey("large_toadstool_checked");
    public static final ResourceKey<PlacedFeature> ETHEREAL_TREE_CHECKED = createKey("ethereal_tree_checked");
    public static final ResourceKey<PlacedFeature> LILAC_BUSH_CHECKED = createKey("lilac_bush_checked");
    public static final ResourceKey<PlacedFeature> PINK_COTTON_CANDY_TREE_CHECKED = createKey("pink_cotton_candy_tree_checked");
    public static final ResourceKey<PlacedFeature> BLUE_COTTON_CANDY_TREE_CHECKED = createKey("blue_cotton_candy_tree_checked");
    public static final ResourceKey<PlacedFeature> WISTERIA_TREE_CHECKED = createKey("wisteria_tree_checked");
    public static final ResourceKey<PlacedFeature> MYSTICAL_TREE_CHECKED = createKey("mystical_tree_checked");
    public static final ResourceKey<PlacedFeature> FAIRY_ROSE_BUSH_CHECKED = createKey("fairy_rose_bush_checked");
    public static final ResourceKey<PlacedFeature> PINK_MUSHROOM_CHECKED = createKey("pink_mushroom_checked");
    public static final ResourceKey<PlacedFeature> LARGE_PINK_MUSHROOM_CHECKED = createKey("large_pink_mushroom_checked");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> getter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> FOREST_SHRUB = getter.getOrThrow(DreamTreeFeatures.FOREST_SHRUB);
        Holder<ConfiguredFeature<?, ?>> FOREST_MUSHROOM = getter.getOrThrow(DreamTreeFeatures.FOREST_MUSHROOM);
        Holder<ConfiguredFeature<?, ?>> LARGE_FOREST_MUSHROOM = getter.getOrThrow(DreamTreeFeatures.LARGE_FOREST_MUSHROOM);
        Holder<ConfiguredFeature<?, ?>> DREAMY_TREE = getter.getOrThrow(DreamTreeFeatures.DREAMY_TREE);
        Holder<ConfiguredFeature<?, ?>> DREAMY_SHRUB = getter.getOrThrow(DreamTreeFeatures.DREAMY_SHRUB);
        Holder<ConfiguredFeature<?, ?>> LARGE_DREAMY_SHRUB = getter.getOrThrow(DreamTreeFeatures.LARGE_DREAMY_SHRUB);
        Holder<ConfiguredFeature<?, ?>> DREAMY_MUSHROOM = getter.getOrThrow(DreamTreeFeatures.DREAMY_MUSHROOM);
        Holder<ConfiguredFeature<?, ?>> LARGE_DREAMY_MUSHROOM = getter.getOrThrow(DreamTreeFeatures.LARGE_DREAMY_MUSHROOM);
        ///Holder<ConfiguredFeature<?, ?>> ASPEN_TREE = getter.getOrThrow(DreamTreeFeatures.ASPEN_TREE);
        ///Holder<ConfiguredFeature<?, ?>> TALL_ASPEN_TREE = getter.getOrThrow(DreamTreeFeatures.TALL_ASPEN_TREE);
        Holder<ConfiguredFeature<?, ?>> EVERGREEN_TREE = getter.getOrThrow(DreamTreeFeatures.EVERGREEN_TREE);
        Holder<ConfiguredFeature<?, ?>> LARGE_EVERGREEN_TREE = getter.getOrThrow(DreamTreeFeatures.LARGE_EVERGREEN_TREE);
        Holder<ConfiguredFeature<?, ?>> TOADSTOOL = getter.getOrThrow(DreamTreeFeatures.TOADSTOOL);
        Holder<ConfiguredFeature<?, ?>> LARGE_TOADSTOOL = getter.getOrThrow(DreamTreeFeatures.LARGE_TOADSTOOL);
        Holder<ConfiguredFeature<?, ?>> ETHEREAL_TREE = getter.getOrThrow(DreamTreeFeatures.ETHEREAL_TREE);
        Holder<ConfiguredFeature<?, ?>> LILAC_BUSH = getter.getOrThrow(DreamTreeFeatures.LILAC_BUSH);
        Holder<ConfiguredFeature<?, ?>> PINK_COTTON_CANDY_TREE = getter.getOrThrow(DreamTreeFeatures.PINK_COTTON_CANDY_TREE);
        Holder<ConfiguredFeature<?, ?>> BLUE_COTTON_CANDY_TREE = getter.getOrThrow(DreamTreeFeatures.BLUE_COTTON_CANDY_TREE);
        Holder<ConfiguredFeature<?, ?>> WISTERIA_TREE = getter.getOrThrow(DreamTreeFeatures.WISTERIA_TREE);
        Holder<ConfiguredFeature<?, ?>> MYSTICAL_TREE = getter.getOrThrow(DreamTreeFeatures.MYSTICAL_TREE);
        Holder<ConfiguredFeature<?, ?>> FAIRY_ROSE_BUSH = getter.getOrThrow(DreamTreeFeatures.FAIRY_ROSE_BUSH);
        Holder<ConfiguredFeature<?, ?>> PINK_MUSHROOM = getter.getOrThrow(DreamTreeFeatures.PINK_MUSHROOM);
        Holder<ConfiguredFeature<?, ?>> LARGE_PINK_MUSHROOM = getter.getOrThrow(DreamTreeFeatures.LARGE_PINK_MUSHROOM);

        PlacementUtils.register(context, FOREST_SHRUB_CHECKED, FOREST_SHRUB, withoutPlacement(DreamBlocks.FOREST_SHRUB.get()));
        PlacementUtils.register(context, FOREST_MUSHROOM_CHECKED, FOREST_MUSHROOM, withoutPlacement(DreamBlocks.FOREST_MUSHROOM.get()));
        PlacementUtils.register(context, LARGE_FOREST_MUSHROOM_CHECKED, LARGE_FOREST_MUSHROOM, withoutPlacement(DreamBlocks.FOREST_MUSHROOM.get()));
        PlacementUtils.register(context, DREAMY_TREE_CHECKED, DREAMY_TREE, withoutPlacement(DreamBlocks.DREAMY_SAPLING.get()));
        PlacementUtils.register(context, DREAMY_SHRUB_CHECKED, DREAMY_SHRUB, withoutPlacement(DreamBlocks.DREAMY_SAPLING.get()));
        PlacementUtils.register(context, LARGE_DREAMY_SHRUB_CHECKED, LARGE_DREAMY_SHRUB, withoutPlacement(DreamBlocks.DREAMY_SAPLING.get()));
        PlacementUtils.register(context, DREAMY_MUSHROOM_CHECKED, DREAMY_MUSHROOM, withoutPlacement(DreamBlocks.DREAMY_MUSHROOM.get()));
        PlacementUtils.register(context, LARGE_DREAMY_MUSHROOM_CHECKED, LARGE_DREAMY_MUSHROOM, withoutPlacement(DreamBlocks.DREAMY_MUSHROOM.get()));
        ///PlacementUtils.register(context, ASPEN_TREE_CHECKED, ASPEN_TREE, withoutPlacement(DreamBlocks.ASPEN_SAPLING.get()));
        ///PlacementUtils.register(context, TALL_ASPEN_TREE_CHECKED, TALL_ASPEN_TREE, withoutPlacement(DreamBlocks.ASPEN_SAPLING.get()));
        PlacementUtils.register(context, EVERGREEN_TREE_CHECKED, EVERGREEN_TREE, withoutPlacement(DreamBlocks.EVERGREEN_SAPLING.get()));
        PlacementUtils.register(context, LARGE_EVERGREEN_TREE_CHECKED, LARGE_EVERGREEN_TREE, withoutPlacement(DreamBlocks.EVERGREEN_SAPLING.get()));
        PlacementUtils.register(context, TOADSTOOL_CHECKED, TOADSTOOL, withoutPlacement(DreamBlocks.TOADSTOOL.get()));
        PlacementUtils.register(context, LARGE_TOADSTOOL_CHECKED, LARGE_TOADSTOOL, withoutPlacement(DreamBlocks.TOADSTOOL.get()));
        PlacementUtils.register(context, ETHEREAL_TREE_CHECKED, ETHEREAL_TREE, withoutPlacement(DreamBlocks.ETHEREAL_SAPLING.get()));
        PlacementUtils.register(context, LILAC_BUSH_CHECKED, LILAC_BUSH, withoutPlacement(DreamBlocks.LILAC_BUSH.get()));
        PlacementUtils.register(context, PINK_COTTON_CANDY_TREE_CHECKED, PINK_COTTON_CANDY_TREE, withoutPlacement(DreamBlocks.PINK_COTTON_CANDY_SAPLING.get()));
        PlacementUtils.register(context, BLUE_COTTON_CANDY_TREE_CHECKED, BLUE_COTTON_CANDY_TREE, withoutPlacement(DreamBlocks.BLUE_COTTON_CANDY_SAPLING.get()));
        PlacementUtils.register(context, WISTERIA_TREE_CHECKED, WISTERIA_TREE, withoutPlacement(DreamBlocks.WISTERIA_SAPLING.get()));
        PlacementUtils.register(context, MYSTICAL_TREE_CHECKED, MYSTICAL_TREE, withoutPlacement(DreamBlocks.MYSTICAL_SAPLING.get()));
        PlacementUtils.register(context, FAIRY_ROSE_BUSH_CHECKED, FAIRY_ROSE_BUSH, withoutPlacement(DreamBlocks.FAIRY_ROSE_BUSH.get()));
        PlacementUtils.register(context, PINK_MUSHROOM_CHECKED, PINK_MUSHROOM, withoutPlacement(DreamBlocks.PINK_MUSHROOM.get()));
        PlacementUtils.register(context, LARGE_PINK_MUSHROOM_CHECKED, LARGE_PINK_MUSHROOM, withoutPlacement(DreamBlocks.PINK_MUSHROOM.get()));
    }

    /**
     * placement will be instead in a selector in vegetation features & placements.
     */
    private static List<PlacementModifier> withoutPlacement(Block block) {
        return List.of(
                PlacementUtils.filteredByBlockSurvival(block),
                BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE),
                BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.GRASS_BLOCK, DreamBlocks.DREAMY_GRASS_BLOCK.get()))
        );
    }

    private static ImmutableList.Builder<PlacementModifier> treePlacement(PlacementModifier placement, Block block) {
        return treePlacementBase(placement)
                .add(BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(block.defaultBlockState(), BlockPos.ZERO)));
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