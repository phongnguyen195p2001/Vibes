/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author phong
 */
public class Navigator {

    public static final String LOGIN_FXML = "login.fxml";
    public static final String INSERTMOTOR_FXML = "insertmotor.fxml";
    public static final String MOTOR_FXML = "motor.fxml";
    public static final String SIGNUP_FXML = "signup.fxml";
    public static final String APP_FXML = "app.fxml";

    private FXMLLoader loader;
    private Stage stage = null;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    private static Navigator nav = null;

    private Navigator() {

    }

    public static Navigator getInstance() {
        if (nav == null) {
            nav = new Navigator();
        }
        return nav;
    }

    private void goTo(String fxml) throws IOException {
        this.loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
//        stage.scene = scene;
        this.stage.setScene(scene);
    }

    public void gotoLOGIN() throws IOException {
        this.goTo(LOGIN_FXML);
    }

    public void gotoSIGNUP() throws IOException {
        this.goTo(SIGNUP_FXML);
    }

     void goToInsertMotor() throws IOException {
        this.goTo(INSERTMOTOR_FXML);
    }

    void goToInsertMotor(Motor updateMotor) throws IOException {
        this.goTo(INSERTMOTOR_FXML);
    }
    
    public void goToMotor() throws IOException {
        this.goTo(MOTOR_FXML);
    }
    
    public void goToAPP() throws IOException {
        this.goTo(APP_FXML);
    }
   
}
