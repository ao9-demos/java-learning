package com.company.todolist;

import com.company.todolist.datamodel.TodoData;
import com.company.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField descriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePicker;
    @FXML
    private ColorPicker backgroundPicker;

    public TodoItem saveNewItem() {
        String description = descriptionField.getText();
        String details = detailsArea.getText();
        LocalDate deadline = deadlinePicker.getValue();
        Color background = backgroundPicker.getValue();
        TodoItem newItem = new TodoItem(description, details, deadline, background);
        TodoData.getInstance().getTodoItems().add(newItem);
        return newItem;
    }

    public void readItemData(TodoItem item) {
        descriptionField.setText(item.getDescription());
        detailsArea.setText(item.getDetails());
        deadlinePicker.setValue(item.getDeadline());
        backgroundPicker.setValue(item.getBackground());
    }

    public void editItemData(TodoItem item){
        item.setDescription(descriptionField.getText());
        item.setDetails(detailsArea.getText());
        item.setDeadline(deadlinePicker.getValue());
        item.setBackground(backgroundPicker.getValue());
    }
}
