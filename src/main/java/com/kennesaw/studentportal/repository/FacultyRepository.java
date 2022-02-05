package com.kennesaw.studentportal.repository;

import com.kennesaw.studentportal.entities.Faculty;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FacultyRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final String INSERT_FACULTY_RECORD = "Insert into public.faculty (ksu_id, email, first_name, last_name, department_name, teaching_course ) " +
            "values ( " +
            ":ksu_id, :email, :first_name, :last_name, :department_name, :teaching_course)";

    public void insertFacultyRecord(final Faculty faculty) {
        try {
            jdbcTemplate.update(INSERT_FACULTY_RECORD, createFacultyRecord(faculty));
        } catch (Exception e) {
            System.out.println("exception occurred" + e);
        }
    }

    private SqlParameterSource createFacultyRecord(final Faculty faculty) {
        return new MapSqlParameterSource()
                .addValue("ksu_id", faculty.getKsuId())
                .addValue("email", faculty.getEmail())
                .addValue("first_name", faculty.getFirstName())
                .addValue("last_name", faculty.getLastName())
                .addValue("department_name", faculty.getDepartmentName())
                .addValue("teaching_course", faculty.getTeachingCourse());
    }
}
