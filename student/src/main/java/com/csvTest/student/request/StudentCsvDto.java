package com.csvTest.student.request;


import com.opencsv.bean.CsvBindByName;

public class StudentCsvDto {

    @CsvBindByName(column = "studentId")
    private long studentId;

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "department")
    private String department;

    @CsvBindByName(column = "address")
    private String address;

    @CsvBindByName(column = "phoneNumber")
    private String phoneNumber;

	public long getstudentId() {
		return studentId;
	}

	public void getstudentId(Long studentId) {
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
