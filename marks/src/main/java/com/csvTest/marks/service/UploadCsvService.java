package com.csvTest.marks.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.csvTest.marks.exception.MarksException;

public interface UploadCsvService {
	String uploadMarksInformation(MultipartFile file) throws MarksException, IOException;
}
