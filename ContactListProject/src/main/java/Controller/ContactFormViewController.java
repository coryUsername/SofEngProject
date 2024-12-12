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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ContactFormViewController implements Initializable {

  @FXML
  private TextField nameField;

  @FXML
  private TextField surnameField;

  @FXML
  private TextField phone1Field;

  @FXML
  private TextField phone2Field;

  @FXML
  private TextField phone3Field;

  @FXML
  private TextField email1Field;

  @FXML
  private TextField email2Field;

  @FXML
  private TextField email3Field;

  @FXML
  private TextField companyField;

  @FXML
  private TextField ibanField;

  @FXML
  private TextField addressField;

  @FXML
  private TextField websiteField;

  @FXML
  private TextArea notesField;

  @FXML
  private CheckBox favouriteCheck;

  @FXML
  private Button backBtn;

  @FXML
  private Button saveBtn;

  private Contact contact;
  private boolean isModification;
    @FXML
    private Label errorLbl;
  

  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    contact = new Contact();
    isModification = false;
  }

 
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

  public void setContact(Contact contact, boolean isModification) {
    setContactForm(contact);
    this.isModification = isModification;
  }
}

