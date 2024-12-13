package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    this.contacts = FXCollections.observableArrayList();
  }

  public void setContactsObservable(ObservableList<Contact> contacts) {
    this.contacts = contacts;
  }

  public ObservableList<Contact> getContacts() {
    return contacts;
  }

  public boolean contains(Contact contact) {
    return contacts.stream().anyMatch(c -> c.equals(contact));
  }

  /**
   * Adds a new contact to the contact list.
   * @param contact The contact to be added to the list.
   * @throws java.io.IOException
   */
  public void addContact(Contact contact) throws IOException {
    if (contact == null) {
      throw new IllegalArgumentException("Compila i campi del contatto.");
    }
    if (contacts.size() < 10000) {
      contacts.add(contact);
    }
  }

  /**
   * Searches for a contact by name or surname.
   * @param substring The name or surname to search for.
   * @return A Contact object that matches the search query, or null if no match is found.
   */
  public ObservableList<Contact> search(String substring) {
    if (substring == null || substring.isEmpty()) {
      return FXCollections.observableArrayList(contacts);
    }
    String lowSub = substring.toLowerCase();

    ObservableList<Contact> searchResult = FXCollections.observableArrayList(
      contacts
        .stream()
        .filter(contact ->
          contact.getName().toLowerCase().contains(lowSub) ||
          contact.getSurname().toLowerCase().contains(lowSub)
        )
        .collect(Collectors.toList())
    );
    return searchResult;
  }

  /* * Filters the contact list based on a specific criterion.
   * @param criteria The filtering criterion (e.g. favourite, number or email).
   * @return A list of contacts that match the filtering criterion.
   */
  public ObservableList<Contact> filter(String criteria) {
    if (criteria.equals("favourite")) {
      return FXCollections.observableArrayList(
        contacts
          .stream()
          .filter(Contact::isFavourite)
          .collect(Collectors.toList())
      );
    } else if (criteria.equals("number")) {
      return FXCollections.observableArrayList(
        contacts
          .stream()
          .filter(contact ->
            (
              contact.getPhoneNumber1() != null &&
              !contact.getPhoneNumber1().isEmpty()
            ) ||
            (
              contact.getPhoneNumber2() != null &&
              !contact.getPhoneNumber2().isEmpty()
            ) ||
            (
              contact.getPhoneNumber3() != null &&
              !contact.getPhoneNumber3().isEmpty()
            )
          )
          .collect(Collectors.toList())
      );
    } else if (criteria.equals("email")) {
      return FXCollections.observableArrayList(
        contacts
          .stream()
          .filter(contact ->
            (contact.getEmail1() != null && !contact.getEmail1().isEmpty()) ||
            (contact.getEmail2() != null && !contact.getEmail2().isEmpty()) ||
            (contact.getEmail3() != null && !contact.getEmail3().isEmpty())
          )
          .collect(Collectors.toList())
      );
    }
    return FXCollections.observableArrayList();
  }

  /**
   * Sorts the contact list based on a given criterion.
   * @param criteria The criterion by which to sort (e.g., by name, surname, or company).
   */
  public void sort(String criteria) {
    if (criteria.equals("name")) {
      contacts.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
    } else if (criteria.equals("surname")) {
      contacts.sort((o1, o2) -> o1.getSurname().compareTo(o2.getSurname()));
    }
  }

  /**
   * Deletes a contact from the contact list.
   * @param contact The contact to be deleted.
   * @return true if the contact was successfully deleted, false otherwise.
   */
  public boolean delete(Contact contact) {
    return contacts.remove(contact);
  }

  /**
   * Exports the contact list to a destination (e.g., file, database).
   * @return true if the contacts are successfully exported, false otherwise.
   */
  public boolean exportContacts() {
    try (
      PrintWriter writer = new PrintWriter(
        new BufferedWriter(new FileWriter("contactList.csv"))
      )
    ) {
      for (Contact contact : contacts) {
        writer.println(contact.toCsv());
      }
      System.out.println("Contacts successfully exported.");
    } catch (Exception e) {
      System.err.println("Error occurred while exporting contacts!");
    }
    return true;
  }

  public void updateContact(Contact contact, Contact updatedContact) {
    int index = contacts.indexOf(contact);
    if (index != -1) {
      contacts.set(index, updatedContact);
    }
  }
}
