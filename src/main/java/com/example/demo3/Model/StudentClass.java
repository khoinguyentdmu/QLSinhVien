package com.example.demo3.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentClass {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StudentClass(StudentClass studentClass) {
        this.id = studentClass.getId();
    }

    public StudentClass() {
    }

    public StudentClass(String id) {

        this.id = id;
    }
}
