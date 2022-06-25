package dev.sonnyjon.spring5recipe.converters;

import dev.sonnyjon.spring5recipe.commands.CategoryCommand;
import dev.sonnyjon.spring5recipe.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Sonny on 6/8/2022.
 */
class CategoryCommandToCategoryTest
{
    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    CategoryCommandToCategory converter;

    @BeforeEach
    public void setUp()
    {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject()
    {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject()
    {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert()
    {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = converter.convert(categoryCommand);

        //then
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}