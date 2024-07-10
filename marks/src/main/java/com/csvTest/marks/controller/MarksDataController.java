package com.csvTest.marks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csvTest.marks.request.UserPaginationResponse;
import com.csvTest.marks.service.MarksDataService;

@RestController
public class MarksDataController {

	@Autowired
	private MarksDataService marksDataService;

	@GetMapping("/api/v1/markss")
	public ResponseEntity<UserPaginationResponse> getAllStudents(
			@RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
			@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
		UserPaginationResponse response = marksDataService.getAllStudents(pageNumber, pageSize);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
