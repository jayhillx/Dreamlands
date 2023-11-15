package com.dreamlands.common.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

/**
 * Marshmallows can be put on sticks and toasted on campfires.
 */
public class MarshmallowItem extends Item {

    public MarshmallowItem(int nutrition, float saturation) {
        super(new Properties().food(new FoodProperties.Builder().fast().nutrition(nutrition).saturationMod(saturation).build()));
    }

}