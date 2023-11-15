package com.dreamlands.datagen.registry;

import com.dreamlands.Dreamlands;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.dimension.DimensionType;

import java.util.OptionalLong;

import static com.dreamlands.Dreamlands.createKey;

public class DreamDimensionTypes {

    public static final ResourceKey<DimensionType> DREAMLAND = createKey(Registries.DIMENSION_TYPE, "dreamland");

    public static void bootstrap(BootstapContext<DimensionType> context) {
        context.register(DREAMLAND, createDimension());
    }

    private static DimensionType createDimension() {
        return new DimensionType(OptionalLong.empty(), true, false, false, false, 1.0D, false, false, -64, 384, 384, BlockTags.INFINIBURN_OVERWORLD, Dreamlands.modLoc("dreamland"), 0.0F, new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0));
    }

}