package com.kennesaw.studentportal.entities.database;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
@Builder
@Entity
public class Course {
    @Id
    private String uuid;

    private String courseId;

    private String courseName;

    private String departmentName;
}
