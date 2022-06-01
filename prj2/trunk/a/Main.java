/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject.a;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author Khanh NH
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Motorcycle Management");
        Navigator.getInstance().setStage(primaryStage);
        Navigator.getInstance().goToMotor();
        Navigator.getInstance().getStage().show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}