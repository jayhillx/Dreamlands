package com.mystanica.dreamlands.common.worldgen.feature.misc;

import com.mystanica.dreamlands.common.worldgen.feature.config.PatchConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public abstract class PatchFeature<C extends PatchConfiguration> extends Feature<C> {

    public PatchFeature(Codec<C> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<C> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos initialPos = context.origin();
        C config = context.config();

        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        int count = 0;
        int radius = config.radius;
        for (int i = 0; i < config.tries; i++) {
            int offsetX = random.nextInt(radius) - random.nextInt(radius);
            int offsetY = random.nextInt(radius) - random.nextInt(radius);
            int offsetZ = random.nextInt(radius) - random.nextInt(radius);
            mutablePos.setWithOffset(initialPos, offsetX, offsetY, offsetZ);

            if (this.canPlace(level, mutablePos, random, config)) {
                this.placeBlocks(level, mutablePos, random, config);
                count++;
            }
        }

        return count > 0;
    }

    /**
     * @return if the blocks/feature will be able to place at all.
     */
    protected abstract boolean canPlace(LevelAccessor level, BlockPos pos, RandomSource random, C config);

    /**
     * defines what the given feature should do when placing the block.
     * i.e. moss patches will place moss in the ground and a carpet above, or clover patches that place randomized flowerbed blocks.
     */
    protected abstract void placeBlocks(LevelAccessor level, BlockPos pos, RandomSource random, C config);

}