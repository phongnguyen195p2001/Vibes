package eproject2_motor;

import com.jfoenix.controls.JFXButton;
import eproject2_motor.ColorChangeCallback;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SidePanelController implements Initializable {

    @FXML
    private JFXButton b1;
    @FXML
    private JFXButton b2;
    @FXML
    private JFXButton b3;
    @FXML
    private JFXButton exit;

    private ColorChangeCallback callback;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setCallback(ColorChangeCallback callback) {
        this.callback = callback;
    }
    
     public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Motorcycle Management");
        Navigator.getInstance().setStage(primaryStage);
        Navigator.getInstance().goToAPP();
        Navigator.getInstance().getStage().show();
    }

    @FXML
    private void changeColor(ActionEvent event) throws IOException {
//        JFXButton btn = (JFXButton) event.getSource();
//        System.out.println(btn.getText());
//        switch (btn.getText()) {
//            case "Brand":
//                Parent root
//                        = FXMLLoader.load(getClass().getResource("admin.fxml"));
//
//                Node node = (Node) event.getSource();
//
//                Stage stage = (Stage) node.getScene().getWindow();
//
//                stage.setScene(new Scene(root));
//                break;
//            case "Style":
//                start(Stage primaryStage);
//                break;
//            case "Color 3":
//                callback.updateColor("#FF0000");
//                break;
//        }
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

}
