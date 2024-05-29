package com.test.studentservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.test.studentservice.model.Student;
import com.test.studentservice.repository.StudentRepository;

import jakarta.annotation.PostConstruct;

@Service
public class StudentService {
    
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    private Map<String, Integer> eligibleCriteria = new HashMap<>();

    @PostConstruct
    public void init() {

        eligibleCriteria.put("science",85);
        eligibleCriteria.put("math",90);
        eligibleCriteria.put("english",75);
        eligibleCriteria.put("computer",75);
    }

    public void updateEligibleCriteria(Map<String, Integer> criteria) {

        eligibleCriteria.clear();
        eligibleCriteria.putAll(criteria);
        logger.info("Updated eligibility criteria: []",eligibleCriteria );
    }

    public void fileProcess(MultipartFile file) throws Exception {

        logger.info("Processing File: []",file.getOriginalFilename());
        List<Student> students = InspectCsvService.inspectCSV(file);
        students.parallelStream().forEach(this::checkEligible);
        studentRepository.saveAll(students);
        logger.info("Processed and saved [] students",students.size());
    }

    public Student findStudentByrollNo(String rollNo) {
        return studentRepository.findById(rollNo).orElse(null);
    }

    public void checkEligible(Student student) {
      
     boolean check;
     check = student.getScience() > eligibleCriteria.get("science") &&
                        student.getMath() > eligibleCriteria.get("math") &&
                        student.getEnglish() > eligibleCriteria.get("english") &&
                        student.getComputer() > eligibleCriteria.get("computer");

                     student.setEligible(check ? "Yes": "No");
    }

}
