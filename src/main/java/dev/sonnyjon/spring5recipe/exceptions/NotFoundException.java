package dev.sonnyjon.spring5recipe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Sonny on 6/14/2022.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException
{
    public NotFoundException()
    {
        super();
    }

    public NotFoundException(String message)
    {
        super(message);
    }

    public NotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

}