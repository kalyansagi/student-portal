package com.kennesaw.studentportal.services;

import com.google.common.collect.Lists;
import com.kennesaw.studentportal.entities.database.Student;
import com.kennesaw.studentportal.entities.StudentResponse;
import com.kennesaw.studentportal.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private StudentRepository studentRepository;


    public StudentService(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponse addStudent(final String ksuId,
                                      final String email,
                                      final String firstName,
                                      final String lastName,
                                      final String course) {
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

    public List<Student> findAllStudents() {
        return Lists.newArrayList(studentRepository.findAll());
    }

    public Student findStudentByKsuId(final String ksuId) {
        Optional<Student> student = studentRepository.findById(ksuId);
        if (student.isPresent()) {
            return student.get();
        }
        return Student.builder().build();
    }
}
