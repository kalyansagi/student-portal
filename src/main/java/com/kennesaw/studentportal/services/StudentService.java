package com.kennesaw.studentportal.services;

import com.kennesaw.studentportal.entities.database.Student;
import com.kennesaw.studentportal.entities.StudentResponse;
import com.kennesaw.studentportal.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentService {

    private StudentRepository studentRepository;


    public StudentService(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponse addStudent(String ksuId, String email, String firstName, String lastName, String course) {
        Student student = Student.builder()
                .ksuId(ksuId)
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .course(course).build();
        studentRepository.save(student);
        return StudentResponse.builder()
                .ksuId(ksuId)
                .email(email)
                .confirmationCode(UUID.randomUUID().toString())
                .build();

    }
}
