package com.workintech.sql.exceptions;

import org.springframework.http.HttpStatus;

public class BurgerException extends RuntimeException{
    private HttpStatus status;

    public BurgerException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
