package com.example.core.domain.repository;

import com.example.core.domain.entity.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<Topic, String> {

    @Query(nativeQuery = true, value = "SELECT * FROM math.topic ORDER BY ?#{#pageable}",
    countQuery = "SELECT count(*) FROM math.topic")
    Page<Topic> findAll(Pageable pageable);
}
