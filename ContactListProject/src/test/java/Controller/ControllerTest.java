/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Controller;

import Model.Contact;
import Model.ContactList;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author maria
 */
public class ControllerTest {

    Controller controller; // Campo della classe
    ContactList cList; // Campo della classe

    @BeforeAll
    public static void setUpClass() {
        System.out.println("Inizio test Controller.");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("Fine test Controller.");
    }

    @BeforeEach
    public void setUp() {
        controller = new Controller(); // Inizializzazione
        cList = new ContactList(); // Inizializzazione

        // Popolamento della lista di contatti
        cList.addContact(new Contact("Anna", "Guarino"));
        cList.addContact(new Contact("Mario", "Rossi"));
        cList.addContact(new Contact("Elena", "Ferrante"));

        // Inizializzazione delle dipendenze del controller
        controller.contacts = new TableView<>();
        controller.contactName = new TableColumn<>();
        controller.contactSurname = new TableColumn<>();
        controller.search = new TextField();
        controller.favourite = new CheckBox();
        controller.contactList = cList; // Collegamento della lista al controller
    }

    @AfterEach
    public void tearDown() {
        controller = null;
        cList = null;
    }

    @Test
    public void testInitialize() {
        System.out.println("Test initialize");
        URL url = null;
        ResourceBundle rb = null;

        controller.initialize(url, rb);

        ObservableList<Contact> expectedContacts = cList.getContacts();
        assertEquals(expectedContacts, controller.contacts.getItems(),
                "La TableView non contiene i contatti attesi dopo l'inizializzazione.");

        assertNotNull(controller.contactName.getCellValueFactory(),
                "La colonna 'contactName' non ha una factory associata.");
        assertNotNull(controller.contactSurname.getCellValueFactory(),
                "La colonna 'contactSurname' non ha una factory associata.");
    }

    @Test
    public void testHandleSearch() {
        System.out.println("Test handleSearch");



        controller.search.setText("Anna");

        // Esegui il metodo
        controller.handleSearch(new ActionEvent());

        // Controlla che i risultati siano filtrati correttamente
        ObservableList<Contact> expectedResults = FXCollections.observableArrayList(
                new Contact("Anna", "Guarino")
        );
        assertEquals(expectedResults, controller.contacts.getItems(),
                "La ricerca non ha prodotto i risultati attesi.");
    }

    @Test
    public void testHandleSortByName() {
        System.out.println("Test handleSortByName");

        // Esegui il metodo
        controller.handleSortByName(new ActionEvent());

        // Controlla che i contatti siano ordinati per nome
        ObservableList<Contact> expectedOrder = FXCollections.observableArrayList(
                new Contact("Anna", "Guarino"),
                new Contact("Elena", "Ferrante"),
                new Contact("Mario", "Rossi")
        );
        assertEquals(expectedOrder, controller.contacts.getItems(),
                "I contatti non sono stati ordinati correttamente per nome.");
    }

    @Test
    public void testHandleSortBySurname() {
        System.out.println("Test handleSortBySurname");

        // Esegui il metodo
        controller.handleSortBySurname(new ActionEvent());

        // Controlla che i contatti siano ordinati per cognome
        ObservableList<Contact> expectedOrder = FXCollections.observableArrayList(
                new Contact("Elena", "Ferrante"),
                new Contact("Anna", "Guarino"),
                new Contact("Mario", "Rossi")
        );
        assertEquals(expectedOrder, controller.contacts.getItems(),
                "I contatti non sono stati ordinati correttamente per cognome.");
    }
    @Test
    public void testUpdateTableViewWithEmptyList() {
        System.out.println("Test updateTableView with empty list");

        // Passa una lista vuota al metodo
        LinkedList<Contact> emptyList = new LinkedList<>();
        controller.updateTableView(emptyList);

        // Controlla che la TableView sia vuota
        ObservableList<Contact> expectedResults = FXCollections.observableArrayList();
        assertEquals(expectedResults, controller.contacts.getItems(),
                "L'aggiornamento della TableView con una lista vuota non ha prodotto una lista vuota.");
    }

    @Test
    public void testUpdateTableView() {
        System.out.println("Test updateTableView");

        // Lista di contatti aggiornata
        LinkedList<Contact> newContacts = new LinkedList<>();
        newContacts.add(new Contact("Luigi", "Verdi"));
        newContacts.add(new Contact("Carla", "Bianchi"));

        // Esegui il metodo
        controller.updateTableView(newContacts);

        // Controlla che la TableView contenga i nuovi dati
        ObservableList<Contact> expectedContacts = FXCollections.observableArrayList(newContacts);
        assertEquals(expectedContacts, controller.contacts.getItems(),
                "La TableView non è stata aggiornata correttamente.");
    }

    @Test
    public void testHandleFilterByFavourite() {
        System.out.println("Test handleFilterByFavourite");

        // Mock: segna "Anna Guarino" come preferita
        cList.getContacts().get(0).setFavourite(true);

        // Esegui il metodo
        controller.handleFilterByFavourite(new ActionEvent());

        // Controlla che la TableView contenga solo i contatti preferiti
        ObservableList<Contact> expectedResults = FXCollections.observableArrayList(
                new Contact("Anna", "Guarino")
        );
        assertEquals(expectedResults, controller.contacts.getItems(),
                "Il filtro 'Preferiti' non ha prodotto i risultati attesi.");
    }
}