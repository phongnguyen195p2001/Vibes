/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject.a;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Khanh NH
 */
public class Navigator {
    
    public static final String BRAND_FXML = "Brand.fxml";
    public static final String INSERTBRAND_FXML = "InsertBrand.fxml";
    public static final String ADMIN_FXML = "Admin.fxml";
    public static final String INSERTADMIN_FXML = "InsertAdmin.fxml";
    public static final String STYLE_FXML = "Style.fxml";
    public static final String INSERTSTYLE_FXML = "InsertStyle.fxml";
    public static final String USER_FXML = "User.fxml";
    public static final String INSERTUSER_FXML = "InsertUser.fxml";
    public static final String MOTOR_FXML = "Motor.fxml";
    public static final String INSERTMOTOR_FXML = "InsertMotor.fxml";
    
    private FXMLLoader loader;
    private Stage stage = null;
    
    private static Navigator nav = null;
    
    private Navigator() {
        
    }
    
    public static Navigator getInstance() {
        if(nav == null) {
            nav = new Navigator();
        }
        return nav;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public Stage getStage() {
        return stage;
    }
    
    private void goTo(String fxml) throws IOException {
        this.loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        this.stage.setScene(scene);
    }
    
    public void goToBrand() throws IOException {
        this.goTo(BRAND_FXML);
    }
    
    public void goToInsertBrand() throws IOException {
        this.goTo(INSERTBRAND_FXML);
    }
    
    public void goToAdmin() throws IOException {
        this.goTo(ADMIN_FXML);
    }
    
    public void goToInsertAdmin() throws IOException {
        this.goTo(INSERTADMIN_FXML);
    }
    
    public void goToStyle() throws IOException {
        this.goTo(STYLE_FXML);
    }
    
    public void goToInsertStyle() throws IOException {
        this.goTo(INSERTSTYLE_FXML);
    }
    
    public void goToUser() throws IOException {
        this.goTo(USER_FXML);
    }
    
    public void goToInsertUser() throws IOException {
        this.goTo(INSERTUSER_FXML);
    }
    
    public void goToMotor() throws IOException {
        this.goTo(MOTOR_FXML);
    }
    
    public void goToInsertMotor() throws IOException {
        this.goTo(INSERTMOTOR_FXML);
    }
    
    public void goToInsertBrand(Brand updateTeacher) throws IOException {
        this.goTo(INSERTBRAND_FXML);
        InsertBrandController ins = loader.getController();
        ins.initialize(updateTeacher);
    }

    public void goToInsertAdmin(Admin updateAdmin) throws IOException {
        this.goTo(INSERTADMIN_FXML);
        InsertAdminController ins = loader.getController();
        ins.initialize(updateAdmin);
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
    
    public void goToInsertMotor(Motor updateMotor) throws IOException {
        this.goTo(INSERTMOTOR_FXML);
        InsertMotorController ins = loader.getController();
        ins.initialize(updateMotor);
    }
}
