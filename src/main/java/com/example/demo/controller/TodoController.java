package com.example.demo.controller;

import com.example.demo.domain.TodoItem;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;


    @GetMapping(value = "/api/items")
    public ResponseEntity<Collection<TodoItem>> getAllItems() {
        Collection<TodoItem> todoItems = todoService.getItems();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoItems);
    }

    @PutMapping(value = "/api/items/{uuid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TodoItem> updateItem(@PathVariable UUID uuid, @RequestBody TodoItem item) {
        TodoItem updatedItem = todoService.updateItem(uuid, item);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedItem);
    }


}
