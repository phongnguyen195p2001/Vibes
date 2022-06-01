/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Controller;

import eproject2_motor.Navigator;
import com.jfoenix.controls.JFXButton;
import eproject2_motor.Dbconnection.DbFactory;
import eproject2_motor.Dbconnection.DbType;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 *
 * @author phong
 */
public class LoginController {

    public DbType database = DbType.SQLSERVER;

    @FXML
    private TextField txtUser;
    ;

    @FXML
    private PasswordField txtPassword;
    ;
    
    @FXML
    private JFXButton btnLogin;

    @FXML
    private Text btnSignUp;

    @FXML
    void btnLogin(ActionEvent event) throws IOException, SQLException {
        String user, password;
        user = txtUser.getText();
        password = txtPassword.getText();

        try (
                Connection conn = DbFactory.getConnection(database);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM admin WHERE userName= '" + user + "' AND password= '" + password + "'");) {
            if (rs.next()) {
                Navigator.getInstance().goToMotor();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void btnSignUp(MouseEvent event) throws IOException {
        Navigator.getInstance().goToSignUp();
    }
}
