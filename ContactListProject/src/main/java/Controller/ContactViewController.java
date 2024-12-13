package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Contact;
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
 * Controller for the contact view. Handles the display and manipulation of
 * contact details, including modifying, deleting, or navigating back to the
 * main view.
 */
public class ContactViewController implements Initializable {

/**
 * FXML elements for the contact view.
 */
    @FXML
    private Button modifyBtn; // Button for modifying the current contact.

    @FXML
    private Button deleteBtn; // Button for deleting the current contact.

    @FXML
    private Button backBtn; // Button for navigating back to the main view.

    @FXML
    private Label nameLbl; // Label to display the contact's name.

    @FXML
    private Label surnameLbl; // Label to display the contact's surname.

    @FXML
    private Label phoneNumber1Lbl; // Label to display the first phone number.

    @FXML
    private Label phoneNumber2Lbl; // Label to display the second phone number.

    @FXML
    private Label phoneNumber3Lbl; // Label to display the third phone number.

    @FXML
    private Label email1Lbl; // Label to display the first email address.

    @FXML
    private Label email2Lbl; // Label to display the first email address.

    @FXML
    private Label email3Lbl; // Label to display the third email address.

    @FXML
    private Label companyLbl; // Label to display the company name.

    @FXML
    private Label IBANLbl; // Label to display the IBAN.

    @FXML
    private Label addressLbl; // Label to display the address.

    @FXML
    private Label websiteLbl; // Label to display the website URL.

    @FXML
    private Label notesLbl; // Label to display additional notes.

    @FXML
    private CheckBox favouriteCheck; // Checkbox indicating if the contact is marked as favorite.

    private Contact contact; // The current contact being displayed.

    

    /**
     * @brief Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contact = new Contact();
    }

   
    /**
     * @brief Sets the contact object with values from the labels in the UI.
     * 
     */
    private void setContactlbl() {
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
    }

    /**
     * Handles the deletion of the current contact.
     *
     * @param click the ActionEvent triggered by the delete button.
     * @throws IOException if an error occurs while loading the main view FXML
     * file.
     */
    @FXML
    private void handleDelete(ActionEvent click) throws IOException {
        setContactlbl();
        MainViewController.contactList.delete(contact);
        Parent root = FXMLLoader.load(
                getClass().getResource("/View/MainView.fxml")
        );
        Stage stage = (Stage) backBtn.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Handles navigation back to the main view.
     *
     * @param event the ActionEvent triggered by the back button.
     * @throws IOException if an error occurs while loading the main view FXML
     * file.
     */
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

    /**
     * Sets the contact information in the labels from the given Contact object.
     *
     * @param contact the Contact object containing the data to display.
     */
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

    /**
     * Handles modifying the current contact. Opens the contact form view and
     * pre-fills it with the current contact's information.
     *
     * @param event the ActionEvent triggered by the modify button.
     * @throws IOException if an error occurs while loading the contact form
     * FXML file.
     */
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
        controller.setContact(contact, true);

        Stage stage = (Stage) modifyBtn.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
