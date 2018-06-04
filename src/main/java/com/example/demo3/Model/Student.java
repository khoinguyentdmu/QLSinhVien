package com.example.demo3.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String studentClass;
    private Date dateOfBirth;

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Student() {  }

    public Student(String name, String studentClass, Date dateOfBirth) {
        this.name = name;
        this.studentClass = studentClass;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public Student(Student student){
        this.id = student.getId();
        this.name = student.getName();
        this.studentClass = student.getStudentClass();
        this.dateOfBirth = student.getDateOfBirth();
    }
}