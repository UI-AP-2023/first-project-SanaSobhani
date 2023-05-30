package com.example.phase2;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    public static Stage newStage;
    @Override
    public void start(Stage stage) throws IOException {
        newStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("firstPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 875, 600);
        stage.setTitle("online shop");
        stage.setScene(scene);
        stage.show();
    }
    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        newStage.getScene().setRoot(pane);
        newStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}