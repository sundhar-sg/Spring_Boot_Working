package com.example.SampleWebApp.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.SampleWebApp.restapi.exception.StudentErrorResponse;
import com.example.SampleWebApp.restapi.exception.StudentNotFoundException;

@ControllerAdvice
public class StudentRESTExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		StudentErrorResponse error = new StudentErrorResponse();
		error.setId(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException1(Exception exc) {
		StudentErrorResponse error = new StudentErrorResponse();
		error.setId(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}