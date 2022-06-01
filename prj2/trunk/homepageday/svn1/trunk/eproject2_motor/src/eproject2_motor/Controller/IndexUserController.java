/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Controller;

import eproject2_motor.Navigator;
import com.jfoenix.controls.JFXButton;
import eproject2_motor.Data.User.User;
import eproject2_motor.Data.User.UserDao;
import eproject2_motor.Data.User.UserDaoImpl;
import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class IndexUserController {

    private UserDao userDao = new UserDaoImpl();
    
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
    private TableView<User> tvAdmin;

    @FXML
    private TableColumn<User, String> tcUserName;

    @FXML
    private TableColumn<User, String> tcPassword;

    @FXML
    private TableColumn<User, String> tcFullName;

    @FXML
    private TableColumn<User, String> tcPhone;

    @FXML
    private TableColumn<User, String> tcEmail;

    @FXML
    private JFXButton btnInsert;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    void btnAdmin(ActionEvent event) throws IOException {
        Navigator.getInstance().goToAdmin();
    }

    @FXML
    void btnBrand(ActionEvent event) throws IOException {
        Navigator.getInstance().goToBrand();
    }

    @FXML
    void btnDelete(ActionEvent event) throws IOException {
        User deleteAdmin = tvAdmin.getSelectionModel().getSelectedItem();
        if(deleteAdmin == null) {
            warning();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Are you want to delete admin???");
            alert.setTitle("Delete admin???");
            Optional<ButtonType> confirm = alert.showAndWait();
            if(confirm.get() == ButtonType.OK) {
                boolean result = userDao.delete(deleteAdmin); 
                if(result) {
                    tvAdmin.getItems().remove(deleteAdmin);
                    System.out.println("A admin is deleted");
                }
                else {
                    System.err.println("No admin is deleted");
                }
            }
        }
    }

    @FXML
    void btnInsert(ActionEvent event) throws IOException {
        Navigator.getInstance().goToInsertAdmin();
    }

    @FXML
    void btnLogout(ActionEvent event) throws IOException {
        Navigator.getInstance().goToAdmin();
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
    void btnUpdate(ActionEvent event) throws IOException {
        User updateAdmin = tvAdmin.getSelectionModel().getSelectedItem();

        if (updateAdmin == null) {
            warning();
        } else {
            Navigator.getInstance().goToInsertUser(updateAdmin);
        }

    }

    @FXML
    void btnUser(ActionEvent event) throws IOException {
        Navigator.getInstance().goToUser();
    }
    
    private void warning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Please select admin");
        alert.setHeaderText("A admin must be selected  for the update");
        alert.showAndWait();
    }
    
    public void initialize() {
        tvAdmin.setItems(userDao.selectAll());
        
        tcUserName.setCellValueFactory((admin) ->{
            return admin.getValue().getUserNameProperty();
        });
        
        tcPassword.setCellValueFactory((admin) ->{
            return admin.getValue().getPasswordProperty();
        });
        
        tcFullName.setCellValueFactory((admin) ->{
            return admin.getValue().getFullNameProperty();
        });
        
        tcPhone.setCellValueFactory((admin) ->{
            return admin.getValue().getPhoneProperty();
        });
        
        tcEmail.setCellValueFactory((admin) ->{
            return admin.getValue().getEmailProperty();
        });

    }
}
