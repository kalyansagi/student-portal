package com.kennesaw.studentportal.services;

import com.kennesaw.studentportal.entities.CourseRequest;
import com.kennesaw.studentportal.entities.database.Course;
import com.kennesaw.studentportal.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(final CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void addCourse(final String courseId, final String courseName, final String departmentName) {

        Course course = Course.builder()
                .uuid(UUID.randomUUID().toString())
                .courseId(courseId)
                .courseName(courseName)
                .departmentName(departmentName)
                .build();
        courseRepository.save(course);

    }

    public List<Course> findAllCoursesByDepartment(final String departmentName) {
        return courseRepository.findAllCoursesByDepartment(departmentName);
    }
}
