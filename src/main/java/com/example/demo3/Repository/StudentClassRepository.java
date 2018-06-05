package com.example.demo3.Repository;

import com.example.demo3.Model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass, Integer> {
}

