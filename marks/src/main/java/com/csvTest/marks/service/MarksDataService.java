package com.csvTest.marks.service;

import com.csvTest.marks.request.UserPaginationResponse;

public interface MarksDataService {
    UserPaginationResponse getAllStudents(int pageNumber, int pageSize);
}
