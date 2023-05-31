package com.example.phase2;

import com.example.phase2.model.commodity.Commodity;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FilterPageController implements Initializable {
    private ListView<String> commodity;
    @FXML
    private AnchorPane mainPane;

    @FXML
    private ImageView badkGroundImg;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private ListView<String> commodityList;

    @FXML
    private Button homeButton;

    @FXML
    private ImageView homeImg;

    @FXML
    void back(ActionEvent event) throws IOException {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.changeScene("productPage.fxml");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
       //commodityList = ProductsPageController.getFilterCommodity();
        for(String commodityName : ProductsPageController.getFilterCommodities())
            commodityList.getItems().add(commodityName);
    }
}

