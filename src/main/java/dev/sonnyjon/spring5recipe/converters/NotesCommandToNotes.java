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
public class NotesCommandToNotes implements Converter<NotesCommand, Notes>
{
    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand source)
    {
        if (source == null) return null;

        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());

        return notes;
    }
}
