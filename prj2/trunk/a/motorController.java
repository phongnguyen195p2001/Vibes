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
public class motorController {
    @FXML
    private Button btnUser;
    
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
    private TableView<Motor> tvTeacher;

    @FXML
    private TableColumn<Motor, String> tcMotorName;

    @FXML
    private TableColumn<Motor, String> tcImage;

    @FXML
    private TableColumn<Motor, String> tcIntroduce;

    @FXML
    private TableColumn<Motor, Float> tcPrice;

    @FXML
    private TableColumn<Motor, Integer> tcEngine;

    @FXML
    private TableColumn<Motor, Integer> tcBrandMotor;

    @FXML
    private TableColumn<Motor, Integer> tcStyleMotor;
    
    @FXML
    void btnStyle(ActionEvent event) throws IOException {
        Navigator.getInstance().goToStyle();
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
    void btnAdmin(ActionEvent event) throws IOException {
        Navigator.getInstance().goToAdmin();
    }
    
    @FXML
    void btnInsertClick(ActionEvent event) throws IOException {
        Navigator.getInstance().goToInsertMotor();
    }

    @FXML
    void btnUpdateClick(ActionEvent event) throws IOException {
        Motor updateMotor = tvTeacher.getSelectionModel().getSelectedItem();
        if(updateMotor == null) {
            warning();
        }
        else {
            Navigator.getInstance().goToInsertMotor(updateMotor); 
        }
    }
    
         @FXML
    void btnDeleteClick(ActionEvent event) throws IOException {
        Motor deleteMotor = tvTeacher.getSelectionModel().getSelectedItem();
        if(deleteMotor == null) {
            warning();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Are you want to delete teacher ?");
            alert.setTitle("Delete teacher");
            Optional<ButtonType> confirm = alert.showAndWait();
            if(confirm.get() == ButtonType.OK) {
                boolean result = Motor.delete(deleteMotor); 
                if(result) {
                    tvTeacher.getItems().remove(deleteMotor);
                    System.out.println("A teacher is deleted");
                }
                else {
                    System.err.println("No teacher is deleted");
                }
            }
        }
    }
    
    private void warning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Please select teacher");
        alert.setHeaderText("A teacher must be selected  for the update");
        alert.showAndWait();
    }
    
    public void initialize() {
        tvTeacher.setItems(Motor.selectAll());
        
        tcMotorName.setCellValueFactory((teachers) ->{
            return teachers.getValue().getMotorNameProperty();
        });
        
        tcImage.setCellValueFactory((teachers) ->{
            return teachers.getValue().getImageProperty();
        });

        tcIntroduce.setCellValueFactory((teachers) ->{
            return teachers.getValue().getIntroduceProperty();
        });
        
        tcPrice.setCellValueFactory((teachers) ->{
            return teachers.getValue().getPriceProperty();
        });
        
        tcEngine.setCellValueFactory((teachers) ->{
            return teachers.getValue().getEngineProperty();
        });

        tcBrandMotor.setCellValueFactory((teachers) ->{
            return teachers.getValue().getBrandMotorProperty();
        });
        
        tcStyleMotor.setCellValueFactory((teachers) ->{
            return teachers.getValue().getStyleMotorProperty();
        });
    }
}
