/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import View.*;
import Model.*;
import Controller.*;
import javafx.application.Application;
import javafx.scene.Scene;

/**
 *
 * @author corys
 */
public class Main extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MainView view = new MainView(); 
        
        new MainView(view);
        
        Scene scene = new Scene(view, 450, 250);
        
        primaryStage.setTitle("Contact List");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
}
