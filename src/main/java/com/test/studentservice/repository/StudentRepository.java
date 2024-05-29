package com.test.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.studentservice.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{
    
}
