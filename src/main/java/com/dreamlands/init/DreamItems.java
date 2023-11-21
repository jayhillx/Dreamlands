package com.dreamlands.init;

import com.dreamlands.common.item.MarshmallowItem;
import com.dreamlands.Dreamlands;
import com.dreamlands.common.item.MarshmallowOnStickItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DreamItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Dreamlands.modId);

    // CAMPING
    public static RegistryObject<Item> MARSHMALLOW = ITEMS.register("marshmallow", MarshmallowItem::new);
    public static RegistryObject<Item> MARSHMALLOW_ON_A_STICK = ITEMS.register("marshmallow_on_a_stick", MarshmallowOnStickItem::new);
    public static RegistryObject<Item> TOASTED_MARSHMALLOW = ITEMS.register("toasted_marshmallow", MarshmallowItem::new);
    public static RegistryObject<Item> TOASTED_MARSHMALLOW_ON_A_STICK = ITEMS.register("toasted_marshmallow_on_a_stick", MarshmallowOnStickItem::new);
    public static RegistryObject<Item> BURNT_MARSHMALLOW = ITEMS.register("burnt_marshmallow", MarshmallowItem::new);
    public static RegistryObject<Item> BURNT_MARSHMALLOW_ON_A_STICK = ITEMS.register("burnt_marshmallow_on_a_stick", MarshmallowOnStickItem::new);

    public static RegistryObject<Item> SMORE = ITEMS.register("smore", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.5F).build())));

    public static RegistryObject<Item> DREAMY_MUSHROOM = ITEMS.register("dreamy_mushroom", () -> new BlockItem(DreamBlocks.DREAMY_MUSHROOM.get(), new Item.Properties()));
    public static RegistryObject<Item> DREAMY_MUSHROOM_SOUP = ITEMS.register("dreamy_mushroom_soup", () -> new BowlFoodItem((new Item.Properties()).stacksTo(1).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).alwaysEat().build())));

    // DREAMLAND
    public static RegistryObject<Item> EVERGREEN_PLANKS = ITEMS.register("evergreen_planks", () -> new BlockItem(DreamBlocks.EVERGREEN_PLANKS.get(), new Item.Properties()));
    public static RegistryObject<Item> ETHEREAL_PLANKS = ITEMS.register("ethereal_planks", () -> new BlockItem(DreamBlocks.ETHEREAL_PLANKS.get(), new Item.Properties()));
    public static RegistryObject<Item> CANDY_PLANKS = ITEMS.register("candy_planks", () -> new BlockItem(DreamBlocks.CANDY_PLANKS.get(), new Item.Properties()));

    // NIGHTMOOR
    public static RegistryObject<Item> EBONY_PLANKS = ITEMS.register("ebony_planks", () -> new BlockItem(DreamBlocks.EBONY_PLANKS.get(), new Item.Properties()));
    public static RegistryObject<Item> DEAD_PLANKS = ITEMS.register("dead_planks", () -> new BlockItem(DreamBlocks.DEAD_PLANKS.get(), new Item.Properties()));
    public static RegistryObject<Item> BLOODWOOD_PLANKS = ITEMS.register("bloodwood_planks", () -> new BlockItem(DreamBlocks.BLOODWOOD_PLANKS.get(), new Item.Properties()));

}