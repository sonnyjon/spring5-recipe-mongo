package dev.sonnyjon.spring5recipe.repos;

import dev.sonnyjon.spring5recipe.model.UnitOfMeasure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

/**
 * Created by Sonny on 6/5/2022.
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class UnitOfMeasureRepositoryIT
{
    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp()
    {
    }

    @Test
    void findByDescription()
    {
        Optional<UnitOfMeasure> optional = unitOfMeasureRepository.findByDescription("Teaspoon");
        Assertions.assertEquals("Teaspoon", optional.get().getDescription());
    }

    @Test
    void findByDescriptionCup()
    {
        Optional<UnitOfMeasure> optional = unitOfMeasureRepository.findByDescription("Cup");
        Assertions.assertEquals("Cup", optional.get().getDescription());
    }
}