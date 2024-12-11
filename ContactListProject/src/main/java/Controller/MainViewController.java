package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Contact;
import Model.ContactList;
import View.App;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainViewController implements Initializable {

    @FXML
    private TextField search;
    @FXML
    private TableView<Contact> contacts;
   
   /**
    *  for Test
    * */ 
public TableView<Contact> getContacts() {
    return contacts;
}  public void setContacts(ObservableList<Contact> contacts) {
    this.contacts.setItems(contacts);
}
    public void setContacts(TableView<Contact> contacts) {
        this.contacts = contacts;
    }


    @FXML
    private TableColumn<Contact, String> contactName;
    @FXML
    private TableColumn<Contact, String> contactSurname;

    public static ContactList contactList;

    @FXML
    private Button sortByName;
    @FXML
    private Button sortBySurname;
    @FXML
    private Button importBtn;
    @FXML
    private Button addBtn;
    @FXML
    private Button exportBtn;
    @FXML
    private Button filterByFavourite;
    @FXML
    private Button filterByNumber;
    @FXML
    private Button filterByEmail;
    @FXML
    private Button clearBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (contactList == null) {
            contactList = new ContactList();
        }

        contacts.setItems(contactList.getContacts());

        contactName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        contactSurname.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getSurname()));
    }
    
    

    @FXML
    private void handleAddContact(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ContactFormView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) addBtn.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        App.setRoot("ContactFormView");
    }
    @FXML
    private void handleSearch(ActionEvent event) {
        String substring = search.getText();
        if (substring != null && !substring.isEmpty()) {
            ObservableList<Contact> searchResults = contactList.search(substring);
            contacts.setItems(searchResults);
        } else {
            contacts.setItems(contactList.getContacts());
        }
    }
    @FXML
    private void handleSortByName(ActionEvent event) {
        contactList.sort("name");
        contacts.setItems(contactList.getContacts());
    }
    @FXML
    private void handleSortBySurname(ActionEvent event) {
        contactList.sort("surname");
        contacts.setItems(contactList.getContacts());
    }
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
    @FXML
    private void openContact(MouseEvent event) throws IOException {
        if (event.getClickCount() == 2) {
            Contact selectedContact = contacts.getSelectionModel().getSelectedItem();
            showContactDetails(selectedContact);
        }
    }

    private void showContactDetails(Contact contact) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ContactView.fxml"));
        Parent root = loader.load();
        ContactViewController controller = loader.getController();
        controller.setContact(contact);
        Stage stage = (Stage) contacts.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleImportBtn(ActionEvent event) {
    }

    @FXML
    private void handleExportBtn(ActionEvent event) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("contatti");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File csv", "*.csv"));
        File selectedFile = fileChooser.showSaveDialog(contacts.getScene().getWindow());
        if (selectedFile != null) {
            try (PrintWriter writer = new PrintWriter(selectedFile)) {
                writer.println("nome;cognome;telefono1;telefono2;telefono3;email1;email2;email3;azienda;iban;indirizzo;sito;note");
                for (Contact contact : contactList.getContacts()) {
                    writer.println(contact.toCsv());
                }
            }
        }
    }

    @FXML
    private void handleClearBtn(ActionEvent event) {
        
        contacts.setItems(contactList.getContacts());
        
    }


}
