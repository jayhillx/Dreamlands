package com.dreamlands.common.item;

import net.minecraft.world.item.*;

public class MarshmallowOnStickItem extends Item {

    public MarshmallowOnStickItem() {
        super(new Item.Properties().stacksTo(1).craftRemainder(Items.STICK));
    }

}