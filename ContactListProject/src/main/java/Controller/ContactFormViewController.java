package Controller;

import Model.Contact;
import View.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 */
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
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        clearFields();
        App.setRoot("MainView");
        
    }
    
    private void clearFields(){
        nameField.setText("");
        surnameField.setText("");
        phone1Field.setText("");
        phone2Field.setText("");
        phone3Field.setText("");
        email1Field.setText("");
        email2Field.setText("");
        email3Field.setText("");
        companyField.setText("");
        ibanField.setText("");
        addressField.setText("");
        notesField.setText("");
        favouriteCheck.setSelected(false);
        
    }

    @FXML
    private void handleSave(ActionEvent event) throws IOException {
       
        String name = nameField.getText();
        String surname = surnameField.getText();
        String phoneNumber1 = phone1Field.getText();
        String phoneNumber2 = phone2Field.getText();
        String phoneNumber3 = phone3Field.getText();
        String email1 = email1Field.getText();
        String email2 = email2Field.getText();
        String email3 = email3Field.getText();
        String company = companyField.getText();
        String IBAN = ibanField.getText();
        String address = addressField.getText();
        String website = websiteField.getText();
        String notes = notesField.getText();
        boolean favourite = favouriteCheck.isSelected();

   
        contact = new Contact(name, surname, phoneNumber1, phoneNumber2, phoneNumber3,
                email1, email2, email3, company, IBAN, address, website, notes, favourite);

        MainViewController.contactList.addContact(contact);

        App.setRoot("MainView");
    }
}