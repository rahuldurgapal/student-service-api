package com.test.studentservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    
    @Override
    public String toString() {
        return "Student [rollNo=" + rollNo + ", name=" + name + ", science=" + science + ", math=" + math + ", english="
                + english + ", computer=" + computer + ", eligible=" + eligible + "]";
    }
    @Id
    private String rollNo;
    public Student() {
    }
    public Student(String rollNo, String name, int science, int math, int english, int computer,
            String eligible) {
        this.rollNo = rollNo;
        this.name = name;
        this.science = science;
        this.math = math;
        this.english = english;
        this.computer = computer;
        this.eligible = eligible;
    }
    private String name;
    private int science;
    private int math;
    private int english;
    private int computer;
    private String eligible;
    public String getRollNo() {
        return rollNo;
    }
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getScience() {
        return science;
    }
    public void setScience(int science) {
        this.science = science;
    }
    public int getMath() {
        return math;
    }
    public void setMath(int math) {
        this.math = math;
    }
    public int getEnglish() {
        return english;
    }
    public void setEnglish(int english) {
        this.english = english;
    }
    public int getComputer() {
        return computer;
    }
    public String getEligible() {
        return eligible;
    }
    public void setEligible(String eligible) {
        this.eligible = eligible;
    }
    public void setComputer(int computer) {
        this.computer = computer;
    }
   

    

}
