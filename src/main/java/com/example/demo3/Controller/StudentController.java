package com.example.demo3.Controller;

import com.example.demo3.Model.Student;
import com.example.demo3.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    //Lay danh sach sinh vien
    @GetMapping("/student")
    public List<Student> index(){
        return studentRepository.findAll();
    }

    //Lay thong tin sinh vien dua theo id
    @GetMapping("/student/{id}")
    public Student getInfo(@PathVariable String id){
        int studentID = Integer.parseInt(id);
        Student student1 = studentRepository.getOne(studentID);
        Student student2 = new Student(student1);
        System.out.print(student2);
        return student2;
    }

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
        Date dateOfBirth = new Date();
        try {
            dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(body.get("dateOfBirth"));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return studentRepository.save(new Student(name, studentClass, dateOfBirth));
    }

    //Sua 1 thong tin sinh vien
    @PutMapping("/student/{id}")
    public Student update(@PathVariable String id, @RequestBody Map<String, String> body){
        int studentID = Integer.parseInt(id);

        Student student = studentRepository.getOne(studentID);
        student.setName(body.get("name"));
        student.setStudentClass(body.get("studentClass"));
        return studentRepository.save(student);
    }

    //Xoa mot sinh vien
    @DeleteMapping("student/{id}")
    public boolean delete(@PathVariable String id){
        int studentID = Integer.parseInt(id);
        studentRepository.deleteById(studentID);
        return true;
    }
}