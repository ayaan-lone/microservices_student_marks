package com.csvTest.student.service;

import com.csvTest.student.request.UserPaginationResponse;

public interface StudentDataService {
    UserPaginationResponse getAllStudents(int pageNumber, int pageSize);
}
