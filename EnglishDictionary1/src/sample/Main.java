package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
    Stage window ;
    @FXML
     Button addButton ;
    @FXML
    Button sampleButton ;


    @Override
    public void start(Stage primaryStage) {
        try {
            window = primaryStage;
            Parent sampleViewScreen = FXMLLoader.load(getClass().getResource("fxml/sample.fxml"));
            primaryStage.setTitle("English Dictionary");
            Scene sampleScene = new Scene(sampleViewScreen, 351, 601);
            sampleScene.getStylesheets().add(getClass().getResource("DictionaryCss.css").toExternalForm());

            Parent addViewScreen = FXMLLoader.load(getClass().getResource("fxml/addScreen.fxml"));
            primaryStage.setTitle("English Dictionary");
            Scene addScene = new Scene(addViewScreen, 351, 601);
            addScene.getStylesheets().add(getClass().getResource("DictionaryCss.css").toExternalForm());

            primaryStage.setScene(sampleScene);
            primaryStage.show();
            addButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("1");
                    //primaryStage.setScene(addScene);
                    //primaryStage.show();
                }
            });
            //primaryStage.show();

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
