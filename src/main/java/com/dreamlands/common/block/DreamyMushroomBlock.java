package com.dreamlands.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;

public class DreamyMushroomBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);

    public DreamyMushroomBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter getter, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return SHAPE;
    }

    public void randomTick(@Nonnull BlockState state, @Nonnull ServerLevel level, @Nonnull BlockPos pos, RandomSource source) {
        if (source.nextInt(25) == 0) {
            int i = 5;
            for (BlockPos pos1 : BlockPos.betweenClosed(pos.offset(-4, -1, -4), pos.offset(4, 1, 4))) {
                if (level.getBlockState(pos1).is(this)) {
                    --i;
                    if (i <= 0) {
                        return;
                    }
                }
            }

            BlockPos pos1 = pos.offset(source.nextInt(3) - 1, source.nextInt(2) - source.nextInt(2), source.nextInt(3) - 1);
            for (int k = 0; k < 4; ++k) {
                if (level.isEmptyBlock(pos1) && state.canSurvive(level, pos1)) {
                    pos = pos1;
                }
                pos1 = pos.offset(source.nextInt(3) - 1, source.nextInt(2) - source.nextInt(2), source.nextInt(3) - 1);
            }

            if (level.isEmptyBlock(pos1) && state.canSurvive(level, pos1)) {
                level.setBlock(pos1, state, 2);
            }
        }

    }
    
    public boolean canSurvive(@Nonnull BlockState state, LevelReader reader, BlockPos pos) {
        BlockPos belowPos = pos.below();
        BlockState belowState = reader.getBlockState(belowPos);
        if (belowState.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return true;
        } else {
            return reader.getRawBrightness(pos, 0) < 13;
        }
    }

}