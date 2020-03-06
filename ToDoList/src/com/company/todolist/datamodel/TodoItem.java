package com.company.todolist.datamodel;

import javafx.scene.paint.Color;

import java.time.LocalDate;

public class TodoItem {
    private String description;
    private String details;
    private LocalDate deadline;
    private Color background;

    public TodoItem(String description, String details, LocalDate deadline, Color background) {
        this.description = description;
        this.details = details;
        this.deadline = deadline;
        this.background = background;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    @Override
    public String toString() {
        return description;
    }
}
