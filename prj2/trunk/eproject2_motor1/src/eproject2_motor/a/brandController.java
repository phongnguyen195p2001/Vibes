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

public class brandController {

    @FXML
    private Button btnDelete;
    
    @FXML
    private Button btnStyle;
    
    @FXML
    private Button btnUser;
    
    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnInsert;
    
    @FXML
    private TableView<Brand> tvTeacher;

    @FXML
    private TableColumn<Brand, String> tcName;

    @FXML
    private TableColumn<Brand, String> tcDob;

    @FXML
    void btnDeleteClick(ActionEvent event) throws IOException {
        Brand deleteTeacher = tvTeacher.getSelectionModel().getSelectedItem();
        if(deleteTeacher == null) {
            warning();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Are you want to delete teacher ?");
            alert.setTitle("Delete teacher");
            Optional<ButtonType> confirm = alert.showAndWait();
            if(confirm.get() == ButtonType.OK) {
                boolean result = Brand.delete(deleteTeacher); 
                if(result) {
                    tvTeacher.getItems().remove(deleteTeacher);
                    System.out.println("A teacher is deleted");
                }
                else {
                    System.err.println("No teacher is deleted");
                }
            }
        }
    }

    @FXML
    void btnInsertClick(ActionEvent event) throws IOException {
        Navigator.getInstance().goToInsertBrand();
    }
    
    @FXML
    void btnStyle(ActionEvent event) throws IOException {
        Navigator.getInstance().goToStyle();
    }
    
    @FXML
    void btnAdmin(ActionEvent event) throws IOException {
        Navigator.getInstance().goToAdmin();
    }

    @FXML
    void btnUser(ActionEvent event) throws IOException {
        Navigator.getInstance().goToUser();
    }
    
    @FXML
    void btnUpdateClick(ActionEvent event) throws IOException {
        Brand updateTeacher = tvTeacher.getSelectionModel().getSelectedItem();
        if(updateTeacher == null) {
            warning();
        }
        else {
            Navigator.getInstance().goToInsertBrand(updateTeacher); 
        }
    }
    
    private void warning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Please select teacher");
        alert.setHeaderText("A teacher must be selected  for the update");
        alert.showAndWait();
    }
    
    public void initialize() {
        tvTeacher.setItems(Brand.selectAll());
        
        tcName.setCellValueFactory((teachers) ->{
            return teachers.getValue().getBrandProperty();
        });
        
        tcDob.setCellValueFactory((teachers) ->{
            return teachers.getValue().getLogoProperty();
        });

    }

}

