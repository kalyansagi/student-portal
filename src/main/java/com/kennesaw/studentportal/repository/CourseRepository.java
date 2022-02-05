package com.kennesaw.studentportal.repository;

import com.kennesaw.studentportal.entities.database.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {

    @Query("SELECT u FROM Course u WHERE u.departmentName = :departmentName")
    List<Course> findAllCoursesByDepartment(
            @Param("departmentName") String department);


}
