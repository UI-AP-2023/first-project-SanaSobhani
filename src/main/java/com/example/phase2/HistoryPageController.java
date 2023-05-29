package com.example.phase2;
import com.example.phase2.model.commodity.Bill;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HistoryPageController implements Initializable {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private ImageView backGroundImg;

    @FXML
    private Label topic_lbl;

    @FXML
    private Button homeButton;

    @FXML
    private ImageView homeImg;

    @FXML
    private ScrollPane mainScroll;

    @FXML
    private ListView<String> histoyList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
       if(SignUpPageController.getCustomerController().getCustomerPointer().getShoppingHistory()!=null){
        for(Bill bill :SignUpPageController.getCustomerController().getCustomerPointer().getShoppingHistory())
            histoyList.getItems().add(bill.toString());
    }
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.changeScene("customerPage.fxml");
    }

}

