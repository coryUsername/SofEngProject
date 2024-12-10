/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
    private Label Surname;
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
        // TODO
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
    
}
