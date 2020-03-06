package com.company.todolist;

import com.company.todolist.datamodel.TodoData;
import com.company.todolist.datamodel.TodoItem;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

public class Controller {
    @FXML
    private ListView todoListView;
    @FXML
    private TextArea todoDetails;
    @FXML
    private DatePicker deadlinePicker;
    @FXML
    private ColorPicker bkgColorPicker;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private ContextMenu listContextMenu;
    @FXML
    private ToggleButton filterToggleButton;

    private FilteredList<TodoItem> filteredList;
    private Predicate<TodoItem> wantTodaysItem;

    public void initialize() {
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem todoItem, TodoItem t1) {
                if (t1 != null) {
                    TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
                    String s = item.getDetails();
                    todoDetails.setText(s);
                    deadlinePicker.setValue(item.getDeadline());
                    todoDetails.setStyle("-fx-control-inner-background: " + format(item.getBackground()));
                    bkgColorPicker.setValue(item.getBackground());
                } else {
                    todoDetails.setText("");
//                    deadlinePicker.setValue(LocalDate.now());
                    todoDetails.setStyle("-fx-control-inner-background: white");
                    bkgColorPicker.setValue(Color.WHITE);
                }
            }
        });

        todoDetails.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (t1 != null) {
                    TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
                    if (item != null) {
                        String details = todoDetails.getText();
                        item.setDetails(details);
                    }
                }
            }
        });

        deadlinePicker.setConverter(new StringConverter<LocalDate>() {
            String pattern = "MMM dd, yyyy";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            {
                deadlinePicker.setPromptText(pattern.toLowerCase());
            }

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        deadlinePicker.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observableValue, LocalDate localDate, LocalDate t1) {
                TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
                if (item != null) {
                    if (t1 != null) {
                        System.out.println(item);
                        LocalDate deadline = deadlinePicker.getValue();
                        item.setDeadline(deadline);
                        sortItems();
                    }
                }
            }
        });

        bkgColorPicker.valueProperty().addListener(new ChangeListener<Color>() {
            @Override
            public void changed(ObservableValue<? extends Color> observableValue, Color color, Color t1) {
                if (t1 != null) {
                    TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
                    if (item != null) {
                        Color background = bkgColorPicker.getValue();
                        todoDetails.setStyle("-fx-control-inner-background: " + format(t1));
                        item.setBackground(background);
                    }
                }
            }
        });

        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("delete");
        listContextMenu.getItems().addAll(deleteMenuItem);
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                deleteItem();
            }
        });

//      a shallow copy, items in TodoData and ListView are the same ones;
        todoListView.setItems(TodoData.getInstance().getTodoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> param) {
                ListCell<TodoItem> cell = new ListCell<TodoItem>() {
                    @Override
                    protected void updateItem(TodoItem item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setText(null);
                        } else {
                            setText(item.getDescription());
                            setFont(Font.font("Arial", 18));
                            if (item.getDeadline() != null && item.getDeadline().isBefore(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.MEDIUMVIOLETRED);
                            }
                        }
                    }
                };
                cell.emptyProperty().addListener(
                        (obs, wasEmpty, isNowEmpty) -> {
                            if (isNowEmpty) {
                                cell.setContextMenu(null);
                            } else {
                                cell.setContextMenu(listContextMenu);
                            }
                        });
                return cell;
            }
        });

        wantTodaysItem = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem item) {
                return item.getDeadline().isEqual(LocalDate.now());
            }
        };
    }

    private String format(Color c) {
        int r = (int) (255 * c.getRed());
        int g = (int) (255 * c.getGreen());
        int b = (int) (255 * c.getBlue());
        return String.format("#%02x%02x%02x", r, g, b);
    }

    @FXML
    public void showNewItemDialog() throws IOException {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Add new todo item");
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("todoItemDialog.fxml"));
        dialog.getDialogPane().setContent(fxmlLoader.load());
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            TodoItem newItem = controller.saveNewItem();
            sortItems();
            todoListView.getSelectionModel().select(newItem);
        }
    }

    @FXML
    public void sortItems() {
        System.out.println("sorting");
        if (!filterToggleButton.isSelected()) {
            if (todoListView != null) {
                todoListView.getItems().sort(new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        if (o1 == o2) {
                            return 0;
                        }
                        LocalDate date1 = ((TodoItem) o1).getDeadline();
                        LocalDate date2 = ((TodoItem) o2).getDeadline();
                        return date1 != null ? (date2 != null ? date1.compareTo(date2) : -1) : (date2 != null ? 1 : 0);
                    }
                });
            }
        }
    }

    @FXML
    public void showEditItemDialog() throws IOException {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Edit todo item");
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("todoItemDialog.fxml"));
        dialog.getDialogPane().setContent(fxmlLoader.load());
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
        DialogController controller = fxmlLoader.getController();
        controller.readItemData(item);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            controller.editItemData(item);
            sortItems();
            todoListView.getSelectionModel().select(item);
        }
    }

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) {
        System.out.println(keyEvent.getCode());
        if (keyEvent.getCode().equals(KeyCode.DELETE)) {
            deleteItem();
        }
    }

    @FXML
    public void handleMouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getButton().equals(MouseButton.PRIMARY) && mouseEvent.getClickCount() == 2) {
            try {
                showEditItemDialog();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void deleteItem() {
        TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deleting todo item");
        alert.setHeaderText("Do you want to delete todo item " + item.getDescription() + " ?");
        alert.setContentText("Press OK to confirm, Cancel to back out");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            TodoData.getInstance().getTodoItems().remove(item);
            int index = todoListView.getItems().indexOf(item);
            if (index > 0) {
                todoListView.getSelectionModel().select(index - 1);
            } else if (todoListView.getItems().size() > 0) {
                todoListView.getSelectionModel().select(0);
            }
        }
    }

    public void handleFilterButton() {
        TodoItem selectedItem = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
        if (filterToggleButton.isSelected()) {
            filteredList = new FilteredList<>(TodoData.getInstance().getTodoItems(), wantTodaysItem);
            for (TodoItem item : filteredList) {
                System.out.println(item);
            }
            todoListView.setItems(filteredList);
            if (todoListView.getItems().contains(selectedItem)) {
                todoListView.getSelectionModel().select(selectedItem);
            } else {
                todoListView.getSelectionModel().selectFirst();
            }
        } else {
            todoListView.setItems(TodoData.getInstance().getTodoItems());
            todoListView.getSelectionModel().select(selectedItem);
        }
    }

    public void handleExit(){
        Platform.exit();
    }
}
