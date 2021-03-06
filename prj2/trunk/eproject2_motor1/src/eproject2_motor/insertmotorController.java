/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.ActionEvent;
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
    private JFXButton btnCancel;
    
    @FXML
    private JFXButton btnSubmit;
    
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
    
    private Motor edit = null;
//
//    @FXML
//    void btnSubmit(ActionEvent event) throws SQLException {
//        if (this.edit == null) {
//            Motor insertMotor = extract();
//            insertMotor = Motor.insert(insertMotor);
//        } else {
//            Motor updateMotor = extract();
//            updateMotor.setId(this.edit.getId());
//            boolean result = Motor.update(updateMotor);
//        }
//    }
//    
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
    void clickInsert(MouseEvent event) throws SQLException, IOException {
        if (this.edit == null) {
            Motor insertMotor = extract();
            insertMotor = Motor.insert(insertMotor);
        } else {
            Motor updateMotor = extract();
            updateMotor.setId(this.edit.getId());
            boolean result = Motor.update(updateMotor);
        }
    }
    
    private Motor extract() {
        Motor subject = new Motor();
        subject.setMotorName(name.getText());
        subject.setImage(img.getText());
        subject.setDescriptionImg(des.getText());
        subject.setPrice(Float.parseFloat(price.getText()));
        subject.setEngine(Integer.parseInt(engine.getText()));
        subject.setIntroduce(introduce.getText());
        subject.setBrandMotor(Integer.parseInt(brand.getText()));
        subject.setStyleMotor(Integer.parseInt(style.getText()));

        return subject;
    }

    public void initialize(Motor edit) {
        this.edit = edit;
        String msg = "";
        if (this.edit == null) {
        } else {
            name.setText(edit.getMotorName());
            img.setText(edit.getImage());
            des.setText(edit.getDescriptionImg());
            price.setText(Float.toString(edit.getPrice()));
            engine.setText(Integer.toString(edit.getEngine()));
            introduce.setText(edit.getIntroduce());
            brand.setText(Integer.toString(edit.getBrandMotor()));
            style.setText(Integer.toString(edit.getStyleMotor()));
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
