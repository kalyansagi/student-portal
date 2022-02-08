package com.kennesaw.studentportal.repository;

import com.kennesaw.studentportal.entities.Faculty;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;

@Component
@RequiredArgsConstructor
public class FacultyMapper implements RowMapper<Faculty> {

    @SneakyThrows
    @Override
    public Faculty mapRow(@NonNull final ResultSet resultSet, final int rowNumber) {
        return new Faculty(resultSet.getString("ksu_id"),
                resultSet.getString("email"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("department_name"),
                resultSet.getString("teaching_course")
        );
    }
}
