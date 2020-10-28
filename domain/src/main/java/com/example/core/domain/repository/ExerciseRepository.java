package com.example.core.domain.repository;

import com.example.core.domain.entity.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long>, QueryByExampleExecutor<Exercise> {

}
