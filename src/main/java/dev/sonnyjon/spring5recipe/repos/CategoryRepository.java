package dev.sonnyjon.spring5recipe.repos;

import dev.sonnyjon.spring5recipe.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Sonny on 5/31/2022.
 */
public interface CategoryRepository extends CrudRepository<Category, String>
{
    Optional<Category> findByDescription(String description);
}
