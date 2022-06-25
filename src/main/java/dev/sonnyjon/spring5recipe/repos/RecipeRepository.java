package dev.sonnyjon.spring5recipe.repos;

import dev.sonnyjon.spring5recipe.model.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sonny on 5/31/2022.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long>
{
}
