package com.example.core.domain.service;

import com.example.core.domain.entity.Course;
import com.example.core.domain.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Transactional(readOnly=true)
    public Page<Course> findAll(Pageable pageable){
        return courseRepository.findAll(pageable);
    }
}
