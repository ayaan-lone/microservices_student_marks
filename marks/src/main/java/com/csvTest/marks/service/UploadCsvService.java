package com.csvTest.marks.service;

import java.io.FileNotFoundException;

import org.springframework.web.multipart.MultipartFile;

public interface UploadCsvService {
	String uploadMarksInformation(MultipartFile file) throws FileNotFoundException;
}
