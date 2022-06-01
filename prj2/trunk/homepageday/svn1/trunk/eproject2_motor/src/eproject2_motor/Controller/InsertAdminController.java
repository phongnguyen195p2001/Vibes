/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Controller;

import eproject2_motor.Navigator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import eproject2_motor.Data.Admin.Admin;
import eproject2_motor.Data.Admin.AdminDao;
import eproject2_motor.Data.Admin.AdminDaoImpl;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author Admin
 */
public class InsertAdminController {

    @FXML
    private JFXButton btnAdmin;

    @FXML
    private JFXButton btnUser;

    @FXML
    private JFXButton btnMotor;

    @FXML
    private JFXButton btnBrand;

    @FXML
    private JFXButton btnStyle;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnSubmit;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXTextField txtFullName;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtPhone;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXPasswordField txtPassword;

    private Admin editAdmin = null;
    
    private AdminDao adminDao = new AdminDaoImpl();

    @FXML
    void btnAdmin(ActionEvent event) throws IOException {
        Navigator.getInstance().goToAdmin();
    }

    @FXML
    void btnBrand(ActionEvent event) throws IOException {
        Navigator.getInstance().goToBrand();
    }

    @FXML
    void btnCancel(ActionEvent event) throws IOException {
        Navigator.getInstance().goToAdmin();
    }

    @FXML
    void btnLogout(ActionEvent event) {

    }

    @FXML
    void btnMotor(ActionEvent event) throws IOException {
        Navigator.getInstance().goToMotor();
    }

    @FXML
    void btnStyle(ActionEvent event) throws IOException {
        Navigator.getInstance().goToStyle();
    }

    @FXML
    void btnSubmit(ActionEvent event) throws IOException {
        if (this.editAdmin == null) {
            Admin insertAdmin = extract();
            insertAdmin = adminDao.insert(insertAdmin);
            String msg = "Insert complete!!!";
//            lbMess.setText(msg);
        } else {
            Admin updateAdmin = extract();
            updateAdmin.setAdminId(editAdmin.getAdminId());
            boolean result = adminDao.update(updateAdmin);
//            if (result) {
//                lbMess.setText("Update succesfully");
//            } else {
//                lbMess.setText("Update fail");
//            }
        }
        Navigator.getInstance().goToAdmin();
    }

    @FXML
    void btnUser(ActionEvent event) throws IOException {
        Navigator.getInstance().goToUser();
    }

    public void initialize(Admin editAdmin) {
        this.editAdmin = editAdmin;
        String msg = "";
        if (this.editAdmin == null) {
            msg = "Create a new Admin";
        } else {
            msg = "Update an existing Admin";
            txtUserName.setText(editAdmin.getUserName());
            txtPassword.setText(editAdmin.getPassword());
            txtFullName.setText(editAdmin.getFullName());
            txtPhone.setText(editAdmin.getPhone());
            txtEmail.setText(editAdmin.getEmail());
        }
    }
    
    private Admin extract() {
        Admin subject = new Admin();
        subject.setUserName(txtUserName.getText());
        subject.setPassword(txtPassword.getText());
        subject.setFullName(txtFullName.getText());
        subject.setPhone(txtPhone.getText());
        subject.setEmail(txtEmail.getText());
        return subject;
    }


    private Admin extractAdminFromFields() {
//        boolean b = false;
//        Admin admin = new Admin();
//        if (tfName.getText().length() < 1) {
//            lberrosname.setStyle("-fx-text-fill:red");
//            lberrosname.setText("Name is required");
//        } else {
//            lberrosname.setText("");
//            admin.setName(tfName.getText());
//            if (tfPass.getText().length() < 1) {
//                lberrorspass.setStyle("-fx-text-fill:red");
//                lberrorspass.setText("Password is required");
//            } else {
//                lberrorspass.setText("");
//                admin.setPassword(tfPass.getText());
//                if (tfphone.getText().length() < 1) {
//                    lberrorsphone.setStyle("-fx-text-fill:red");
//                    lberrorsphone.setText("Phone is required");
//                } else {
//                    lberrorsphone.setText("");
//                    admin.setPhone(tfphone.getText());
//                    if (tfemail.getText().length() < 1) {
//                        lberrorsemail.setStyle("-fx-text-fill:red");
//                        lberrorsemail.setText("Email is required");
//                    } else {
//                        lberrorsemail.setText("");
//                        admin.setEmail(tfemail.getText());
//                        b = true;
//                    }
//                }
//            }
//
//        }
//
//        if (b == true) {
//            return admin;
//        } else {
//            return null;
//        }
        Admin ad = new Admin();
        ad.setUserName(txtUserName.getText());
        ad.setPassword(txtPassword.getText());
        ad.setFullName(txtFullName.getText());
        ad.setPhone(txtPhone.getText());
        ad.setEmail(txtEmail.getText());
        return ad;
    }

}
