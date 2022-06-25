package dev.sonnyjon.spring5recipe.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Sonny on 5/31/2022.
 */
@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;
}
