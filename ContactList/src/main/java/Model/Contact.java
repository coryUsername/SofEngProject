package Model;

import java.util.List;


/**
 * @brief The Contact class represents an individual contact in the contact book.
 * It stores personal information such as name, surname, phone numbers, emails, 
 * and other relevant details of a contact.
 */
public class Contact {
    
    /// The name of the contact. 
    private String name; 
    
    /// The surname of the contact.
    private String surname; 
    
    /// A list of phone numbers associated with the contact.
    private List<String> phoneNumbers; 
    
    /// A list of email addresses associated with the contact.
    private List<String> emails; 
    
    /// The company the contact works for.
    private String company; 
    
    /// The IBAN (International Bank Account Number) of the contact.
    private String IBAN; 
    
    /// The physical address of the contact.
    private String address; 
    
    /// The website associated with the contact.
    private String website; 
    
    /// Additional notes related to the contact.
    private String notes; 
    
    /// A flag indicating whether the contact is marked as a favorite.
    private boolean favorite;
    
    /**
     * @brief Default constructor for the Contact class.
     * Initializes a new Contact object.
     */
    public Contact() {
        // To be implemented
    }
    
    /**
     * Returns whether the contact is marked as a favorite or not.
     * @return true if the contact is marked as a favorite, false otherwise.
     */
    public boolean isFavourite(){
        // To be implemented
        return false;
    }

    
    
}
