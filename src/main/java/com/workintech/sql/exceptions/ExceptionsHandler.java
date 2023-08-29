package com.workintech.sql.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class ExceptionsHandler {
    @ExceptionHandler
    public ResponseEntity errorHandler(MethodArgumentNotValidException exception){
        List errorList = exception.getBindingResult().getFieldErrors().stream().map(fieldError -> {
            Map<String,String> errorMap = new HashMap<>();
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            return errorMap;

        }).collect(Collectors.toList());
        log.error(exception.getMessage());
        return ResponseEntity.badRequest().body(errorList);
    }
    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> allErrors(Exception exception){
        BurgerErrorResponse response = new BurgerErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.value(),System.currentTimeMillis());
        log.error(exception.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

}
