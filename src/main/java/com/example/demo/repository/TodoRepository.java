package com.example.demo.repository;

import com.example.demo.domain.TodoItem;
import org.springframework.stereotype.Repository;
import org.springframework.util.IdGenerator;
import org.springframework.util.SimpleIdGenerator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class TodoRepository {

    private IdGenerator idGenerator = new SimpleIdGenerator();

    private Map<UUID, TodoItem> todoItems = new HashMap<>();

    public Collection<TodoItem> getItems() {
        return todoItems.values();
    }

    public TodoItem saveOrUpdate(TodoItem item) {
        TodoItem existingItem = todoItems.get(item.getId());
        if (existingItem == null) {
            return saveNewItem(item);
        } else {
            return updateExistingItem(existingItem, item);
        }
    }

    private TodoItem updateExistingItem(TodoItem existingItem, TodoItem newItem) {
        existingItem.setText(newItem.getText());
        existingItem.setDone(newItem.getDone());
        return existingItem;
    }

    private TodoItem saveNewItem(TodoItem newItem) {
        UUID id = idGenerator.generateId();
        newItem.setId(id);
        todoItems.put(id, newItem);
        return newItem;
    }

    public boolean isExist(UUID id) {
        return todoItems.containsKey(id);
    }

    public boolean isEmpty() {
        return todoItems.isEmpty();
    }
}
