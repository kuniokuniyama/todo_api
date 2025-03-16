package com.example.TodoAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TodoAPI.model.Todo;
import com.example.TodoAPI.service.TodoService;
import com.example.TodoAPI.util.ResponseUtil;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
    private final ResponseUtil responseUtil;

    @GetMapping("")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.findAll();
        return responseUtil.createCacheableResponse(todos);
    }

    @PostMapping("")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.add(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
        return HttpStatus.OK;
    }
}
