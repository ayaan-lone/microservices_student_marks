package com.csvTest.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// Entity class representing a Student in the database
@Entity
public class Student {
    
    // Primary key for the Student entity
    @Column
    @Id
    private long studentId; 

    // Student's name
    @Column
    private String name;

    // Student's department
    @Column
    private String department;

    // Student's address
    @Column
    private String address;

    // Student's phone number
    @Column
    private String phoneNumber;

    // Getter and setter methods for each field

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}