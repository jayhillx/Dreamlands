package com.dreamlands.common.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

/**
 * Marshmallows can be put on sticks, and be toasted on campfires.
 */
public class MarshmallowItem extends Item {

    public MarshmallowItem() {
        super(new Properties().food(new FoodProperties.Builder().fast().nutrition(1).saturationMod(0.1F).build()));
    }

}