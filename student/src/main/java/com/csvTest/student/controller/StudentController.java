package com.csvTest.student.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csvTest.student.exception.StudentException;
import com.csvTest.student.service.UploadCsvService;

// Controller for handling student-related API endpoints
@RestController
@RequestMapping("/api/v1/")
public class StudentController {
    
    // Service for handling CSV file uploads
    private UploadCsvService uploadCsvService;
    
    // Constructor injection for uploadCsvService
    @Autowired
    public StudentController(UploadCsvService uploadCsvService) {
        this.uploadCsvService = uploadCsvService;
    }
    
    // Endpoint for uploading student information via CSV file
    @PostMapping("upload-student-information")
    public ResponseEntity<String> uploadStudentInformation(@RequestParam MultipartFile file) throws StudentException, FileNotFoundException {
        if (file.isEmpty()) {
            throw new StudentException(HttpStatus.NOT_FOUND, "File not found or is empty");
        }

        String response = uploadCsvService.uploadStudentInformation(file);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    

}
