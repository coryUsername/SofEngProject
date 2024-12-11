package Controller;

import Model.Contact;
import Model.ContactList;
import View.App;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainViewController implements Initializable {

    @FXML
    private TextField search;
    @FXML
    private TableView<Contact> contacts;

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
    private Button filerByFavourite;
    @FXML
    private Button filerByNumber;
    @FXML
    private Button filerByEmail;
    @FXML
    private Button importBtn;
    @FXML
    private Button addBtn;
    @FXML
    private Button exportBtn;

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
        App.setRoot("ContactFormView");
    }
    private void handleSearch(ActionEvent event) {
        String substring = search.getText();
        if (substring != null && !substring.isEmpty()) {
            ObservableList<Contact> searchResults = contactList.search(substring);
            contacts.setItems(searchResults);
        } else {
            contacts.setItems(contactList.getContacts());
        }
    }
    private void handleSortByName(ActionEvent event) {
        contactList.sort("name");
        contacts.setItems(contactList.getContacts());
    }
    private void handleSortBySurname(ActionEvent event) {
        contactList.sort("surname");
        contacts.setItems(contactList.getContacts());
    }
    private void handleFilterByFavourite(ActionEvent event) {
        contacts.setItems(contactList.filter("favourite"));
    }
    private void handleFilterByNumber(ActionEvent event) {
        contacts.setItems(contactList.filter("number"));
    }
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

}
