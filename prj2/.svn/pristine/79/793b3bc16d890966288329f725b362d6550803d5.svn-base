/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject.a;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author phong
 */
public class adminController {

    @FXML
    private Button btnUser;
    
    @FXML
    private Button btnBrand;
    
    @FXML
    private Button btnStyle;
    
    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnInsert;

    @FXML
    private TableView<Admin> tvTeacher;

    @FXML
    private TableColumn<Admin, String> tcName;

    @FXML
    private TableColumn<Admin, String> tcPassword;
    
    @FXML
    private TableColumn<Admin, String> tcFullName;

    @FXML
    private TableColumn<Admin, String> tcPhone;

    @FXML
    private TableColumn<Admin, String> tcEmail;

     @FXML
    void btnDeleteClick(ActionEvent event) throws IOException {
        Admin deleteAdmin = tvTeacher.getSelectionModel().getSelectedItem();
        if(deleteAdmin == null) {
            warning();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Are you want to delete teacher ?");
            alert.setTitle("Delete teacher");
            Optional<ButtonType> confirm = alert.showAndWait();
            if(confirm.get() == ButtonType.OK) {
                boolean result = Admin.delete(deleteAdmin); 
                if(result) {
                    tvTeacher.getItems().remove(deleteAdmin);
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
        Navigator.getInstance().goToInsertAdmin();
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
    void btnUser(ActionEvent event) throws IOException {
        Navigator.getInstance().goToUser();
    }

    @FXML
    void btnUpdateClick(ActionEvent event) throws IOException {
        Admin updateAdmin = tvTeacher.getSelectionModel().getSelectedItem();
        if(updateAdmin == null) {
            warning();
        }
        else {
            Navigator.getInstance().goToInsertAdmin(updateAdmin); 
        }
    }
    
    private void warning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Please select teacher");
        alert.setHeaderText("A teacher must be selected  for the update");
        alert.showAndWait();
    }
    
    public void initialize() {
        tvTeacher.setItems(Admin.selectAll());
        
        tcName.setCellValueFactory((teachers) ->{
            return teachers.getValue().getUserNameProperty();
        });
        
        tcPassword.setCellValueFactory((teachers) ->{
            return teachers.getValue().getPasswordProperty();
        });
        
        tcFullName.setCellValueFactory((teachers) ->{
            return teachers.getValue().getFullNameProperty();
        });
        
        tcPhone.setCellValueFactory((teachers) ->{
            return teachers.getValue().getPhoneProperty();
        });
        
        tcEmail.setCellValueFactory((teachers) ->{
            return teachers.getValue().getEmailProperty();
        });

    }

//    @FXML
//    private TableView<Motor> tvmotor;
//
//    @FXML
//    private TableColumn<Motor, String> tvname;
//
//    @FXML
//    private TableColumn<Motor, String> tvimg;
//
//    @FXML
//    private TableColumn<Motor, Float> tvprice;
//
//    @FXML
//    private TableColumn<Motor, Integer> tvengine;
//
//    @FXML
//    private TableColumn<Motor, String> tvintroduce;
//
//    @FXML
//    private TableColumn<Motor, Integer> tvbrand;
//
//    @FXML
//    private TableColumn<Motor, Integer> tvstyle;
//
//    @FXML
//    private JFXTextField name;
//
//    @FXML
//    private JFXTextField price;
//
//    @FXML
//    private JFXTextField des;
//
//    @FXML
//    private JFXTextField img;
//
//    @FXML
//    private JFXTextField engine;
//
//    @FXML
//    private JFXTextField brand;
//
//    @FXML
//    private JFXTextField style;
//
//    @FXML
//    private JFXTextField introduce;
//
//    @FXML
//    void btnadmin(MouseEvent event) {
//
//    }
//
//    @FXML
//    void btnbrand(MouseEvent event) {
//
//    }
//
//    @FXML
//    void btncaontact(MouseEvent event) {
//
//    }
//
//    @FXML
//    void btndb(MouseEvent event) {
//
//    }
//
//    @FXML
//    void btnlogout(MouseEvent event) {
//
//    }
//
//    @FXML
//    void btnmotor(MouseEvent event) {
//
//    }
//
//    @FXML
//    void btnstyle(MouseEvent event) {
//
//    }
//
//    @FXML
//    void btnuser(MouseEvent event) {
//
//    }
//
//    @FXML
//    void clickInsert(MouseEvent event) throws SQLException {
//        Connection connection = DBConnect.getInstance().getConnection();
//
//        String nam, pric, im, eng, bra, sty, in,de;
//
//        nam = name.getText();
//        pric = price.getText();
//        im = img.getText();
//        eng = engine.getText();
//        bra = brand.getText();
//        in = introduce.getText();
//        sty = style.getText();
//        de = des.getText();
//
//        Statement statement = connection.createStatement();
//        int status = statement.executeUpdate("insert into motor (motorName, image,descriptionImg , price,engine,introduce,brandMotor,styleMotor) VALUES ('" + nam + "', '" + im + "', '" + de + "', '" + pric + "', '" + eng + "', '" + in + "','" + bra + "','" + sty + "')");
//
//        if (status > 0) {
//            System.out.println("user registered!");
//        }
//
//    }
//
//    @FXML
//    void clickdelete(MouseEvent event
//    ) {
//
//    }
//
//    @FXML
//    void clickupdate(MouseEvent event
//    ) {
//
//    }
//
//    public void initialize() throws SQLException {
//        System.out.println("Done!");
////        ObservableList<Motor> teachers = null;
////        try {
////            teachers = MotorDaoImpl.selectAll();
////        } catch (SQLException ex) {
////            Logger.getLogger(IndexUIController.class.getName()).log(Level.SEVERE, null, ex);
////        }
//
//        tvmotor.setItems(MotorDaoImpl.selectAll());
//
//        tvname.setCellValueFactory((hocsinh) -> {
//            return hocsinh.getValue().getFullNameProperty();
//        });
//
//        tvimg.setCellValueFactory((hocsinh) -> {
//            return hocsinh.getValue().getImageProperty();
//        });
//
//        tvprice.setCellValueFactory((hocsinh) -> {
//            return hocsinh.getValue().getPriceProperty();
//        });
//
//        tvengine.setCellValueFactory((hocsinh) -> {
//            return hocsinh.getValue().getEngineProperty();
//        });
//
//        tvintroduce.setCellValueFactory((hocsinh) -> {
//            return hocsinh.getValue().getIntroduceProperty();
//        });
//
//        tvbrand.setCellValueFactory((hocsinh) -> {
//            return hocsinh.getValue().getBrandMotorProperty();
//        });
//
//        tvstyle.setCellValueFactory((hocsinh) -> {
//            return hocsinh.getValue().getBrandMotorProperty();
//        });
//    }
}
