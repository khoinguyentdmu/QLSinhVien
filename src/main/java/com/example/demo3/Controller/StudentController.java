package com.example.demo3.Controller;

import com.example.demo3.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRespository studentRespository;
//Lay danh sach sinh vien
    @GetMapping("/student")
    public List<Student> index(){
        return studentRespository.findAll();
    }
//Lay thong tin sinh vien dua theo id
    /*@GetMapping("/student/{id}")
    public void getInfo(@PathVariable String id){
        int studentID = Integer.parseInt(id);
        Optional<Student> opt = studentRespository.findById(studentID);
        System.out.print(opt.toString());
    }*/
//Dang lam
    /*
    @PostMapping("/student/search")
    public List<Student> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return studentRespository...
    }*/
//Tao moi mot sinh vien
    @PostMapping("/student")
    public Student create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        String studentClass = body.get("studentClass");
        return studentRespository.save(new Student(name,studentClass));
    }
//Sua 1 thong tin sinh vien
    @PutMapping("/student/{id}")
    public Student update(@PathVariable String id, @RequestBody Map<String, String> body){
        int studentID = Integer.parseInt(id);

        Student student = studentRespository.getOne(studentID);
        student.setName(body.get("name"));
        student.setStudentClass(body.get("studentClass"));
        return studentRespository.save(student);
    }
//Xoa mot sinh vien
    @DeleteMapping("student/{id}")
    public boolean delete(@PathVariable String id){
        int studentID = Integer.parseInt(id);
        studentRespository.deleteById(studentID);
        return true;
    }


}