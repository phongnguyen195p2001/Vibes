/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author phong
 */
public class insertmotorController {

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField price;

    @FXML
    private JFXTextField des;

    @FXML
    private JFXTextField img;

    @FXML
    private JFXTextField engine;

    @FXML
    private JFXTextField style;

    @FXML
    private JFXTextField brand;

    @FXML
    private JFXTextField introduce;

    @FXML
    void btnadmin(MouseEvent event) {

    }

    @FXML
    void btnbrand(MouseEvent event) {

    }

    @FXML
    void btncaontact(MouseEvent event) {

    }

    @FXML
    void btndb(MouseEvent event) {

    }

    @FXML
    void btnlogout(MouseEvent event) {

    }

    @FXML
    void btnmotor(MouseEvent event) {

    }

    @FXML
    void btnstyle(MouseEvent event) {

    }

    @FXML
    void btnuser(MouseEvent event) {

    }

    @FXML
    void clickInsert(MouseEvent event) throws SQLException {
        Connection connection = DBConnect.getInstance().getConnection();

        String nam, pric, im, eng, bra, sty, in, de;

        nam = name.getText();
        pric = price.getText();
        im = img.getText();
        eng = engine.getText();
        bra = brand.getText();
        in = introduce.getText();
        sty = style.getText();
        de = des.getText();

        Statement statement = connection.createStatement();
        int status = statement.executeUpdate("insert into motor (motorName, image,descriptionImg , price,engine,introduce,brandMotor,styleMotor) VALUES ('" + nam + "', '" + im + "', '" + de + "', '" + pric + "', '" + eng + "', '" + in + "','" + bra + "','" + sty + "')");

        if (status > 0) {
            System.out.println("user registered!");
        }
    }

    @FXML
    void clickcancel(MouseEvent event) throws IOException {
        Parent root
                = FXMLLoader.load(getClass().getResource("motor.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
    }
}
