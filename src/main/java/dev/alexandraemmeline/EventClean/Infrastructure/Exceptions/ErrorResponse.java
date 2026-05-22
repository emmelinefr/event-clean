package dev.alexandraemmeline.EventClean.Infrastructure.Exceptions;

public record ErrorResponse(

        boolean sucess,
        int status,
        String message

) {
}
