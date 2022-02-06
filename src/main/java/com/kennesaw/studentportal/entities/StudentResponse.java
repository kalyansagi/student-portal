package com.kennesaw.studentportal.entities;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@ToString
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@EqualsAndHashCode(callSuper = false)
@Builder
public class StudentResponse {
    private String ksuId;
    private String email;
    private String confirmationCode;
}
