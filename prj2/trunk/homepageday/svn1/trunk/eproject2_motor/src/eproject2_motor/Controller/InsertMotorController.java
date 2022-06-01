/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Controller;

import eproject2_motor.Navigator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import eproject2_motor.Data.Motor.Motor;
import eproject2_motor.Data.Motor.MotorDao;
import eproject2_motor.Data.Motor.MotorDaoImpl;
import eproject2_motor.Dbconnection.DbFactory;
import eproject2_motor.Dbconnection.DbType;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

public class InsertMotorController implements Initializable  {

    public DbType database = DbType.SQLSERVER;

    @FXML
    private JFXButton btnAdmin;

    @FXML
    private JFXButton btnUser;

    @FXML
    private JFXButton btnMotor;

    @FXML
    private JFXComboBox<String> cbBrand;

    @FXML
    private JFXComboBox<String> cbStyle;

    @FXML
    private JFXButton btnStyle;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnSubmit;

    @FXML
    private JFXTextField txtMotorName;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtEngine;

    @FXML
    private JFXTextField txtIntroduce;

    @FXML
    private Label lbErrorMotorName;

    @FXML
    private Label lbErrorIntroduce;

    @FXML
    private Label lbErrorPrice;

    @FXML
    private Label lbErrorEngine;

    @FXML
    private Label lbErrorBrand;

    @FXML
    private Label lbErrorStyle;

    @FXML
    private Label lbMessage;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXTextField txtImage;

    @FXML
    private Button btnImage;

    @FXML
    private Button btnDescriptionImg;

    @FXML
    private JFXTextField txtDescriptionImg;

    @FXML
    private Label lbErrorImage;

    @FXML
    private Label lbErrorDescriptionImg;

    String fileImg;
    String fileDescriptionImg;

    private Motor editMotor = null;

    private MotorDao motorDao = new MotorDaoImpl();

