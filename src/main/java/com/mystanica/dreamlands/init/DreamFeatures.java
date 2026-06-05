package com.mystanica.dreamlands.init;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.common.worldgen.feature.*;
import com.mystanica.dreamlands.common.worldgen.feature.config.*;
import com.mystanica.dreamlands.common.worldgen.feature.decorator.*;
import com.mystanica.dreamlands.common.worldgen.feature.misc.*;
import com.mystanica.dreamlands.common.worldgen.feature.tree.*;
import com.mystanica.dreamlands.common.worldgen.placement.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DreamFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, Dreamlands.modId);
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, Dreamlands.modId);

    public static final RegistryObject<DreamTreeFeature> SHRUB = FEATURES.register("shrub", () -> new ShrubFeature(DreamTreeConfiguration.CODEC));
    public static final RegistryObject<DreamTreeFeature> BUSH = FEATURES.register("bush", () -> new BushFeature(DreamTreeConfiguration.CODEC));
    public static final RegistryObject<DreamTreeFeature> FLOWERING_BUSH = FEATURES.register("flowering_bush", () -> new FloweringBushFeature(DreamTreeConfiguration.CODEC));
    public static final RegistryObject<DreamTreeFeature> DREAMY_TREE = FEATURES.register("dreamy_tree", () -> new DreamyTreeFeature(DreamTreeConfiguration.CODEC));
    public static final RegistryObject<DreamTreeFeature> EVERGREEN_TREE = FEATURES.register("evergreen_tree", () -> new EvergreenTreeFeature(DreamTreeConfiguration.CODEC));
    public static final RegistryObject<DreamTreeFeature> ETHEREAL_TREE = FEATURES.register("ethereal_tree", () -> new EtherealTreeFeature(DreamTreeConfiguration.CODEC));
    public static final RegistryObject<DreamTreeFeature> COTTON_CANDY_TREE = FEATURES.register("cotton_candy_tree", () -> new CottonCandyTreeFeature(DreamTreeConfiguration.CODEC));
    public static final RegistryObject<DreamTreeFeature> WISTERIA_TREE = FEATURES.register("wisteria_tree", () -> new WisteriaTreeFeature(DreamTreeConfiguration.CODEC));
    public static final RegistryObject<DreamTreeFeature> MYSTICAL_TREE = FEATURES.register("mystical_tree", () -> new MysticalTreeFeature(DreamTreeConfiguration.CODEC));
    public static final RegistryObject<MushroomFeature> MUSHROOM = FEATURES.register("mushroom", () -> new MushroomFeature(MushroomConfiguration.CODEC));

    public static final RegistryObject<Feature<MossPatchConfiguration>> MOSS_PATCH = FEATURES.register("moss_patch", () -> new MossPatchFeature(MossPatchConfiguration.CODEC));

    /// tree decorators
    public static final RegistryObject<TreeDecoratorType<HangingWisteriaDecorator>> HANGING_WISTERIA = TREE_DECORATORS.register("hanging_wisteria", () -> new TreeDecoratorType<>(HangingWisteriaDecorator.CODEC));

    public static class Configured {
        public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
            return ResourceKey.create(Registries.CONFIGURED_FEATURE, Dreamlands.modLoc(name));
        }

        public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
            DreamTreeFeatures.bootstrap(context);
            DreamVegetationFeatures.bootstrap(context);
        }
    }

    public static class Placed {
        public static ResourceKey<PlacedFeature> createKey(String name) {
            return ResourceKey.create(Registries.PLACED_FEATURE, Dreamlands.modLoc(name));
        }

        public static void bootstrap(BootstapContext<PlacedFeature> context) {
            DreamTreePlacements.bootstrap(context);
            DreamVegetationPlacements.bootstrap(context);
        }
    }
    
}