package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Contact;
import Model.ContactList;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @file MainViewController.java
 * @brief Controller for the main view, managing contact list interactions such as adding, 
 * sorting, searching, filtering, importing, and exporting contacts.
 * 
 */
public class MainViewController implements Initializable {

  @FXML
  private TextField search; // Search field for filtering contacts by name or surname.

  @FXML
  private TableView<Contact> contacts; // Table view displaying the contact list.

  @FXML
  private TableColumn<Contact, String> contactName; // Table column for displaying contact names.

  @FXML
  private TableColumn<Contact, String> contactSurname;// Table column for displaying contact surnames.

  public static ContactList contactList; // Static contact list to hold all contacts.

  @FXML
  private Button sortByName; // Button for sorting contacts by name.

  @FXML
  private Button sortBySurname; // Button for sorting contacts by surname.

  @FXML
  private Button importBtn; // Button for importing contacts from a CSV file.

  @FXML
  private Button addBtn; // Button for adding a new contact.

  @FXML
  private Button exportBtn; // Button for exporting contacts to a CSV file.

  @FXML
  private Button filterByFavourite; // Button for filtering contacts by favourite status.

  @FXML
  private Button filterByNumber; // Button for filtering contacts by phone number.

  @FXML
  private Button filterByEmail; // Button for filtering contacts by email address.

  @FXML
  private Button clearBtn; // Button to clear all filters and reset the contact list.

  /**
   * Initializes the controller class.
   * 
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    if (contactList == null) {
      contactList = new ContactList();
    }

    contacts.setItems(contactList.getContacts());

    contactName.setCellValueFactory(c ->
      new SimpleStringProperty(c.getValue().getName())
    );
    contactSurname.setCellValueFactory(c ->
      new SimpleStringProperty(c.getValue().getSurname())
    );
  }

   /**
   * Handles the action of adding a new contact by opening the contact form view.
   *
   * @param event the ActionEvent triggered by the add button.
   * @throws IOException if there is an error loading the contact form FXML file.
   */
  @FXML
  private void handleAddContact(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(
      getClass().getResource("/View/ContactFormView.fxml")
    );
    Parent root = loader.load();
    Stage stage = (Stage) addBtn.getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }


  /**
   * Handles the action of searching contacts by a substring entered in the search field.
   * Filters contacts based on the substring.
   *
   * @param event the ActionEvent triggered by the search action.
   */
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

  
  /**
   * Handles sorting the contact list by name.
   *
   * @param event the ActionEvent triggered by the sort by name button.
   */
  @FXML
  private void handleSortByName(ActionEvent event) {
    ObservableList<Contact> sortedContacts = FXCollections.observableArrayList(contacts.getItems());
    sortedContacts.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
    contacts.setItems(sortedContacts);
  }

  /**
   * Handles sorting the contact list by surname.
   *
   * @param event the ActionEvent triggered by the sort by surname button.
   */
  @FXML
  private void handleSortBySurname(ActionEvent event) {
    ObservableList<Contact> sortedContacts = FXCollections.observableArrayList(contacts.getItems());
    sortedContacts.sort((o1, o2) -> o1.getSurname().compareTo(o2.getSurname()));
    contacts.setItems(sortedContacts);
  }


   /**
   * Filters the contact list to display only favourite contacts.
   *
   * @param event the ActionEvent triggered by the filter by favourite button.
   */
  @FXML
  private void handleFilterByFavourite(ActionEvent event) {
    contacts.setItems(contactList.filter("favourite"));
  }
  
  /**
   * Filters the contact list to display contacts with phone numbers.
   *
   * @param event the ActionEvent triggered by the filter by number button.
   */
  @FXML
  private void handleFilterByNumber(ActionEvent event) {
    contacts.setItems(contactList.filter("number"));
  }

  /**
   * Filters the contact list to display contacts with email addresses.
   *
   * @param event the ActionEvent triggered by the filter by email button.
   */
  @FXML
  private void handleFilterByEmail(ActionEvent event) {
    contacts.setItems(contactList.filter("email"));
  }

  /**
   * Opens the contact details view when a contact is double-clicked.
   *
   * @param event the MouseEvent triggered by a double-click on a contact in the table.
   * @throws IOException if there is an error loading the contact details view FXML file.
   */
  @FXML
  private void openContact(MouseEvent event) throws IOException {
    if (event.getClickCount() == 2) {
      Contact selectedContact = contacts.getSelectionModel().getSelectedItem();
      showContactDetails(selectedContact);
    }
  }
  
