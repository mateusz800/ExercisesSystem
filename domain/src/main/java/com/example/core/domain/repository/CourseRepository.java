package com.example.core.domain.repository;

import com.example.core.domain.entity.Course;
import com.example.core.domain.entity.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>, QueryByExampleExecutor<Course> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM math.course WHERE id = (SELECT course_id FROM math.course_author WHERE author_id = ?1) ORDER BY ?#{#pageable}",
            countQuery = "SELECT COUNT(*) FROM math.course WHERE id = (SELECT course_id FROM math.course_author WHERE author_id = ?1) ORDER BY ?#{#pageable}")
    Page<Course> findByAuthor(Long authorId, Pageable pageable);
}
