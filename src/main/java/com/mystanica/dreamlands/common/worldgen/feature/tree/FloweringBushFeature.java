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

public class FloweringBushFeature extends BushFeature {

    public FloweringBushFeature(Codec<DreamTreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config) {
        return super.placeTree(level, random, initialPos, trunkSetter, branchSetter, foliageSetter, config);
    }

    @Override
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

}