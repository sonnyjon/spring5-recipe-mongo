package dev.sonnyjon.spring5recipe.services;

import dev.sonnyjon.spring5recipe.commands.UnitOfMeasureCommand;

import java.util.Set;

/**
 * Created by Sonny on 6/11/2022.
 */
public interface UnitOfMeasureService
{
    Set<UnitOfMeasureCommand> listAllUoms();
}
