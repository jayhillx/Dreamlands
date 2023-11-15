package com.dreamlands.init;

import com.dreamlands.common.item.MarshmallowItem;
import com.dreamlands.Dreamlands;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DreamItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Dreamlands.modId);

    public static RegistryObject<Item> EVERGREEN_PLANKS = ITEMS.register("evergreen_planks", () -> new BlockItem(DreamBlocks.EVERGREEN_PLANKS.get(), new Item.Properties()));
    public static RegistryObject<Item> ETHEREAL_PLANKS = ITEMS.register("ethereal_planks", () -> new BlockItem(DreamBlocks.ETHEREAL_PLANKS.get(), new Item.Properties()));
    public static RegistryObject<Item> CANDY_PLANKS = ITEMS.register("candy_planks", () -> new BlockItem(DreamBlocks.CANDY_PLANKS.get(), new Item.Properties()));

    public static RegistryObject<Item> DREAMY_MUSHROOM = ITEMS.register("dreamy_mushroom", () -> new BlockItem(DreamBlocks.DREAMY_MUSHROOM.get(), new Item.Properties()));
    public static RegistryObject<Item> DREAMY_MUSHROOM_SOUP = ITEMS.register("dreamy_mushroom_soup", () -> new BowlFoodItem((new Item.Properties()).stacksTo(1).food(Foods.MUSHROOM_STEW)));

    public static RegistryObject<Item> MARSHMALLOW = ITEMS.register("marshmallow", MarshmallowItem::new);
    public static RegistryObject<Item> TOASTED_MARSHMALLOW = ITEMS.register("toasted_marshmallow", MarshmallowItem::new);
    public static RegistryObject<Item> BURNT_MARSHMALLOW = ITEMS.register("burnt_marshmallow", MarshmallowItem::new);

}