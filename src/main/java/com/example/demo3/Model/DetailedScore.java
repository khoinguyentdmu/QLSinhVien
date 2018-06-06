package com.example.demo3.Model;

public class DetailedScore extends Score{
    private String nameOfStudent, nameOfSubject;

    public String getNameOfStudent() {
        return nameOfStudent;
    }

    public void setNameOfStudent(String nameOfStudent) {
        this.nameOfStudent = nameOfStudent;
    }

    public String getNameOfSubject() {
        return nameOfSubject;
    }

    public void setNameOfSubject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    public DetailedScore() {
    }

    public DetailedScore(int studentID, int subjectID, int score, String nameOfStudent, String nameOfSubject) {
        super(studentID, subjectID, score);
        this.nameOfStudent = nameOfStudent;
        this.nameOfSubject = nameOfSubject;
    }
}
