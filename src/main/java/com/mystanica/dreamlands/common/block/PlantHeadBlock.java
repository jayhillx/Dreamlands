package com.mystanica.dreamlands.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class PlantHeadBlock extends PlantWithWallPlantBlock implements BonemealableBlock {

    protected PlantHeadBlock(Properties properties, Direction placeDirection, VoxelShape shape) {
        super(properties, placeDirection, shape);
    }

    @Override
    protected PlantHeadBlock getHeadBlock() {
        return this;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (facing == this.placeDirection.getOpposite() && !state.canSurvive(level, currentPos)) {
            level.scheduleTick(currentPos, this, 1);
        }

        if (facing != this.placeDirection || !facingState.is(this) && !facingState.is(this.getBodyBlock())) {
            return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
        } else {
            return this.updateBodyAfterConvertedFromHead(this.getBodyBlock().defaultBlockState());
        }
    }

    protected BlockState updateBodyAfterConvertedFromHead(BlockState body) {
        return body;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean valid) {
        return this.canGrowInto(level.getBlockState(pos.relative(this.placeDirection)));
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos relativePos = pos.relative(this.placeDirection);

        for (int k = 0; k < this.getBlocksToGrowWhenBonemealed(random) && this.canGrowInto(level.getBlockState(relativePos)); k++) {
            level.setBlockAndUpdate(relativePos, state);
            relativePos = relativePos.relative(this.placeDirection);
        }
    }

    protected abstract boolean canGrowInto(BlockState state);

    protected abstract int getBlocksToGrowWhenBonemealed(RandomSource random);

}