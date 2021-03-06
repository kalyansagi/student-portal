package com.kennesaw.studentportal.controllers;

import com.kennesaw.studentportal.entities.Faculty;
import com.kennesaw.studentportal.services.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(final FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping(value = "/faculty/add", name = "adding new faculty")
    public ResponseEntity<String> addFaculty(@RequestBody final Faculty faculty) {
        facultyService.addFaculty(faculty);
        return new ResponseEntity<>("Faculty added.", HttpStatus.OK);

    }

    @GetMapping(value = "/faculty", name = "query faculty by department")
    public List<Faculty> findFacultyOfDepartment(@RequestParam(name = "departmentName") final String departmentName) {
        return facultyService.findFacultyOfDepartment(departmentName);
    }
}
