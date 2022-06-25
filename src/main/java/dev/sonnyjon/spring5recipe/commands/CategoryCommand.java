package dev.sonnyjon.spring5recipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Sonny on 6/8/2022.
 */
@Getter
@Setter
@NoArgsConstructor
public class CategoryCommand
{
    private Long id;
    private String description;
}
