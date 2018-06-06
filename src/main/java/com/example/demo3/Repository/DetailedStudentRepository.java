package com.example.demo3.Repository;

import com.example.demo3.Model.DetailedStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetailedStudentRepository extends JpaRepository<DetailedStudent, Integer> {
    @Query(value = "SELECT t1.id studentid, student_classid, monitor, \n" +
            "t1.name student_name, t2.name student_class_name, t1.date_of_birth\n" +
            "FROM tbl_student t1, tbl_student_class t2 \n" +
            "WHERE t1.student_classid = t2.id", nativeQuery = true)
    List<DetailedStudent> findDetailedAll();
}
