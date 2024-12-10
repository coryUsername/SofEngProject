package Model;

import java.io.IOException;
import java.util.LinkedList;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @file ContactList.java
 * @brief Represents a collection of contacts stored in a linked list.
 */
public class ContactList {

  /// A list of contacts in the contact list.
  /**
   * @details
   * This is a linked list of contacts. Each contact is stored as a Contact object.
   */
  private ObservableList<Contact> contacts;

  /**
   * Constructor for the ContactList class.
   */
  public ContactList() {
      this.contacts= FXCollections.observableArrayList();
  }

 public ObservableList<Contact> getContacts() {
        return contacts;
    }



  /**
   * Adds a new contact to the contact list.
   * @param contact The contact to be added to the list.
   */
  public void addContact(Contact contact) throws IOException{
    if (contacts.size()<10000){
       contacts.add(contact);
        }
    }

  /**
   * Searches for a contact by name or surname.
   * @param substring The name or surname to search for.
   * @return A Contact object that matches the search query, or null if no match is found.
   */
  public ObservableList<Contact> search(String substring) {
    if (substring==null || substring.isEmpty()){
        return FXCollections.observableArrayList(contacts);
        
        String lowSub=substring.toLowerCase();
        
        ObservableList<Contact> searchResult= FXCollections.ObservableArrayList((contacts.stream().filter(contact->contact.getName().contains(lowSub))||(contact->contact.getSurname().contains(lowSub))));
    }
    return null;
  }

    /* * Filters the contact list based on a specific criterion.
   * @param criteria The filtering criterion (e.g. favourite, number or email).
   * @return A list of contacts that match the filtering criterion.
   */
  public ObservableList<Contact> filter(String criteria) {
    if(criteria.equals("favourite")) {
        return  FXCollections.observableArrayList(contacts.stream()
                .filter(Contact::isFavourite)
                .collect(Collectors.toList()));
    } else if (criteria.equals("number")) {
        return FXCollections.observableArrayList(contacts.stream()
                .filter(contact -> contact.getPhoneNumber1() != null
                        || contact.getPhoneNumber2() != null
                        || contact.getPhoneNumber3() != null)
                .collect(Collectors.toList()));
    } else if (criteria.equals("email")) {
        return FXCollections.observableArrayList(contacts.stream()
                .filter(contact -> contact.getEmail1() != null
                        || contact.getEmail2() != null
                        || contact.getEmail3() != null)
                .collect(Collectors.toList()));
    }
    return FXCollections.observableArrayList();
}


  /**
   * Sorts the contact list based on a given criterion.
   * @param criteria The criterion by which to sort (e.g., by name, surname, or company).
   */
  public void sort(String criteria) {
  if(criteria.equals("name")){
    contacts.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
  }else if(criteria.equals("surname")){
    contacts.sort((o1, o2) -> o1.getSurname().compareTo(o2.getSurname()));
  }
  }

  /**
   * Deletes a contact from the contact list.
   * @param contact The contact to be deleted.
   * @return true if the contact was successfully deleted, false otherwise.
   */
  public boolean delete(Contact contact) {
contacts.remove(contact);
    return true;
  }

  /**
   * Imports contacts into the contact list from a source (e.g., file, database).
   * @return true if the contacts are successfully imported, false otherwise.
   */
  public boolean importContacts() {
    // To be implemented
    return false;
  }

  /**
   * Exports the contact list to a destination (e.g., file, database).
   * @return true if the contacts are successfully exported, false otherwise.
   */
  public boolean exportContacts() {
    // To be implemented
    return false;
  }
}
