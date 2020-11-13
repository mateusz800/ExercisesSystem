package com.example.user.web.controller;

import com.example.core.domain.dto.GetCourseDetailsDto;
import com.example.core.domain.dto.GetCoursesListDto;
import com.example.core.domain.entity.Course;
import com.example.core.domain.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping(path = "/courses")
    public Page<?> getCourses(@PageableDefault(page = 0, size = 20) @SortDefault.SortDefaults({
            @SortDefault(sort = "name", direction = Sort.Direction.ASC)}) Pageable pageable) {
        Page<Course> courses = courseService.findAll(pageable);
        Page<GetCoursesListDto> response = courses
                .map(course -> new GetCoursesListDto(
                        course.getId(),
                        course.getName(),
                        course.getDesc(),
                        course.getImage()
                ));
        return response;
    }

    @GetMapping(path = "/courses/{id}")
    public ResponseEntity<?> getCourse(@PathVariable("id") Long id) {
        Optional<Course> course = courseService.findById(id);
        if (course.isPresent()) {
            Course entity = course.get();
            return new ResponseEntity<>(new GetCourseDetailsDto(
                    entity.getId(),
                    entity.getName(),
                    entity.getDesc(),
                    entity.getImage()
            ),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
