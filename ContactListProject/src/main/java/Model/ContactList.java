package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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

  public ObservableList<Contact> getContacts() {
    return contacts;
  }

  
  public boolean contains(Contact contact) {
    return contacts.stream().anyMatch(c -> c.equals(contact));
}


/**
 *  Sets the contacts in the contact list.
   * @param contacts The contacts to be set in the list.
 */
    public void setContacts(ObservableList<Contact> contacts) {
        this.contacts = contacts;
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
            (contact.getPhoneNumber1() != null && !contact.getPhoneNumber1().isEmpty()) ||
            (contact.getPhoneNumber2() != null && !contact.getPhoneNumber2().isEmpty()) ||
            (contact.getPhoneNumber3() != null && !contact.getPhoneNumber3().isEmpty())
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
   * Imports contacts into the contact list from a source (e.g., file, database).
   * @return true if the contacts are successfully imported, false otherwise.
   */
  public boolean importContacts() {
    try (
      BufferedReader reader = new BufferedReader(
        new FileReader("contactList.csv")
      )
    ) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] dati = line.split(";");
        if (dati.length == 14) {
          String name = dati[0];
          String surname = dati[1];
          String phoneNumber1 = dati[2];
          String phoneNumber2 = dati[3];
          String phoneNumber3 = dati[4];
          String email1 = dati[5];
          String email2 = dati[6];
          String email3 = dati[7];
          String company = dati[8];
          String IBAN = dati[9];
          String address = dati[10];
          String website = dati[11];
          String notes = dati[12];
          boolean favourite = Boolean.parseBoolean(dati[13]);
          contacts.add(
            new Contact(
              name,
              surname,
              phoneNumber1,
              phoneNumber2,
              phoneNumber3,
              email1,
              email2,
              email3,
              company,
              IBAN,
              address,
              website,
              notes,
              favourite
            )
          );
        }
      }
      return true;
    } catch (Exception e) {
      System.out.println("errore");
      return false;
    }
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
      for (Contact c : contacts) {
        writer.print(
          c.getName() +
          ";" +
          c.getSurname() +
          ";" +
          c.getPhoneNumber1() +
          ";" +
          c.getPhoneNumber2() +
          ";" +
          c.getPhoneNumber3() +
          ";" +
          c.getEmail1() +
          ";" +
          c.getEmail2() +
          ";" +
          c.getEmail3() +
          ";" +
          c.getCompany() +
          ";" +
          c.getIBAN() +
          ";" +
          c.getAddress() +
          ";" +
          c.getWebsite() +
          ";" +
          c.getNotes() +
          ";" +
          c.isFavourite() +
          ";\n"
        );
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
