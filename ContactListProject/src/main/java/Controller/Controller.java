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



public class Controller implements Initializable{

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

    //creazione di un oggetto di tipo ContactList

    private ContactList contactList;

    /*
    Inizializza i dati presenti all'interno delle colonne della tabella. 
    Il metodo che viene chiamato sulle colonne specifica i passi dell'operazione di
    prelievo dei dati da un contatto: cellData contiene quindi i dati della riga che
    si sta andando a leggere, ciò avviene creando una propietà osservabile che aggiorna
    automaticamente gli oggetti all'interno della tabella quando vengono modificati.
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ///inutile poichè viene inizializzato nel costruttore della classe ContactList
        //contactList=FXCollections.observableArrayList();
        contactList=new ContactList();
        
        contacts.setItems(contactList.getContacts());
        contactName.setCellValueFactory(c -> {return new SimpleStringProperty (c.getValue().getName());});
        contactSurname.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSurname()));

    }  
    
     @FXML
    private void addStudent(ActionEvent event) {
        contactControllerList.add(///)
    }
    
    @FXML
     private void updateTableView(LinkedList<Contact> contactsList) {
        ObservableList<Contact> observableList = FXCollections.observableArrayList(contactsList);
        contacts.setItems(observableList);
    }
    
    
    @FXML
    private void handleAddContact(ActionEvent event) throws IOException {
        App.setRoot("ContactFormView");
    }
    
     @FXML
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
    
    @FXML
    private void handleSortByName(ActionEvent event) {
        contactList.sort("name");
      contacts.setItems(contactList.getContacts());  }

    @FXML
    private void handleSortBySurname(ActionEvent event) {
        contactList.sort("surname");
      contacts.setItems(contactList.getContacts());  }

    @FXML
    private void handleFilterByFavourite(ActionEvent event) {
        contacts.setItems(contactList.filter("favourite"));
    }

    @FXML
    private void handleFilterByNumber(ActionEvent event) {
        contacts.setItems(contactList.filter("number"));
    }
     @FXML
    private void handleFilterByEmail(ActionEvent event) {
        contacts.setItems(contactList.filter("email"));
    }
}
