package com.example.demo3.Controller;

import com.example.demo3.Model.Score;
import com.example.demo3.Repository.ScoreRepository;
import com.sun.corba.se.impl.logging.InterceptorsSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    ScoreRepository scoreRepository;

    //Tao diem
    @PostMapping("")
    public Score create(@RequestBody Map<String, String> body){
        int studentID = Integer.parseInt(body.get("studentID"));
        int subjectID = Integer.parseInt(body.get("subjectID"));
        int score = Integer.parseInt(body.get("score"));
        return scoreRepository.save(new Score(studentID, subjectID, score));
    }

    //Lay thong tin diem
    @GetMapping("/{id}")
    public Score getInfo(@PathVariable String id){
        int scoreID = Integer.parseInt(id);
        Score score1 = scoreRepository.getOne(scoreID);
        Score score2 = new Score(score1);
        return score2;
    }
    //Dang lam
/*
    //Lay thong tin tat ca diem
    @GetMapping("")
    public List<Score> index(){
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
    @DeleteMapping("score/{id}")
    public boolean delete(@PathVariable String id){
        int studentClassID = Integer.parseInt(id);
        studentClassRepository.deleteById(studentClassID);
        return true;
    }*/
}
