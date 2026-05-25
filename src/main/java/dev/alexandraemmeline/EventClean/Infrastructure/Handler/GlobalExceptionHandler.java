package dev.alexandraemmeline.EventClean.Infrastructure.Handler;

import dev.alexandraemmeline.EventClean.Core.Exceptions.DuplicateEventException;
import dev.alexandraemmeline.EventClean.Core.Exceptions.EventNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEventoNaoEcontrado (EventNotFoundException ex) {

        ErrorResponse response = new ErrorResponse(
                false,
                "Evento não encontrado",
                List.of(ex.getMessage()),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }



    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateEvent (DuplicateEventException ex) {

        ErrorResponse response = new ErrorResponse(
                false,
                "Identificador duplicado",
                List.of(ex.getMessage()),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(response);
    }

}
