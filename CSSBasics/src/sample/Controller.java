package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Controller {
    @FXML
    private Label label;
    @FXML
    private Button button4;
    @FXML
    private GridPane gridPane;
    @FXML
    private WebView webView;

    public void initialize() {
        button4.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseEntered() {
        label.setScaleX(2.5);
        label.setScaleY(2.5);
        label.setRotate(90);
    }

    @FXML
    public void handleMouseExited() {
        label.setScaleX(1.0);
        label.setScaleY(1.0);
        label.setRotate(0);
    }

    @FXML
    public void handleClicked() {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("ZIP", "*.zip"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.png", "*.jpeg", "*.gif"),
                new FileChooser.ExtensionFilter("All files", "*.*")

        );
        List<File> file = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
        if (file != null) {
            for (int i = 0; i < file.size(); i++) {
                System.out.println(file.get(i).getPath());
            }
        }
    }

    @FXML
    public void handleClicked2() {
        DirectoryChooser chooser = new DirectoryChooser();
        File file = chooser.showDialog(gridPane.getScene().getWindow());
        if (file != null) {
            System.out.println(file.getPath());
        }
    }

    @FXML
    public void handleClicked3() {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf")
        );
        File file = chooser.showSaveDialog(gridPane.getScene().getWindow());
        if (file != null) {
            System.out.println(file.getPath());
        }
    }

    @FXML
    public void handleClicked4() {
        WebEngine webEngine = webView.getEngine();
        System.out.println(webEngine);
        webEngine.load("http://www.javafx.com");
//        try {
//            Desktop.getDesktop().browse(new URI("www.javafx.com"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

    }
}
