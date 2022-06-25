package dev.sonnyjon.spring5recipe.converters;

import dev.sonnyjon.spring5recipe.commands.UnitOfMeasureCommand;
import dev.sonnyjon.spring5recipe.model.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by Sonny on 6/8/2022.
 */
@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure>
{
    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source)
    {
        if (source == null) return null;

        final UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(source.getId());
        uom.setDescription(source.getDescription());

        return uom;
    }
}
