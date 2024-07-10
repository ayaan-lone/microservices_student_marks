package com.csvTest.marks.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csvTest.marks.service.UploadCsvService;

@RestController
@RequestMapping("/api/v1/")
public class MarksController {

	private UploadCsvService uploadCsvService;

	@Autowired
    public MarksController(UploadCsvService uploadCsvService) {
        this.uploadCsvService = uploadCsvService;
    }

	@PostMapping("upload-marks-information")
	public ResponseEntity<String> uploadmarksInformation(@RequestParam MultipartFile file)
			throws FileNotFoundException {
		String response = uploadCsvService.uploadMarksInformation(file);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
