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

@Service
public class StudentDataServiceImpl implements StudentDataService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public UserPaginationResponse getAllStudents(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Student> page = studentRepository.findAll(pageable);

		List<Student> students = page.getContent();
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();

		UserPaginationResponse response = new UserPaginationResponse();
		response.setStudents(students);
		response.setTotalElements(totalItems);
		response.setTotalPages(totalPages);

		return response;
	}
}
