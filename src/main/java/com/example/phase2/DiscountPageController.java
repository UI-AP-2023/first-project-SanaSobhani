package com.example.phase2;
import com.example.phase2.model.discount.Discount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DiscountPageController implements Initializable {
    @FXML
    private AnchorPane mainPane;

    @FXML
    private ImageView backGroundImg;

    @FXML
    private Button homeButton;

    @FXML
    private ImageView homeImg;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private ListView<String> discontList;

    @FXML
    void back(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
      for (Discount discount : SignUpPageController.getCustomerController().getCustomerPointer().getDiscounts())
          discontList.getItems().add(discount.getDiscountCode());
    }
}
