package com.example.TodoAPI.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Todo {
    private Long id;
    private String title;
    private String description;
    private Boolean isCompleted;
    private LocalDate dueDate;
    private LocalDate createdAt;
}
