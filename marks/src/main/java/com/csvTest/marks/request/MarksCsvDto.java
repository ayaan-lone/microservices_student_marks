package com.csvTest.marks.request;

import com.opencsv.bean.CsvBindByName;

public class MarksCsvDto {

    // Mapping CSV column "studentId" to Java attribute studentId
    @CsvBindByName(column = "studentId")
    private long studentId;

    // Mapping CSV column "marks" to Java attribute marks
    @CsvBindByName(column = "marks")
    private int marks;

    // Getter method for retrieving studentId
    public long getstudentId() {
        return studentId;
    }

    // Setter method for setting studentId
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    // Getter method for retrieving marks
    public int getMarks() {
        return marks;
    }

    // Setter method for setting marks
    public void setMarks(int marks) {
        this.marks = marks;
    }

}
