package com.csvTest.marks.service.impl;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.csvTest.marks.dao.MarksRepository;
import com.csvTest.marks.entity.StudentMarks;
import com.csvTest.marks.request.MarksCsvDto;
import com.csvTest.marks.service.UploadCsvService;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

@Service
public class UploadServiceImpl implements UploadCsvService {

	@Autowired
	private MarksRepository marksRepository;

	@Override
	public String uploadMarksInformation(MultipartFile file) {
		Map<String, String> mapping = new HashMap<>();
		mapping.put("studentId", "studentId");
		mapping.put("marks", "marks");

		HeaderColumnNameTranslateMappingStrategy<MarksCsvDto> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
		strategy.setType(MarksCsvDto.class);
		strategy.setColumnMapping(mapping);

		try (Reader reader = new InputStreamReader(file.getInputStream());
		     CSVReader csvReader = new CSVReader(reader)) {

			CsvToBean<MarksCsvDto> csvToBean = new CsvToBean<>();
			List<MarksCsvDto> marksCsvDtoList = csvToBean.parse(strategy, csvReader);

			for (MarksCsvDto marksCsvDto : marksCsvDtoList) {
				StudentMarks marks = new StudentMarks();
				marks.setStudentId(marksCsvDto.getstudentId());
				marks.setMarks(marksCsvDto.getMarks());

				marksRepository.save(marks);
			}
			return "Marks information uploaded successfully!";
		} catch (Exception e) {
			throw new RuntimeException("Failed to process CSV file", e);
		}
	}
}
