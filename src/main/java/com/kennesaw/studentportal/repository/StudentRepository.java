package com.kennesaw.studentportal.repository;

import com.kennesaw.studentportal.entities.database.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository<Student, String> {

}
