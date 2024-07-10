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

import com.csvTest.student.service.UploadCsvService;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {

    private UploadCsvService uploadCsvService;

    @Autowired
    public StudentController(UploadCsvService uploadCsvService) {
        this.uploadCsvService = uploadCsvService;
    }

    @PostMapping("upload-student-information")
    public ResponseEntity<String> uploadStudentInformation(@RequestParam MultipartFile file)
            throws FileNotFoundException {
        String response = uploadCsvService.uploadStudentInformation(file);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
