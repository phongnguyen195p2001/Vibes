/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject2_motor.Controller;

import eproject2_motor.Navigator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import eproject2_motor.Data.Style.Style;
import eproject2_motor.Data.Style.StyleDao;
import eproject2_motor.Data.Style.StyleDaoImpl;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author Admin
 */
public class InsertStyleController {

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
    private JFXTextField txtStyle;

    @FXML
    private JFXButton btnCancel;
    
    private Style editStyle = null;
    
    private StyleDao styleDao = new StyleDaoImpl();

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
            Navigator.getInstance().goToStyle();
    }

    @FXML
    void btnLogout(ActionEvent event) throws IOException {
            Navigator.getInstance().goToStyle();
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
    void btnSubmit(ActionEvent event) throws IOException, SQLException {
        if (this.editStyle == null) {
            Style insertStyle = extract();
            insertStyle = styleDao.insertStyle(insertStyle);
//            String msg = "Insert complete!!!";
//            lbMess.setText(msg);
        } else {
            Style updateStyle = extract();
            updateStyle.setStyleId(this.editStyle.getStyleId());
            boolean result = styleDao.updateStyle(updateStyle);
//            if (result) {
//                lbMess.setText("Update succesfully");
//            } else {
//                lbMess.setText("Update fail");
//            }
        }
        Navigator.getInstance().goToStyle();
    }

    @FXML
    void btnUser(ActionEvent event) throws IOException {
            Navigator.getInstance().goToUser();
    }
    
    private Style extract() {
        Style style = new Style();
        style.setStyleName(txtStyle.getText());
        return style;
    }
    
    public void initialize(Style edit) {
        this.editStyle = edit;
        String msg = "";
        if (this.editStyle == null) {
            msg = "Create a new subject";
        } else {
            msg = "Update an existing subject";
            txtStyle.setText(edit.getStyleName());
        }
    }
}
