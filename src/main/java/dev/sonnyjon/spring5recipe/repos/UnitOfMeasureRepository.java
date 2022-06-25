package dev.sonnyjon.spring5recipe.repos;

import dev.sonnyjon.spring5recipe.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Sonny on 5/31/2022.
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>
{
    Optional<UnitOfMeasure> findByDescription(String description);
}
