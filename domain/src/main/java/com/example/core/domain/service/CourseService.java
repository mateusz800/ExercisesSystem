package com.example.core.domain.service;

import com.example.core.domain.dto.GetCoursesListByAuthorDto;
import com.example.core.domain.dto.GetCoursesListDto;
import com.example.core.domain.entity.Course;
import com.example.core.domain.entity.Exercise;
import com.example.core.domain.entity.user.User;
import com.example.core.domain.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Page<Course> findAll(GetCoursesListDto input, Pageable pageable){
        Course course = new Course();
        if(input.getName() != null){
           course.setName(input.getName());
        }
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                .withIgnoreCase();
        Example<Course> example = Example.of(course, matcher);

        return courseRepository.findAll(example, pageable);
    }

    public Page<Course> findByAuthor(GetCoursesListByAuthorDto input, User author, Pageable pageable){
        // TODO: query by example

        return courseRepository.findByAuthor(author.getId(), pageable);
    }


    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }
}


