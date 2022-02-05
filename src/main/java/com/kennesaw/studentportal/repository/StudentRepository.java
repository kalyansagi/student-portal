package com.kennesaw.studentportal.repository;

import com.kennesaw.studentportal.entities.database.Course;
import com.kennesaw.studentportal.entities.database.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface StudentRepository extends CrudRepository<Student, String> {

}
