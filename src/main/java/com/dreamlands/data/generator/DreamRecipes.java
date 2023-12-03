package com.dreamlands.data.generator;

import com.dreamlands.Dreamlands;
import com.dreamlands.common.block.state.DreamBlockFamilies;
import com.dreamlands.data.generator.tag.DreamItemTags;
import com.dreamlands.init.DreamBlocks;
import com.dreamlands.init.DreamItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class DreamRecipes extends RecipeProvider {

    public DreamRecipes(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DreamItems.DREAMY_MUSHROOM_SOUP.get()).group("dreamy_mushroom_soup").requires(DreamItems.DREAMY_MUSHROOM.get()).requires(Items.BOWL).unlockedBy(getHasName(DreamItems.DREAMY_MUSHROOM.get()), has(DreamItems.DREAMY_MUSHROOM.get())).save(consumer, Dreamlands.modLoc("dreamy_mushroom_soup"));
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, DreamItems.MARSHMALLOW.get(), 1).define('#', Items.SUGAR).pattern("##").pattern("##").group("food").unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR)).save(consumer, DreamItems.MARSHMALLOW.getId());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DreamItems.MARSHMALLOW.get()).group("marshmallow_from_stick").requires(DreamItems.MARSHMALLOW_ON_A_STICK.get()).unlockedBy(getHasName(DreamItems.MARSHMALLOW.get()), has(DreamItems.MARSHMALLOW.get())).save(consumer, Dreamlands.modLoc("marshmallow_from_stick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DreamItems.TOASTED_MARSHMALLOW.get()).group("toasted_marshmallow_from_stick").requires(DreamItems.TOASTED_MARSHMALLOW_ON_A_STICK.get()).unlockedBy(getHasName(DreamItems.TOASTED_MARSHMALLOW.get()), has(DreamItems.TOASTED_MARSHMALLOW.get())).save(consumer, Dreamlands.modLoc("toasted_marshmallow_from_stick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DreamItems.BURNT_MARSHMALLOW.get()).group("burnt_marshmallow_from_stick").requires(DreamItems.BURNT_MARSHMALLOW_ON_A_STICK.get()).unlockedBy(getHasName(DreamItems.BURNT_MARSHMALLOW.get()), has(DreamItems.BURNT_MARSHMALLOW.get())).save(consumer, Dreamlands.modLoc("burnt_marshmallow_from_stick"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DreamItems.MARSHMALLOW_ON_A_STICK.get()).group("marshmallow_on_a_stick").requires(DreamItems.MARSHMALLOW.get()).requires(Items.STICK).unlockedBy(getHasName(DreamItems.MARSHMALLOW.get()), has(DreamItems.MARSHMALLOW.get())).save(consumer, DreamItems.MARSHMALLOW_ON_A_STICK.getId());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DreamItems.TOASTED_MARSHMALLOW_ON_A_STICK.get()).group("toasted_marshmallow_on_a_stick").requires(DreamItems.TOASTED_MARSHMALLOW.get()).requires(Items.STICK).unlockedBy(getHasName(DreamItems.TOASTED_MARSHMALLOW.get()), has(DreamItems.TOASTED_MARSHMALLOW.get())).save(consumer, DreamItems.TOASTED_MARSHMALLOW_ON_A_STICK.getId());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DreamItems.BURNT_MARSHMALLOW_ON_A_STICK.get()).group("burnt_marshmallow_on_a_stick").requires(DreamItems.BURNT_MARSHMALLOW.get()).requires(Items.STICK).unlockedBy(getHasName(DreamItems.BURNT_MARSHMALLOW.get()), has(DreamItems.BURNT_MARSHMALLOW.get())).save(consumer, DreamItems.BURNT_MARSHMALLOW_ON_A_STICK.getId());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DreamItems.SMORE.get()).group("smore").requires(DreamItems.TOASTED_MARSHMALLOW.get()).requires(Items.COCOA_BEANS).requires(Items.BREAD).unlockedBy(getHasName(DreamItems.TOASTED_MARSHMALLOW.get()), has(DreamItems.TOASTED_MARSHMALLOW.get())).save(consumer, DreamItems.SMORE.getId());

        woodFromLogs(consumer, DreamBlocks.EVERGREEN_WOOD.get(), DreamBlocks.EVERGREEN_LOG.get());
        woodFromLogs(consumer, DreamBlocks.STRIPPED_EVERGREEN_WOOD.get(), DreamBlocks.STRIPPED_EVERGREEN_LOG.get());
        planksFromLogs(consumer, DreamBlocks.EVERGREEN_PLANKS.get(), DreamItemTags.EVERGREEN_LOGS, 4);
        generateRecipes(consumer, DreamBlockFamilies.EVERGREEN_PLANKS);
        hangingSign(consumer, DreamItems.EVERGREEN_HANGING_SIGN.get(), DreamBlocks.STRIPPED_EVERGREEN_LOG.get());

        woodFromLogs(consumer, DreamBlocks.ETHEREAL_WOOD.get(), DreamBlocks.ETHEREAL_LOG.get());
        woodFromLogs(consumer, DreamBlocks.STRIPPED_ETHEREAL_WOOD.get(), DreamBlocks.STRIPPED_ETHEREAL_LOG.get());
        planksFromLogs(consumer, DreamBlocks.ETHEREAL_PLANKS.get(), DreamItemTags.ETHEREAL_LOGS, 4);
        generateRecipes(consumer, DreamBlockFamilies.ETHEREAL_PLANKS);
        hangingSign(consumer, DreamItems.ETHEREAL_HANGING_SIGN.get(), DreamBlocks.STRIPPED_ETHEREAL_LOG.get());

        woodFromLogs(consumer, DreamBlocks.CANDY_WOOD.get(), DreamBlocks.CANDY_LOG.get());
        woodFromLogs(consumer, DreamBlocks.STRIPPED_CANDY_WOOD.get(), DreamBlocks.STRIPPED_CANDY_LOG.get());
        planksFromLogs(consumer, DreamBlocks.CANDY_PLANKS.get(), DreamItemTags.CANDY_LOGS, 4);
        generateRecipes(consumer, DreamBlockFamilies.CANDY_PLANKS);
        hangingSign(consumer, DreamItems.CANDY_HANGING_SIGN.get(), DreamBlocks.STRIPPED_CANDY_LOG.get());
    }

}