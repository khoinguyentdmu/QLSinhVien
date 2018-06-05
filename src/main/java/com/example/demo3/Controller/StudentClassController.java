package com.example.demo3.Controller;

import com.example.demo3.Model.StudentClass;
import com.example.demo3.Repository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/studentClass")
public class StudentClassController {
    @Autowired
    StudentClassRepository studentClassRepository;

    //Tao lop
    @PostMapping("")
    public StudentClass create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        String monitor = body.get("monitor");
        return studentClassRepository.save(new StudentClass(name, monitor));
    }

    //Lay thong tin lop
    @GetMapping("/{id}")
    public StudentClass getInfo(@PathVariable String id){
        int studentClassID = Integer.parseInt(id);
        StudentClass studentClass1 = studentClassRepository.getOne(studentClassID);
        StudentClass studentClass2 = new StudentClass(studentClass1);
        return studentClass2;
    }

    //Lay thong tin tat ca cac lop
    @GetMapping("")
    public List<StudentClass> index(){
        return studentClassRepository.findAll();
    }

    //Sua 1 thong tin lop
    @PutMapping("/{id}")
    public StudentClass update(@PathVariable String id, @RequestBody Map<String, String> body){
        int studentClassID = Integer.parseInt(id);
        StudentClass studentClass = studentClassRepository.getOne(studentClassID);
        studentClass.setName(body.get("name"));
        studentClass.setMonitor(body.get("monitor"));
        return studentClassRepository.save(studentClass);
    }

    //Xoa mon hoc
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id){
        int studentClassID = Integer.parseInt(id);
        studentClassRepository.deleteById(studentClassID);
        return true;
    }
}

