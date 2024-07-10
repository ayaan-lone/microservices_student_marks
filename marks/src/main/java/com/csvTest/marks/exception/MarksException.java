package com.csvTest.marks.exception;

import org.springframework.http.HttpStatus;

public class MarksException extends Exception {
    private static final long serialVersionUID = -2469452495472342583L;
    private HttpStatus httpStatus;

    public MarksException() {
    }

    public MarksException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}