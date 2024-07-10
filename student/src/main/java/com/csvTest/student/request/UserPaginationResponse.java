package com.csvTest.student.request;

import java.util.List;

import com.csvTest.student.entity.Student;

// Response class for paginated student data
public class UserPaginationResponse {

	// List of students for the current page
	private List<Student> students;

	// Total number of student records
	private long totalElements;

	// Total number of pages
	private int totalPages;

	// Getter for students list
	public List<Student> getStudents() {
		return students;
	}

	// Setter for students list
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	// Getter for total number of elements
	public long getTotalElements() {
		return totalElements;
	}

	// Setter for total number of elements
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	// Getter for total number of pages
	public int getTotalPages() {
		return totalPages;
	}

	// Setter for total number of pages
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}