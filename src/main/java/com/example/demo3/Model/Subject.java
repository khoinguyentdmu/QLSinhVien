package com.example.demo3.Model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public Subject() {
    }

    public Subject(Subject subject) {
        this.id = subject.getId();
        this.name = subject.getName();
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

    public Subject(String name) {
        this.name = name;
    }
}
