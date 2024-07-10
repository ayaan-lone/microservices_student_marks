package com.csvTest.marks.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csvTest.marks.entity.StudentMarks;

@Repository
public interface MarksRepository extends JpaRepository<StudentMarks, Long> {
}
