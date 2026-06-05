package com.mystanica.dreamlands.common.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public interface StackableBlock {
    IntegerProperty AMOUNT = IntegerProperty.create("amount", 1, 3);

    /**
     * @param useItem - will need to be the block being placed on. like 'this'.
     */
    static boolean canBeReplaced(BlockState state, BlockPlaceContext context, Item useItem) {
        return !context.isSecondaryUseActive() && context.getItemInHand().is(useItem) && state.getValue(AMOUNT) < 3;
    }

}