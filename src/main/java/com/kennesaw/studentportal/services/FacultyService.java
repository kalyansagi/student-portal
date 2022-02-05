package com.kennesaw.studentportal.services;

import com.kennesaw.studentportal.entities.Faculty;
import com.kennesaw.studentportal.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FacultyService {

    private FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(final FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public void addFaculty(final Faculty faculty)  {
        facultyRepository.insertFacultyRecord(faculty);

    }
}
