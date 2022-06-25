package dev.sonnyjon.spring5recipe.converters;

import dev.sonnyjon.spring5recipe.commands.NotesCommand;
import dev.sonnyjon.spring5recipe.model.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Sonny on 6/8/2022.
 */
class NotesCommandToNotesTest
{
    public static final Long ID_VALUE = 1L;
    public static final String RECIPE_NOTES = "Notes";
    NotesCommandToNotes converter;

    @BeforeEach
    public void setUp() throws Exception
    {
        converter = new NotesCommandToNotes();
    }

    @Test
    public void testNullParameter()
    {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject()
    {
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    public void convert()
    {
        //given
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID_VALUE);
        notesCommand.setRecipeNotes(RECIPE_NOTES);

        //when
        Notes notes = converter.convert(notesCommand);

        //then
        assertNotNull(notes);
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
    }}