package dev.sonnyjon.spring5recipe.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by Sonny on 6/4/2022.
 */
class CategoryTest
{
    Category category;

    @BeforeEach
    public void setUp()
    {
        category = new Category();
    }

    @Test
    void getId() throws Exception
    {
        String idValue = "4";
        category.setId(idValue);
        Assertions.assertEquals(idValue, category.getId());
    }

    @Test
    void getDescription()
    {
    }

    @Test
    void getRecipes()
    {
    }
}