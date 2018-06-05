package com.example.demo3.Model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "tbl_student_class")
public class StudentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String monitor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public StudentClass() {
    }

    public StudentClass(StudentClass studentClass) {
        this.id = studentClass.getId();
        this.name = studentClass.getName();
        this.monitor = studentClass.getMonitor();
    }

    public StudentClass(String name, String monitor) {
        this.name = name;
        this.monitor = monitor;
    }

}
