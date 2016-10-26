package com.example.arsa.tasklistapp.model;

/**
 * Created by Arsa on 21-Oct-16.
 */

public class Task {

    private String name;
    private String description;
    private boolean isDone;

    public Task(String name, String description, boolean isDone) {
        this.name = name;
        this.description = description;
        this.isDone = isDone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() { return isDone; }

    public void setDone(boolean done) { isDone = done; }
}
