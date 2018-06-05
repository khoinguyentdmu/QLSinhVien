package com.example.demo3.Controller;

import com.example.demo3.Model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo3.Repository.*;
import java.util.List;
import java.util.Map;

@RestController
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;

    //Tao mon hoc
    @PostMapping("/subject")
    public Subject create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        return subjectRepository.save(new Subject(name));
    }

    //Lay thong tin mon hoc
    @GetMapping("/subject/{id}")
    public Subject getInfo(@PathVariable String id){
        int subjectID = Integer.parseInt(id);
        Subject subject1 = subjectRepository.getOne(subjectID);
        Subject subject2 = new Subject(subject1);
        System.out.print(subject2 + "<=======");
        return subject2;
    }

    //Lay thong tin tat ca mon hoc
    @GetMapping("/subject")
    public List<Subject> index(){
        return subjectRepository.findAll();
    }

    //Sua 1 thong tin mon hoc
    @PutMapping("/subject/{id}")
    public Subject update(@PathVariable String id, @RequestBody Map<String, String> body){
        int subjectID = Integer.parseInt(id);

        Subject subject = subjectRepository.getOne(subjectID);
        subject.setName(body.get("name"));
        return subjectRepository.save(subject);
    }

    //Xoa mon hoc
    @DeleteMapping("subject/{id}")
    public boolean delete(@PathVariable String id){
        int subjectID = Integer.parseInt(id);
        subjectRepository.deleteById(subjectID);
        return true;
    }

}
