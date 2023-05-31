package com.example.phase2;
import com.example.phase2.controller.CommodityController;
import com.example.phase2.controller.CustomerController;
import com.example.phase2.model.commodity.*;
import com.example.phase2.model.user.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductsPageController implements Initializable {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private ImageView backGrondImg;

    @FXML
    private Label topic_lbl;

    @FXML
    private Button homeButton;

    @FXML
    private ImageView homeImg;

    @FXML
    private ScrollPane productPane;
    @FXML
    private Button filterCostButton;

    @FXML
    private TextField costLimitField;
    @FXML
    private ImageView searchImg2;

    @FXML
    private TextField searchField;

    @FXML
    private Button allCommentsButton;
    @FXML
    private ListView<String> productList;
    private static Commodity commodity ;
    private static ListView<String>filterCommodity = new ListView<>();
    private static ArrayList<String> filterCommodities = new ArrayList<>();
    HelloApplication helloApplication = new HelloApplication();
    public static Commodity getCommodity() {
        return commodity;
    }

    public static void setCommodity(Commodity commodity) {
        ProductsPageController.commodity = commodity;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        if(Admin.getAdmin().getCommodities()!=null) {
            for (Commodity commodity : Admin.getAdmin().getCommodities())
                productList.getItems().add(commodity.toString());
        }
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        HelloApplication helloApplication = new HelloApplication();
        if(CustomerController.getCustomerPointer()!=null)
            helloApplication.changeScene("customerPage.fxml");
        else
            helloApplication.changeScene("firstPage.fxml");
    }
    @FXML
    void fillterSSD(ActionEvent event) throws IOException {
        if(filterCommodities!=null)
            filterCommodities.clear();
        ArrayList <SSD> SSDs = CommodityController.filterSSD();
        for(SSD ssd : SSDs)
            filterCommodities.add(ssd.getName());
        helloApplication.changeScene("filterPage.fxml");

    }

    @FXML
    void filterCost(ActionEvent event) throws IOException {
        if(filterCommodity!=null)
            filterCommodities.clear();
        ArrayList<Commodity> commodities = CommodityController.filterCost(Integer.parseInt(costLimitField.getText()));
        for(Commodity commodity1 : commodities)
            filterCommodities.add(commodity1.getName());
        helloApplication.changeScene("filterPage.fxml");

    }

    @FXML
    void filterCpu(ActionEvent event) {
        filterCommodity.getSelectionModel().clearSelection();
       /* ArrayList <> SSDs = CommodityController.filterSSD();
        for(SSD ssd : SSDs)
            filterCommodity.getItems().add(ssd.getName()); */      //delete
    }

    @FXML
    void filterFlashMemory(ActionEvent event) throws IOException {
        if(filterCommodities!=null)
            filterCommodities.clear();
        ArrayList <FlashMemory> flashMemories = CommodityController.filterFlashMemory();
        for(FlashMemory flashMemory : flashMemories)
            filterCommodities.add(flashMemory.getName());
        helloApplication.changeScene("filterPage.fxml");

    }

    @FXML
    void filterLaptop(ActionEvent event) throws IOException {
        if(filterCommodities!=null)
            filterCommodities.clear();
        ArrayList <PC> pcs = CommodityController.filterPC();
        for(PC pc : pcs)
            filterCommodities.add(pc.getName());
        helloApplication.changeScene("filterPage.fxml");
    }

    @FXML
    void filterNote(ActionEvent event) throws IOException {
        if(filterCommodities!=null)
            filterCommodities.clear();
        ArrayList <NoteBook> noteBooks = CommodityController.filterNoteBook();
        for(NoteBook noteBook : noteBooks)
            filterCommodities.add(noteBook.getName());
        helloApplication.changeScene("filterPage.fxml");

    }

    @FXML
    void filterPen(ActionEvent event) throws IOException {
        if(filterCommodities!=null)
            filterCommodities.clear();
        ArrayList <Pen> pens = CommodityController.filterPen();
        for(Pen pen : pens)
            filterCommodities.add(pen.getName());
        helloApplication.changeScene("filterPage.fxml");
    }

    @FXML
    void filterPencil(ActionEvent event) throws IOException {
        if(filterCommodities!=null)
            filterCommodities.clear();
        ArrayList <Pencil> pencils = CommodityController.filterPencil();
        for(Pencil pencil : pencils)
            filterCommodities.add(pencil.getName());
        helloApplication.changeScene("filterPage.fxml");

    }

    @FXML
    void filtterBike(ActionEvent event) throws IOException {
        if(filterCommodities!=null)
            filterCommodities.clear();
        ArrayList <Bicycle> bicycles = CommodityController.filterBike();
        for(Bicycle bicycle : bicycles)
            filterCommodities.add(bicycle.getName());
        helloApplication.changeScene("filterPage.fxml");

    }

    @FXML
    void filtterCar(ActionEvent event) throws IOException {
        if(filterCommodities!=null)
            filterCommodities.clear();
        ArrayList <Car> cars = CommodityController.filterCar();
        for(Car car : cars)
            filterCommodities.add(car.getName());
        helloApplication.changeScene("filterPage.fxml");

    }

    @FXML
    void filtterFood(ActionEvent event) throws IOException {
        if(filterCommodities!=null)
            filterCommodities.clear();
        ArrayList<Commodity> foods = CommodityController.filterCategory("FOOD");
        for(Commodity commodity1: foods)
            filterCommodities.add(commodity1.getName());
        helloApplication.changeScene("filterPage.fxml");
    }

    @FXML
    void search(ActionEvent event) throws IOException {
      this.commodity = CommodityController.searchCommodity(searchField.getText());
      //CommodityPageController commodityPageController = new CommodityPageController(commodity);
      //HelloApplication helloApplication = new HelloApplication();
      helloApplication.changeScene("commodityPage.fxml");
    }

    @FXML
    void filterGrade(ActionEvent event) throws IOException {
        if(filterCommodities!=null)
            filterCommodities.clear();
        ArrayList<Commodity>commodities = CommodityController.filterScore();
        for (Commodity commodity1 : commodities)
            filterCommodities.add(commodity1.getName());
        helloApplication.changeScene("filterPage.fxml");

    }
    public static ListView<String> getFilterCommodity() {
        return filterCommodity;
    }

    public void setFilterCommodity(ListView<String> filterCommodity) {
        this.filterCommodity = filterCommodity;
    }

    public static ArrayList<String> getFilterCommodities() {
        return filterCommodities;
    }
}

