package dev.sonnyjon.spring5recipe.converters;

import dev.sonnyjon.spring5recipe.commands.UnitOfMeasureCommand;
import dev.sonnyjon.spring5recipe.model.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Sonny on 6/8/2022.
 */
class UnitOfMeasureToUnitOfMeasureCommandTest
{
    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @BeforeEach
    public void setUp() throws Exception
    {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullObjectConvert()
    {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj()
    {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() throws Exception
    {
        //given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(LONG_VALUE);
        uom.setDescription(DESCRIPTION);
        //when
        UnitOfMeasureCommand uomc = converter.convert(uom);

        //then
        assertEquals(LONG_VALUE, uomc.getId());
        assertEquals(DESCRIPTION, uomc.getDescription());
    }
}