package com.example.demo3.Controller;

import com.example.demo3.Model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo3.Repository.*;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;

    //Tao mon hoc
    @PostMapping("")
    public Subject create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        return subjectRepository.save(new Subject(name));
    }

    //Lay thong tin mon hoc
    @GetMapping("/{id}")
    public Subject getInfo(@PathVariable String id){
        int subjectID = Integer.parseInt(id);
        Subject subject1 = subjectRepository.getOne(subjectID);
        Subject subject2 = new Subject(subject1);
        return subject2;
    }

    //Lay thong tin tat ca mon hoc
    @GetMapping("")
    public List<Subject> index(){
        return subjectRepository.findAll();
    }

    //Sua 1 thong tin mon hoc
    @PutMapping("/{id}")
    public Subject update(@PathVariable String id, @RequestBody Map<String, String> body){
        int subjectID = Integer.parseInt(id);

        Subject subject = subjectRepository.getOne(subjectID);
        subject.setName(body.get("name"));
        return subjectRepository.save(subject);
    }

    //Xoa mon hoc
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id){
        int subjectID = Integer.parseInt(id);
        subjectRepository.deleteById(subjectID);
        return true;
    }

}
