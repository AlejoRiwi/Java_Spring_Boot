package com.riwi.vacants.controllers.errors;

import java.util.ArrayList;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.riwi.vacants.utils.dto.errors.ErrorResponse;
import com.riwi.vacants.utils.exceptions.IdNotFoundException;

/**
 * BadRequestController => Controlador de errores
 */
@RestControllerAdvice

//Status de error 
@ResponseStatus (code = HttpStatus.BAD_REQUEST)
public class BadRequestController {
    /*
     * Para especificar cuando se va a disparar este metodo
     * se utiliza la anotacion ExceptionHandle
     */
    @ExceptionHandler(IdNotFoundException.class)
    publica BaseErrorResponse handleIdNotFound(IdNotFoundException exception){
        return ErrorResponse.builder().status(HttpStatus.BAD_REQUEST.name()).code(HttpStatus.BAD_REQUEST.value()).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResponse handleErrors(MethodArgumentNotValidException exception) {
        List<String> errors = new ArrayList<>();

        exception.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));

        return ErrorsResponse.builder()
            .status(HttpStatus.BAD_REQUEST.name())
            .code(HttpStatus.BAD_REQUEST.value())
            .build();
    }
}