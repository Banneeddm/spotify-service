package com.spotifyservice.spotifyservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ResponseBody
@ControllerAdvice
public class GlobalControllerAdvice {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handlerValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors1 = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((errors) -> {
            String fieldName = ((FieldError) errors1).getField();
            String errorMessage = ((FieldError) errors1).getDefaultMessage();
            errors1.put(fieldName, errorMessage);
        });
        return errors1;
    }
}
