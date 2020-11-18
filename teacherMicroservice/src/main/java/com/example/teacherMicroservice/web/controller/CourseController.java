package com.example.teacherMicroservice.web.controller;

import com.example.core.domain.entity.Course;
import com.example.core.domain.entity.user.User;
import com.example.core.domain.service.CourseService;
import com.example.core.domain.dto.GetCoursesListByAuthorDto;
import com.example.core.domain.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
