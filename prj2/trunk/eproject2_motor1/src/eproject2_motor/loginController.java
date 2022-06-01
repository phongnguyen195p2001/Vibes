/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor;

import com.mysql.cj.xdevapi.Result;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author phong
 */
public class loginController {

    @FXML
    private TextField tf_user;

    @FXML
    private PasswordField pf_pass;

    @FXML
    void login(MouseEvent event) throws IOException, SQLException {
        Connection connection = DBConnect.getInstance().getConnection();

        String user, pass;

        user = tf_user.getText();
        pass = pf_pass.getText();
        Statement statement = connection.createStatement();
//        or email = '"+pf_pass+"'
        ResultSet resultSet = statement.executeQuery("select * from user where userName= '" + user + "' and password=SHA1('" + pass + "')");
        if (resultSet.next()) {
            AnchorPane root
                    = FXMLLoader.load(getClass().getResource("motor.fxml"));
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(new Scene(root));
        }
    }

    @FXML
    void signup(MouseEvent event) throws IOException {
        Parent root
                = FXMLLoader.load(getClass().getResource("signup.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
    }
}
