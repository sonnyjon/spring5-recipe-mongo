package dev.sonnyjon.spring5recipe.services;

import dev.sonnyjon.spring5recipe.commands.UnitOfMeasureCommand;
import dev.sonnyjon.spring5recipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import dev.sonnyjon.spring5recipe.repos.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Sonny on 6/11/2022.
 */
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService
{
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository,
                                    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand)
    {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms()
    {
        return StreamSupport
                        .stream(unitOfMeasureRepository.findAll().spliterator(), false)
                        .map(unitOfMeasureToUnitOfMeasureCommand::convert)
                        .collect(Collectors.toSet());
    }
}
