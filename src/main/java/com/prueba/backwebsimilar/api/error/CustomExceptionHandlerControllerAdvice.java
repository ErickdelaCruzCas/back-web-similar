package com.prueba.backwebsimilar.api.error;

import com.prueba.backwebsimilar.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler({CustomException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleConflict(CustomException exception, WebRequest request) {
        return "Custom Exception: " + exception.getErrorCode() + " " + exception.getMessage();
    }
}
