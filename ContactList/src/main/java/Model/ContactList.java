package Model;
import Controller.*;
import View.*;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @brief The ContactList class Represents a collection of contacts stored in a linked list.
 */
public class ContactList {
    
    /// A list of contacts in the contact list.
    /**
     * @details
     * This is a linked list of contacts. Each contact is stored as a Contact object.
     */
    private LinkedList<Contact> contacts; 
    
    /**
     * Constructor for the ContactList class.
     */
    public ContactList(){
        // To be implemented
    }
    
    /**
     * Adds a new contact to the contact list.
     * @param contact The contact to be added to the list.
     */
    public void addContact(Contact contact){
        // To be implemented
    };
    
    /**
     * Searches for a contact by name or surname.
     * @param substring The name or surname to search for.
     * @return A Contact object that matches the search query, or null if no match is found.
     */
    public Contact search(String substring){
        // To be implemented
        return null; 
    };
    
    /**
     * Filters the contact list based on a specific criterion.
     * @param criteria The filtering criterion (e.g., favorite status, company, etc.).
     * @return A list of contacts that match the filtering criterion.
     */
    public LinkedList<Contact> filter(String criteria){
        // To be implemented
        return new LinkedList<>(); 
    };
    
    /**
     * Sorts the contact list based on a given criterion.
     * @param criteria The criterion by which to sort (e.g., by name, surname, or company).
     */
    public void sort(String criteria){
        // To be implemented
    };
    
    /**
     * Deletes a contact from the contact list.
     * @param contact The contact to be deleted.
     * @return true if the contact was successfully deleted, false otherwise.
     */
    public boolean delete(Contact contact){
        // To be implemented
        return false; 
    };
    
    /**
     * Imports contacts into the contact list from a source (e.g., file, database).
     * @return true if the contacts are successfully imported, false otherwise. 
     */
    public boolean importContacts(){
        // To be implemented
        return false;
    };
    
    /**
     * Exports the contact list to a destination (e.g., file, database).
     * @return true if the contacts are successfully exported, false otherwise. 
     */
    public boolean exportContacts(){
        // To be implemented
        return false; 
    };
    
}
