package com.csvTest.student.service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.csvTest.student.dao.StudentRepository;
import com.csvTest.student.entity.Student;
import com.csvTest.student.request.StudentCsvDto;
import com.csvTest.student.service.UploadCsvService;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

@Service
public class UploadCsvServiceImpl implements UploadCsvService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public String uploadStudentInformation(MultipartFile file) throws FileNotFoundException {
		Map<String, String> mapping = new HashMap<>();
		mapping.put("studentId", "studentId");
		mapping.put("name", "name");
		mapping.put("department", "department");
		mapping.put("address", "address");
		mapping.put("phoneNumber", "phoneNumber");

		HeaderColumnNameTranslateMappingStrategy<StudentCsvDto> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
		strategy.setType(StudentCsvDto.class);
		strategy.setColumnMapping(mapping);
		CSVReader csvReader = new CSVReader(new FileReader(file.getOriginalFilename()));
		CsvToBean<StudentCsvDto> csvToBean = new CsvToBean<>();
		List<StudentCsvDto> studentCsvDtoList = csvToBean.parse(strategy, csvReader);

		for (StudentCsvDto studentCsvDto : studentCsvDtoList) {
			Student student = new Student();
			student.setStudentId(studentCsvDto.getstudentId());
			student.setName(studentCsvDto.getName());
			student.setDepartment(studentCsvDto.getDepartment());
			student.setAddress(studentCsvDto.getAddress());
			student.setPhoneNumber(studentCsvDto.getPhoneNumber());

			studentRepository.save(student);
		}
		return "Student information uploaded successfully!";
	}
}
