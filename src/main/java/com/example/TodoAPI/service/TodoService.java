package com.example.TodoAPI.service;

import com.example.TodoAPI.mapper.TodoMapper;
import com.example.TodoAPI.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {
    private final TodoMapper todoMapper;

    @Autowired
    public TodoService(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    @Transactional
    public List<Todo> findAll() {
        return todoMapper.findAll();
    }

    @Transactional
    public Todo add(Todo todo) {
        todoMapper.add(todo);
        return todoMapper.findById(todo.getId());
    }

    @Transactional
    public Todo update(Long id, Todo todo) {
        todoMapper.update(id, todo);
        return todoMapper.findById(id);
    }

    @Transactional
    public void delete(Long id) {
        todoMapper.delete(id);
    }
}
