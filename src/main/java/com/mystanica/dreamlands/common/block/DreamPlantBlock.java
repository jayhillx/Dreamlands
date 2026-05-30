package com.mystanica.dreamlands.common.block;

import com.mystanica.dreamlands.init.DreamBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DreamPlantBlock extends BushBlock implements BonemealableBlock {

    public DreamPlantBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Block.box(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean valid) {
        return this.getDoublePlant(state) != this;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return this.getDoublePlant(state) != this;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        BlockState blockState = this.getDoublePlant(state).defaultBlockState();

        if (blockState.canSurvive(level, pos) && level.isEmptyBlock(pos.above())) {
            DoublePlantBlock.placeAt(level, blockState, pos, 2);
        }
    }

    /**
     * @param state - determines the states matching tall block variant. (i.e. this state being dreamy fern, will return tall dreamy fern)
     * @return ------ default to self if it does not exist.
     */
    private Block getDoublePlant(BlockState state) {
        if (state.getBlock() == DreamBlocks.DREAMY_GRASS.get()) {
            return DreamBlocks.TALL_DREAMY_GRASS.get();
        }

        return this;
    }
    
}