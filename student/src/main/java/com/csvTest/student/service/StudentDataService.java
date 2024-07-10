package com.csvTest.student.service;

import com.csvTest.student.request.UserPaginationResponse;

// Service interface for retrieving student data
public interface StudentDataService {

	// Retrieves a paginated list of all students

	UserPaginationResponse getAllStudents(int pageNumber, int pageSize);
}