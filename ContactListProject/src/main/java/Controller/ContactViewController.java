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
    private CheckBox favourite;
    @FXML
    private Button modifyBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button backBtn;
    @FXML
    private Label nameLbl;
    @FXML
    private Label surnameLbl;
    @FXML
    private Label phoneNumber1Lbl;
    @FXML
    private Label phoneNumber2Lbl;
    @FXML
    private Label phoneNumber3Lbl;
    @FXML
    private Label email1Lbl;
    @FXML
    private Label email2Lbl;
    @FXML
    private Label email3Lbl;
    @FXML
    private Label companyLbl;
    @FXML
    private Label IBANLbl;
    @FXML
    private Label addressLbl;
    @FXML
    private Label websiteLbl;
    @FXML
    private Label notesLbl;
    
    private Contact contact;

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
        
        MainViewController.contactList.delete(contact);
        
    }

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        
        App.setRoot("MainView");
        
    }

    public void setContact(Contact contact) {
        nameLbl.setText(contact.getName());
        surnameLbl.setText(contact.getSurname());
        phoneNumber1Lbl.setText(contact.getPhoneNumber1());
        phoneNumber2Lbl.setText(contact.getPhoneNumber2());
        phoneNumber3Lbl.setText(contact.getPhoneNumber3());
        email1Lbl.setText(contact.getEmail1());
        email2Lbl.setText(contact.getEmail2());
        email3Lbl.setText(contact.getEmail3());
        companyLbl.setText(contact.getCompany());
        IBANLbl.setText(contact.getIBAN());
        addressLbl.setText(contact.getAddress());
        websiteLbl.setText(contact.getWebsite());
        notesLbl.setText(contact.getNotes());
        favourite.setSelected(contact.isFavourite());
    }

}
