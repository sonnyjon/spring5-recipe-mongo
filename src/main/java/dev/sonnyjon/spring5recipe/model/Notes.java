package dev.sonnyjon.spring5recipe.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Sonny on 5/31/2022.
 */
@Getter
@Setter
public class Notes
{
    private String id;
    private Recipe recipe;
    private String recipeNotes;
}
