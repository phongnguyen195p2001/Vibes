/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Controller;

import eproject2_motor.Navigator;
import com.jfoenix.controls.JFXButton;
import eproject2_motor.Data.Brand.Brand;
import eproject2_motor.Data.Brand.BrandDao;
import eproject2_motor.Data.Brand.BrandDaoImpl;
import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class IndexBrandController {

    private BrandDao brandDao = new BrandDaoImpl();
    
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
    private TableView<Brand> tvBrand;

    @FXML
    private TableColumn<Brand, String> tcBrand;

    @FXML
    private TableColumn<Brand, String> tcLogo;

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
        Brand deleteBrand = tvBrand.getSelectionModel().getSelectedItem();
        if(deleteBrand == null) {
            warning();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Are you want to delete brand???");
            alert.setTitle("Delete brand???");
            Optional<ButtonType> confirm = alert.showAndWait();
            if(confirm.get() == ButtonType.OK) {
                boolean result = brandDao.deleteBrand(deleteBrand); 
                if(result) {
                    tvBrand.getItems().remove(deleteBrand);
                    System.out.println("A brand is deleted");
                }
                else {
                    System.err.println("No brand is deleted");
                }
            }
        }
    }

    @FXML
    void btnInsert(ActionEvent event) throws IOException {
        Navigator.getInstance().goToInsertBrand();
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
        Brand updateBrand = tvBrand.getSelectionModel().getSelectedItem();

        if (updateBrand == null) {
            warning();
        } else {
            Navigator.getInstance().goToInsertBrand(updateBrand);
        }

    }

    @FXML
    void btnUser(ActionEvent event) throws IOException {
        Navigator.getInstance().goToUser();
    }
    private void warning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Please select brand");
        alert.setHeaderText("A brand must be selected  for the update");
        alert.showAndWait();
    }
    
    public void initialize() {
        tvBrand.setItems(brandDao.selectBrandAll());
        
        tcBrand.setCellValueFactory((brand) ->{
            return brand.getValue().getBrandNameProperty();
        });
        
        tcLogo.setCellValueFactory((brand) ->{
            return brand.getValue().getLogoNameProperty();
        });

    }
}
