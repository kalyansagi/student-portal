package com.kennesaw.studentportal.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseRequest {

    private String courseId;
    private String courseName;
    private String departmentName;
}
