package Controller;

import View.*;
import Model.*;
import java.util.LinkedList;
 
/**
 * @file Controller.java
 * @brief Represents contact list operations and interactions with views.
 */
public class Controller {
    
    private ContactList contactList; 
    
    private MainView mainView;
    private ContactView contactView;
    private ContactFormView contactFormView;
    
    /**
     * @brief Constructs a Controller instance initializing the contact list and views.
     */
    public Controller(){
        this.contactList = contactList; 
        this.mainView = mainView; 
        this.contactView = contactView; 
    };
    
    /**
     * Adds a new contact alla rubrica.
     * @param newContact The Contact to add.
     * @return true if the addition was successful, false otherwise.
     */
    public boolean add(Contact newContact){
        // To be implemented
        return false; 
    };
    
    /**
     * Displays the complete contact list.
     * @return a list of contacts to be displayed.
     */
    public ContactList showContactList(){
      // To be implemented
      return null; 
    };
    
    /**
     * Displays the details of a single contact.
     * @param contact The contact to be displayed.
     * @return the selected contact.
     */
    public Contact showContact(Contact contact){
        // To be implemented
        return null;
    };
    
    /**
     * Modifies the details of an existing contact.
     * @param contact The contact to be modified.
     * @param updatedContact The contact with the updated details.
     * @return true if the modification was successful, false otherwise.
     */
    public boolean modify(Contact contact, Contact updatedContact){
        // To be implemented
        return false; 
    };
    
    /**
     * Deletes a contact from the contact list.
     * @param contact The contact to be deleted.
     * @return true if the deletion was successful, false otherwise.
     */
    public boolean delete(Contact contact){
        // To be implemented
        return false; 
    };
    
    /**
     * Searches for a contact in the contact list based on a specific criteria.
     * @param criteria The search criteria (name, number, etc.).
     * @return a list of contacts that match the search criteria.
     */
    public LinkedList<Contact> find(String criteria){
        // To be implemented
        return new LinkedList<>();  
    };
    
    /**
     * Filters the contacts based on a specific criterion.
     * @param criteria The filtering criterion (e.g., name, city, etc.).
     * @return a list of filtered contacts.
     */
    public LinkedList<Contact> filter(String criteria){
        // To be implemented
        return new LinkedList<>();
    };
    
    /**
     * Exports the contact list to an external file.
     * @param filePath The path of the file to export the contact list.
     * @return true if the export was successful, false otherwise.
     */
    public boolean exportList(String filePath){
        // To be implemented
        return false; 
    };
    
    /**
     * Imports a contact list from an external file.
     * @param filePath The path of the file to import the contact list from.
     * @return true if the import was successful, false otherwise.
     */
    public boolean importList(String filePath){
        // To be implemented
        return false; 
    };
    
    
}
