package dev.alexandraemmeline.EventClean.Infrastructure.Handler;

import java.time.LocalDateTime;

public record SuccessResponse<T> (

        boolean success,
        String message,
        T data,
        LocalDateTime timestamp
){}
