/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Model;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author URSULA
 */
public class ContactListTest {
    
    public ContactListTest() {
    }
    private ContactList contactList;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        contactList= new ContactList();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getContacts method, of class ContactList.
     */
    @Test
    public void testGetContacts() {
        System.out.println("getContacts");
        ContactList instance = new ContactList();
        ObservableList<Contact> expResult = null;
        ObservableList<Contact> result = instance.getContacts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addContact method, of class ContactList.
     */
    @Test
    public void testAddContact() throws IOException {
        System.out.println("addContact");
         
        Contact contact = new Contact( "Chiara","Rossi","123456789", "987654321", "1122334455", 
        "c.rossi@studenti.unisa.it", "chiararossi2@gmail.com", "rossiconstruction@gmail.com", 
        "Rossi Construction.", "IT123456789987654321", 
        "Via Roma 89, Salerno(Sa)", "www.rossiconstruction.com", 
        "Chiama il contatto venerdì 20 dicembre per avere info sul progetto.", false);
        
        contactList.addContact(contact);
        
        ObservableList <Contact> contacts= contactList.getContacts();
        assertEquals(1, contacts.size(), "Contact list size should be 1 after adding a contact.");
        assertEquals("Chiara", contacts.get(0).getName(), "The name of the first contact doesn't match.");
        assertEquals("Rossi", contacts.get(0).getSurname(), "The surname of the first contact doesn't match.");
            }

    /**
     * Test of search method, of class ContactList.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        Contact c1=
        Contact c2=
        contactList.addContact(c1);
        contactList.addContact(c2);
        
 
        ObservableList<Contact> result = contactList.search("Luigi");
        assertEquals(1, result.size(), "Search should return 1 contact.");
         assertEquals("Luigi", result.get(0).getName(), "The searched contact should be 'Alice'.");
         
        result = contactList.search("Esposito");
        assertEquals(1, result.size(), "Search should return 1 contact.");
        assertEquals("Esposito", result.get(0).getSurname(), "The searched contact should be 'Brown'.");
 
    }

    /**
     * Test of filter method, of class ContactList.
     */
    @Test
    public void testFilter() {
        System.out.println("filter");
        String criteria = "";
        ContactList instance = new ContactList();
        ObservableList<Contact> expResult = null;
        ObservableList<Contact> result = instance.filter(criteria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sort method, of class ContactList.
     */
    @Test
    public void testSort() {
        System.out.println("sort");
        String criteria = "";
        ContactList instance = new ContactList();
        instance.sort(criteria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ContactList.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Contact contact = null;
        ContactList instance = new ContactList();
        boolean expResult = false;
        boolean result = instance.delete(contact);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContacts method, of class ContactList.
     */
    @Test
    public void testImportContacts() {
        System.out.println("importContacts");
        ContactList instance = new ContactList();
        boolean expResult = false;
        boolean result = instance.importContacts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContacts method, of class ContactList.
     */
    @Test
    public void testExportContacts() {
        System.out.println("exportContacts");
        ContactList instance = new ContactList();
        boolean expResult = false;
        boolean result = instance.exportContacts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
