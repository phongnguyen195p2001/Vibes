/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class motorController {

    @FXML
    private TableView<Motor> tvmotor;

    @FXML
    private TableColumn<Motor, String> tvname;

    @FXML
    private TableColumn<Motor, String> tvimg;

    @FXML
    private TableColumn<Motor, Float> tvprice;

    @FXML
    private TableColumn<Motor, Integer> tvengine;

    @FXML
    private TableColumn<Motor, String> tvintroduce;

    @FXML
    private TableColumn<Motor, Integer> tvbrand;

    @FXML
    private TableColumn<Motor, Integer> tvstyle;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField price;

    @FXML
    private JFXTextField img;

    @FXML
    private JFXTextField engine;

    @FXML
    private JFXTextField brand;

    @FXML
    private JFXTextField style;

    @FXML
    private JFXTextField introduce;

    @FXML
    private JFXTextField des;

    @FXML
    void btnadmin(MouseEvent event) {

    }

    @FXML
    void btnbrand(MouseEvent event) throws IOException {
        Parent root
                = FXMLLoader.load(getClass().getResource("Brand.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
    }

    @FXML
    void btncaontact(MouseEvent event) throws IOException {
        Parent root
                = FXMLLoader.load(getClass().getResource("contact.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
    }

    @FXML
    void btndb(MouseEvent event) {

    }

    @FXML
    void btnlogout(MouseEvent event) {

    }

    @FXML
    void btnmotor(MouseEvent event) throws IOException {
        Parent root
                = FXMLLoader.load(getClass().getResource("motor.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
    }

    @FXML
    void btnstyle(MouseEvent event) throws IOException {
        Parent root
                = FXMLLoader.load(getClass().getResource("style.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
    }

    @FXML
    void btnuser(MouseEvent event) throws IOException {
        Parent root
                = FXMLLoader.load(getClass().getResource("user.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
    }

    @FXML
    void clickInsert(MouseEvent event) throws SQLException, IOException {
        Parent root
                = FXMLLoader.load(getClass().getResource("insertmotor.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
    }

    @FXML
    void clickdelete(MouseEvent event
    ) {

    }

    @FXML
    void clickupdate(MouseEvent event
    ) {

    }

    public void initialize() throws SQLException {
        System.out.println("Done!");
//        ObservableList<Motor> teachers = null;
//        try {
//            teachers = MotorDaoImpl.selectAll();
//        } catch (SQLException ex) {
//            Logger.getLogger(IndexUIController.class.getName()).log(Level.SEVERE, null, ex);
//        }

        tvmotor.setItems(MotorDaoImpl.selectAll());

        tvname.setCellValueFactory((hocsinh) -> {
            return hocsinh.getValue().getMotorNameProperty();
        });

        tvimg.setCellValueFactory((hocsinh) -> {
            return hocsinh.getValue().getFullNameProperty();
        });

        tvprice.setCellValueFactory((hocsinh) -> {
            return hocsinh.getValue().getPriceProperty();
        });

        tvengine.setCellValueFactory((hocsinh) -> {
            return hocsinh.getValue().getEngineProperty();
        });

        tvintroduce.setCellValueFactory((hocsinh) -> {
            return hocsinh.getValue().getIntroduceProperty();
        });

        tvbrand.setCellValueFactory((hocsinh) -> {
            return hocsinh.getValue().getBrandMotorProperty();
        });

        tvstyle.setCellValueFactory((hocsinh) -> {
            return hocsinh.getValue().getStyleMotorProperty();
        });
    }
}
