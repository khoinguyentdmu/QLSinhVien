package com.example.demo3.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DetailedScore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int subject_id;

    private String subject_name;

    private int student_id;

    private String student_name;

    private int score;

    public DetailedScore(int subject_id, String subject_name, int student_id, String student_name, int score) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.student_id = student_id;
        this.student_name = student_name;
        this.score = score;
    }

    public DetailedScore() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
