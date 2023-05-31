package com.example.phase2;
import com.example.phase2.controller.CustomerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerPageController implements Initializable {
    HelloApplication helloApplication = new HelloApplication();
    @FXML
    private AnchorPane menuPane;

    @FXML
    private Button accountIcon;

    @FXML
    private ImageView accountImg;

    @FXML
    private Label account_lbl;

    @FXML
    private Button basketButton;

    @FXML
    private ImageView basketImg;

    @FXML
    private Label basket_lbl;

    @FXML
    private Button historyButton;

    @FXML
    private ImageView historyImg;

    @FXML
    private Label history_lbl;

    @FXML
    private Button bankButton;

    @FXML
    private ImageView bankImg;

    @FXML
    private Label bank_lbl;

    @FXML
    private Button discountButton;

    @FXML
    private ImageView discounImg;

    @FXML
    private Label discount_lbl;

    @FXML
    private AnchorPane topicPane;

    @FXML
   static private Label name_lbl = new Label();

    @FXML
    private Label welcome_lbl;

    @FXML
    private Button backButton;

    @FXML
    private ImageView backImg;

    @FXML
    private Button productPButton;

    @FXML
    private ImageView productsImg;
    @FXML
    private Text name_txt;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        name_txt.setText(CustomerController.getCustomerPointer().getUserName());

    }
    public static void setLabel(String name){
        name_lbl.setText(name);
    }
    public CustomerPageController(){
        System.out.println(CustomerController.getCustomerPointer().getUserName());
        //name_lbl=new Label();
    }

    @FXML
    void gotoPtoductsPage(ActionEvent event) throws IOException {
        helloApplication.changeScene("productPage.fxml");
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        helloApplication.changeScene("SignUpPageController.fxml");
    }


    @FXML
    void showAccount(ActionEvent event) throws IOException {
        helloApplication.changeScene("accountPage.fxml");
    }

    @FXML
    void showBasket(ActionEvent event) throws IOException {
        helloApplication.changeScene("basketPage.fxml");
    }
    public static Label getName_lbl() {
        return name_lbl;
    }

    @FXML
    void showBankPanel(ActionEvent event) throws IOException {
        helloApplication.changeScene("bankPanel.fxml");
    }

    @FXML
    void showHistory(ActionEvent event) throws IOException {
        helloApplication.changeScene("historyPage.fxml");
    }
    @FXML
    void showDiscounts(ActionEvent event) throws IOException {
        helloApplication.changeScene("discountPage.fxml");
    }
}
