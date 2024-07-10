package com.csvTest.marks.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentMarks {
	@Column
	@Id
	private long studentId;
	@Column
	private int marks;

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public int getNMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}


}