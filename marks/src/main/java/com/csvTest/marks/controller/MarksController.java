package com.csvTest.marks.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csvTest.marks.exception.MarksException;
import com.csvTest.marks.service.UploadCsvService;
import com.csvTest.marks.util.ConstantsUtil;

@RestController
@RequestMapping("/api/v1/")
public class MarksController {

    // Injecting the UploadCsvService to handle CSV file uploads
    private UploadCsvService uploadCsvService;

    @Autowired
    public MarksController(UploadCsvService uploadCsvService) {
        this.uploadCsvService = uploadCsvService;
    }

    // Endpoint to upload marks information from a CSV file
    @PostMapping("upload-marks-information")
    public ResponseEntity<String> uploadmarksInformation(@RequestParam MultipartFile file)
            throws MarksException, IOException {
        String response = uploadCsvService.uploadMarksInformation(file);
        if(file==null) {
        	throw new MarksException(HttpStatus.NOT_FOUND,ConstantsUtil.FILE_NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
