package com.csvTest.marks.request;


import com.opencsv.bean.CsvBindByName;

public class MarksCsvDto {

    @CsvBindByName(column = "studentId")
    private long studentId;

    @CsvBindByName(column = "marks")
    private int marks;


	public long getstudentId() {
		return studentId;
	}

	public void getstudentId(Long studentId) {
		this.studentId = studentId;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}





    
}
