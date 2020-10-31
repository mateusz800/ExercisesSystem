package com.example.core.domain.repository;

import com.example.core.domain.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {

    @Query(nativeQuery = true, value = "SELECT * FROM math.course ORDER BY ?#{#pageable}",
    countQuery = "SELECT count(*) FROM math.course")
    Page<Course> findAll(Pageable pageable);
}
