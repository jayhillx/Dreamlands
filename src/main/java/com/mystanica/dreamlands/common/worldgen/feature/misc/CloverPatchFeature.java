package com.mystanica.dreamlands.common.worldgen.feature.misc;

import com.mojang.serialization.Codec;
import com.mystanica.dreamlands.common.block.CloverBlock;
import com.mystanica.dreamlands.common.worldgen.feature.config.PatchConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class CloverPatchFeature extends PatchFeature<PatchConfiguration> {

    public CloverPatchFeature(Codec<PatchConfiguration> codec) {
        super(codec);
    }

    @Override
    protected void placeBlocks(LevelAccessor level, BlockPos pos, RandomSource random, PatchConfiguration config) {
        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        final int amount = random.nextInt(4);
        for (int i = 2; i <= amount; i++) {
            level.setBlock(pos, config.blockProvider.getState(random, pos)
                    .setValue(CloverBlock.AMOUNT, i)
                    .setValue(CloverBlock.FACING, direction),
                    3);
        }
    }

    @Override
    protected boolean canPlace(LevelAccessor level, BlockPos pos, RandomSource random, PatchConfiguration config) {
        BlockState state = level.getBlockState(pos);
        BlockState belowState = level.getBlockState(pos.below());
        if (state.getFluidState().isSource()) {
            return false;
        }

        return !state.is(BlockTags.LEAVES) && belowState.is(BlockTags.DIRT) && (state.isAir() || state.canBeReplaced() || state.is(config.blockProvider.getState(random, pos).getBlock()));
    }
    
}