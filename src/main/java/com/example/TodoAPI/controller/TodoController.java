package com.example.TodoAPI.controller;

import com.example.TodoAPI.model.Todo;
import com.example.TodoAPI.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/all")
    public List<Todo> getAllTodos() {
        return todoService.findAll();
    }

    @PostMapping("/add")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.add(todo);
    }

    @PutMapping("/update/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
        return HttpStatus.OK;
    }
}
