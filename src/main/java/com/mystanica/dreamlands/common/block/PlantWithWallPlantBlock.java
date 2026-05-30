package com.mystanica.dreamlands.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public abstract class PlantWithWallPlantBlock extends Block implements BonemealableBlock {
    protected final Direction placeDirection;
    protected final VoxelShape shape;

    protected PlantWithWallPlantBlock(Properties properties, Direction placeDirection, VoxelShape shape) {
        super(properties);
        this.placeDirection = placeDirection;
        this.shape = shape;
    }

    protected abstract PlantHeadBlock getHeadBlock();

    protected abstract Block getBodyBlock();

    @Nullable
    protected abstract Block getWallBlock();

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return this.shape;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState relativeState = context.getLevel().getBlockState(context.getClickedPos().relative(this.placeDirection));

        return !relativeState.is(this.getHeadBlock()) && !relativeState.is(this.getBodyBlock())
                ? this.getStateForPlacement(context.getLevel())
                : this.getBodyBlock().defaultBlockState();
    }

    public BlockState getStateForPlacement(LevelAccessor level) {
        return this.defaultBlockState();
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos relativePos = pos.relative(this.placeDirection.getOpposite());
        BlockState relativeState = level.getBlockState(relativePos);

        if (this.canPlace(relativeState)) {
            return relativeState.is(this.getHeadBlock()) || relativeState.is(this.getBodyBlock()) || relativeState.isFaceSturdy(level, relativePos, this.placeDirection);
        } else {
            return false;
        }
    }

    protected boolean canPlace(BlockState state) {
        return true;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.canSurvive(level, pos)) {
            level.destroyBlock(pos, true);
        }
    }

}