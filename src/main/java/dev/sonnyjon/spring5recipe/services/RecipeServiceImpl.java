package dev.sonnyjon.spring5recipe.services;

import dev.sonnyjon.spring5recipe.commands.RecipeCommand;
import dev.sonnyjon.spring5recipe.converters.RecipeCommandToRecipe;
import dev.sonnyjon.spring5recipe.converters.RecipeToRecipeCommand;
import dev.sonnyjon.spring5recipe.exceptions.NotFoundException;
import dev.sonnyjon.spring5recipe.model.Recipe;
import dev.sonnyjon.spring5recipe.repos.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Sonny on 5/31/2022.
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService
{
    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository,
                             RecipeCommandToRecipe recipeCommandToRecipe,
                             RecipeToRecipeCommand recipeToRecipeCommand)
    {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes()
    {
        log.debug("I'm in the service");

        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long id)
    {
        Optional<Recipe> optional = recipeRepository.findById(id);

        if (optional.isEmpty()) throw new NotFoundException("Recipe not found for id: " + id);

        return optional.get();
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long id)
    {
        return recipeToRecipeCommand.convert(findById(id));
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command)
    {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId:" + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }

    @Override
    public void deleteById(Long idToDelete)
    {
        recipeRepository.deleteById(idToDelete);
    }
}
