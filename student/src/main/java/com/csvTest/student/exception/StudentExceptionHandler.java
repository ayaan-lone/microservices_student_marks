package com.csvTest.student.exception;
import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {

	@ExceptionHandler(value = { StudentException.class })
	public ResponseEntity<Object> handleStudentException(StudentException studentException) {
		return ResponseEntity.status(studentException.getHttpStatus()).body(studentException.getMessage());
	}

	@ExceptionHandler(value = { RuntimeException.class })
	public ResponseEntity<Object> handleRuntimeException(RuntimeException runtimeException) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Something went wrong. Please try again later.");
	}

	@ExceptionHandler(value = { FileNotFoundException.class })
	public ResponseEntity<Object> handleFileNotFoundException(FileNotFoundException fileNotFoundException) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("File Not Found Please Try Again Later");
	}
}