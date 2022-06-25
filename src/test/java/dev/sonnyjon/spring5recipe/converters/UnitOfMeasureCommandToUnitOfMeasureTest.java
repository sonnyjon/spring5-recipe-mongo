package dev.sonnyjon.spring5recipe.converters;

import dev.sonnyjon.spring5recipe.commands.UnitOfMeasureCommand;
import dev.sonnyjon.spring5recipe.model.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Sonny on 6/8/2022.
 */
class UnitOfMeasureCommandToUnitOfMeasureTest
{
    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @BeforeEach
    public void setUp() throws Exception
    {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();

    }

    @Test
    public void testNullParameter()
    {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject()
    {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert()
    {
        //given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure uom = converter.convert(command);

        //then
        assertNotNull(uom);
        assertEquals(LONG_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());

    }
}