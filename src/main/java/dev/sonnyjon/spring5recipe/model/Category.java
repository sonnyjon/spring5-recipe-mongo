package dev.sonnyjon.spring5recipe.model;

import lombok.*;

import java.util.Set;

/**
 * Created by Sonny on 5/31/2022.
 */
@Getter
@Setter
public class Category
{
    private String id;
    private String description;
    private Set<Recipe> recipes;
}
