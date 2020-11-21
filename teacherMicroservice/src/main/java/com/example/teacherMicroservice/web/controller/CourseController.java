package com.example.teacherMicroservice.web.controller;

import com.example.core.domain.dto.course.CreateCourseDto;
import com.example.core.domain.dto.course.GetCourseDetailsWithExercisesDto;
import com.example.core.domain.entity.Course;
import com.example.core.domain.entity.user.User;
import com.example.core.domain.service.CourseService;
import com.example.core.domain.dto.course.GetCoursesListByAuthorDto;
import com.example.core.domain.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/courses")
    public Page getUserCourses(@PageableDefault(page = 0, size = 20) @SortDefault.SortDefaults({
            @SortDefault(sort = "name", direction = Sort.Direction.ASC)}) Pageable pageable,
                               @Valid GetCoursesListByAuthorDto inputDto /* TODO : @AuthenticationPrincipal User author*/) {

        User author = (User) userService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        Page<Course> courses = courseService.findByAuthor(inputDto, author, pageable);
        Page<GetCoursesListByAuthorDto> response = courses
                .map(course -> new GetCoursesListByAuthorDto(
                        course.getId(),
                        course.getName()
                ));
        return response;
    }

    @GetMapping(path = "/courses/{courseId}")
    public ResponseEntity<GetCourseDetailsWithExercisesDto> getCourseDetails(@PathVariable("courseId") Long courseId) {
        Optional<Course> optional = courseService.findById(courseId);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Course course = optional.get();
            return new ResponseEntity<GetCourseDetailsWithExercisesDto>(new GetCourseDetailsWithExercisesDto(
                    course.getId(),
                    course.getName(),
                    course.getDesc(),
                    course.getImage(),
                    course.getExercises()),
                    HttpStatus.OK);
        }
    }

    @PostMapping(path = "/courses")
    public ResponseEntity<?> createNewCourse(@RequestBody CreateCourseDto inputDto){
        User author = (User) userService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        courseService.createNewCourse(inputDto, author);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
