package com.dreamlands.common.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class MarshmallowOnStickItem extends Item {

    public MarshmallowOnStickItem(Properties properties) {
        super(properties);
    }

    @Nonnull
    public Component getName(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (tag != null) {
            int stage = tag.getInt("Condition");
            if (stage == 1) {
                return Component.translatable("item.dreamlands.toasted_marshmallow_on_a_stick");
            } else if (stage == 2) {
                return Component.translatable("item.dreamlands.burnt_marshmallow_on_a_stick");
            } else {
                return Component.translatable("item.dreamlands.marshmallow_on_a_stick");
            }
        } else {
            return Component.translatable("item.dreamlands.marshmallow_on_a_stick");
        }
    }

}