package com.kennesaw.studentportal.controllers;

import com.kennesaw.studentportal.entities.CourseRequest;
import com.kennesaw.studentportal.entities.database.Course;
import com.kennesaw.studentportal.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping(value = "/course/add", name = "adding new course")
    public ResponseEntity<String> addCourse(@RequestBody final CourseRequest courseRequest) {
        courseService.addCourse(courseRequest);
        return new ResponseEntity<>("A Course request has been submitted. It will reflect in course list in next few mins", HttpStatus.OK);

    }


    @GetMapping(value = "course/", name = "query courses by department")
    public List<Course> findAllCoursesByDepartment(@RequestParam(name = "departmentName") final String departmentName) {
        return courseService.findAllCoursesByDepartment(departmentName);
    }
}
