/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Contact;
import View.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 */
public class ContactViewController implements Initializable {


    @FXML
    private Button modify;
    @FXML
    private Button delete;
    @FXML
    private Button back;
    @FXML
    private CheckBox favourite;
    @FXML
    private Label name;
    @FXML
    private Label surname;
    @FXML
    private Label phoneNumber1;
    @FXML
    private Label phoneNumber2;
    @FXML
    private Label phoneNumber3;
    @FXML
    private Label email1;
    @FXML
    private Label email2;
    @FXML
    private Label email3;
    @FXML
    private Label company;
    @FXML
    private Label IBAN;
    @FXML
    private Label address;
    @FXML
    private Label website;
    @FXML
    private Label notes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void handleModify(ActionEvent event) throws IOException {
        App.setRoot("ContactFormView");
    
    }

    @FXML
    private void handleDelete(ActionEvent event) {
    }

    @FXML
    private void handleBack(ActionEvent event) {
    }
    public void setContact(Contact contact) {
        name.setText(contact.getName());
        surname.setText(contact.getSurname());
        phoneNumber1.setText(contact.getPhoneNumber1());
        phoneNumber2.setText(contact.getPhoneNumber2());
        phoneNumber3.setText(contact.getPhoneNumber3());
        email1.setText(contact.getEmail1());
        email2.setText(contact.getEmail2());
        email3.setText(contact.getEmail3());
        company.setText(contact.getCompany());
        IBAN.setText(contact.getIBAN());
        address.setText(contact.getAddress());
        website.setText(contact.getWebsite());
        notes.setText(contact.getNotes());
        favourite.setSelected(contact.isFavourite());
    }
    
}
