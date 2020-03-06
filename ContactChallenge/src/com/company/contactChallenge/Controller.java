package com.company.contactChallenge;

import com.company.contactChallenge.contactModel.Contact;
import com.company.contactChallenge.contactModel.ContactData;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import java.io.IOException;
import java.util.Optional;

public class Controller {
    @FXML
    private TableView<Contact> table;
    @FXML
    private TableColumn<Contact, String> firstNameColumn;
    @FXML
    private TableColumn<Contact, String> lastNameColumn;
    @FXML
    private TableColumn<Contact, String> phoneNumberColumn;
    @FXML
    private TableColumn<Contact, String> notesColumn;
    @FXML
    private BorderPane mainBorderPane;

    private ContactData data;

    public void initialize() {
        data = ContactData.getInstance();
        table.setItems(data.getContacts());
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));
        table.getSelectionModel().selectFirst();
    }

    @FXML
    public void showAddContactDialog() throws IOException {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Add contact");
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContactDialog.fxml"));
        dialog.getDialogPane().setContent(fxmlLoader.load());
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            ContactDialogController controller = fxmlLoader.getController();
            controller.addContact();
        }
    }

    @FXML
    public void showEditContactDialog() throws IOException {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Edit contact");
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ContactDialog.fxml"));
        dialog.getDialogPane().setContent(fxmlLoader.load());
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        ContactDialogController controller = fxmlLoader.getController();
        Contact contact = table.getSelectionModel().getSelectedItem();
        controller.setFields(contact);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            controller.saveData(contact);
        }
    }

    @FXML
    public void handleMouseClicked(MouseEvent event) throws IOException {
        if(event != null){
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
                showEditContactDialog();
            }
        }
    }

    @FXML
    public void handleDeletePressed(KeyEvent event){
        if (event != null) {
            if(event.getCode().equals(KeyCode.DELETE)){
                deleteContact();
            }
        }
    }

    @FXML
    public void deleteContact(){
        Contact contact = table.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deleting todo item");
        alert.setHeaderText("Do you want to delete todo item " + contact.getFirstName() + " " + contact.getLastName() + " ?");
        alert.setContentText("Press OK to confirm, Cancel to back out");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            data.deleteContact(contact);
        }
    }
}
