package com.mystanica.dreamlands.datagen.provider;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.datagen.DreamBlockFamilies;
import com.mystanica.dreamlands.datagen.DreamBlockFamily;
import com.mystanica.dreamlands.datagen.provider.tag.DreamItemTags;
import com.mystanica.dreamlands.init.*;
import com.google.common.collect.ImmutableMap;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class DreamRecipes extends RecipeProvider {
    private static final Map<DreamBlockFamily.Variant, BiFunction<ItemLike, ItemLike, RecipeBuilder>> SHAPE_BUILDERS = ImmutableMap.<DreamBlockFamily.Variant, BiFunction<ItemLike, ItemLike, RecipeBuilder>>builder()
            .put(DreamBlockFamily.Variant.STAIRS, (item, ingredient) -> stairBuilder(item, Ingredient.of(ingredient)))
            .put(DreamBlockFamily.Variant.SLAB, (item, ingredient) -> slabBuilder(RecipeCategory.BUILDING_BLOCKS, item, Ingredient.of(ingredient)))
            .put(DreamBlockFamily.Variant.FENCE, (item, ingredient) -> fenceBuilder(item, Ingredient.of(ingredient)))
            .put(DreamBlockFamily.Variant.FENCE_GATE, (item, ingredient) -> fenceGateBuilder(item, Ingredient.of(ingredient)))
            .put(DreamBlockFamily.Variant.BUTTON, (item, ingredient) -> buttonBuilder(item, Ingredient.of(ingredient)))
            .put(DreamBlockFamily.Variant.PRESSURE_PLATE, (item, ingredient) -> pressurePlateBuilder(RecipeCategory.REDSTONE, item, Ingredient.of(ingredient)))
            .put(DreamBlockFamily.Variant.TRAPDOOR, (item, ingredient) -> trapdoorBuilder(item, Ingredient.of(ingredient)))
            .put(DreamBlockFamily.Variant.DOOR, (item, ingredient) -> doorBuilder(item, Ingredient.of(ingredient)))
            .put(DreamBlockFamily.Variant.SIGN, (item, ingredient) -> signBuilder(item, Ingredient.of(ingredient)))
            .put(DreamBlockFamily.Variant.WALL, (item, ingredient) -> wallBuilder(RecipeCategory.DECORATIONS, item, Ingredient.of(ingredient)))
            .put(DreamBlockFamily.Variant.POLISHED, (item, ingredient) -> polishedBuilder(RecipeCategory.BUILDING_BLOCKS, item, Ingredient.of(ingredient)))
            .put(DreamBlockFamily.Variant.CHISELED, (item, ingredient) -> chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, item, Ingredient.of(ingredient)))
            .put(DreamBlockFamily.Variant.CUT, (item, ingredient) -> cutBuilder(RecipeCategory.BUILDING_BLOCKS, item, Ingredient.of(ingredient)))
            .build();

    public DreamRecipes(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@Nonnull Consumer<FinishedRecipe> output) {
        DreamBlockFamilies.getAllFamilies().filter(DreamBlockFamily::shouldGenerateRecipe).forEach(family -> generateFor(output, family));
        mossyBlockFromMossAndBase(output, DreamBlocks.MOSSY_COBBLED_DREAMSTONE.get(), DreamBlocks.COBBLED_DREAMSTONE.get(), DreamBlocks.FOREST_MOSS_BLOCK.get());
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DreamBlocks.MOSSY_COBBLED_DREAMSTONE_STAIRS.get(), DreamBlocks.MOSSY_COBBLED_DREAMSTONE.get());
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DreamBlocks.MOSSY_COBBLED_DREAMSTONE_SLAB.get(), DreamBlocks.MOSSY_COBBLED_DREAMSTONE.get(), 2);
        stonecutterResultFromBase(output, RecipeCategory.DECORATIONS, DreamBlocks.MOSSY_COBBLED_DREAMSTONE_WALL.get(), DreamBlocks.MOSSY_COBBLED_DREAMSTONE.get());
        mossyBlockFromMossAndBase(output, DreamBlocks.MOSSY_DREAMSTONE_BRICKS.get(), DreamBlocks.DREAMSTONE_BRICKS.get(), DreamBlocks.FOREST_MOSS_BLOCK.get());
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DreamBlocks.MOSSY_DREAMSTONE_BRICK_STAIRS.get(), DreamBlocks.MOSSY_DREAMSTONE_BRICKS.get());
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, DreamBlocks.MOSSY_DREAMSTONE_BRICK_SLAB.get(), DreamBlocks.MOSSY_DREAMSTONE_BRICKS.get(), 2);
        stonecutterResultFromBase(output, RecipeCategory.DECORATIONS, DreamBlocks.MOSSY_DREAMSTONE_BRICK_WALL.get(), DreamBlocks.MOSSY_DREAMSTONE_BRICKS.get());

        planksFromLogs(output, DreamBlocks.DREAMY_PLANKS.get(), DreamItemTags.DREAMY_LOGS);
        planksFromLogs(output, DreamBlocks.EVERGREEN_PLANKS.get(), DreamItemTags.EVERGREEN_LOGS);
        planksFromLogs(output, DreamBlocks.ETHEREAL_PLANKS.get(), DreamItemTags.ETHEREAL_LOGS);
        planksFromLogs(output, DreamBlocks.CANDY_PLANKS.get(), DreamItemTags.CANDY_LOGS);
        planksFromLogs(output, DreamBlocks.WISTERIA_PLANKS.get(), DreamItemTags.WISTERIA_LOGS);
        planksFromLogs(output, DreamBlocks.MYSTICAL_PLANKS.get(), DreamItemTags.MYSTICAL_LOGS);
        planksFromLogs(output, DreamBlocks.MUSHROOM_PLANKS.get(), DreamItemTags.MUSHROOM_STEMS);

        woodenBoat(output, DreamItems.DREAMY_BOAT.get(), DreamBlocks.DREAMY_PLANKS.get());
        woodenBoat(output, DreamItems.EVERGREEN_BOAT.get(), DreamBlocks.EVERGREEN_PLANKS.get());
        woodenBoat(output, DreamItems.ETHEREAL_BOAT.get(), DreamBlocks.ETHEREAL_PLANKS.get());
        woodenBoat(output, DreamItems.CANDY_BOAT.get(), DreamBlocks.CANDY_PLANKS.get());
        woodenBoat(output, DreamItems.WISTERIA_BOAT.get(), DreamBlocks.WISTERIA_PLANKS.get());
        woodenBoat(output, DreamItems.MYSTICAL_BOAT.get(), DreamBlocks.MYSTICAL_PLANKS.get());
        woodenBoat(output, DreamItems.MUSHROOM_BOAT.get(), DreamBlocks.MUSHROOM_PLANKS.get());

        chestBoat(output, DreamItems.DREAMY_CHEST_BOAT.get(), DreamItems.DREAMY_BOAT.get());
        chestBoat(output, DreamItems.EVERGREEN_CHEST_BOAT.get(), DreamItems.EVERGREEN_BOAT.get());
        chestBoat(output, DreamItems.ETHEREAL_CHEST_BOAT.get(), DreamItems.ETHEREAL_BOAT.get());
        chestBoat(output, DreamItems.CANDY_CHEST_BOAT.get(), DreamItems.CANDY_BOAT.get());
        chestBoat(output, DreamItems.WISTERIA_CHEST_BOAT.get(), DreamItems.WISTERIA_BOAT.get());
        chestBoat(output, DreamItems.MYSTICAL_CHEST_BOAT.get(), DreamItems.MYSTICAL_BOAT.get());
        chestBoat(output, DreamItems.MUSHROOM_CHEST_BOAT.get(), DreamItems.MUSHROOM_BOAT.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DreamItems.DREAMY_MUSHROOM_SOUP.get())
                .group("dreamy_mushroom_soup")
                .requires(DreamBlocks.DREAMY_MUSHROOM.get())
                .requires(Items.BOWL)
                .unlockedBy(getHasName(DreamBlocks.DREAMY_MUSHROOM.get()), has(DreamBlocks.DREAMY_MUSHROOM.get()))
                .save(output, Dreamlands.modLoc("dreamy_mushroom_soup"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, DreamItems.MARSHMALLOW.get(), 1)
                .define('#', Items.SUGAR)
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .save(output, Dreamlands.modLoc("marshmallow"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DreamItems.SMORE.get())
                .requires(Items.BREAD)
                .requires(DreamItems.MARSHMALLOW.get())
                .requires(Items.COCOA_BEANS)
                .unlockedBy(getHasName(DreamItems.MARSHMALLOW.get()), has(DreamItems.MARSHMALLOW.get()))
                .save(output, Dreamlands.modLoc("smore"));
    }
    
    private static void generateFor(Consumer<FinishedRecipe> output, DreamBlockFamily family) {
        family.getVariants().forEach((variant, block) -> {
            ItemLike baseBlock = getBaseBlock(family, variant);
            ItemLike source = family.get(variant.source());
            switch (variant) {
                case WOOD, STRIPPED_WOOD -> woodFromLogs(output, block, source);
                case HANGING_SIGN -> hangingSign(output, block, source);
                case CRACKED -> smeltingResultFromBase(output, block, baseBlock);
            }

            BiFunction<ItemLike, ItemLike, RecipeBuilder> function = SHAPE_BUILDERS.get(variant);
            if (function != null) {
                RecipeBuilder builder = function.apply(block, baseBlock);
                family.getRecipeGroupPrefix().ifPresent(group -> {
                    if (variant != DreamBlockFamily.Variant.CUT) {
                        builder.group(group + "_" + variant.getRecipeGroup());
                    }
                });
                builder.unlockedBy(family.getRecipeUnlockedBy().orElseGet(() -> getHasName(baseBlock)), has(baseBlock));
                builder.save(output);
            }
        });
    }

    private static Block getBaseBlock(DreamBlockFamily family, DreamBlockFamily.Variant variant) {
        if (variant == DreamBlockFamily.Variant.CHISELED) {
            if (!family.getVariants().containsKey(DreamBlockFamily.Variant.SLAB)) {
                throw new IllegalStateException("Slab is not defined for the family.");
            } else {
                return family.get(DreamBlockFamily.Variant.SLAB);
            }
        } else {
            return family.getBaseBlock();
        }
    }

    protected static void planksFromLogs(Consumer<FinishedRecipe> output, Block block, TagKey<Item> tag) {
        planksFromLogs(output, block, tag, 4);
    }

    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> recipeOutput, RecipeCategory category, ItemLike result, ItemLike material) {
        stonecutterResultFromBase(recipeOutput, category, result, material, 1);
    }

    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> output, RecipeCategory category, ItemLike result, ItemLike material, int resultCount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(material), category, result, resultCount)
                .unlockedBy(getHasName(material), has(material))
                .save(output, Dreamlands.modLoc(getConversionRecipeName(result, material) + "_stonecutting"));
    }

    protected static void mossyBlockFromMossAndBase(Consumer<FinishedRecipe> output, Block resultBlock, Block baseBlock, Block mossBlock) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, resultBlock)
                .requires(baseBlock)
                .requires(mossBlock)
                .group(getItemName(baseBlock))
                .unlockedBy("has_" + getItemName(mossBlock), has(mossBlock))
                .save(output, Dreamlands.modLoc(getConversionRecipeName(resultBlock, mossBlock)));
    }

}