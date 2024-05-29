package com.test.studentservice.service;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.test.studentservice.model.Student;

public class InspectCsvService {
    
    private static final Logger logger = LoggerFactory.getLogger(InspectCsvService.class);
    public static List<Student> inspectCSV(MultipartFile file) throws Exception{
     List<Student> students = new ArrayList<>();

        try(Reader reader = new InputStreamReader(file.getInputStream());
         CSVReader csvReader = new CSVReader(reader)) {

            String [] row;
            while((row=csvReader.readNext())!=null) {
                if("roll number".equalsIgnoreCase(row[0])) {
                    continue; //skip header row
                }

                Student student = new Student();
                student.setRollNo(row[0]);
                student.setName(row[1]);
                student.setScience(Integer.parseInt(row[2]));
                student.setMath(Integer.parseInt(row[3]));
                student.setEnglish(Integer.parseInt(row[4]));
                student.setComputer(Integer.parseInt(row[5]));
                student.setEligible(row[6]);
                
                //add student into the list
                logger.info("Parsed [] studetns from file",students.size());
                students.add(student);
        
            }

         }
         return students;
    }
    }