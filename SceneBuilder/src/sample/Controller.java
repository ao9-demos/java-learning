package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label label;

    @FXML
    public void handleOKPressed(){
        label.setText("OK pressed");
    }

    @FXML
    public void handleCancelPressed(){
        label.setText("Cancel pressed");
    }

    @FXML
    public void handleHelpPressed(){
        label.setText("Help pressed");
    }
}
