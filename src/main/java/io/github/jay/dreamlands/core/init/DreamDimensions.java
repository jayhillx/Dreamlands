package io.github.jay.dreamlands.core.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;

import java.util.OptionalLong;

import static io.github.jay.dreamlands.Dreamlands.createKey;

public class DreamDimensions {

    public static final ResourceKey<DimensionType> NIGHTMOOR = createKey(Registries.DIMENSION_TYPE, "nightmoor");
    public static final ResourceKey<DimensionType> DREAMLAND = createKey(Registries.DIMENSION_TYPE, "dreamland");

    public static void bootstrap(BootstapContext<DimensionType> context) {
        context.register(NIGHTMOOR, createDimension());
        context.register(DREAMLAND, createDimension());
    }

    private static DimensionType createDimension() {
        return new DimensionType(OptionalLong.empty(), true, false, false, false, 1.0D, false, false, -64, 384, 384, BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.OVERWORLD_EFFECTS, 0.0F, new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0));
    }

}