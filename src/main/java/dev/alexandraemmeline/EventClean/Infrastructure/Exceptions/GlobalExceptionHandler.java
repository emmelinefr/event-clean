package dev.alexandraemmeline.EventClean.Infrastructure.Exceptions;

import dev.alexandraemmeline.EventClean.Core.Exceptions.EventoNaoEncontradoException;
import dev.alexandraemmeline.EventClean.Core.Exceptions.PeriodoEventoInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EventoNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handleEventoNaoEcontrado (EventoNaoEncontradoException ex) {

        ErrorResponse response = new ErrorResponse(
                false,
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }



    @ExceptionHandler(PeriodoEventoInvalidoException.class)
    public ResponseEntity<ErrorResponse> handlePeriodoEventoInvalido (PeriodoEventoInvalidoException ex) {

        ErrorResponse response = new ErrorResponse(
                false,
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

}
