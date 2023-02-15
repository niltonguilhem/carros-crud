package com.example.carros.handler.exceptionHandler;

import com.example.carros.handler.exception.EntidadeInexistenteException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(EntidadeInexistenteException.class)
    public ResponseEntity<?> handleIdNaoEncontradoException(
            EntidadeInexistenteException exception, WebRequest request) {
        return handleExceptionInternal(exception, exception.getMessage(), new HttpHeaders(),
                HttpStatus.BAD_REQUEST, request);

    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<?> handleInvalidFormatExceptio(
            InvalidFormatException exception, WebRequest request) {
        return ResponseEntity.status (HttpStatus.NOT_FOUND)
                .body(exception);
    }

}
