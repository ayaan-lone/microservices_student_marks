package com.csvTest.student.service;

import java.io.FileNotFoundException;

import org.springframework.web.multipart.MultipartFile;

import com.csvTest.student.exception.StudentException;

// Service interface for handling CSV file uploads of student information
public interface UploadCsvService {

	// Uploads and processes student information from a CSV file
	String uploadStudentInformation(MultipartFile file) throws StudentException, FileNotFoundException;
}