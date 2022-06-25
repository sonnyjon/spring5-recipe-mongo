package dev.sonnyjon.spring5recipe.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Sonny on 5/31/2022.
 */
@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;
}
