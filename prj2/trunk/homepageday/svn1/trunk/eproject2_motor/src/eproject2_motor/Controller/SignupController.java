/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Controller;

import eproject2_motor.Dbconnection.DbFactory;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author phong
 */
public class SignupController implements Initializable {

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_user;

    @FXML
    private PasswordField pf_pass;

    @FXML
    private TextField tf_phone;

    @FXML
    private TextField tf_mail;

    @FXML
    void login(MouseEvent event) throws IOException {
        Parent root
                = FXMLLoader.load(getClass().getResource("login.fxml"));
        
        Node node = (Node) event.getSource();
        
        Stage stage = (Stage) node.getScene().getWindow();
        
        stage.setScene(new Scene(root));
    }

    @FXML
    void signup(MouseEvent event) throws SQLException {
        Connection connection = DbFactory.getInstance().getConnection();
        
        String name = tf_name.getText();
        String user = tf_user.getText();
        String pass = pf_pass.getText();
        String phone = tf_phone.getText();
        String mail = tf_mail.getText();
        
        
        try {
            Statement statement = connection.createStatement();
            int status = statement.executeUpdate("insert into user (name, username, password,phone,email) VALUES ('"+name+"', '"+user+"', SHA1('"+pass+"'), '"+phone+"', '"+mail+"')");
            
            if(status > 0){
                System.out.println("user registered!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
