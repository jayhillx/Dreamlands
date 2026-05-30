package com.mystanica.dreamlands.common.worldgen.feature.config;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mystanica.dreamlands.common.worldgen.feature.tree.provider.TrunkShapeProvider;
import com.mystanica.dreamlands.init.DreamBlocks;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.FeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;

import java.util.List;

public class DreamTreeConfiguration implements FeatureConfiguration {
    public static final Codec<DreamTreeConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockStateProvider.CODEC.fieldOf("trunk_provider").forGetter(config -> config.trunkProvider),
            TrunkShapeProvider.CODEC.fieldOf("trunk_shape").forGetter(config -> config.trunkShape),
            BlockStateProvider.CODEC.fieldOf("foliage_provider").forGetter(config -> config.foliageProvider),
            BlockStateProvider.CODEC.fieldOf("dirt_provider").forGetter(config -> config.dirtProvider),
            FeatureSize.CODEC.fieldOf("minimum_size").forGetter(config -> config.minimumSize),
            TreeDecorator.CODEC.listOf().fieldOf("decorators").forGetter(config -> config.decorators),
            Codec.BOOL.fieldOf("large").forGetter(config -> config.large)
    ).apply(instance, DreamTreeConfiguration::new));
    public final BlockStateProvider trunkProvider;
    public final TrunkShapeProvider trunkShape;
    public final BlockStateProvider foliageProvider;
    public final BlockStateProvider dirtProvider;
    public final FeatureSize minimumSize;
    public List<TreeDecorator> decorators;
    public boolean large;

    protected DreamTreeConfiguration(BlockStateProvider trunkProvider,
                                     TrunkShapeProvider trunkShape,
                                     BlockStateProvider foliageProvider,
                                     BlockStateProvider dirtProvider,
                                     FeatureSize minimumSize,
                                     List<TreeDecorator> decorators,
                                     boolean large
    ) {
        this.trunkProvider = trunkProvider;
        this.trunkShape = trunkShape;
        this.foliageProvider = foliageProvider;
        this.dirtProvider = dirtProvider;
        this.minimumSize = minimumSize;
        this.decorators = decorators;
        this.large = large;
    }

    public static class Builder {
        public BlockStateProvider trunkProvider;
        public TrunkShapeProvider trunkShape;
        public BlockStateProvider foliageProvider;
        public BlockStateProvider dirtProvider;
        public FeatureSize minimumSize;
        public List<TreeDecorator> decorators = ImmutableList.of();
        public boolean large = false;

        public Builder(BlockStateProvider trunkProvider, TrunkShapeProvider trunkShape, BlockStateProvider foliageProvider) {
            this(trunkProvider, trunkShape, foliageProvider, new TwoLayersFeatureSize(1, 0, 1));
        }

        public Builder(BlockStateProvider trunkProvider, TrunkShapeProvider trunkShape, BlockStateProvider foliageProvider, FeatureSize minimumSize) {
            this.trunkProvider = trunkProvider;
            this.trunkShape = trunkShape;
            this.foliageProvider = foliageProvider;
            this.dirtProvider = BlockStateProvider.simple(DreamBlocks.DREAMY_DIRT.get());
            this.minimumSize = minimumSize;
        }

        public Builder decorators(List<TreeDecorator> decorators) {
            this.decorators = decorators;
            return this;
        }

        public Builder large() {
            this.large = true;
            return this;
        }

        public DreamTreeConfiguration build() {
            return new DreamTreeConfiguration(
                    this.trunkProvider,
                    this.trunkShape,
                    this.foliageProvider,
                    this.dirtProvider,
                    this.minimumSize,
                    this.decorators,
                    this.large
            );
        }
    }

}