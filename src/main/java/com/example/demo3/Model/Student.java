package com.example.demo3.Model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int studentClassID;
    private Date dateOfBirth;

    public int getStudentClassID() {
        return studentClassID;
    }

    public void setStudentClassID(int studentClassID) {
        this.studentClassID = studentClassID;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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

    public Student() {  }

    public Student(String name, int studentClassID, Date dateOfBirth) {
        this.name = name;
        this.studentClassID = studentClassID;
        this.dateOfBirth = dateOfBirth;
    }

    public Student(Student student){
        this.id = student.getId();
        this.name = student.getName();
        this.studentClassID = student.getStudentClassID();
        this.dateOfBirth = student.getDateOfBirth();
    }
}