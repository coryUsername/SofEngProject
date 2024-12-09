package View;

import Controller.*;
import Model.*;
import java.awt.Button;
import java.util.LinkedList;
import javafx.scene.control.TableView;

/**
 * @file MainView.java
 * @brief Represents the main view for the contact list.
 */
public class MainView {

  /// Table to display the contacts.
  private TableView contacts;

  /// Buttons for various actions.
  private Button search;
  private Button filterByNumber;
  private Button filterByEmail;
  private Button filterByFavourite;
  private Button sortByName;
  private Button sortBySurname;
  private Button exportBtn;
  private Button importBtn;
  private Button add;

  /**
   * Constructor for the MainView class.
   * Initializes the UI components and sets up the event handlers for each action button.
   */
  public MainView() {
    // To be implemented
  }
}
