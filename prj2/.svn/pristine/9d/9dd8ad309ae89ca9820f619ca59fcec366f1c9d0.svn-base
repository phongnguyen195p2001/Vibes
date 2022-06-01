/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject.a;

import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author Khanh NH
 */
public class userController {

    @FXML
    private Button btnBrand;

    @FXML
    private Button btnStyle;

    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnInsert;

    @FXML
    private TableView<User> tvTeacher;

    @FXML
    private TableColumn<User, String> tcName;

    @FXML
    private TableColumn<User, String> tcPassword;

    @FXML
    private TableColumn<User, String> tcFullName;

    @FXML
    private TableColumn<User, String> tcPhone;

    @FXML
    private TableColumn<User, String> tcEmail;

    @FXML
    void btnDeleteClick(ActionEvent event) throws IOException {
        User deleteUser = tvTeacher.getSelectionModel().getSelectedItem();
        if (deleteUser == null) {
            warning();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Are you want to delete teacher ?");
            alert.setTitle("Delete teacher");
            Optional<ButtonType> confirm = alert.showAndWait();
            if (confirm.get() == ButtonType.OK) {
                boolean result = User.delete(deleteUser);
                if (result) {
                    tvTeacher.getItems().remove(deleteUser);
                    System.out.println("A teacher is deleted");
                } else {
                    System.err.println("No teacher is deleted");
                }
            }
        }
    }

    @FXML
    void btnInsertClick(ActionEvent event) throws IOException {
        Navigator.getInstance().goToInsertUser();
    }

    @FXML
    void btnStyle(ActionEvent event) throws IOException {
        Navigator.getInstance().goToStyle();
    }

    @FXML
    void btnBrand(ActionEvent event) throws IOException {
        Navigator.getInstance().goToBrand();
    }
    
    @FXML
    void btnAdmin(ActionEvent event) throws IOException {
        Navigator.getInstance().goToAdmin();
    }

    @FXML
    void btnUpdateClick(ActionEvent event) throws IOException {
        User updateUser = tvTeacher.getSelectionModel().getSelectedItem();
        if (updateUser == null) {
            warning();
        } else {
            Navigator.getInstance().goToInsertUser(updateUser);
        }
    }

    private void warning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Please select teacher");
        alert.setHeaderText("A teacher must be selected  for the update");
        alert.showAndWait();
    }

    public void initialize() {
        tvTeacher.setItems(User.selectAll());

        tcFullName.setCellValueFactory((teachers) -> {
            return teachers.getValue().getFullNameProperty();
        });

        tcName.setCellValueFactory((teachers) -> {
            return teachers.getValue().getUserNameProperty();
        });

        tcPassword.setCellValueFactory((teachers) -> {
            return teachers.getValue().getPasswordProperty();
        });

        tcPhone.setCellValueFactory((teachers) -> {
            return teachers.getValue().getPhoneProperty();
        });

        tcEmail.setCellValueFactory((teachers) -> {
            return teachers.getValue().getEmailProperty();
        });

    }
}
