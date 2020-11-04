package com.example.core.domain.repository;

import com.example.core.domain.entity.Exercise;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long>, QueryByExampleExecutor<Exercise> {

    @Query(nativeQuery = true, value = "SELECT * FROM math.exercise WHERE " +
            "topic_name = :#{#example.getProbe().getCourse().getName()} AND" +
            " id NOT IN (SELECT exercise_id FROM math.answer WHERE correct = true AND user_email = :#{#userEmail}) ORDER BY ?#{#pageable}",
    countQuery ="SELECT count(*) FROM math.exercise WHERE " +
            "topic_name = :#{#example.getProbe().getCourse().getName()} AND" +
                    " id NOT IN (SELECT exercise_id FROM math.answer WHERE correct = true  AND user_email = :#{#userEmail} ORDER BY ?#{#pageable}" )
    Page<Exercise> findAllUnsolved(Example<Exercise> example, Pageable pageable, String userEmail);

}
