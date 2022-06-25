package dev.sonnyjon.spring5recipe.converters;

import dev.sonnyjon.spring5recipe.commands.IngredientCommand;
import dev.sonnyjon.spring5recipe.model.Ingredient;
import dev.sonnyjon.spring5recipe.model.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by Sonny on 6/8/2022.
 */
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient>
{
    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter)
    {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source)
    {
        if (source == null) {return null;}

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUom(uomConverter.convert(source.getUom()));

        if (source.getRecipeId() != null)
        {
            Recipe recipe = new Recipe();
            recipe.setId(source.getRecipeId());
            ingredient.setRecipe(recipe);
            recipe.addIngredient(ingredient);
        }

        return ingredient;
    }
}
