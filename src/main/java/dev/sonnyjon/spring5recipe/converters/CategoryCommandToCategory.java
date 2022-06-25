package dev.sonnyjon.spring5recipe.converters;

import dev.sonnyjon.spring5recipe.commands.CategoryCommand;
import dev.sonnyjon.spring5recipe.model.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by Sonny on 6/8/2022.
 */
@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category>
{
    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source)
    {
        if (source == null)  return null;

        final Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());

        return category;
    }
}
