package com.mystanica.dreamlands.common.worldgen.feature.tree;

import com.mojang.serialization.Codec;
import com.mystanica.dreamlands.common.worldgen.feature.config.DreamTreeConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiConsumer;

public class ShrubFeature extends DreamTreeFeature {

    public ShrubFeature(Codec<DreamTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config) {
        setDirtAt(level, random, initialPos.below(), trunkSetter, config);

        int height = config.large ? 2 : 1;
        for (int currentY = 0; currentY < height; currentY++) {
            this.placeLog(level, random, initialPos.above(currentY), Direction.Axis.Y, trunkSetter, config);
        }

        this.placeFoliage(level, random, initialPos, foliageSetter, config, 1, height + 1);
        this.placeBushyFoliage(level, random, initialPos, foliageSetter, config, height, height, false, 0.6D);
        return true;
    }

    protected void placeFoliage(LevelAccessor level, RandomSource random, BlockPos pos, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config, int foliageRadius, int foliageHeight) {
        BlockPos.MutableBlockPos mutablePos = pos.mutable();

        for (int y = 0; y < foliageHeight; y++) {
            this.placeLeavesRow(level, random, mutablePos, foliageSetter, config, foliageRadius, false, true, 0.0D);
            mutablePos.move(Direction.UP);
        }
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk) {
        return x == radius && z == radius && (random.nextInt(2) == 0 || y == 0);
    }

}