package com.example.demo3.Controller;

import com.example.demo3.Model.DetailedScore;
import com.example.demo3.Model.Score;
import com.example.demo3.Repository.DetailedScoreRepository;
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
    @Autowired
    DetailedScoreRepository detailedScoreRepository;

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

    //Lay thong tin tat ca diem
    @GetMapping("")
    public List<DetailedScore> index(){
        return detailedScoreRepository.findDetailedAll();
    }

    //Lay danh sach diem dua theo ma mon hoc
    @GetMapping("/subject/{id}")
    public List<DetailedScore> getScoreBySubjectID(@PathVariable String id){
        int subjectID = Integer.parseInt(id);
        return detailedScoreRepository.findDetailedAllBySubjectID(subjectID);
    }

    //Sua thong tin diem
    @PutMapping("/{id}")
    public Score update(@PathVariable String id, @RequestBody Map<String, String> body){
        int scoreID = Integer.parseInt(id);
        Score score = scoreRepository.getOne(scoreID);
        score.setScore(Integer.parseInt(body.get("score")));
        return scoreRepository.save(score);
    }

    //Thong ke danh sach sinh vien theo khoang diem [minVal.. maxVal]
    @PostMapping("/filter")
    public List<DetailedScore> getScoreList(@RequestBody Map<String, String> body){
        int minVal = Integer.parseInt(body.get("minVal"));
        int maxVal = Integer.parseInt(body.get("maxVal"));
        return detailedScoreRepository.findByScoreIsGreaterThanAndScoreLessThan(maxVal, minVal);
    }


    //Xoa diem mon hoc dung de test
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id){
        int scoreID = Integer.parseInt(id);
        scoreRepository.deleteById(scoreID);
        return true;
    }
}
