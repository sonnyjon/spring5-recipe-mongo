package dev.sonnyjon.spring5recipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by Sonny on 6/8/2022.
 */
@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand
{
    private Long id;
    private Long recipeId;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand uom;
}
