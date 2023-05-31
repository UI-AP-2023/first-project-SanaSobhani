package com.example.phase2;

import com.example.phase2.controller.CommodityController;
import com.example.phase2.controller.CustomerController;
import com.example.phase2.model.commodity.Commodity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CommodityPageController implements Initializable {

        @FXML
        private AnchorPane mainPane;

        @FXML
        private ImageView backGroundImg;

        @FXML
        private Text commodityName;

        @FXML
        private Button addBasketButton;

        @FXML
        private Button gradeButton;

        @FXML
        private Button commentButton;

        @FXML
        private ImageView addBasketImg;

        @FXML
        private Text addBasket_txt;

        @FXML
        private ImageView gradeImg;

        @FXML
        private ImageView commentImg;

        @FXML
        private Text comment_txt;

        @FXML
        private Text grade_txt;

        @FXML
        private TextField gradeField;

        @FXML
        private TextField commentField;

        @FXML
        private Text name_txt;

        @FXML
        private Text name_txt2;

        @FXML
        private Text commodityId_txt;

        @FXML
        private Text commodityId_txt2;

        @FXML
        private Text cost_text;

        @FXML
        private Text cost_txt2;

        @FXML
        private Text category_txt;

        @FXML
        private Text amountOfInventory_txt;

        @FXML
        private Text category_txt2;

        @FXML
        private Text amountOfInventory_txt2;
        @FXML
        private Text addCommentMessage;
        @FXML
        private Text moreInfo_txt;

        @FXML
        private Text moreInfo_txt2;

        @FXML
        private Button homeButton;

        @FXML
        private Text unsuccessfulGrading;
        @FXML
        private ImageView homeImg;
        private static Commodity commodity;
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle){
           this.commodity = ProductsPageController.getCommodity();
           moreInfo_txt2.setText(commodity.toString());
           amountOfInventory_txt2.setText(String.valueOf(commodity.getAmountOfInventory()));
           category_txt2.setText(commodity.getCategory().toString());
           cost_txt2.setText(String.valueOf(commodity.getCost()));
           commodityId_txt2.setText(commodity.getCommodityID());
           name_txt2.setText(commodity.getName());
           commodityName.setText(commodity.getName());
        }
        @FXML
        void addComment(ActionEvent event) {
                if(commentField.getText()!=null){
                CustomerController.sendingComment(commentField.getText(),commodity);
                addCommentMessage.setText("a request is sent to admin");
                }
        }

        @FXML
        void addToShoppingBasket(ActionEvent event) {
                SignUpPageController.getCustomerController().makingShoppingBasket(commodity.getName(),1);
        }

        @FXML
        void back(ActionEvent event) throws IOException {
                HelloApplication helloApplication = new HelloApplication();
                helloApplication.changeScene("productPage.fxml");
        }

        @FXML
        void grade(ActionEvent event) {
               if(!SignUpPageController.getCustomerController().grading(Integer.valueOf(gradeField.getText()),commodity.getName()))
                       unsuccessfulGrading.setText("you have not bought it");
        }
        @FXML
        void visitAllComments(ActionEvent event) throws IOException {
                HelloApplication helloApplication = new HelloApplication();
                helloApplication.changeScene("commentsPage.fxml");
        }
        public static Commodity getCommodity() {
                return commodity;
        }
}


