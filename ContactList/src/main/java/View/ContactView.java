package View;
import Model.*; 
import Controller.*;
import java.awt.Button;
import java.awt.Label;

/**
 *@brief The ContactView class represents the view for displaying details of a single contact.
 */
public class ContactView {
    
    /// Buttons for modifying, deleting, and navigating back.
    private Button modify;
    private Button back; 
    private Button delete; 
    
    /// Labels for displaying contact details.
    private Label name; 
    private Label surname; 
    private Label phoneNumber1; 
    private Label phoneNumber2; 
    private Label phoneNumber3; 
    private Label email1; 
    private Label email2; 
    private Label email3; 
    private Label company; 
    private Label IBAN; 
    private Label address; 
    private Label website; 
    private Label notes; 
    private Label favorite;
    
    /**
     * Constructor for the ContactView class.
     * Initializes the UI components and sets the contact details in the labels.
     * @param contact The contact containing the details to be displayed.
     */
    public ContactView(Contact contact){
        // To be implemented
    };
    
    
}
