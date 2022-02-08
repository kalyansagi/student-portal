package com.kennesaw.studentportal.controllers;

import com.kennesaw.studentportal.entities.StudentResponse;
import com.kennesaw.studentportal.entities.database.Student;
import com.kennesaw.studentportal.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /*
     *API to create a student record
     **/
    @PostMapping(path = "/student/create",
            consumes = {"multipart/form-data"})
    public ResponseEntity<StudentResponse> addStudent(@RequestParam(value = "ksuId", required = false) String ksuId,
                                                      @RequestParam(value = "email", required = false) String email,
                                                      @RequestParam(value = "firstName", required = false) String firstName,
                                                      @RequestParam(value = "lastName", required = false) String lastName,
                                                      @RequestParam(value = "course", required = false) String course) {
        StudentResponse studentResponse = studentService.addStudent(ksuId, email, firstName, lastName, course);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/student/all", name = "list all students")
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping(value = "/student", name = "query particular student")
    public ResponseEntity<Student> findStudentByKsuId(@RequestParam(name = "ksuId") final String ksuId) {
        return ResponseEntity.ok(studentService.findStudentByKsuId(ksuId));
    }

}
