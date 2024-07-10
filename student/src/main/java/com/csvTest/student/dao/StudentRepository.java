package com.csvTest.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.csvTest.student.entity.Student;

// Repository interface for Student entity
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}