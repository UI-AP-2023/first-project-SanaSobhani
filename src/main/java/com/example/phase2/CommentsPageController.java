package com.example.phase2;

        import com.example.phase2.model.commodity.Comment;
        import com.example.phase2.model.commodity.Commodity;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Button;
        import javafx.scene.control.ListView;
        import javafx.scene.control.ScrollPane;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.AnchorPane;
        import javafx.scene.text.Text;

        import java.io.IOException;
        import java.net.URL;
        import java.util.ResourceBundle;

public class CommentsPageController implements Initializable {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private ImageView backGroundImg;

    @FXML
    private ScrollPane lisPane;

    @FXML
    private ListView<String> commentsList;

    @FXML
    private Text name_txt;

    @FXML
    private Button homeButton;

    @FXML
    private ImageView homeImg;
   private Commodity commodity;
    @FXML
    void back(ActionEvent event) throws IOException {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.changeScene("commodityPage.fxml");

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        this.commodity = CommodityPageController.getCommodity();
        for(Comment comment : commodity.getComments())
            commentsList.getItems().add(comment.getText());
        name_txt.setText(commodity.getName());
    }
    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }
}
