/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Controller;

import eproject2_motor.Navigator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import eproject2_motor.Data.Brand.Brand;
import eproject2_motor.Data.Brand.BrandDao;
import eproject2_motor.Data.Brand.BrandDaoImpl;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author Admin
 */
public class InsertBrandController {

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
    private JFXTextField txtBrand;

    @FXML
    private JFXTextField txtLogo;

    @FXML
    private JFXButton btnCancel;
    
    private Brand editBrand = null;
    
    private BrandDao brandDao = new BrandDaoImpl();

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
            Navigator.getInstance().goToBrand();
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
    void btnSubmit(ActionEvent event) throws IOException, SQLException  {
        if (this.editBrand == null) {
            Brand insertBrand = extract();
            insertBrand = brandDao.insertBrand(insertBrand);
//            String msg = "Insert complete!!!";
//            lbMess.setText(msg);
        } else {
            Brand updateBrand = extract();
            updateBrand.setBrandId(editBrand.getBrandId());
            boolean result = brandDao.updateBrand(updateBrand);
//            if (result) {
//                lbMess.setText("Update succesfully");
//            } else {
//                lbMess.setText("Update fail");
//            }
        }
        Navigator.getInstance().goToBrand();
    }

    @FXML
    void btnUser(ActionEvent event) throws IOException {
            Navigator.getInstance().goToUser();
    }
    
    private Brand extract() {
        Brand brand = new Brand();
        brand.setBrandName(txtBrand.getText());
        brand.setLogoName(txtLogo.getText());
        return brand;
    }


    public void initialize(Brand editBrand) {
        this.editBrand = editBrand;
        String msg = "";
        if (this.editBrand == null) {
            msg = "Create a new subject";
        } else {
            msg = "Update an existing subject";
            txtBrand.setText(editBrand.getBrandName());
            txtLogo.setText(editBrand.getLogoName());
        }
    }
}
