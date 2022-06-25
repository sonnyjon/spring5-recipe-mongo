package dev.sonnyjon.spring5recipe.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Sonny on 5/31/2022.
 */
@Getter
@Setter
@Entity
public class UnitOfMeasure
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
}
