package com.example.TodoAPI.mapper;

import com.example.TodoAPI.model.Todo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TodoMapper {
    List<Todo> findAll();

    Todo findById(Long id);

    void add(Todo todo);

    void update(@Param("id") Long id, @Param("todo") Todo todo);

    void delete(Long id);
}
