package com.jdz.biblioteka.exception;

import org.springframework.http.HttpStatus;

public class BibliotekaAPIException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public BibliotekaAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
