/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mario Stanco
 */
public class Controller implements Initializable {

    @FXML
    private Button add;
    @FXML
    private TextField search;
    @FXML
    private Button importBtn;
    @FXML
    private Button sortByName;
    @FXML
    private Button sortBySurname;
    @FXML
    private Button filerByFavourite;
    @FXML
    private Button filerByNumber;
    @FXML
    private Button filerByEmail;
    @FXML
    private TableView<?> contacts;
    @FXML
    private TableColumn<?, ?> contactName;
    @FXML
    private TableColumn<?, ?> contactSurname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
