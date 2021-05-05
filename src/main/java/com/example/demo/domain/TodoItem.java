package com.example.demo.domain;

import org.apache.logging.log4j.util.Strings;

import java.util.UUID;

public class TodoItem {

    public static class Builder {

        public TodoItem build() {
            TodoItem todoItem = new TodoItem();
            todoItem.setDone(this.done);
            if (this.text != null) {
                todoItem.setText(this.text);
            } else {
                todoItem.setText(Strings.EMPTY);
            }
            return todoItem;
        }

        private String text;
        private Boolean done;

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder done(Boolean initialState) {
            this.done = initialState;
            return this;
        }
    }

    public TodoItem() {
    }

    public TodoItem(UUID id, String text, Boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }

    private UUID id;
    private String text;
    private Boolean done;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

}
