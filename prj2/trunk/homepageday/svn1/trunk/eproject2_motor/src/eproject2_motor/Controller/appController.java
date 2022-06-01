/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author phong
 */
public class appController implements Initializable {

     @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            VBox vbox = FXMLLoader.load(getClass().getResource("sidepanel.fxml"));
            drawer.setSidePane(vbox);
        } catch (IOException e) {
            Logger.getLogger(appController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        HamburgerBackArrowBasicTransition burger = new HamburgerBackArrowBasicTransition(hamburger);
        burger.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            burger.setRate(burger.getRate() * -1);
            burger.play();
            
            if (drawer.isOpened()) {
                drawer.close();
            } else {
                drawer.open();
            }
            
        });
    }    
    
}
