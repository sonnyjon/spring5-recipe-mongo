package dev.sonnyjon.spring5recipe.converters;

import dev.sonnyjon.spring5recipe.commands.IngredientCommand;
import dev.sonnyjon.spring5recipe.model.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by Sonny on 6/8/2022.
 */
@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand>
{
    private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter)
    {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient ingredient)
    {
        if (ingredient == null) return null;

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ingredient.getId());
        ingredientCommand.setAmount(ingredient.getAmount());
        ingredientCommand.setDescription(ingredient.getDescription());
        ingredientCommand.setUom(uomConverter.convert(ingredient.getUom()));

        if (ingredient.getRecipe() != null) ingredientCommand.setRecipeId(ingredient.getRecipe().getId());

        return ingredientCommand;
    }
}
