package View;

import java.awt.Button;
import java.awt.TextField;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

/**
 * @file ContactFormView.java
 * @brief Represents the view for creating or modifying a contact.
 */
public class ContactFormView {
    
    /// The stage for the contact form window.
    private Stage stage; 
    
    /// Button to save the contact information.
    private Button save;
    
    /// Button to cancel the operation.
    private Button cancel; 
    
    /// The form fields for entering or modifying contact information.
    private TextField name; 
    private TextField surname; 
    private TextField phoneNumber1; 
    private TextField phoneNumber2; 
    private TextField phoneNumber3; 
    private TextField email1; 
    private TextField email2; 
    private TextField email3; 
    private TextField company; 
    private TextField IBAN; 
    private TextField address; 
    private TextField website; 
    private TextField notes; 
    
    /// Checkbox to mark the contact as a favorite.
    private CheckBox favorite;
    
    
    /**
     * Constructor for the ContactFormView class.
     */
    public ContactFormView(){
        // To be implemented
    };
    
    
}
