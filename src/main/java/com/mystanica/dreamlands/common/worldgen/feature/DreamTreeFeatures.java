package com.mystanica.dreamlands.common.worldgen.feature;

import com.mystanica.dreamlands.common.worldgen.feature.config.DreamTreeConfiguration;
import com.mystanica.dreamlands.common.worldgen.feature.config.MushroomConfiguration;
import com.mystanica.dreamlands.common.worldgen.feature.decorator.HangingWisteriaDecorator;
import com.mystanica.dreamlands.common.worldgen.feature.tree.provider.TrunkShapeProvider;
import com.mystanica.dreamlands.init.DreamBlocks;
import com.mystanica.dreamlands.init.DreamFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

import static com.mystanica.dreamlands.init.DreamFeatures.Configured.createKey;

public class DreamTreeFeatures {

    /// shared
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOREST_SHRUB = createKey("forest_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOREST_MUSHROOM = createKey("forest_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_FOREST_MUSHROOM = createKey("large_forest_mushroom");
    
    /// dreamland
    public static final ResourceKey<ConfiguredFeature<?, ?>> DREAMY_TREE = createKey("dreamy_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DREAMY_SHRUB = createKey("dreamy_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_DREAMY_SHRUB = createKey("large_dreamy_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DREAMY_MUSHROOM = createKey("dreamy_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_DREAMY_MUSHROOM = createKey("large_dreamy_mushroom");
    ///public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_TREE = createKey("aspen_tree");
    ///public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_ASPEN_TREE = createKey("tall_aspen_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EVERGREEN_TREE = createKey("evergreen_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_EVERGREEN_TREE = createKey("large_evergreen_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TOADSTOOL = createKey("toadstool");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_TOADSTOOL = createKey("large_toadstool");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHEREAL_TREE = createKey("ethereal_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LILAC_BUSH = createKey("lilac_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_COTTON_CANDY_TREE = createKey("pink_cotton_candy_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_COTTON_CANDY_TREE = createKey("blue_cotton_candy_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WISTERIA_TREE = createKey("wisteria_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MYSTICAL_TREE = createKey("mystical_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FAIRY_ROSE_BUSH = createKey("fairy_rose_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_MUSHROOM = createKey("pink_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_PINK_MUSHROOM = createKey("large_pink_mushroom");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, FOREST_SHRUB, DreamFeatures.SHRUB.get(), shrub(DreamBlocks.FOREST_SHRUB_LEAVES.get()).build());
        FeatureUtils.register(context, FOREST_MUSHROOM, DreamFeatures.MUSHROOM.get(), flatMushroom(DreamBlocks.FOREST_MUSHROOM_BLOCK.get(), UniformInt.of(2, 4), UniformInt.of(1, 2)).build());
        FeatureUtils.register(context, LARGE_FOREST_MUSHROOM, DreamFeatures.MUSHROOM.get(), flatMushroom(DreamBlocks.FOREST_MUSHROOM_BLOCK.get(), UniformInt.of(4, 7), UniformInt.of(2, 3)).build());

        FeatureUtils.register(context, DREAMY_TREE, DreamFeatures.DREAMY_TREE.get(), tree(DreamBlocks.DREAMY_LOG.get(), DreamBlocks.DREAMY_LEAVES.get(), 7, 4).build());
        FeatureUtils.register(context, DREAMY_SHRUB, DreamFeatures.SHRUB.get(), shrub(DreamBlocks.DREAMY_LEAVES.get()).build());
        FeatureUtils.register(context, LARGE_DREAMY_SHRUB, DreamFeatures.SHRUB.get(), shrub(DreamBlocks.DREAMY_LEAVES.get()).large().build());
        FeatureUtils.register(context, DREAMY_MUSHROOM, DreamFeatures.MUSHROOM.get(), roundMushroom(DreamBlocks.DREAMY_MUSHROOM_BLOCK.get(), UniformInt.of(3, 6), ConstantInt.of(1)).build());
        FeatureUtils.register(context, LARGE_DREAMY_MUSHROOM, DreamFeatures.MUSHROOM.get(), roundMushroom(DreamBlocks.DREAMY_MUSHROOM_BLOCK.get(), UniformInt.of(6, 10), ConstantInt.of(2)).build());

        ///FeatureUtils.register(context, ASPEN_TREE, DreamFeatures.ASPEN_TREE.get(), tree(DreamBlocks.ASPEN_LOG.get(), DreamBlocks.ASPEN_LEAVES.get(), 9, 4).build());
        ///FeatureUtils.register(context, TALL_ASPEN_TREE, DreamFeatures.ASPEN_TREE.get(), tree(DreamBlocks.ASPEN_LOG.get(), DreamBlocks.ASPEN_LEAVES.get(), 13, 4).build());

        FeatureUtils.register(context, EVERGREEN_TREE, DreamFeatures.EVERGREEN_TREE.get(), tree(DreamBlocks.EVERGREEN_LOG.get(), DreamBlocks.EVERGREEN_LEAVES.get(), 25, 2).build());
        FeatureUtils.register(context, LARGE_EVERGREEN_TREE, DreamFeatures.EVERGREEN_TREE.get(), tree(DreamBlocks.EVERGREEN_LOG.get(), DreamBlocks.EVERGREEN_LEAVES.get(), 31, 2).large().build());
        FeatureUtils.register(context, TOADSTOOL, DreamFeatures.MUSHROOM.get(), flatMushroom(DreamBlocks.TOADSTOOL_BLOCK.get(), UniformInt.of(2, 4), ConstantInt.of(1)).build());
        FeatureUtils.register(context, LARGE_TOADSTOOL, DreamFeatures.MUSHROOM.get(), flatMushroom(DreamBlocks.TOADSTOOL_BLOCK.get(), UniformInt.of(4, 7), ConstantInt.of(2)).build());
        
        FeatureUtils.register(context, ETHEREAL_TREE, DreamFeatures.ETHEREAL_TREE.get(), tree(DreamBlocks.ETHEREAL_LOG.get(), DreamBlocks.ETHEREAL_LEAVES.get(), 7, 7).build());
        FeatureUtils.register(context, LILAC_BUSH, DreamFeatures.FLOWERING_BUSH.get(), shrub(DreamBlocks.LILAC_BUSH_LEAVES.get()).build());

        FeatureUtils.register(context, PINK_COTTON_CANDY_TREE, DreamFeatures.COTTON_CANDY_TREE.get(), tree(DreamBlocks.CANDY_LOG.get(), DreamBlocks.PINK_COTTON_CANDY_BLOCK.get(), 7, 7).build());
        FeatureUtils.register(context, BLUE_COTTON_CANDY_TREE, DreamFeatures.COTTON_CANDY_TREE.get(), tree(DreamBlocks.CANDY_LOG.get(), DreamBlocks.BLUE_COTTON_CANDY_BLOCK.get(), 7, 7).build());

        FeatureUtils.register(context, WISTERIA_TREE, DreamFeatures.WISTERIA_TREE.get(), tree(DreamBlocks.WISTERIA_LOG.get(), DreamBlocks.WISTERIA_LEAVES.get(), 10, 4).decorators(List.of(new HangingWisteriaDecorator(1.0D))).build());

        FeatureUtils.register(context, MYSTICAL_TREE, DreamFeatures.MYSTICAL_TREE.get(), tree(DreamBlocks.MYSTICAL_LOG.get(), DreamBlocks.MYSTICAL_LEAVES.get(), 8, 4).build());
        FeatureUtils.register(context, FAIRY_ROSE_BUSH, DreamFeatures.FLOWERING_BUSH.get(), shrub(DreamBlocks.FAIRY_ROSE_BUSH_LEAVES.get()).build());
        FeatureUtils.register(context, PINK_MUSHROOM, DreamFeatures.MUSHROOM.get(), roundMushroom(DreamBlocks.PINK_MUSHROOM_BLOCK.get(), UniformInt.of(3, 6), ConstantInt.of(1)).build());
        FeatureUtils.register(context, LARGE_PINK_MUSHROOM, DreamFeatures.MUSHROOM.get(), roundMushroom(DreamBlocks.PINK_MUSHROOM_BLOCK.get(), UniformInt.of(6, 10), ConstantInt.of(2)).build());
    }

    private static DreamTreeConfiguration.Builder shrub(Block leaves) {
        return new DreamTreeConfiguration.Builder(
                provider(DreamBlocks.DREAMY_LOG.get()),
                new TrunkShapeProvider(1, 1),
                provider(leaves)
        );
    }

    private static DreamTreeConfiguration.Builder tree(Block log, Block leaves, int baseHeight, int randHeight) {
        return new DreamTreeConfiguration.Builder(
                provider(log),
                new TrunkShapeProvider(baseHeight, randHeight),
                provider(leaves)
        );
    }

    private static MushroomConfiguration.Builder flatMushroom(Block cap, IntProvider stemHeight, IntProvider capRadius) {
        return new MushroomConfiguration.Builder(
                BlockStateProvider.simple(cap.defaultBlockState().setValue(HugeMushroomBlock.UP, true).setValue(HugeMushroomBlock.DOWN, false)),
                BlockStateProvider.simple(DreamBlocks.MUSHROOM_STEM.get()),
                stemHeight,
                capRadius,
                false,
                true
        );
    }
    
    private static MushroomConfiguration.Builder roundMushroom(Block cap, IntProvider stemHeight, IntProvider capRadius) {
        return new MushroomConfiguration.Builder(
                BlockStateProvider.simple(cap.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false)),
                BlockStateProvider.simple(DreamBlocks.MUSHROOM_STEM.get()),
                stemHeight,
                capRadius,
                true,
                false
        );
    }

    private static BlockStateProvider provider(Block block) {
        return BlockStateProvider.simple(block);
    }
    
}