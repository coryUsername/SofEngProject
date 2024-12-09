/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Contact;
import Model.ContactList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;



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
    private TableView<Contact> contacts;
    @FXML
    private TableColumn<Contact, String> contactName;
    @FXML
    private TableColumn<Contact, String> contactSurname;

    
    private ContactList contactList = new ContactList();
   

    /*
    Inizializza i dati presenti all'interno delle colonne della tabella. 
    Il metodo che viene chiamato sulle colonne specifica i passi dell'operazione di
    prelievo dei dati da un contatto: cellData contiene quindi i dati della riga che
    si sta andando a leggere, ciò avviene creando una propietà osservabile che aggiorna
    automaticamente gli oggetti all'interno della tabella quando vengono modificati.
    */
    @Override
    public void initialize() {
        
        contactName.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getName()));

        contactSurname.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getSurname()));

    }    

    @FXML
    private void handleAddContact(ActionEvent event) throws IOException {
        App.setRoot("ContactFormView");
    }
    
}
