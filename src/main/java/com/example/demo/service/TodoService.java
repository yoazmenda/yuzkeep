package com.example.demo.service;

import com.example.demo.domain.TodoItem;
import com.example.demo.exception.TodoItemNotFoundException;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Collection<TodoItem> getItems() {
        if (todoRepository.isEmpty()) {
            TodoItem item1 = new TodoItem.Builder()
                    .text("This is your first Todo item")
                    .done(true)
                    .build();
            TodoItem item2 = new TodoItem.Builder()
                    .text("This is your second Todo item")
                    .done(false)
                    .build();
            todoRepository.saveOrUpdate(item1);
            todoRepository.saveOrUpdate(item2);
        }
        return todoRepository.getItems();
    }

    public TodoItem updateItem(UUID id, TodoItem item) {
        if (!todoRepository.isExist(id)) {
            throw new TodoItemNotFoundException("Todo item " + id + " does not exist");
        } else {
            return todoRepository.saveOrUpdate(item);
        }
    }
}
