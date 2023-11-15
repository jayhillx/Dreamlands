package com.dreamlands.common.util;

import com.dreamlands.Dreamlands;
import com.dreamlands.init.DreamItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class ItemPropertiesUtils {

    private static int getMarshmallowCondition(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (tag != null) {
            return tag.getInt("Condition");
        } else {
            return 0;
        }
    }

    public static void registerItemProperties() {
        ItemProperties.register(DreamItems.MARSHMALLOW_ON_A_STICK.get(), Dreamlands.modLoc("condition"), (stack, level, entity, id) -> getMarshmallowCondition(stack));
    }

}