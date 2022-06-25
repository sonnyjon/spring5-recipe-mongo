package dev.sonnyjon.spring5recipe.converters;

import dev.sonnyjon.spring5recipe.commands.NotesCommand;
import dev.sonnyjon.spring5recipe.model.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by Sonny on 6/8/2022.
 */
@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand>
{
    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes source)
    {
        if (source == null) return null;

        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(source.getId());
        notesCommand.setRecipeNotes(source.getRecipeNotes());

        return notesCommand;
    }
}
