package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField nameField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox clearCheckBox;
    @FXML
    private Label ourLabel;

    @FXML
    public void initialize() {
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonclicked(ActionEvent e) {
        if (e.getSource() == helloButton) {
            System.out.println("Hello, " + nameField.getText());
        } else if (e.getSource() == byeButton) {
            System.out.println("Bye, " + nameField.getText());
        }
        Runnable task = new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        String s = Platform.isFxApplicationThread() ? "UI thread" : "background thread";
                        System.out.println("Sleeping on: " + s);
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    int finalI = i;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI thread" : "background thread";
                            System.out.println("Updating on: " + s);
                            ourLabel.setText("Running counting: " + (10- finalI));
                        }
                    });
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ourLabel.setText("Done!");
                    }
                });
            }
        };
        new Thread(task).start();

        if (clearCheckBox.isSelected()) {
            nameField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }
        System.out.println("The button is clicked: " + e.getSource());
    }

    @FXML
    public void handleKeyRelease() {
        String text = nameField.getText();
        Boolean disableButton = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButton);
        byeButton.setDisable(disableButton);
    }

    @FXML
    public void handleChange() {
        System.out.println("Checkbox is " + (clearCheckBox.isSelected() ? "" : "un") + "checked");
    }
}
