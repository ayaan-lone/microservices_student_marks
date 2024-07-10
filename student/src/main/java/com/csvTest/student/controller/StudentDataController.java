package com.csvTest.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csvTest.student.exception.StudentException;
import com.csvTest.student.request.UserPaginationResponse;
import com.csvTest.student.service.StudentDataService;
import com.csvTest.student.util.ConstantsUtil;

@RestController
public class StudentDataController {

    @Autowired
    private StudentDataService studentDataService;

    @GetMapping("/api/v1/students")
    public ResponseEntity<UserPaginationResponse> getAllStudents(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) throws StudentException {

        // Retrieve paginated student data from the service
        UserPaginationResponse response = studentDataService.getAllStudents(pageNumber, pageSize);

        // Handle case where no students are found
        if (response.getStudents().isEmpty()) {
            throw new StudentException(HttpStatus.NOT_FOUND, ConstantsUtil.NO_DATA_AVAILABLE);
        }

        // Return the response with an OK status
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
