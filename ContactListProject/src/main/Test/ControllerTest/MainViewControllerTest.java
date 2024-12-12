package Controller;

import Model.Contact;
import Model.ContactList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import java.net.URL;
import java.util.ResourceBundle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MainViewControllerTest{

    private MainViewController controller;
    private ContactList contactList;

       @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @BeforeEach
    public void setUp() {
        contactList = new ContactList();
        ObservableList<Contact> contacts = FXCollections.observableArrayList();
        contacts.add(new Contact("Maria", "Pagano"));
        contacts.add(new Contact("Cory", "Senatore"));
        contacts.add(new Contact("Mario", "Stanco"));
        contacts.add(new Contact("Ursula", "Iannone"));
        contactList.setContacts(contacts);

        // Instantiate the controller
        controller = new MainViewController();
        MainViewController.contactList = contactList;

        // Mock JavaFX TableView and columns
        controller.setContacts( new TableView<>());
controller.setContacts(contactList.getContacts());
        

    }

    @Test
    public void testInitialize() {
        // Test if the initialize method properly initializes the TableView
        controller.initialize(null, null);
        assertNotNull(controller.getContacts().getItems());
        assertEquals(2, controller.getContacts().getItems().size(), "The contact list should contain 2 items.");
    }

    @Test
    public void testHandleSearch() {
        // Test the search functionality
        controller.search = new javafx.scene.control.TextField();
        controller.search.setText("Maria");

        controller.handleSearchPublic(null);

        ObservableList<Contact> filteredContacts = controller.getContacts().getItems();
        assertEquals(1, filteredContacts.size(), "Search should return 1 contact.");
        assertEquals("Maria", filteredContacts.get(0).getName(), "The contact name should be 'Maria'.");
    }

    @Test
    public void testHandleSortByName() {
        // Test sorting by name
        controller.handleSortByNamePublic(null);
        ObservableList<Contact> sortedContacts = controller.getContacts().getItems();

        assertEquals("Maria", sortedContacts.get(0).getName(), "The first contact should be 'Maria' after sorting by name.");
        assertEquals("Cory", sortedContacts.get(1).getName(), "The second contact should be 'Cory' after sorting by name.");
        assertEquals("Mario", sortedContacts.get(2).getName(), "The third contact should be 'Mario' after sorting by name.");
        assertEquals("Ursula", sortedContacts.get(3).getName(), "The fourth contact should be 'Ursula' after sorting by name.");
    }

    @Test
    public void testHandleClearBtn() {
        // Simulate filtering and clearing the filter
        controller.contacts.setItems(FXCollections.observableArrayList(new Contact("Filtered", "Contact")));

        controller.handleClearBtnPublic(null);
        ObservableList<Contact> allContacts = controller.getContacts().getItems();

        assertEquals(2, allContacts.size(), "The contact list should be reset to the original size.");
    }

    @Test
    public void testHandleFilterByFavourite() {
        // Add a favourite contact and test filtering by favourite
        Contact favouriteContact = new Contact("Favorite", "Person");
        favouriteContact.setFavourite(true);
        contactList.getContacts().add(favouriteContact);

        controller.handleFilterByFavouritePublic(null);
        ObservableList<Contact> filteredContacts = controller.getContacts().getItems();

        assertEquals(1, filteredContacts.size(), "The filter should return 1 favourite contact.");
        assertTrue(filteredContacts.get(0).isFavourite(), "The contact should be marked as favourite.");
    }
}