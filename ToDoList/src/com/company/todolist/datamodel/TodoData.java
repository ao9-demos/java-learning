package com.company.todolist.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class TodoData {
    private static TodoData instance;
    private static String filename;

    private DateTimeFormatter formatter;
    private ObservableList<TodoItem> todoItems;

    private TodoData() {
        filename = "TodoListItems.txt";
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public static TodoData getInstance() {
        if (instance == null) {
            instance = new TodoData();
        }
        return instance;
    }

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void loadTodoItems() throws IOException {
        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;
        try {
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");
                String description = itemPieces[0];
                String details = itemPieces[1];
                String date = itemPieces[2];
                String color = itemPieces[3];

                LocalDate deadline = (!date.equals("none")) ? LocalDate.parse(date, formatter) : null;
                Color background = Color.valueOf(color);

                TodoItem todoItem = new TodoItem(description, details, deadline,background);
                todoItems.add(todoItem);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public void storeTodoItems() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        Iterator<TodoItem> itr = todoItems.iterator();

        try {
            while (itr.hasNext()) {
                TodoItem todoItem = itr.next();
                bw.write(String.format("%s\t%s\t%s\t%s",
                        todoItem.getDescription(),
                        todoItem.getDetails(),
                        (todoItem.getDeadline() != null ? todoItem.getDeadline().format(formatter) : "none"),
                        todoItem.getBackground().toString()));
                bw.newLine();
            }
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }
}
