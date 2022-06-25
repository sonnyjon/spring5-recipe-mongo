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
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand>
{
    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure)
    {
        if (unitOfMeasure == null) return null;

        final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
        uomc.setId(unitOfMeasure.getId());
        uomc.setDescription(unitOfMeasure.getDescription());

        return uomc;
    }
}
