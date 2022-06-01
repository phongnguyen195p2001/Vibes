/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
    
/**
 *
 * @author phong
 */
public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Motorcycle Management");
        Navigator.getInstance().setStage(primaryStage);
        Navigator.getInstance().goToAPP();
        Navigator.getInstance().getStage().show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//
//
//at eproject2_motor.Navigator.goTo(Navigator.java:53)
//	at eproject2_motor.Navigator.goToInsertMotor(Navigator.java:69)
//	at eproject2_motor.motorController.clickupdate(motorController.java:93)
