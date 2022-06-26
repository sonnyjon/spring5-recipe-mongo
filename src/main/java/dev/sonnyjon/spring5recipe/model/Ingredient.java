package dev.sonnyjon.spring5recipe.model;

import lombok.*;

import java.math.BigDecimal;

/**
 * Created by Sonny on 5/31/2022.
 */
@Getter
@Setter
public class Ingredient
{
    private String id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasure uom;
    private Recipe recipe;

    public Ingredient() {}

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom)
    {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe)
    {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
        this.recipe = recipe;
    }

}