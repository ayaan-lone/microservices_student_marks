package com.csvTest.student.service;

import java.io.FileNotFoundException;

import org.springframework.web.multipart.MultipartFile;

public interface UploadCsvService {
    String uploadStudentInformation(MultipartFile file) throws FileNotFoundException;
}