  /**
   * Shows the details of the selected contact by loading the contact view.
   *
   * @param contact the selected contact whose details will be displayed.
   * @throws IOException if there is an error loading the contact view FXML file.
   */
  private void showContactDetails(Contact contact) throws IOException {
    FXMLLoader loader = new FXMLLoader(
      getClass().getResource("/View/ContactView.fxml")
    );
    Parent root = loader.load();
    ContactViewController controller = loader.getController();
    controller.setContact(contact);
    Stage stage = (Stage) contacts.getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  /**
   * Handles the action of importing contacts from a CSV file.
   *
   * @param event the ActionEvent triggered by the import button.
   */
  @FXML
  private void handleImportBtn(ActionEvent event) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setInitialFileName("contatti");
    fileChooser
      .getExtensionFilters()
      .add(new FileChooser.ExtensionFilter("File csv", "*.csv"));
    File selectedFile = fileChooser.showOpenDialog(
      contacts.getScene().getWindow()
    );
    if (selectedFile != null) {
      try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
        String line;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
          String[] fields = line.split(";");

          Contact contact = new Contact(
            fields.length > 0 ? fields[0] : "",
            fields.length > 1 ? fields[1] : "",
            fields.length > 2 ? fields[2] : "",
            fields.length > 3 ? fields[3] : "",
            fields.length > 4 ? fields[4] : "",
            fields.length > 5 ? fields[5] : "",
            fields.length > 6 ? fields[6] : "",
            fields.length > 7 ? fields[7] : "",
            fields.length > 8 ? fields[8] : "",
            fields.length > 9 ? fields[9] : "",
            fields.length > 10 ? fields[10] : "",
            fields.length > 11 ? fields[11] : "",
            fields.length > 12 ? fields[12] : "",
            fields.length > 13 ? Boolean.parseBoolean(fields[13]) : false
          );

          contactList.addContact(contact);
        }
        contacts.setItems(contactList.getContacts());
      } catch (IOException ex) {
        System.out.println("Error reading file: " + ex.getMessage());
      }
    }
  }
  
  /**
   * Handles the action of exporting the contact list to a CSV file.
   * The user selects the destination file, and the contact list is written 
   * in CSV format.
   * 
   * @param event the ActionEvent triggered by the export button.
   * @throws FileNotFoundException if the file cannot be found or created during the export process.
   */
  @FXML
  private void handleExportBtn(ActionEvent event) throws FileNotFoundException {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setInitialFileName("contatti");
    fileChooser
      .getExtensionFilters()
      .add(new FileChooser.ExtensionFilter("File csv", "*.csv"));
    File selectedFile = fileChooser.showSaveDialog(
      contacts.getScene().getWindow()
    );
    if (selectedFile != null) {
      try (PrintWriter writer = new PrintWriter(selectedFile)) {
        writer.println(
          "nome;cognome;telefono1;telefono2;telefono3;email1;email2;email3;azienda;iban;indirizzo;sito;note;favourite"
        );
        for (Contact contact : contactList.getContacts()) {
          writer.println(contact.toCsv());
        }
      }
    }
  }


   /**
   * Clears any applied filters and resets the table to show all contacts.
   * 
   * @param event the ActionEvent triggered by the clear button.
   */
  @FXML
  private void handleClearBtn(ActionEvent event) {
    contacts.setItems(contactList.getContacts());
  }




/**
 * metodi usati per il test
 * 
 */
  public TableView<Contact> getContacts() {
    return contacts;
  }
public void handleSortByNamePublic(ActionEvent event) {
    handleSortByName(event);
  }
public void handleSearchPublic(ActionEvent event) {
  handleSearch(event);
}
 public void setContactsObservable(ObservableList<Contact> contacts) {
    this.contacts.setItems(contacts);
  }

  public void setContactsTable(TableView<Contact> contacts) {
    this.contacts = contacts;
  }

public TextField getSearch() {
    return search;
}
public void setSearch(TextField search) {
    this.search = search;
}
public void handleFilterByFavouritePublic(ActionEvent event) {
  handleFilterByFavourite(event);
}
  public void handleClearBtnPublic(ActionEvent event) {
    handleClearBtn(event);
  }
   public void handleExportBtnPublic(ActionEvent event) throws FileNotFoundException {
     handleExportBtn(event);
  }
  public void handleSortBySurnamePublic(ActionEvent event) {
  handleSortBySurname(event);
}


}
