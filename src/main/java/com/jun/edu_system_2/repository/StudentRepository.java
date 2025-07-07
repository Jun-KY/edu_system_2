package com.jun.edu_system_2.repository;

import com.jun.edu_system_2.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository@RequiredArgsConstructor
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;
    public int save(Student student){
        return jdbcTemplate.update(
                "INSERT INTO student (name, score, teacher_id) VALUES (?, ?, ?)",
                student.getName(), student.getScore(), student.getTeacherId()
        );
    }

}
