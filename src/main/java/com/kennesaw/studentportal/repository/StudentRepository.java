package com.kennesaw.studentportal.repository;

import com.kennesaw.studentportal.entities.database.Student;
import org.springframework.data.repository.CrudRepository;



public interface StudentRepository extends CrudRepository<Student, String> {

}
