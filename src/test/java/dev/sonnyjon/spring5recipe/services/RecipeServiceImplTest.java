package dev.sonnyjon.spring5recipe.services;

import dev.sonnyjon.spring5recipe.converters.RecipeCommandToRecipe;
import dev.sonnyjon.spring5recipe.converters.RecipeToRecipeCommand;
import dev.sonnyjon.spring5recipe.exceptions.NotFoundException;
import dev.sonnyjon.spring5recipe.model.Recipe;
import dev.sonnyjon.spring5recipe.repos.RecipeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created by Sonny on 6/4/2022.
 */
class RecipeServiceImplTest
{
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    AutoCloseable mocks;

    @BeforeEach
    void setUp()
    {
        mocks = MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @AfterEach
    void tearDown() throws Exception
    {
        mocks.close();
    }

    @Test
    void getRecipesById()
    {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> optional = Optional.of(recipe);
        when(recipeRepository.findById(anyLong())).thenReturn(optional);

        Recipe returned = recipeService.findById(1L);

        assertNotNull(returned,"Null Recipe returned");
        verify(recipeRepository, times(1)).findById(1L);
        verify(recipeRepository, never()).findAll();
    }

    @Test()
    public void getRecipeByIdTestNotFound()
    {
        Optional<Recipe> recipeOptional = Optional.empty();
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Assertions.assertThrows(NotFoundException.class, () -> {
            Recipe recipeReturned = recipeService.findById(1L);
        });
    }

    @Test
    void getRecipes()
    {
        Recipe recipe = new Recipe();
        Set<Recipe> data = new HashSet<>();
        data.add(recipe);

        when(recipeRepository.findAll()).thenReturn(data);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteById()
    {
        //given
        Long idToDelete = Long.valueOf(2L);

        //when
        recipeService.deleteById(idToDelete);

        //then
        verify(recipeRepository, times(1)).deleteById(anyLong());
    }
}