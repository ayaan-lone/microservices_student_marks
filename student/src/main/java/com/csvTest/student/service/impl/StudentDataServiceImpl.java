package com.csvTest.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.csvTest.student.dao.StudentRepository;
import com.csvTest.student.entity.Student;
import com.csvTest.student.request.UserPaginationResponse;
import com.csvTest.student.service.StudentDataService;

// Implementation of StudentDataService interface
@Service
public class StudentDataServiceImpl implements StudentDataService {

	// Inject the StudentRepository for database operations
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public UserPaginationResponse getAllStudents(int pageNumber, int pageSize) {
		// Create a Pageable object for pagination
		Pageable pageable = PageRequest.of(pageNumber, pageSize);

		// Fetch a page of students from the repository
		Page<Student> page = studentRepository.findAll(pageable);

		// Extract the list of students for the current page
		List<Student> students = page.getContent();

		// Get the total number of students
		long totalItems = page.getTotalElements();

		// Get the total number of pages
		int totalPages = page.getTotalPages();

		// Create and populate the response object
		UserPaginationResponse response = new UserPaginationResponse();
		response.setStudents(students);
		response.setTotalElements(totalItems);
		response.setTotalPages(totalPages);

		return response;
	}
}