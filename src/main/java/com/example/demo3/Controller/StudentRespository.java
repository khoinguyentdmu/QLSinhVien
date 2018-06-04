package com.example.demo3.Controller;

import com.example.demo3.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRespository extends JpaRepository<Student, Integer> {
}
