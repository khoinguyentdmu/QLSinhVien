package com.example.demo3.Repository;

import com.example.demo3.Model.DetailedScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailedScoreRepository extends JpaRepository<DetailedScore, Integer> {
    @Query(value = "SELECT t2.id, t1.id student_id, t1.name student_name, \n" +
            "t3.id subject_id, t3.name subject_name, t2.score\n" +
            "FROM tbl_student t1, tbl_score t2, tbl_subject t3 \n" +
            "WHERE t1.id = t2.studentid AND t2.subjectid = t3.id", nativeQuery = true)
    List<DetailedScore> findDetailedAll();

    @Query(value = "SELECT t2.id, t1.id student_id, t1.name student_name, \n" +
            "t3.id subject_id, t3.name subject_name, t2.score\n" +
            "FROM tbl_student t1, tbl_score t2, tbl_subject t3 \n" +
            "WHERE t1.id = t2.studentid AND t2.subjectid = t3.id AND t3.id =?1", nativeQuery = true)
    List<DetailedScore> findDetailedAllBySubjectID(int subjectID);

    @Query(value = "SELECT t2.id, t1.id student_id, t1.name student_name, \n" +
            "t3.id subject_id, t3.name subject_name, t2.score\n" +
            "FROM tbl_student t1, tbl_score t2, tbl_subject t3 \n" +
            "WHERE t1.id = t2.studentid AND t2.subjectid = t3.id AND score <= ?1 AND score >=?2", nativeQuery = true)
    List<DetailedScore> findByScoreIsGreaterThanAndScoreLessThan(int maxVal, int minVal);
}