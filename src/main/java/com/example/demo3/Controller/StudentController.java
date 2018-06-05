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
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    //Lay danh sach sinh vien
    @GetMapping("")
    public List<Student> index(){
        return studentRepository.findAll();
    }

    //Lay thong tin sinh vien dua theo id
    @GetMapping("/{id}")
    public Student getInfo(@PathVariable String id){
        int studentID = Integer.parseInt(id);
        Student student1 = studentRepository.getOne(studentID);
        Student student2 = new Student(student1);
        return student2;
    }

    //Tao moi mot sinh vien
    @PostMapping("")
    public Student create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        int studentClassID = Integer.parseInt(body.get("studentClassID"));
        Date dateOfBirth = new Date();

        try {
            dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(body.get("dateOfBirth"));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return studentRepository.save(new Student(name, studentClassID, dateOfBirth));
    }

    //Sua 1 thong tin sinh vien
    @PutMapping("/{id}")
    public Student update(@PathVariable String id, @RequestBody Map<String, String> body){
        int studentID = Integer.parseInt(id);

        Student student = studentRepository.getOne(studentID);
        student.setName(body.get("name"));
        student.setStudentClassID(Integer.parseInt(body.get("studentClassID")));
        return studentRepository.save(student);
    }

    //Xoa mot sinh vien
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id){
        int studentID = Integer.parseInt(id);
        studentRepository.deleteById(studentID);
        return true;
    }

    //Lay danh sach sinh vien theo ID lop
    @PostMapping("/studentClassID/{id}")
    public List<Student> getStudentsByClassID(@PathVariable String id){
        int studentClassID = Integer.parseInt(id);

        List<Student> studentList = studentRepository.findByStudentClassID(studentClassID);
        return studentList;
    }
}