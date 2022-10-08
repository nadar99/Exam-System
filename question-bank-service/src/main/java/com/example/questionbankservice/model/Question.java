package com.example.questionbankservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Document
public class Question {
    @Id
    private String id;
    private String name;
    private String level;
    private String type;
    private String category_id;
    private String sub_category;
    private Double mark;
    private Integer expected_time;
    private String created_by;
    private LocalDateTime created_at;
    @Transient
    private String category_name;

}
