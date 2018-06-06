package com.example.demo3.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class DetailedStudent {
    @Id
    private int studentID;
    private int student_classid;
    private String monitor;
    private String student_Name;
    private String student_class_name;
    private Date date_of_birth;

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public DetailedStudent(int studentID, int student_classid, String monitor, String student_Name, String student_class_name, Date date_of_birth) {
        this.studentID = studentID;
        this.student_classid = student_classid;
        this.monitor = monitor;
        this.student_Name = student_Name;
        this.student_class_name = student_class_name;
        this.date_of_birth = date_of_birth;
    }

    public DetailedStudent() {
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getStudent_classid() {
        return student_classid;
    }

    public void setStudent_classid(int student_classid) {
        this.student_classid = student_classid;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }

    public String getStudent_class_name() {
        return student_class_name;
    }

    public void setStudent_class_name(String student_class_name) {
        this.student_class_name = student_class_name;
    }
}
