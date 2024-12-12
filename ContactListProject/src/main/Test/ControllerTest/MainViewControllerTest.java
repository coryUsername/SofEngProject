package Controller;

import java.io.File;
import java.io.PrintWriter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Contact;
import Model.ContactList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;


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
        contactList.getContacts().clear();
    }


    @BeforeEach
    public void setUp() {
        contactList = new ContactList();
        ObservableList<Contact> contacts = FXCollections.observableArrayList();
        contacts.add(new Contact("Maria", "Pagano", null, null, null, null, null, null, null, null, null, null, null, false));
contacts.add(new Contact("Cory", "Senatore", null, "3332406997", null, null, null, null, null, null, null, null, null, false));
contacts.add(new Contact("Mario",null, null, null, null, null, "m.stanco@gmail.com", null, null, null, null, null, null, false));
contacts.add(new Contact("Ursula", "Iannone", null, null, null, null, null, null, null, null, null, null, null, false));
        contactList.setContactsObservable(contacts);

        // Instantiate the controller
        controller = new MainViewController();
        MainViewController.contactList = contactList;

        // Mock JavaFX TableView and columns
        controller.setContactsTable( new TableView<>());
controller.setContactsObservable(contactList.getContacts());
     controller.setSearch(new TextField());

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
       // controller.search = new javafx.scene.control.TextField();
        controller.getSearch().setText("Maria");

        controller.handleSearchPublic(null);

        ObservableList<Contact> filteredContacts = controller.getContacts().getItems();
        assertEquals(1, filteredContacts.size(), "Search should return 1 contact.");
        assertEquals("Maria", filteredContacts.get(0).getName(), "The contact name should be 'Maria'.");
    controller.getSearch().setText("");
        controller.handleSearchPublic(null);
        assertEquals(4, controller.getContacts().getItems().size(), "La lista dei contatti dovrebbe tornare alla dimensione originale.");
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
    public void testHandleSortBySurname() {
        // Test ordinamento per cognome
        controller.handleSortBySurnamePublic(null);
       ObservableList<Contact> sortedContacts = controller.getContacts().getItems();

        assertEquals("Iannone", sortedContacts.get(0).getSurname(), "Il primo cognome dovrebbe essere 'Iannone' dopo l'ordinamento.");
        assertEquals("Pagano", sortedContacts.get(1).getSurname());
        assertEquals("Senatore", sortedContacts.get(2).getSurname());
        assertEquals("Stanco", sortedContacts.get(3).getSurname());
    }

    @Test
    public void testHandleClearBtn() {
        // Simulate filtering and clearing the filter
        controller.getContacts().setItems(FXCollections.observableArrayList(new Contact("Filtered", "Contact",null, null, null, null, null, null, null, null, null, null, null, false)));

        controller.handleClearBtnPublic(null);
        ObservableList<Contact> allContacts = controller.getContacts().getItems();

        assertEquals(2, allContacts.size(), "The contact list should be reset to the original size.");
    }

    @Test
    public void testHandleFilterByFavourite() {
        // Add a favourite contact and test filtering by favourite
        Contact favouriteContact = new Contact("Favorite", "Person", null, null, null, null, null, null, null, null, null, null, null, true);
        favouriteContact.setFavorite(true);
        contactList.getContacts().add(favouriteContact);

        controller.handleFilterByFavouritePublic(null);
        ObservableList<Contact> filteredContacts = controller.getContacts().getItems();

        assertEquals(1, filteredContacts.size(), "The filter should return 1 favourite contact.");
        assertTrue(filteredContacts.get(0).isFavourite(), "The contact should be marked as favourite.");
    }

     @Test
    public void testHandleExportBtn() throws Exception {
        // Test dell'esportazione
        FileChooser fileChooser = new FileChooser();
        File tempFile = File.createTempFile("test_contacts", ".csv");
        tempFile.deleteOnExit();

        try (PrintWriter writer = new PrintWriter(tempFile)) {
            controller.handleExportBtnPublic(null);
            writer.println("nome;cognome");

            ObservableList<Contact> exportedContacts = contactList.getContacts();
            assertEquals(4, exportedContacts.size(), "Il file esportato dovrebbe contenere 4 contatti.");
        }
    }
}