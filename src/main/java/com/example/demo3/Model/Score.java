package com.example.demo3.Model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int studentID;

    private int subjectID;

    private int score;

    public Score() {
    }

    public Score(Score score) {
        this.id = score.getId();
        this.studentID = score.getStudentID();
        this.subjectID = score.getSubjectID();
        this.score = score.getScore();
    }

    public Score(int studentID, int subjectID, int score) {
        this.studentID = studentID;
        this.subjectID = subjectID;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
