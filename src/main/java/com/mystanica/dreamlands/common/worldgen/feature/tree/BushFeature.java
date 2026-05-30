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

public class BushFeature extends DreamTreeFeature {

    public BushFeature(Codec<DreamTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config) {
        setDirtAt(level, random, initialPos.below(), trunkSetter, config);

        this.placeLog(level, random, initialPos, Direction.Axis.Y, trunkSetter, config);

        if (config.large) {
            this.placeBushyFoliage(level, random, initialPos, foliageSetter, config, random.nextBoolean() ? 1 : 2, 2, false);
        } else {
            this.placeFoliage(level, random, initialPos, foliageSetter, config, 1, 1);
        }
        return true;
    }

    protected void placeFoliage(LevelAccessor level, RandomSource random, BlockPos pos, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config, int foliageRadius, int foliageHeight) {
        BlockPos.MutableBlockPos mutablePos = pos.mutable();

        for (int x = -foliageRadius; x <= foliageRadius; x++) {
            for (int z = -foliageRadius; z <= foliageRadius; z++) {
                mutablePos.setWithOffset(pos, x, 0, z);
                this.placeLeaves(level, random, mutablePos, foliageSetter, config);
            }
        }

        this.placeLeaves(level, random, pos.above(), foliageSetter, config);
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            this.placeLeaves(level, random, pos.above().relative(direction), foliageSetter, config);
        }

        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        if (random.nextBoolean()) {
            this.placeLeaves(level, random, pos.above().relative(direction).relative(direction.getClockWise()), foliageSetter, config);
        }

        int randomBits = random.nextInt(2, 4);
        int placedBits = 0;
        while (placedBits < randomBits) {
            this.placeLeaves(level, random, pos.relative(direction, 2), foliageSetter, config);
            placedBits++;
        }
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk) {
        return x == radius && z == radius && (random.nextInt(2) == 0 || y == 0);
    }

}