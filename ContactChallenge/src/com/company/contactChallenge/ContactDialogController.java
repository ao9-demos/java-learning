package com.company.contactChallenge;

import com.company.contactChallenge.contactModel.Contact;
import com.company.contactChallenge.contactModel.ContactData;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ContactDialogController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField notesField;

    public void addContact() {
        Contact newContact = new Contact(firstNameField.getText(),
                lastNameField.getText(),
                phoneNumberField.getText(),
                notesField.getText());
        ContactData.getInstance().addContact(newContact);
    }

    public void setFields(Contact contact) {
        this.firstNameField.setText(contact.getFirstName());
        this.lastNameField.setText(contact.getLastName());
        this.phoneNumberField.setText(contact.getPhoneNumber());
        this.notesField.setText(contact.getNotes());
    }

    public void saveData(Contact contact) {
        contact.setFirstName(firstNameField.getText());
        contact.setLastName(lastNameField.getText());
        contact.setPhoneNumber(phoneNumberField.getText());
        contact.setNotes(notesField.getText());
    }
}
