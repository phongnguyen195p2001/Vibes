/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor;


import eproject2_motor.Controller.InsertAdminController;
import eproject2_motor.Controller.InsertAdminController;
import eproject2_motor.Controller.InsertBrandController;
import eproject2_motor.Controller.InsertBrandController;
import eproject2_motor.Controller.InsertMotorController;
import eproject2_motor.Controller.InsertMotorController;
import eproject2_motor.Controller.InsertStyleController;
import eproject2_motor.Controller.InsertStyleController;
import eproject2_motor.Controller.InsertUserController;
import eproject2_motor.Controller.InsertUserController;
import eproject2_motor.Data.Admin.Admin;
import eproject2_motor.Data.Brand.Brand;
import eproject2_motor.Data.Motor.Motor;
import eproject2_motor.Data.Style.Style;
import eproject2_motor.Data.User.User;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author phong
 */
public class Navigator {

    public static final String LOGIN_FXML = "login.fxml";
    public static final String SIGNUP_FXML = "signup.fxml";
    public static final String ADMIN_FXML = "admin.fxml";
    public static final String BRAND_FXML = "brand.fxml";
    public static final String MOTOR_FXML = "motor.fxml";
    public static final String STYLE_FXML = "style.fxml";
    public static final String USER_FXML = "user.fxml";
    public static final String INSERTADMIN_FXML = "insertadmin.fxml";
    public static final String INSERTBRAND_FXML = "insertbrand.fxml";
    public static final String INSERTMOTOR_FXML = "insertmotor.fxml";
    public static final String INSERTSTYLE_FXML = "insertstyle.fxml";
    public static final String INSERTUSER_FXML = "insertuser.fxml";
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
        this.stage.setScene(scene);
    }

    public void goToLogin() throws IOException {
        this.goTo(LOGIN_FXML);
    }
    
    public void goToApp() throws IOException{
        this.goTo(APP_FXML);
    }

    public void goToSignUp() throws IOException {
        this.goTo(SIGNUP_FXML);
    }

    public void goToAdmin() throws IOException {
        this.goTo(ADMIN_FXML);
    }
    
    public void goToBrand() throws IOException {
        this.goTo(BRAND_FXML);
    }
    
    public void goToMotor() throws IOException {
        this.goTo(MOTOR_FXML);
    }
    
    public void goToStyle() throws IOException {
        this.goTo(STYLE_FXML);
    }
    
    public void goToUser() throws IOException {
        this.goTo(USER_FXML);
    }

    public void goToInsertAdmin() throws IOException {
        this.goTo(INSERTADMIN_FXML);
    }
    
    public void goToInsertBrand() throws IOException {
        this.goTo(INSERTBRAND_FXML);
    }
    
    public void goToInsertMotor() throws IOException {
        this.goTo(INSERTMOTOR_FXML);
    }

    public void goToInsertStyle() throws IOException {
        this.goTo(INSERTSTYLE_FXML);
    }

    public void goToInsertUser() throws IOException {
        this.goTo(INSERTUSER_FXML);
    }
    
    public void goToInsertAdmin(Admin updateAdmin) throws IOException {
        this.goTo(INSERTADMIN_FXML);
        InsertAdminController ins = loader.getController();
        ins.initialize(updateAdmin);
    }

    public void goToInsertBrand(Brand updateBrand) throws IOException {
        this.goTo(INSERTBRAND_FXML);
        InsertBrandController ins = loader.getController();
        ins.initialize(updateBrand);
    }

    public void goToInsertMotor(Motor updateMotor) throws IOException {
        this.goTo(INSERTMOTOR_FXML);
        InsertMotorController ins = loader.getController();
        ins.initialize(updateMotor);
    }
    
    public void goToInsertStyle(Style updateStyle) throws IOException {
        this.goTo(INSERTSTYLE_FXML);
        InsertStyleController ins = loader.getController();
        ins.initialize(updateStyle);
    }
    
    public void goToInsertUser(User updateUser) throws IOException {
        this.goTo(INSERTUSER_FXML);
        InsertUserController ins = loader.getController();
        ins.initialize(updateUser);
    }

}
