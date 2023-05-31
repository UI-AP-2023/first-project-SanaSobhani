package com.example.phase2;
import com.example.phase2.model.commodity.Commodity;
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

public class BasketPageController implements Initializable {
        @FXML
        private AnchorPane mainPane;
        @FXML
        private Label buy_lbl2;
        @FXML
        private ImageView backGroundImg;
        @FXML
        private Button buyButton;

        @FXML
        private ImageView buyImg;

        @FXML
        private ScrollPane basketPane;

        @FXML
        private ListView<String> basketList;

        @FXML
        private Label topic_lbl;

        @FXML
        private Button homeButton;

        @FXML
        private ImageView homeImg;

        @FXML
        private Label buy_lbl;

        @FXML
        private TextField discountField;

        @FXML
        private Text successful_txt;
        @FXML
        private ImageView discountImg;
        Alert alert = new Alert(Alert.AlertType.ERROR);
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle){
                if(SignUpPageController.getCustomerController().getCustomerPointer().getShoppingBasket()!=null)
                {
                        for(Commodity commodity : SignUpPageController.getCustomerController().getCustomerPointer().getShoppingBasket())
                                basketList.getItems().add(commodity.toString());
                }
                discountField.setText(null);
        }
        @FXML
        void back(ActionEvent event) throws IOException {
            HelloApplication helloApplication = new HelloApplication();
            helloApplication.changeScene("customerPage.fxml");
        }

        @FXML
        void buy(ActionEvent event) {
                try{
                        if(discountField.getText()!=null){
                           if(!SignUpPageController.getCustomerController().buy(discountField.getText()))
                                   buy_lbl2.setText("not successful");
                           else
                                   successful_txt.setText("successful");
                        }
                        else
                        {
                               if(!SignUpPageController.getCustomerController().buy())
                                        buy_lbl2.setText("not successful");
                               else
                                       successful_txt.setText("successful");
                        }
                }
                catch (Exception exception){
                        alert.setTitle("not successful");
                        alert.setContentText(exception.getMessage());
                        Optional<ButtonType> result = alert.showAndWait();
                }
        }

}
