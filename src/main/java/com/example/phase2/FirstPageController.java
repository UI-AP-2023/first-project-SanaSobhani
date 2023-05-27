package com.example.phase2;
import com.example.phase2.controller.AdminController;
import com.example.phase2.view.AdminView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class FirstPageController {
    @FXML
    private AnchorPane anchor;

    @FXML
    private ImageView firstPageImage;

    @FXML
    private Button adminButton;

    @FXML
    private Button customerButton;

    @FXML
    private Button productButton;

    @FXML
    private Text choosing;
    AdminView adminView = new AdminView();
    public FirstPageController(){
        AdminController adminController = new AdminController();
    }
    @FXML
    void customerPage(ActionEvent event) throws IOException {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.changeScene("SignUpPageController.fxml");
    }

    @FXML
    void productPage(ActionEvent event) {

    }

    @FXML
    void adminView(ActionEvent event) {
        adminView.mainView();
    }
}
