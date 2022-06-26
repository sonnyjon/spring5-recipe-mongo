package dev.sonnyjon.spring5recipe.services;

import dev.sonnyjon.spring5recipe.commands.IngredientCommand;

/**
 * Created by Sonny on 6/10/2022.
 */
public interface IngredientService
{
    IngredientCommand findByRecipeIdAndIngredientId(String recipeId, String ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteById(String recipeId, String idToDelete);
}