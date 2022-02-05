package com.kennesaw.studentportal.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Faculty {
    @Id
    private String ksuId;

    private String email;

    private String firstName;

    private String lastName;

    private String departmentName;

    private String teachingCourse;
}
