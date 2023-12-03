package com.dreamlands.init;

import com.dreamlands.common.item.MarshmallowItem;
import com.dreamlands.Dreamlands;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DreamItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Dreamlands.modId);

    public static final RegistryObject<Item> MARSHMALLOW = ITEMS.register("marshmallow", MarshmallowItem::new);
    public static final RegistryObject<Item> MARSHMALLOW_ON_A_STICK = ITEMS.register("marshmallow_on_a_stick", () -> new Item(new Item.Properties().stacksTo(1).craftRemainder(Items.STICK)));
    public static final RegistryObject<Item> TOASTED_MARSHMALLOW = ITEMS.register("toasted_marshmallow", MarshmallowItem::new);
    public static final RegistryObject<Item> TOASTED_MARSHMALLOW_ON_A_STICK = ITEMS.register("toasted_marshmallow_on_a_stick", () -> new Item(new Item.Properties().stacksTo(1).craftRemainder(Items.STICK)));
    public static final RegistryObject<Item> BURNT_MARSHMALLOW = ITEMS.register("burnt_marshmallow", MarshmallowItem::new);
    public static final RegistryObject<Item> BURNT_MARSHMALLOW_ON_A_STICK = ITEMS.register("burnt_marshmallow_on_a_stick", () -> new Item(new Item.Properties().stacksTo(1).craftRemainder(Items.STICK)));
    public static final RegistryObject<Item> SMORE = ITEMS.register("smore", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.5F).build())));

    public static final RegistryObject<Item> DREAMY_MUSHROOM = ITEMS.register("dreamy_mushroom", () -> new BlockItem(DreamBlocks.DREAMY_MUSHROOM.get(), new Item.Properties()));
    public static final RegistryObject<Item> DREAMY_MUSHROOM_SOUP = ITEMS.register("dreamy_mushroom_soup", () -> new BowlFoodItem((new Item.Properties()).stacksTo(1).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).alwaysEat().build())));

    public static final RegistryObject<Item> EVERGREEN_LOG = ITEMS.register("evergreen_log", () -> new BlockItem(DreamBlocks.EVERGREEN_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_EVERGREEN_LOG = ITEMS.register("stripped_evergreen_log", () -> new BlockItem(DreamBlocks.STRIPPED_EVERGREEN_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> EVERGREEN_WOOD = ITEMS.register("evergreen_wood", () -> new BlockItem(DreamBlocks.EVERGREEN_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_EVERGREEN_WOOD = ITEMS.register("stripped_evergreen_wood", () -> new BlockItem(DreamBlocks.STRIPPED_EVERGREEN_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> EVERGREEN_PLANKS = ITEMS.register("evergreen_planks", () -> new BlockItem(DreamBlocks.EVERGREEN_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> EVERGREEN_STAIRS = ITEMS.register("evergreen_stairs", () -> new BlockItem(DreamBlocks.EVERGREEN_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> EVERGREEN_SLAB = ITEMS.register("evergreen_slab", () -> new BlockItem(DreamBlocks.EVERGREEN_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> EVERGREEN_FENCE = ITEMS.register("evergreen_fence", () -> new BlockItem(DreamBlocks.EVERGREEN_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> EVERGREEN_FENCE_GATE = ITEMS.register("evergreen_fence_gate", () -> new BlockItem(DreamBlocks.EVERGREEN_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> EVERGREEN_BUTTON = ITEMS.register("evergreen_button", () -> new BlockItem(DreamBlocks.EVERGREEN_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> EVERGREEN_PRESSURE_PLATE = ITEMS.register("evergreen_pressure_plate", () -> new BlockItem(DreamBlocks.EVERGREEN_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> EVERGREEN_TRAPDOOR = ITEMS.register("evergreen_trapdoor", () -> new BlockItem(DreamBlocks.EVERGREEN_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> EVERGREEN_DOOR = ITEMS.register("evergreen_door", () -> new BlockItem(DreamBlocks.EVERGREEN_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> EVERGREEN_SIGN = ITEMS.register("evergreen_sign", () -> new SignItem(new Item.Properties().stacksTo(16), DreamBlocks.EVERGREEN_SIGN.get(), DreamBlocks.EVERGREEN_WALL_SIGN.get()));
    public static final RegistryObject<Item> EVERGREEN_HANGING_SIGN = ITEMS.register("evergreen_hanging_sign", () -> new HangingSignItem(DreamBlocks.EVERGREEN_HANGING_SIGN.get(), DreamBlocks.EVERGREEN_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> ETHEREAL_LOG = ITEMS.register("ethereal_log", () -> new BlockItem(DreamBlocks.ETHEREAL_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_ETHEREAL_LOG = ITEMS.register("stripped_ethereal_log", () -> new BlockItem(DreamBlocks.STRIPPED_ETHEREAL_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> ETHEREAL_WOOD = ITEMS.register("ethereal_wood", () -> new BlockItem(DreamBlocks.ETHEREAL_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_ETHEREAL_WOOD = ITEMS.register("stripped_ethereal_wood", () -> new BlockItem(DreamBlocks.STRIPPED_ETHEREAL_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> ETHEREAL_PLANKS = ITEMS.register("ethereal_planks", () -> new BlockItem(DreamBlocks.ETHEREAL_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ETHEREAL_STAIRS = ITEMS.register("ethereal_stairs", () -> new BlockItem(DreamBlocks.ETHEREAL_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ETHEREAL_SLAB = ITEMS.register("ethereal_slab", () -> new BlockItem(DreamBlocks.ETHEREAL_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> ETHEREAL_FENCE = ITEMS.register("ethereal_fence", () -> new BlockItem(DreamBlocks.ETHEREAL_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ETHEREAL_FENCE_GATE = ITEMS.register("ethereal_fence_gate", () -> new BlockItem(DreamBlocks.ETHEREAL_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ETHEREAL_BUTTON = ITEMS.register("ethereal_button", () -> new BlockItem(DreamBlocks.ETHEREAL_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> ETHEREAL_PRESSURE_PLATE = ITEMS.register("ethereal_pressure_plate", () -> new BlockItem(DreamBlocks.ETHEREAL_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ETHEREAL_TRAPDOOR = ITEMS.register("ethereal_trapdoor", () -> new BlockItem(DreamBlocks.ETHEREAL_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> ETHEREAL_DOOR = ITEMS.register("ethereal_door", () -> new BlockItem(DreamBlocks.ETHEREAL_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> ETHEREAL_SIGN = ITEMS.register("ethereal_sign", () -> new SignItem(new Item.Properties().stacksTo(16), DreamBlocks.ETHEREAL_SIGN.get(), DreamBlocks.ETHEREAL_WALL_SIGN.get()));
    public static final RegistryObject<Item> ETHEREAL_HANGING_SIGN = ITEMS.register("ethereal_hanging_sign", () -> new HangingSignItem(DreamBlocks.ETHEREAL_HANGING_SIGN.get(), DreamBlocks.ETHEREAL_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> CANDY_LOG = ITEMS.register("candy_log", () -> new BlockItem(DreamBlocks.CANDY_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_CANDY_LOG = ITEMS.register("stripped_candy_log", () -> new BlockItem(DreamBlocks.STRIPPED_CANDY_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> CANDY_WOOD = ITEMS.register("candy_wood", () -> new BlockItem(DreamBlocks.CANDY_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_CANDY_WOOD = ITEMS.register("stripped_candy_wood", () -> new BlockItem(DreamBlocks.STRIPPED_CANDY_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> CANDY_PLANKS = ITEMS.register("candy_planks", () -> new BlockItem(DreamBlocks.CANDY_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> CANDY_STAIRS = ITEMS.register("candy_stairs", () -> new BlockItem(DreamBlocks.CANDY_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> CANDY_SLAB = ITEMS.register("candy_slab", () -> new BlockItem(DreamBlocks.CANDY_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> CANDY_FENCE = ITEMS.register("candy_fence", () -> new BlockItem(DreamBlocks.CANDY_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> CANDY_FENCE_GATE = ITEMS.register("candy_fence_gate", () -> new BlockItem(DreamBlocks.CANDY_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> CANDY_BUTTON = ITEMS.register("candy_button", () -> new BlockItem(DreamBlocks.CANDY_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> CANDY_PRESSURE_PLATE = ITEMS.register("candy_pressure_plate", () -> new BlockItem(DreamBlocks.CANDY_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> CANDY_TRAPDOOR = ITEMS.register("candy_trapdoor", () -> new BlockItem(DreamBlocks.CANDY_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> CANDY_DOOR = ITEMS.register("candy_door", () -> new BlockItem(DreamBlocks.CANDY_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> CANDY_SIGN = ITEMS.register("candy_sign", () -> new SignItem(new Item.Properties().stacksTo(16), DreamBlocks.CANDY_SIGN.get(), DreamBlocks.CANDY_WALL_SIGN.get()));
    public static final RegistryObject<Item> CANDY_HANGING_SIGN = ITEMS.register("candy_hanging_sign", () -> new HangingSignItem(DreamBlocks.CANDY_HANGING_SIGN.get(), DreamBlocks.CANDY_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

}