package com.csvTest.student.request;

import java.util.List;

import com.csvTest.student.entity.Student;

public class UserPaginationResponse {

    private List<Student> students;
    private long totalElements;
    private int totalPages;
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

    // Constructors, getters, and setters
}
