package com.csvTest.marks.request;

import java.util.List;

import com.csvTest.marks.entity.StudentMarks;

public class UserPaginationResponse {

    private List<StudentMarks> marks;
    private long totalElements;
    private int totalPages;
	public List<StudentMarks> getStudentMarkss() {
		return marks;
	}
	public void setStudentMarkss(List<StudentMarks> marks) {
		this.marks = marks;
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
