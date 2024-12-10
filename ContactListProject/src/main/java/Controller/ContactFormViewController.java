/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author corys
 */
public class ContactFormViewController implements Initializable {

    @FXML
    private Button save;
    @FXML
    private Button noSave;
    @FXML
    private CheckBox isFavourite;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField number1;
    @FXML
    private TextField number2;
    @FXML
    private TextField number3;
    @FXML
    private TextField email1;
    @FXML
    private TextField email2;
    @FXML
    private TextField email3;
    @FXML
    private TextField company;
    @FXML
    private TextField IBAN;
    @FXML
    private TextField address;
    @FXML
    private TextField website;
    @FXML
    private TextArea notes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSave(ActionEvent event) {
    }

    @FXML
    private void handleBack(ActionEvent event) {
    }
    
}
