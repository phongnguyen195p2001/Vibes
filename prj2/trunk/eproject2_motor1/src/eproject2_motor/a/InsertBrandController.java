/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject.a;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Khanh NH
 */
public class InsertBrandController{

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnInsert;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSsid;

    @FXML
    private Label lbMess;

    @FXML
    private Label message_value;

    private Brand edit = null;

    @FXML
    void btnInsertClick(ActionEvent event) throws IOException {
        Navigator.getInstance().goToBrand();
    }

    @FXML
    void btnResetClick(ActionEvent event) {
        reset();
    }

    @FXML
    void btnSubmitClick(ActionEvent event) throws SQLException {
        if (this.edit == null) {
            Brand insertTeacher = extract();
            insertTeacher = Brand.insert(insertTeacher);
            String msg = "Insert complete!!!";
            lbMess.setText(msg);
        } else {
            Brand updateTeacher = extract();
            updateTeacher.setId(this.edit.getId());
            boolean result = Brand.update(updateTeacher);
            if (result) {
                lbMess.setText("Update succesfully");
            } else {
                lbMess.setText("Update fail");
            }
        }
    }

    private Brand extract() {
        Brand subject = new Brand();
        subject.setBrand(txtName.getText());
        subject.setLogo(txtSsid.getText());
        return subject;
    }


    public void initialize(Brand edit) {
        this.edit = edit;
        String msg = "";
        if (this.edit == null) {
            msg = "Create a new subject";
        } else {
            msg = "Update an existing subject";
            txtName.setText(edit.getBrand());
            txtSsid.setText(edit.getLogo());
        }
        lbMess.setText(msg);
    }

    void reset() {
        txtName.setText("");
        txtSsid.setText("");
    }

}
