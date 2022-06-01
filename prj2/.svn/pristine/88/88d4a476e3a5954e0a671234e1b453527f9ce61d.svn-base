/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eproject.a;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Khanh NH
 */
public class InsertStyleController {

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtStyle;

    @FXML
    private Label lbMess;

    @FXML
    private Label message_value;

    private Style edit = null;

    @FXML
    void btnInsertClick(ActionEvent event) throws IOException {
        Navigator.getInstance().goToStyle();
    }

    @FXML
    void btnResetClick(ActionEvent event) {
        reset();
    }

    @FXML
    void btnSubmitClick(ActionEvent event) throws SQLException {
        if (this.edit == null) {
            Style insertStyle = extract();
            insertStyle = Style.insert(insertStyle);
            String msg = "Insert complete!!!";
            lbMess.setText(msg);
        } else {
            Style updateStyle = extract();
            updateStyle.setId(this.edit.getId());
            boolean result = Style.update(updateStyle);
            if (result) {
                lbMess.setText("Update succesfully");
            } else {
                lbMess.setText("Update fail");
            }
        }
    }
    
    private Style extract() {
        Style subject = new Style();
        subject.setStyle(txtStyle.getText());
        return subject;
    }
    
    public void initialize(Style edit) {
        this.edit = edit;
        String msg = "";
        if (this.edit == null) {
            msg = "Create a new subject";
        } else {
            msg = "Update an existing subject";
            txtStyle.setText(edit.getStyle());
        }
        lbMess.setText(msg);
    }
    
    public void reset() {
        txtStyle.setText("");
    }

}