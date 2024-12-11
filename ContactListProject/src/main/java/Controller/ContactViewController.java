/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Contact;
import View.App;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 */
public class ContactViewController implements Initializable {

  @FXML
  private Button modifyBtn;

  @FXML
  private Button deleteBtn;

  @FXML
  private Button backBtn;

  @FXML
  private Label nameLbl;

  @FXML
  private Label surnameLbl;

  @FXML
  private Label phoneNumber1Lbl;

  @FXML
  private Label phoneNumber2Lbl;

  @FXML
  private Label phoneNumber3Lbl;

  @FXML
  private Label email1Lbl;

  @FXML
  private Label email2Lbl;

  @FXML
  private Label email3Lbl;

  @FXML
  private Label companyLbl;

  @FXML
  private Label IBANLbl;

  @FXML
  private Label addressLbl;

  @FXML
  private Label websiteLbl;

  @FXML
  private Label notesLbl;

  @FXML
  private CheckBox favouriteCheck;

  private Contact contact;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    contact = new Contact();
  }

  @FXML
  private void handleDelete(ActionEvent click) throws IOException {
    MainViewController.contactList.delete(contact);
    App.setRoot("MainView");
  }

  @FXML
  private void handleBack(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(
      getClass().getResource("/View/MainView.fxml")
    );
    Stage stage = (Stage) backBtn.getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void setContact(Contact contact) {
    nameLbl.setText(contact.getName());
    surnameLbl.setText(contact.getSurname());
    phoneNumber1Lbl.setText(contact.getPhoneNumber1());
    phoneNumber2Lbl.setText(contact.getPhoneNumber2());
    phoneNumber3Lbl.setText(contact.getPhoneNumber3());
    email1Lbl.setText(contact.getEmail1());
    email2Lbl.setText(contact.getEmail2());
    email3Lbl.setText(contact.getEmail3());
    companyLbl.setText(contact.getCompany());
    IBANLbl.setText(contact.getIBAN());
    addressLbl.setText(contact.getAddress());
    websiteLbl.setText(contact.getWebsite());
    notesLbl.setText(contact.getNotes());
    favouriteCheck.setSelected(contact.isFavourite());
  }

  @FXML
  private void handleModify(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(
      getClass().getResource("/View/ContactFormView.fxml")
    );
    Parent root = loader.load();

    ContactFormViewController controller = loader.getController();
    contact.setName(nameLbl.getText());
    contact.setSurname(surnameLbl.getText());
    contact.setPhoneNumber1(phoneNumber1Lbl.getText());
    contact.setPhoneNumber2(phoneNumber2Lbl.getText());
    contact.setPhoneNumber3(phoneNumber3Lbl.getText());
    contact.setEmail1(email1Lbl.getText());
    contact.setEmail2(email2Lbl.getText());
    contact.setEmail3(email3Lbl.getText());
    contact.setCompany(companyLbl.getText());
    contact.setIBAN(IBANLbl.getText());
    contact.setAddress(addressLbl.getText());
    contact.setWebsite(websiteLbl.getText());
    contact.setNotes(notesLbl.getText());
    contact.setFavorite(favouriteCheck.isSelected());
    controller.setContact(contact, true); // Pass boolean to indicate modification

    Stage stage = (Stage) modifyBtn.getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
}
