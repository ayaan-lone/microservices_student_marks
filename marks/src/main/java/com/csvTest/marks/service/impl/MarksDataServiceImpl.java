package com.csvTest.marks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.csvTest.marks.dao.MarksRepository;
import com.csvTest.marks.entity.StudentMarks;
import com.csvTest.marks.request.UserPaginationResponse;
import com.csvTest.marks.service.MarksDataService;

@Service
public class MarksDataServiceImpl implements MarksDataService {

	@Autowired
	private MarksRepository marksRepository;

	@Override
	public UserPaginationResponse getAllStudents(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<StudentMarks> page = marksRepository.findAll(pageable);

		List<StudentMarks> marks = page.getContent();
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();

		UserPaginationResponse response = new UserPaginationResponse();
		response.setStudentMarkss(marks);
		response.setTotalElements(totalItems);
		response.setTotalPages(totalPages);

		return response;
	}
}
