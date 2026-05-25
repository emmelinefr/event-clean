package dev.alexandraemmeline.EventClean.Infrastructure.Handler;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(

        boolean success,
        String message,
        List<String> errors,
        LocalDateTime timestamp

) {}
