package com.csvTest.marks.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentMarks {

    // Primary key representing student ID
    @Id
    @Column
    private long studentId;

    // Column to store marks obtained by the student
    @Column
    private int marks;

    // Getter method for retrieving student ID
    public long getStudentId() {
        return studentId;
    }

    // Setter method for setting student ID
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
