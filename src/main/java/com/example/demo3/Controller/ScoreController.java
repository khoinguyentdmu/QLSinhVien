package com.example.demo3.Controller;

import com.example.demo3.Model.Score;
import com.example.demo3.Repository.ScoreRepository;
import com.sun.corba.se.impl.logging.InterceptorsSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    //Lay thong tin tat ca diem
    @GetMapping("")
    public List<Score> index(){
        return scoreRepository.findAll();
    }

    //Lay danh sach diem dua theo ma mon hoc
    @GetMapping("/subject/{id}")
    public List<Score> getScoreBySubjectID(@PathVariable String id){
        int subjectID =Integer.parseInt(id);
        return scoreRepository.findBySubjectID(subjectID);
    }

    //Sua thong tin diem
    @PutMapping("/{id}")
    public Score update(@PathVariable String id, @RequestBody Map<String, String> body){
        int scoreID = Integer.parseInt(id);
        Score score = scoreRepository.getOne(scoreID);
        score.setScore(Integer.parseInt(body.get("score")));
        return scoreRepository.save(score);
    }

    //Xoa diem mon hoc
    /*@DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id){
        int scoreID = Integer.parseInt(id);
        scoreRepository.deleteById(scoreID);
        return true;
    }*/
}
