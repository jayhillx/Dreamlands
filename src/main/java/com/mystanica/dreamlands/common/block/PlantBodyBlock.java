package com.mystanica.dreamlands.common.block;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Optional;

public abstract class PlantBodyBlock extends PlantWithWallPlantBlock implements BonemealableBlock {
    
    protected PlantBodyBlock(Properties properties, Direction placeDirection, VoxelShape shape) {
        super(properties, placeDirection, shape);
    }

    @Override
    protected Block getBodyBlock() {
        return this;
    }

    @Override
    protected Block getWallBlock() {
        return null;
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return new ItemStack(this.getHeadBlock());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (facing == this.placeDirection.getOpposite() && !state.canSurvive(level, currentPos)) {
            level.scheduleTick(currentPos, this, 1);
        }

        PlantHeadBlock headBlock = this.getHeadBlock();
        if (facing == this.placeDirection && !facingState.is(this) && !facingState.is(headBlock)) {
            return this.updateHeadAfterConvertedFromBody(state, headBlock.getStateForPlacement(level));
        } else {
            return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
        }
    }

    protected BlockState updateHeadAfterConvertedFromBody(BlockState head, BlockState body) {
        return body;
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        boolean flag = super.canBeReplaced(state, useContext);
        return (!flag || !useContext.getItemInHand().is(this.getHeadBlock().asItem())) && flag;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean valid) {
        Optional<BlockPos> optional = this.getHeadPos(level, pos, state.getBlock());
        return optional.isPresent() && this.getHeadBlock().canGrowInto(level.getBlockState(optional.get().relative(this.placeDirection)));
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        Optional<BlockPos> optional = this.getHeadPos(level, pos, state.getBlock());
        if (optional.isPresent()) {
            BlockState headState = level.getBlockState(optional.get());
            ((PlantHeadBlock)headState.getBlock()).performBonemeal(level, random, optional.get(), headState);
        }
    }

    private Optional<BlockPos> getHeadPos(BlockGetter level, BlockPos pos, Block block) {
        return BlockUtil.getTopConnectedBlock(level, pos, block, this.placeDirection, this.getHeadBlock());
    }
    
}