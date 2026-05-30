package com.mystanica.dreamlands.common.block;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.Tags;

/**
 * Inverts the flowering leaves function, and adds the ability to snip the bottom leaves to become flowerless.
 */
public class FloweringBushLeavesBlock extends FloweringLeavesBlock {
    public static final BooleanProperty SNIPPED = BooleanProperty.create("snipped");

    public FloweringBushLeavesBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(SNIPPED, false));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState updatedState = super.getStateForPlacement(context);

        BlockState belowState = context.getLevel().getBlockState(context.getClickedPos().below());
        if (updatedState != null) {
            updatedState = updatedState.setValue(FLOWERING, belowState.is(this) && !belowState.getValue(SNIPPED));
        }
        return updatedState;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos pos, BlockPos facingPos) {
        BlockState updatedState = super.updateShape(state, facing, facingState, level, pos, facingPos);

        BlockState belowState = level.getBlockState(pos.below());
        return updatedState.setValue(FLOWERING, belowState.is(this) && !belowState.getValue(SNIPPED));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack stack = player.getItemInHand(hand);

        if (!state.getValue(SNIPPED) && level.getBlockState(pos.above()).is(this)) {
            if (stack.is(Tags.Items.SHEARS) || stack.is(Items.SHEARS)) {
                stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));

                if (player instanceof ServerPlayer serverPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, stack);
                }

                level.setBlock(pos, state.setValue(SNIPPED, true), 1 | 2);
                level.playSound(player, pos, SoundEvents.GROWING_PLANT_CROP, SoundSource.BLOCKS, 1.0F, 1.0F);
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(SNIPPED);
    }

}