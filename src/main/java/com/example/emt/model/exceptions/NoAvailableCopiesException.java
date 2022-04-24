package com.example.emt.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NoAvailableCopiesException extends RuntimeException{
    public NoAvailableCopiesException(Long id) {
        super(String.format("Book with id %d has no more available copies.", id));
    }
}