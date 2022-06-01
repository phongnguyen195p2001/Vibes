/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject.a;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Khanh NH
 */
public class InsertMotorController {

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtMotorName;

    @FXML
    private TextField txtStyleMotor;

    @FXML
    private Label lbMess;

    @FXML
    private Label message_value;

    @FXML
    private TextField txtImage;

    @FXML
    private TextField txtDescriptionImg;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtEngine;

    @FXML
    private TextField txtIntroduce;

    @FXML
    private TextField txtBrandMotor;

    private Motor edit = null;

    @FXML
    void btnInsertClick(ActionEvent event) throws IOException {
        Navigator.getInstance().goToMotor();
    }

    @FXML
    void btnResetClick(ActionEvent event) {
        reset();
    }

    @FXML
    void btnSubmitClick(ActionEvent event) throws SQLException {
        if (this.edit == null) {
            Motor insertMotor = extract();
            insertMotor = Motor.insert(insertMotor);
            String msg = "Insert complete!!!";
            lbMess.setText(msg);
        } else {
            Motor updateMotor = extract();
            updateMotor.setId(this.edit.getId());
            boolean result = Motor.update(updateMotor);
            if (result) {
                lbMess.setText("Update succesfully");
            } else {
                lbMess.setText("Update fail");
            }
        }
    }

    private Motor extract() {
        Motor subject = new Motor();
        subject.setMotorName(txtMotorName.getText());
        subject.setImage(txtImage.getText());
        subject.setDescriptionImg(txtDescriptionImg.getText());
        subject.setPrice(Float.parseFloat(txtPrice.getText()));
        subject.setEngine(Integer.parseInt(txtEngine.getText()));
        subject.setIntroduce(txtIntroduce.getText());
        subject.setBrandMotor(Integer.parseInt(txtBrandMotor.getText()));
        subject.setStyleMotor(Integer.parseInt(txtStyleMotor.getText()));

        return subject;
    }

    public void initialize(Motor edit) {
        this.edit = edit;
        String msg = "";
        if (this.edit == null) {
            msg = "Create a new subject";
        } else {
            msg = "Update an existing subject";
            txtMotorName.setText(edit.getMotorName());
            txtImage.setText(edit.getImage());
//            txtDescriptionImg.setText(edit.getFullName());
            txtPrice.setText(Float.toString(edit.getPrice()));
            txtEngine.setText(Integer.toString(edit.getEngine()));
            txtIntroduce.setText(edit.getIntroduce());
            txtBrandMotor.setText(Integer.toString(edit.getBrandMotor()));
            txtStyleMotor.setText(Integer.toString(edit.getStyleMotor()));
        }
        lbMess.setText(msg);
    }

    void reset() {
        txtMotorName.setText("");
        txtImage.setText("");
        txtPrice.setText("");
        txtEngine.setText("");
        txtIntroduce.setText("");
        txtBrandMotor.setText("");
        txtStyleMotor.setText("");
    }
}
