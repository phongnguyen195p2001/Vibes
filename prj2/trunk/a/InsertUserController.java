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
public class InsertUserController {

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtEmail;

    @FXML
    private Label lbMess;

    @FXML
    private Label message_value;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtPhone;

    private User edit = null;

    @FXML
    void btnInsertClick(ActionEvent event) throws IOException {
        Navigator.getInstance().goToUser();
    }

    @FXML
    void btnResetClick(ActionEvent event) {
        reset();
    }

    @FXML
    void btnSubmitClick(ActionEvent event) throws SQLException {
        if (this.edit == null) {
            User insertUser = extract();
            insertUser = User.insert(insertUser);
            String msg = "Insert complete!!!";
            lbMess.setText(msg);
        } else {
            User updateUser = extract();
            updateUser.setId(this.edit.getId());
            boolean result = User.update(updateUser);
            if (result) {
                lbMess.setText("Update succesfully");
            } else {
                lbMess.setText("Update fail");
            }
        }
    }

    private User extract() {
        User subject = new User();
        subject.setUserName(txtUserName.getText());
        subject.setPassword(txtPassword.getText());
        subject.setFullName(txtFullName.getText());
        subject.setPhone(txtPhone.getText());
        subject.setEmail(txtEmail.getText());
        return subject;
    }

    public void initialize(User edit) {
        this.edit = edit;
        String msg = "";
        if (this.edit == null) {
            msg = "Create a new subject";
        } else {
            msg = "Update an existing subject";
            txtFullName.setText(edit.getFullName());
            txtUserName.setText(edit.getUserName());
            txtPassword.setText(edit.getPassword());
            txtPhone.setText(edit.getPhone());
            txtEmail.setText(edit.getEmail());
        }
        lbMess.setText(msg);
    }

    void reset() {
        txtUserName.setText("");
        txtPassword.setText("");
        txtFullName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
    }
}
