package com.mystanica.dreamlands.init;

import com.mystanica.dreamlands.Dreamlands;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.dimension.DimensionType;

import java.util.OptionalLong;

public class DreamDimensionTypes {

    public static final ResourceKey<DimensionType> DREAMLAND = createKey("dreamland");
    ///public static final ResourceKey<DimensionType> NIGHTMOOR = createKey("nightmoor");
    public static final ResourceLocation DREAMLAND_EFFECTS = Dreamlands.modLoc("dreamland");
    ///public static final ResourceLocation NIGHTMOOR_EFFECTS = Dreamlands.modLoc("nightmoor");

    private static ResourceKey<DimensionType> createKey(String path) {
        return ResourceKey.create(Registries.DIMENSION_TYPE, Dreamlands.modLoc(path));
    }

    public static void bootstrap(BootstapContext<DimensionType> context) {
        context.register(DREAMLAND, createDimension(DREAMLAND_EFFECTS));
        ///context.register(NIGHTMOOR, createDimension(NIGHTMOOR_EFFECTS));
    }

    private static DimensionType createDimension(ResourceLocation effectsLocation) {
        return new DimensionType(
                OptionalLong.empty(),
                true,
                false,
                false,
                true,
                1.0D,
                true,
                false,
                -64,
                384,
                384,
                BlockTags.INFINIBURN_OVERWORLD,
                effectsLocation,
                0.0F,
                new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 0)
        );
    }

}