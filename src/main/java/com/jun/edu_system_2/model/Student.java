package com.jun.edu_system_2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class Student {
    private Integer id;
    private String name;
    private Integer score;
    private Integer teacherId;
    private String teacherName;


}
