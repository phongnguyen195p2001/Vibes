/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Controller;

import eproject2_motor.Navigator;
import com.jfoenix.controls.JFXButton;
import eproject2_motor.Data.Motor.Motor;
import eproject2_motor.Data.Motor.MotorDao;
import eproject2_motor.Data.Motor.MotorDaoImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class IndexMotorController {

    private MotorDao motorDao = new MotorDaoImpl();
    
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
    private TableView<Motor> tvMotor;

    @FXML
    private TableColumn<Motor, String> tcName;

    @FXML
    private TableColumn<Motor, String> tcImage;

    @FXML
    private TableColumn<Motor, Float> tcPrice;

    @FXML
    private TableColumn<Motor, Integer> tcEngine;

    @FXML
    private TableColumn<Motor, String> tcIntroduce;

    @FXML
    private TableColumn<Motor, String> tcBrand;

    @FXML
    private TableColumn<Motor, String> tcStyle;

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
    void btnDelete(ActionEvent event) {
        Motor deleteMotor = tvMotor.getSelectionModel().getSelectedItem();
        if(deleteMotor == null) {
            warning();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Are you want to delete motor???");
            alert.setTitle("Delete motor???");
            Optional<ButtonType> confirm = alert.showAndWait();
            if(confirm.get() == ButtonType.OK) {
                boolean result = motorDao.deleteMotor(deleteMotor); 
                if(result) {
                    tvMotor.getItems().remove(deleteMotor);
                    System.out.println("A motor is deleted");
                }
                else {
                    System.err.println("No motor is deleted");
                }
            }
        }
    }

    @FXML
    void btnInsert(ActionEvent event) throws IOException {
        Navigator.getInstance().goToInsertMotor();
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
        Motor updateMotor = tvMotor.getSelectionModel().getSelectedItem();

        if (updateMotor == null) {
            warning();
        } else {
            Navigator.getInstance().goToInsertMotor(updateMotor);
        }

    }

    @FXML
    void btnUser(ActionEvent event) throws IOException {
        Navigator.getInstance().goToUser();
    }
    
    private void warning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Please select motor");
        alert.setHeaderText("A motor must be selected  for the update");
        alert.showAndWait();
    }
    
    public void initialize() throws SQLException {
        tvMotor.setItems(motorDao.selectMotorAll());
        
        tcName.setCellValueFactory((motor) ->{
            return motor.getValue().getMotorNameProperty();
        });
        
        tcImage.setCellValueFactory((motor) ->{
            return motor.getValue().getImageProperty();
        });

        tcPrice.setCellValueFactory((motor) ->{
            return motor.getValue().getPriceProperty();
        });
        
        tcEngine.setCellValueFactory((motor) ->{
            return motor.getValue().getEngineProperty();
        });
        
        tcIntroduce.setCellValueFactory((motor) ->{
            return motor.getValue().getIntroduceProperty();
        });

        tcBrand.setCellValueFactory((motor) ->{
            return motor.getValue().getBrandNameProperty();
        });
        
        tcStyle.setCellValueFactory((motor) ->{
            return motor.getValue().getStyleNameProperty();
        });
    }
}

