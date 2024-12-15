package View;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App. Starts the application loading the file MainView.fxml
 */
public class App extends Application {

  private static Scene scene;

  /**
   * @brief Starts the application by loading the MainView.fxml file, creating a new scene and setting it on the given stage.
   * The stage is then set to not be resizable and is shown.
   *
   * @param stage the stage this application should be started in
   * @throws IOException if the fxml file for the main view cannot be found
   */
  @Override
  public void start(Stage stage) throws IOException {
    scene = new Scene(loadFXML("MainView"), 800, 600);
    stage.setScene(scene);
    stage.setResizable(false);

    stage.show();
  }

  /**
   * @brief Loads a fxml file given its name (without the .fxml extension).
   *
   * @param fxml the name of the fxml file to be loaded
   * @return the root node of the loaded fxml file
   * @throws IOException if the fxml file cannot be found
   */
  private static Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(
      App.class.getResource(fxml + ".fxml")
    );
    return fxmlLoader.load();
  }

  /**
   * @brief The main entry point for the JavaFX application.
   * This method launches the application by calling the launch() method,
   * which initializes the JavaFX runtime and triggers the start() method.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch();
  }
}
