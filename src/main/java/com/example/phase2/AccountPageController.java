package com.example.phase2;
import com.example.phase2.controller.CustomerController;
import com.example.phase2.model.exception.InvalidEmail;
import com.example.phase2.model.exception.InvalidInput;
import com.example.phase2.model.exception.InvalidPassword;
import com.example.phase2.model.exception.InvalidPhoneNumber;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AccountPageController implements Initializable {

    @FXML
    private AnchorPane AccountPane;

    @FXML
    private ImageView backGroundImg;

    @FXML
    private Label topic_lbl;

    @FXML
    private Button backButton;

    @FXML
    private ImageView backImg;

    @FXML
    private Text userName_lbl;

    @FXML
    private Text passWord_lbl;

    @FXML
    private Text phoneNumber_lbl;

    @FXML
    private Text email_lbl;

    @FXML
    private Label userName_txt;
    @FXML
    private TextField userNameEdition;

    @FXML
    private TextField passWordEdition;

    @FXML
    private TextField phoneNumberEdition;

    @FXML
    private TextField emailEditiion;

    @FXML
    private Button userNameButton;

    @FXML
    private ImageView userNameImg;

    @FXML
    private Button passWordButton;

    @FXML
    private ImageView passWordImg;

    @FXML
    private Button phoneNumberButton;

    @FXML
    private ImageView phoneImg;

    @FXML
    private Button emailButton;

    @FXML
    private ImageView emailImg;

    @FXML
    private Text passWord_txt = new Text();

    @FXML
    private Text email_txt = new Text();
    @FXML
    private Text phone_txt = new Text();

    @FXML
    private Text credit_txt;

    @FXML
    private Text credit_text1 = new Text();
    private Alert alert = new Alert(Alert.AlertType.ERROR);
    public void initialize(URL url, ResourceBundle resourceBundle){
        email_txt.setText(CustomerController.getCustomerPointer().getEmail());
        phone_txt.setText(CustomerController.getCustomerPointer().getPhoneNumber());
        passWord_txt.setText(CustomerController.getCustomerPointer().getPassWord());
        credit_text1.setText(String.valueOf(CustomerController.getCustomerPointer().getCredit()));
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.changeScene("customerPage.fxml");
    }

    @FXML
    void editEmail(ActionEvent event) throws IOException {
        try{
        SignUpPageController.getCustomerController().editEmail(emailEditiion.getText());}
    catch (InvalidEmail invalidEmail){
        alert.setTitle("wrong info!");
        alert.setContentText(invalidEmail.getMessage());
        Optional<ButtonType> result = alert.showAndWait();
    }
    }

    @FXML
    void editPhone(ActionEvent event) {
        try{
            SignUpPageController.getCustomerController().editPhoneNumber(phoneNumberEdition.getText());
        } catch (InvalidPhoneNumber invalidPhoneNumber) {
            alert.setTitle("wrong info!");
            alert.setContentText(invalidPhoneNumber.getMessage());
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
    @FXML
    void editPassWord(ActionEvent event) throws InvalidPassword {
        try{
        SignUpPageController.getCustomerController().editPassWord(passWordEdition.getText());}
        catch (InvalidPassword invalidPassword){
            alert.setTitle("wrong info!");
            alert.setContentText(invalidPassword.getMessage());
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
}