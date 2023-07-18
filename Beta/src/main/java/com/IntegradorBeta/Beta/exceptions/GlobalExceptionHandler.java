package com.IntegradorBeta.Beta.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger Logger = LogManager.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<String> emitirIllegalArgumentException(IllegalArgumentException e) {
        e.printStackTrace();
        Logger.error("mensaje de error de illegal -->" + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<BetaErrorResponse> emitirBadRequestException(BadRequestException e) {
        e.printStackTrace();
        Logger.error("mensaje de error de BadRequestException -->" + e.getMessage());
        BetaErrorResponse errorResponse = new BetaErrorResponse(e.getCode(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
