package com.example.core.domain.repository;

import com.example.core.domain.entity.Exercise;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long>, QueryByExampleExecutor<Exercise> {

    @Query(nativeQuery = true, value = "SELECT * FROM math.exercise WHERE " +
            "course_id = :#{#example.getProbe().getCourse().getId()} AND" +
            " id NOT IN (SELECT exercise_id FROM math.answer WHERE correct = true AND user_id = :#{#userId}) ORDER BY ?#{#pageable}",
    countQuery ="SELECT count(*) FROM math.exercise WHERE " +
            "course_id = :#{#example.getProbe().getCourse().getId()} AND" +
                    " id NOT IN (SELECT exercise_id FROM math.answer WHERE correct = true  AND user_email = :#{#userEmail} ORDER BY ?#{#pageable}" )
    Page<Exercise> findAllUnsolved(Example<Exercise> example, Pageable pageable, Long userId);

    @Query(nativeQuery = true, value = "SELECT * FROM math.exercise WHERE " +
            "course_id = :#{#example.getProbe().getCourse().getId()} AND" +
            " id IN (SELECT exercise_id FROM math.answer WHERE correct = true AND user_id = :#{#userId}) ORDER BY ?#{#pageable}",
            countQuery ="SELECT count(*) FROM math.exercise WHERE " +
                    "course_id = :#{#example.getProbe().getCourse().getId()} AND" +
                    " id IN (SELECT exercise_id FROM math.answer WHERE correct = true  AND user_id = :#{#userId} ORDER BY ?#{#pageable}" )
    Page<Exercise> findAllSolved(Example<Exercise> example, Pageable pageable, Long userId);

    @Query(nativeQuery = true, value=" UPDATE math.exercise SET question = :question, correct_answers = CAST(:correctAnswers AS JSON), incorrect_answers = CAST(:incorrectAnswers AS JSON) WHERE id = :id")
    void update(@Param("id") Long id, @Param("question") String question, @Param("correctAnswers") String correctAnswers, @Param("incorrectAnswers") String incorrectAnswers);
}
