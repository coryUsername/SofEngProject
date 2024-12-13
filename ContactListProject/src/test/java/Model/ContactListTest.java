package Model;

import java.io.File;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author URSULA
 */
public class ContactListTest {


    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Crea un contatto di test per evitare di scrivere i dati ripetutamente.
     */
    private Contact createTestContact() {
        return new Contact(
            "Chiara", "Rossi", 
            "123456789", "987654321", "1122334455", 
            "c.rossi@studenti.unisa.it", "chiararossi2@gmail.com", "rossiconstruction@gmail.com", 
            "Rossi Construction.", "IT123456789987654321", 
            "Via Roma 89, Salerno(Sa)", "www.rossiconstruction.com", 
            "Chiama il contatto venerdì 20 dicembre per avere info sul progetto.", false
        );
    }

    /**
     * Test of setContactsObservable method, of class ContactList.
     */
    @Test
    public void testSetContactsObservable() {
        System.out.println("setContactsObservable");
        ObservableList<Contact> contacts = FXCollections.observableArrayList(createTestContact());
        ContactList contactList = new ContactList();
        contactList.setContactsObservable(contacts);
        assertEquals(1, contactList.getContacts().size(), "The contacts list should contain one contact.");
    }

    /**
     * Test of getContacts method, of class ContactList.
     */
    @Test
    public void testGetContacts() throws IOException {
        System.out.println("getContacts");
        ContactList instance = new ContactList();
        Contact contact = createTestContact();
       
        instance.addContact(contact);
        ObservableList<Contact> result = instance.getContacts();
        assertEquals(1, result.size());
    }

    /**
     * Test of contains method, of class ContactList.
     */
    @Test
    public void testContains() throws IOException {
        System.out.println("contains");
        Contact contact = createTestContact();
        ContactList contactList = new ContactList();
        contactList.addContact(contact);
        boolean result = contactList.contains(contact);
        assertTrue(result, "Contact should be contained in the list.");
    }

    /**
     * Test of addContact method, of class ContactList.
     */
    @Test
    public void testAddContact() throws IOException {
        System.out.println("addContact");
        Contact contact = createTestContact();
        ContactList contactList = new ContactList();
        contactList.addContact(contact);

        ObservableList<Contact> contacts = contactList.getContacts();
        assertEquals(1, contacts.size(), "Contact list size should be 1 after adding a contact.");
        assertEquals("Chiara", contacts.get(0).getName(), "The name of the first contact doesn't match.");
        assertEquals("Rossi", contacts.get(0).getSurname(), "The surname of the first contact doesn't match.");
    }

    /**
     * Test of search method, of class ContactList.
     */
    @Test
    public void testSearch() throws IOException {
        System.out.println("search");
        Contact c1 = createTestContact();
        Contact c2 = new Contact("Giuseppe", "Esposito", "333444555", "666777888", "999000111",
                                 "giuseppe.esposito@example.com", "giuseppe.esposito2@example.com", "giuseppe.esposito3@example.com",
                                 "Esposito Group", "IT9876543210", "Corso Italia 2, Napoli", "www.esposito.com", "Notes for Giuseppe", true);
         ContactList contactList = new ContactList();
        contactList.addContact(c1);
        contactList.addContact(c2);

        ObservableList<Contact> result = contactList.search("Chiara");
        assertEquals(1, result.size(), "Search should return 1 contact.");
        assertEquals("Chiara", result.get(0).getName(), "The searched contact should be 'Chiara'.");

        result = contactList.search("Esposito");
        assertEquals(1, result.size(), "Search should return 1 contact.");
        assertEquals("Esposito", result.get(0).getSurname(), "The searched contact should be 'Esposito'.");
    }

    /**
     * Test of filter method, of class ContactList.
     */
    @Test
    public void testFilter() throws IOException {
        System.out.println("filter");
        Contact c1 = createTestContact();
        Contact c2 = new Contact("Giuseppe", "Esposito", "12345", "98765", "", "", "", "", "", "", "", "", "", true);
        ContactList contactList = new ContactList();
        contactList.addContact(c1);
        contactList.addContact(c2);

        ObservableList<Contact> favouriteContacts = contactList.filter("favourite");
        assertEquals(1, favouriteContacts.size(), "There should be 1 favourite contact.");

        ObservableList<Contact> numberContacts = contactList.filter("number");
        assertEquals(2, numberContacts.size(), "There should be 2 contacts with a number.");
    }

    /**
     * Test of sort method, of class ContactList.
     */
    @Test
    public void testSort() throws IOException {
        System.out.println("sort");
        Contact c1 = createTestContact();
        Contact c2 = new Contact("Giuseppe", "Esposito", "333444555", "666777888", "999000111",
                                 "giuseppe.esposito@example.com", "giuseppe.esposito2@example.com", "giuseppe.esposito3@example.com",
                                 "Esposito Group", "IT9876543210", "Corso Italia 2, Napoli", "www.esposito.com", "Notes for Giuseppe", true);
        ContactList contactList = new ContactList();
        contactList.addContact(c1);
        contactList.addContact(c2);

        contactList.sort("name");
        assertEquals("Chiara", contactList.getContacts().get(0).getName(), "After sorting by name, the first contact should be 'Giuseppe'.");

        contactList.sort("surname");
        assertEquals("Esposito", contactList.getContacts().get(0).getSurname(), "After sorting by surname, the first contact should be 'Esposito'.");
    }

    /**
     * Test of delete method, of class ContactList.
     */
    @Test
    public void testDelete() throws IOException {
        System.out.println("delete");
        Contact c1 = createTestContact();
        ContactList contactList = new ContactList();
        contactList.addContact(c1);

        boolean result = contactList.delete(c1);
        assertTrue(result, "Contact should be deleted.");
    }

    /**
     * Test of exportContacts method, of class ContactList.
     */
    @Test
    public void testExportContacts() throws IOException {
        System.out.println("exportContacts");
        Contact c1 = createTestContact();
        ContactList contactList = new ContactList();
        contactList.addContact(c1);

        boolean exported = contactList.exportContacts();
        assertTrue(exported, "Contacts should be exported successfully.");

        File file = new File("contactList.csv");
        assertTrue(file.exists(), "The export file 'contactList.csv' should exist.");
    }

    /**
     * Test of updateContact method, of class ContactList.
     */
    @Test
    public void testUpdateContact() throws IOException {
        System.out.println("updateContact");
        Contact contact = createTestContact();
        ContactList contactList = new ContactList();
        contactList.addContact(contact);

        Contact updatedContact = new Contact("Chiara", "Rossi", "123456789", "987654321", "1122334455", 
                                             "c.rossi@newdomain.com", "", "", "Company", "", "", "", "", false);
        contactList.updateContact(contact, updatedContact);

        assertEquals("c.rossi@newdomain.com", contactList.getContacts().get(0).getEmail1(), "The email should be updated.");
    }
}
