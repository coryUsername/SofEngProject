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
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;



public class MainViewController implements Initializable{

    private TextField search;
    private TableView<Contact> contacts;
    private TableColumn<Contact, String> contactName;
    private TableColumn<Contact, String> contactSurname;

    //creazione di un oggetto di tipo ContactList

    private ContactList contactList;
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
     * Initialize the data within the table columns.
     * The method called on the columns specifies the steps required to retrieve data from a contact: 
     * cellData contains the data for the row currently being read. 
     * This is achieved by creating an observable property that automatically updates the objects within the table when they are modified.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        contactList=new ContactList();
        
        contacts.setItems(contactList.getContacts());
        contactName.setCellValueFactory(c -> {return new SimpleStringProperty (c.getValue().getName());});
        contactSurname.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSurname()));

    }  
    
    /*va messo nel controller della contact fomr view
     @FXML
    private void addContact(ActionEvent event) {
        contactControllerList.add();
    }
    */
    
    
    /*
    private void addStudent(ActionEvent event) {
        contactControllerList.add(ora );
    }*/
    
    
     private void updateTableView(LinkedList<Contact> contactsList) {
        ObservableList<Contact> observableList = FXCollections.observableArrayList(contactsList);
        contacts.setItems(observableList);
    }
    
    
    private void handleAddContact(ActionEvent event) throws IOException {
        App.setRoot("ContactFormView");
    }
    
    private void handleSearch(ActionEvent event) {
        String substring = search.getText();
        if (substring != null && !substring.isEmpty()) {
            ObservableList<Contact> searchResults=contactList.search(substring);
            contacts.setItems(searchResults); // Aggiorna i dati della TableView
    } else {
        // Se la barra di ricerca è vuota, mostra tutti i contatti
        contacts.setItems(contactList.getContacts());
        }
    }
    
    private void handleSortByName(ActionEvent event) {
        contactList.sort("name");
      contacts.setItems(contactList.getContacts());  }

    private void handleSortBySurname(ActionEvent event) {
        contactList.sort("surname");
      contacts.setItems(contactList.getContacts());  }

    private void handleFilterByFavourite(ActionEvent event) {
        contacts.setItems(contactList.filter("favourite"));
    }

    private void handleFilterByNumber(ActionEvent event) {
        contacts.setItems(contactList.filter("number"));
    }
    private void handleFilterByEmail(ActionEvent event) {
        contacts.setItems(contactList.filter("email"));
    }
}
