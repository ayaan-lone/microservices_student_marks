package com.csvTest.marks.exception;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MarksExceptionHandler {

    // Exception handler for MarksException
    @ExceptionHandler(value = { MarksException.class })
    public ResponseEntity<Object> handleMarksException(MarksException marksException) {
        // Returns response with the HTTP status and message from MarksException
        return ResponseEntity.status(marksException.getHttpStatus()).body(marksException.getMessage());
    }

    // Exception handler for RuntimeException
    @ExceptionHandler(value = { RuntimeException.class })
    public ResponseEntity<Object> handleRuntimeException(RuntimeException runtimeException) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Something went wrong. Please try again later.");
    }

    // Exception handler for FileNotFoundException
    @ExceptionHandler(value = { FileNotFoundException.class })
    public ResponseEntity<Object> handleFileNotFoundException(FileNotFoundException fileNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("File Not Found. Please try again later.");
    }
}
