/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Controller;

import eproject2_motor.Navigator;
import com.jfoenix.controls.JFXButton;
import eproject2_motor.Data.Style.Style;
import eproject2_motor.Data.Style.StyleDao;
import eproject2_motor.Data.Style.StyleDaoImpl;
import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class IndexStyleController {

    private StyleDao styleDao = new StyleDaoImpl();
    
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
    private TableView<Style> tvStyle;

    @FXML
    private TableColumn<Style, String> tcStyle;

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
        Style deleteStyle = tvStyle.getSelectionModel().getSelectedItem();
        if(deleteStyle == null) {
            warning();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Are you want to delete model???");
            alert.setTitle("Delete model???");
            Optional<ButtonType> confirm = alert.showAndWait();
            if(confirm.get() == ButtonType.OK) {
                boolean result = styleDao.deleteStyle(deleteStyle); 
                if(result) {
                    tvStyle.getItems().remove(deleteStyle);
                    System.out.println("A model is deleted");
                }
                else {
                    System.err.println("No model is deleted");
                }
            }
        }
    }

    @FXML
    void btnInsert(ActionEvent event) throws IOException {
        Navigator.getInstance().goToInsertStyle();
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
        Style updateStyle = tvStyle.getSelectionModel().getSelectedItem();

        if (updateStyle == null) {
            warning();
        } else {
            Navigator.getInstance().goToInsertStyle(updateStyle);
        }

    }

    @FXML
    void btnUser(ActionEvent event) throws IOException {
        Navigator.getInstance().goToUser();
    }
    
    private void warning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Please select model");
        alert.setHeaderText("A model must be selected  for the update");
        alert.showAndWait();
    }
    
    public void initialize() {
        tvStyle.setItems(styleDao.selectStyleAll());
        
        tcStyle.setCellValueFactory((style) ->{
            return style.getValue().getStyleNameProperty();
        });
    }
}
