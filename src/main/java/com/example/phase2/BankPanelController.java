package com.example.phase2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Optional;

public class BankPanelController {

        @FXML
        private AnchorPane mainPane;

        @FXML
        private ImageView backGroundImg;

        @FXML
        private Label topic_lbl;

        @FXML
        private TextField numberField1;

        @FXML
        private TextField numberField2;

        @FXML
        private TextField numberField3;

        @FXML
        private TextField numberField4;

        @FXML
        private TextField credit_lbl;

        @FXML
        private Label cardPassWord_lbl;

        @FXML
        private Label cvv2_lbl;

        @FXML
        private TextField cvv2Field;

        @FXML
        private Label cardNumber_lbl;

        @FXML
        private Label increase_lbl;

        @FXML
        private PasswordField passWordField;

        @FXML
        private Button homeButton;

        @FXML
        private Label creditField;
        @FXML
        private ImageView homeImg;
        Alert alert = new Alert(Alert.AlertType.ERROR);
        @FXML
        void back(ActionEvent event) throws IOException {
            HelloApplication helloApplication = new HelloApplication();
            helloApplication.changeScene("customerPage.fxml");
        }

        @FXML
        void increase(ActionEvent event) {
                StringBuilder cardNumber = new StringBuilder();
                cardNumber.append(numberField1.getText());
                cardNumber.append(numberField2.getText());
                cardNumber.append(numberField3.getText());
                cardNumber.append(numberField4.getText());
                System.out.println(cardNumber.toString());
                System.out.println(Integer.valueOf(creditField.getText()));
                if (SignUpPageController.getCustomerController().increasingCredit(Integer.valueOf(creditField.getText()), cvv2Field.getText(), passWordField.getText(), cardNumber.toString()))
                        increase_lbl.setText("A request is sent to admin");
                else
                {
                        alert.setContentText("not successful");
                        Optional<ButtonType> result = alert.showAndWait();
                }
        }
    }