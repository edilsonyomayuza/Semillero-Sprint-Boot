package com.example.Semillero.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ServiceException extends Exception{

    private int statusCode;
    private String message;

    public ServiceException(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public ServiceException(String message, int statusCode, String message1) {
        super(message);
        this.statusCode = statusCode;
        this.message = message1;
    }

}
