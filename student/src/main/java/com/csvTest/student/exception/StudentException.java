package com.csvTest.student.exception;

import org.springframework.http.HttpStatus;

public class StudentException extends Exception {
    private static final long serialVersionUID = -2469452495472342583L;
    private HttpStatus httpStatus;

    public StudentException() {
    }

    public StudentException(HttpStatus httpStatus, String message) {
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