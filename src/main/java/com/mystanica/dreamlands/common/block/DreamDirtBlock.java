package com.mystanica.dreamlands.common.block;

import com.mystanica.dreamlands.init.DreamBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;
import net.minecraft.world.phys.BlockHitResult;

public class DreamDirtBlock extends Block {

    public DreamDirtBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack stack = player.getItemInHand(hand);
        if (player.mayUseItemAt(pos, player.getDirection(), stack)) {
            if (stack.getItem() instanceof HoeItem) {
                if (!level.isClientSide) {
                    stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));
                }

                level.playSound(player, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                ///level.setBlockAndUpdate(pos, DreamBlocks.DREAMY_SOIL.get().defaultBlockState());
                return InteractionResult.SUCCESS;
            }

            if (stack.getItem() instanceof ShovelItem) {
                if (!level.isClientSide) {
                    stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));
                }

                level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.setBlockAndUpdate(pos, DreamBlocks.DREAMY_DIRT_PATH.get().defaultBlockState());
                return InteractionResult.SUCCESS;
            }
        }

        return super.use(state, level, pos, player, hand, hitResult);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!canBeGrass(state, level, pos)) {
            if (!level.isAreaLoaded(pos, 1)) return;
            level.setBlockAndUpdate(pos, DreamBlocks.DREAMY_DIRT.get().defaultBlockState());
        } else {
            if (!level.isAreaLoaded(pos, 3)) return;
            if (level.getMaxLocalRawBrightness(pos.above()) >= 9) {
                for (int i = 0; i < 4; i++) {
                    BlockPos offsetPos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if (level.getBlockState(offsetPos).is(DreamBlocks.DREAMY_DIRT.get()) && canPropagate(this.defaultBlockState(), level, offsetPos)) {
                        level.setBlockAndUpdate(offsetPos, this.defaultBlockState());
                    }
                }
            }
        }
    }

    private static boolean canPropagate(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos abovePos = pos.above();
        return canBeGrass(state, level, pos) && !level.getFluidState(abovePos).is(FluidTags.WATER);
    }

    private static boolean canBeGrass(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos abovePos = pos.above();
        BlockState aboveState = level.getBlockState(abovePos);
        if (aboveState.getFluidState().getAmount() == 8) {
            return false;
        } else {
            int i = LightEngine.getLightBlockInto(level, state, pos, aboveState, abovePos, Direction.UP, aboveState.getLightBlock(level, abovePos));
            return i < level.getMaxLightLevel();
        }
    }

}