    @FXML
    void btnDescriptionImg(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            File img = fileChooser.showOpenDialog(null);
            fileDescriptionImg = String.valueOf(img.getName());
            txtDescriptionImg.setText(fileDescriptionImg);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void btnImage(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            File img = fileChooser.showOpenDialog(null);
            fileImg = String.valueOf(img.getName());
            txtImage.setText(fileImg);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

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
        Navigator.getInstance().goToMotor();
    }

    @FXML
    void btnLogout(ActionEvent event) throws IOException {
        Navigator.getInstance().goToMotor();
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
    void btnSubmit(ActionEvent event) throws SQLException {
        if (editMotor == null) {
            Motor insertMotor = extract();
            if (insertMotor != null) {
                insertMotor = motorDao.insertMotor(insertMotor);
                String msg = "Insert motor successfully";
                lbMessage.setText(msg);
            }
        } else {
            Motor updateproduct = extract();
            if (updateproduct != null) {
                updateproduct.setMotorId(this.editMotor.getMotorId());

                boolean result = motorDao.updateMotor(updateproduct);
                if (result) {
                    lbMessage.setText("Updated Succesfully");
                } else {
                    lbMessage.setText("Updated Unsuccessfully");
                }
            }

        }
    }

    @FXML
    void btnUser(ActionEvent event) throws IOException {
        Navigator.getInstance().goToUser();
    }

    private Motor extract() {
        boolean b = false;
        Motor motor = new Motor();
        if (txtMotorName.getText().length() < 1) {
            lbErrorMotorName.setStyle("-fx-text-fill:red");
            lbErrorMotorName.setText("Motor name is required");
        } else {
            lbErrorMotorName.setText("");
            motor.setMotorName(txtMotorName.getText());
        }
            
        if (fileImg == null) {
                lbErrorImage.setStyle("-fx-text-fill:red");
                lbErrorImage.setText("Image is requied");
            } else {
                lbErrorImage.setText("");
                motor.setImage(fileImg);
        }

        if (fileDescriptionImg == null) {
            lbErrorDescriptionImg.setStyle("-fx-text-fill:red");
            lbErrorDescriptionImg.setText("Image detail is requied");
        } else {
            lbErrorDescriptionImg.setText("");
            motor.setDescriptionImg(fileDescriptionImg);
        }

        if (txtPrice.getText().length() < 1) {
            lbErrorPrice.setStyle("-fx-text-fill:red");
            lbErrorPrice.setText("Price is requied");
        } else {
//                if (isNumeric(tfPrice.getText())) {
//                    lberrorsPrice.setStyle("-fx-text-fill:red");
//                    lberrorsPrice.setText("Price  must be number");
//                } else {
            lbErrorPrice.setText("");
            motor.setPrice(Float.parseFloat(txtPrice.getText()));  
        }
        if (txtEngine.getText().length() < 1) {
            lbErrorEngine.setStyle("-fx-text-fill:red");
            lbErrorEngine.setText("Engine is requied");
        } else {
//                if (isNumeric(tfPrice.getText())) {
//                    lberrorsPrice.setStyle("-fx-text-fill:red");
//                    lberrorsPrice.setText("Price  must be number");
//                } else {
            lbErrorEngine.setText("");
            motor.setEngine(Integer.parseInt(txtEngine.getText()));  
        }

        if (txtIntroduce.getText().length() < 1) {
            lbErrorIntroduce.setStyle("-fx-text-fill:red");
            lbErrorIntroduce.setText("Introduce is requied");
        } else {
            lbErrorIntroduce.setText("");
            motor.setIntroduce(txtIntroduce.getText());
        }
            
        if (cbBrand.getValue() == null) {
            lbErrorBrand.setStyle("-fx-text-fill:red");
            lbErrorBrand.setText("Brand is requied");
        } else {
            try (
                    Connection conn = DbFactory.getConnection(database);
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM brand where brandName='" + cbBrand.getValue() + "'");) {
                while (rs.next()) {
                    Integer brandid = rs.getInt("brandId");
                    motor.setBrandId(brandid);

                }

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
            
            if (cbStyle.getValue() == null) {
                lbErrorStyle.setStyle("-fx-text-fill:red");
                lbErrorStyle.setText("Style is requied");
            } else {
                try (
                        Connection conn = DbFactory.getConnection(database);
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM style where styleName='" + cbStyle.getValue() + "'");) {
                    while (rs.next()) {
                        Integer styleId = rs.getInt("styleId");
                        motor.setStyleId(styleId);
                        b = true;
                    }

                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
                                
            if (b == true) {
                return motor;
            } else {
                return null;
            }
        }

    public void initialize(Motor editMotor) {
        SelectBrand();
        SelectStype();
        this.editMotor = editMotor;
        String msg = "";
        if (this.editMotor == null) {
            SelectBrand();
            SelectStype();
            msg = "Create a new Product";
        } else {
            msg = "Update an existing Product";
            txtMotorName.setText(editMotor.getMotorName());
            txtImage.setText(editMotor.getImage());
            fileImg = String.valueOf(editMotor.getImage());
            txtDescriptionImg.setText(editMotor.getDescriptionImg());
            fileDescriptionImg = String.valueOf(editMotor.getDescriptionImg());
            txtPrice.setText(Float.toString(editMotor.getPrice()));
            txtEngine.setText(Integer.toString(editMotor.getEngine()));
            txtIntroduce.setText(editMotor.getIntroduce());
            cbBrand.setValue(editMotor.getBrandName());
            cbStyle.setValue(editMotor.getStyleName());
        }
        lbMessage.setText(msg);
    }

    public void SelectBrand() {
        try (
                Connection conn = DbFactory.getConnection(database);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM brand");) {
            while (rs.next()) {
                String name = rs.getString("brandName");
                cbBrand.getItems().addAll(name);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void SelectStype() {
        try (
                Connection conn = DbFactory.getConnection(database);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM style");) {
            while (rs.next()) {
                String name = rs.getString("styleName");
                cbStyle.getItems().addAll(name);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SelectBrand();
        SelectStype();
    }
}
