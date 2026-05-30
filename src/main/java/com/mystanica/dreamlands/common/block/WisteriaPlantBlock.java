package com.mystanica.dreamlands.common.block;

import com.mystanica.dreamlands.init.DreamBlocks;
import com.mystanica.dreamlands.init.DreamItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.HitResult;

public class WisteriaPlantBlock extends PlantBodyBlock implements BonemealableBlock, Wisteria {

    public WisteriaPlantBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE);
        this.registerDefaultState(this.stateDefinition.any().setValue(LEAFY, true));
    }

    @Override
    protected PlantHeadBlock getHeadBlock() {
        return (WisteriaBlock) DreamBlocks.WISTERIA.get();
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return new ItemStack(DreamItems.WISTERIA.get());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos pos, BlockPos facingPos) {
        BlockState updatedState = super.updateShape(state, facing, facingState, level, pos, facingPos);
        BlockState aboveState = level.getBlockState(pos.above());
        if (aboveState.is(DreamBlocks.WISTERIA_BLOSSOMS.get()) || aboveState.is(this)) {
            return updatedState.setValue(LEAFY, false);
        }

        return updatedState;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState aboveState = level.getBlockState(pos.above());
        return aboveState.is(BlockTags.LEAVES) || aboveState.getBlock() instanceof Wisteria || super.canSurvive(state, level, pos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LEAFY);
    }

}