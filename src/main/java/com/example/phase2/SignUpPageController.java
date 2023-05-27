package com.example.phase2;
//import controller.CustomerController;
import com.example.phase2.controller.CustomerController;
import com.example.phase2.model.exception.InvalidInput;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
//import model.exception.InvalidInput;

import java.io.IOException;
import java.util.Optional;

public class SignUpPageController {
    @FXML
    private Button signUpButton;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label hint_lbl;

    @FXML
    private Label signUp_lbl;

    @FXML
    private TextField userNameField1;

    @FXML
    private PasswordField passwordField1;

    @FXML
    private Button logInButton;

    @FXML
    private Label logIn_lbl;
    @FXML
    private Button backButton;
    @FXML
    private ImageView signUpImg;
    @FXML
    private Label topic1_lbl;

    @FXML
    private Label topic2_lbl;
    private Alert alert = new Alert(Alert.AlertType.ERROR);
    private CustomerController customerController = new CustomerController();
    @FXML
    void back(ActionEvent event) throws IOException {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.changeScene("firstPage.fxml");
    }
    @FXML
    void logIn(ActionEvent event) throws IOException {
        if(customerController.login(userNameField1.getText(),passwordField1.getText()))
        {
            HelloApplication helloApplication = new HelloApplication();
            helloApplication.changeScene("CustomerMenu.fxml");
        }
        else
            logIn_lbl.setText("you have not sign up yet");
    }

    @FXML
    void signUp(ActionEvent event) throws InvalidInput, IOException {
        try{
        if(!customerController.signUp(userNameField.getText(),passwordField.getText(),phoneField.getText(),emailField.getText()))
            signUp_lbl.setText("Sign up was not successful");
        else
            signUp_lbl.setText("A request is sent to admin");}
        catch (InvalidInput invalidInput){
            alert.setTitle("wrong info!");
            alert.setContentText("Alert!!!");
            Optional<ButtonType> result = alert.showAndWait();
            HelloApplication helloApplication = new HelloApplication();
            if(result.get() == ButtonType.OK)
            {
                HelloApplication helloApplication1 = new HelloApplication();
                helloApplication1.changeScene("firstPage.fxml");
            }
        }
    }
}
