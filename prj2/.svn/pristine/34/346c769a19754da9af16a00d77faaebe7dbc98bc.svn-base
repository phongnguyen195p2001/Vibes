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
public class styleController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnInsert;

    @FXML
    private TableView<Style> tvTeacher;

    @FXML
    private TableColumn<Style, String> tcName;

    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnBrand;
    
    @FXML
    private Button btnUser;

    @FXML
    void btnAdmin(ActionEvent event) throws IOException {
        Navigator.getInstance().goToAdmin();
    }

    @FXML
    void btnBrand(ActionEvent event) throws IOException {
        Navigator.getInstance().goToBrand();
    }
    
    @FXML
    void btnUser(ActionEvent event) throws IOException {
        Navigator.getInstance().goToUser();
    }
    
     @FXML
    void btnDeleteClick(ActionEvent event) throws IOException {
        Style deleteStyle = tvTeacher.getSelectionModel().getSelectedItem();
        if(deleteStyle == null) {
            warning();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Are you want to delete teacher ?");
            alert.setTitle("Delete teacher");
            Optional<ButtonType> confirm = alert.showAndWait();
            if(confirm.get() == ButtonType.OK) {
                boolean result = Style.delete(deleteStyle); 
                if(result) {
                    tvTeacher.getItems().remove(deleteStyle);
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
        Navigator.getInstance().goToInsertStyle();
    }

    @FXML
    void btnUpdateClick(ActionEvent event) throws IOException {
        Style updateStyle = tvTeacher.getSelectionModel().getSelectedItem();
        if(updateStyle == null) {
            warning();
        }
        else {
            Navigator.getInstance().goToInsertStyle(updateStyle); 
        }
    }
    
    private void warning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Please select teacher");
        alert.setHeaderText("A teacher must be selected  for the update");
        alert.showAndWait();
    }
    
    public void initialize() {
        tvTeacher.setItems(Style.selectAll());
        
        tcName.setCellValueFactory((teachers) ->{
            return teachers.getValue().getStyleProperty();
        });
    }
}
