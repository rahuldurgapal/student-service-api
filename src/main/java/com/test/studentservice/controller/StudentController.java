package com.test.studentservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.studentservice.model.Student;
import com.test.studentservice.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

     @Autowired
     private StudentService studentService;

     @PostMapping("/upload")
     public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        try{
            studentService.fileProcess(file);
            return ResponseEntity.ok("File Uploded successfully");
        }catch(Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
     } 

     @GetMapping("/search/{rollno}") 
     public ResponseEntity<Student> findStudentByRollNo(@PathVariable("rollno") String rollno) {
        
        Student student = studentService.findStudentByrollNo(rollno);
        if(student!=null) {
            return ResponseEntity.ok(student);
        } 
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
     }

     @PutMapping("/update-criteria")
     public ResponseEntity<String> updateCriteria(@RequestBody Map<String, Integer> criteria) {
        
        studentService.updateEligibleCriteria(criteria);
        return ResponseEntity.ok("Eligibility criteria updated...");
     }
    
}