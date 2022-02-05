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
public class Student {

    @Id
    private String ksuId;

    private String email;

    private String firstName;

    private String lastName;

    private String course;
}
