package com.dreamlands.datagen.generator;

import com.dreamlands.Dreamlands;
import com.dreamlands.init.DreamItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class DreamRecipes extends RecipeProvider {

    public DreamRecipes(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DreamItems.DREAMY_MUSHROOM_SOUP.get())
                .group("dreamy_mushroom_soup")
                .requires(DreamItems.DREAMY_MUSHROOM.get())
                .requires(Items.BOWL)
                .unlockedBy(getHasName(DreamItems.DREAMY_MUSHROOM.get()), has(DreamItems.DREAMY_MUSHROOM.get()))
                .save(consumer, Dreamlands.modLoc("dreamy_mushroom_soup"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DreamItems.MARSHMALLOW_ON_A_STICK.get())
                .group("marshmallow_on_a_stick")
                .requires(DreamItems.MARSHMALLOW.get())
                .requires(Items.STICK)
                .unlockedBy(getHasName(DreamItems.MARSHMALLOW.get()), has(DreamItems.MARSHMALLOW.get()))
                .save(consumer, Dreamlands.modLoc("marshmallow_on_a_stick"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DreamItems.MARSHMALLOW.get())
                .group("marshmallow_from_stick")
                .requires(DreamItems.MARSHMALLOW_ON_A_STICK.get())
                .unlockedBy(getHasName(DreamItems.MARSHMALLOW_ON_A_STICK.get()), has(DreamItems.MARSHMALLOW_ON_A_STICK.get()))
                .save(consumer, Dreamlands.modLoc("marshmallow_from_stick"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, DreamItems.MARSHMALLOW.get())
                .group("marshmallow")
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .save(consumer, Dreamlands.modLoc("marshmallow"));
    }

}