package Controller;

import Model.Contact;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * @file ContactFormViewController.java
 * @brief Represents contact modify/add operations and interactions with
 * ContactFormView.
 */
public class ContactFormViewController implements Initializable {

  /// TextField for the contact's name.
  @FXML
  private TextField nameField;

  /// TextField for the contact's surname.
  @FXML
  private TextField surnameField;

  /// TextField for the contact's first phone number.
  @FXML
  private TextField phone1Field;

  /// TextField for the contact's second phone number.
  @FXML
  private TextField phone2Field;

  /// TextField for the contact's third phone number.
  @FXML
  private TextField phone3Field;

  /// TextField for the contact's first email address.
  @FXML
  private TextField email1Field;

  /// TextField for the contact's second email address.
  @FXML
  private TextField email2Field;

  /// TextField for the contact's third email address.
  @FXML
  private TextField email3Field;

  /// TextField for the contact's company.
  @FXML
  private TextField companyField;

  /// TextField for the contact's IBAN.
  @FXML
  private TextField ibanField;

  /// TextField for the contact's address.
  @FXML
  private TextField addressField;

  /// TextField for the contact's website.
  @FXML
  private TextField websiteField;

  /// TextArea for additional information about the contact.
  @FXML
  private TextArea notesField;

  /// Checkbox to mark the contact as favourite.
  @FXML
  private CheckBox favouriteCheck;

  /// Button to cancel the operation.
  @FXML
  private Button backBtn;

  /// Button to save the changes made.
  @FXML
  private Button saveBtn;

  /// Istance of the current modified/created contact.
  private Contact contact;

  /// Boolean true if the operation is a modification.
  private boolean isModification;

  /**
   * @brief Constructs a Controller instance.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    contact = new Contact();
    isModification = false;
  }

  /**
   * @brief Returns to the main view. Does not save the changes.
   *
   * @param event The event triggered.
   */
  @FXML
  private void handleBack(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(
      getClass().getResource("/View/MainView.fxml")
    );
    Parent root = loader.load();
    Stage stage = (Stage) backBtn.getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  /**
   * @brief Handles the input in phone number fields, ensuring that only numeric
   * characters are allowed and the length of the input does not exceed 10
   * characters.
   *
   * @param event the KeyEvent triggered when a key is pressed or released on
   * the associated TextField.
   */
  @FXML
  private void handlePhoneFieldsKey(KeyEvent event) {
    TextField textField = (TextField) event.getSource();
    if (!textField.getText().matches("[0-9]{0,10}")) {
      textField.setText(textField.getText().replaceAll("[^0-9]", ""));
      if (textField.getText().length() > 10) {
        textField.setText(textField.getText().substring(0, 10));
      }
    }
  }

  /**
   * @brief Handles the save operation for a contact. Creates a new contact or
   * updates an existing one based on the input provided in the form fields.
   *
   * @param event The event triggered.
   */
  @FXML
  private void handleSave(ActionEvent event) throws IOException {
    Contact updatedContact = new Contact(
      nameField.getText(),
      surnameField.getText(),
      phone1Field.getText(),
      phone2Field.getText(),
      phone3Field.getText(),
      email1Field.getText(),
      email2Field.getText(),
      email3Field.getText(),
      companyField.getText(),
      ibanField.getText(),
      addressField.getText(),
      websiteField.getText(),
      notesField.getText(),
      favouriteCheck.isSelected()
    );

    if (isModification) {
      MainViewController.contactList.updateContact(contact, updatedContact);
    } else {
      MainViewController.contactList.addContact(updatedContact);
    }

    Parent root = FXMLLoader.load(
      getClass().getResource("/View/MainView.fxml")
    );
    Stage stage = (Stage) saveBtn.getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  /**
   * @brief Sets the fields in the view.
   *
   * @param contact The contact to be displayed.
   */
  private void setContactForm(Contact contact) {
    this.contact = contact;
    nameField.setText(contact.getName());
    surnameField.setText(contact.getSurname());
    phone1Field.setText(contact.getPhoneNumber1());
    phone2Field.setText(contact.getPhoneNumber2());
    phone3Field.setText(contact.getPhoneNumber3());
    email1Field.setText(contact.getEmail1());
    email2Field.setText(contact.getEmail2());
    email3Field.setText(contact.getEmail3());
    companyField.setText(contact.getCompany());
    ibanField.setText(contact.getIBAN());
    addressField.setText(contact.getAddress());
    websiteField.setText(contact.getWebsite());
    notesField.setText(contact.getNotes());
    favouriteCheck.setSelected(contact.isFavourite());
  }

  /**
   * @brief Sets the contact fields in the view.
   *
   * @param contact The contact to be displayed.
   * @param isModification Boolean indicator, true if the operation is
   * "modify".
   */
  public void setContact(Contact contact, boolean isModification) {
    setContactForm(contact);
    this.isModification = isModification;
  }
}
