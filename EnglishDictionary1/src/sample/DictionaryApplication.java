package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import sample.commandline.DictionaryCommandline;
import sample.commandline.DictionaryManagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DictionaryApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage)  {
        DictionaryManagement dictionaryManagement = new DictionaryManagement() ;
        dictionaryManagement.insertFromFile();

        primaryStage.setTitle("EnglishDictionary");


        // Create rectangle
        Rectangle rectangle1 = new Rectangle();
        rectangle1.setX(0);
        rectangle1.setY(0);
        rectangle1.setWidth(300);
        rectangle1.setHeight(45);
        rectangle1.setId("rectangle1");




        TextField word_input = new TextField();
        word_input.setLayoutX(10);
        word_input.setLayoutY(50);
        word_input.setId("word_input1");
        word_input.setPrefSize(280,120);


        TextField word_output = new TextField();
        word_output.setLayoutX(10);
        word_output.setLayoutY(180);
        word_output.setId("word_output1");
        word_output.setPrefSize(280,70);

        ListView<String> word_list = new ListView<>();
        word_list.setLayoutX(10);
        word_list.setLayoutY(260);
        word_list.setPrefWidth(280);
        word_list.setId("word_list");

        Button addButton = new Button();
        addButton.setText("Add");
        addButton.setId("buttonAdd");
        addButton.setLayoutX(30);
        addButton.setLayoutY(130);

        Button subButton = new Button();
        subButton.setText("Sub");
        subButton.setId("buttonSub");
        subButton.setLayoutX(105);
        subButton.setLayoutY(130);

        Button rePairButton = new Button();
        rePairButton.setText("Repair");
        rePairButton.setId("buttonRepair");
        rePairButton.setLayoutX(180);
        rePairButton.setLayoutY(130);

        Button voiceButton = new Button();
        voiceButton.setId("voiceButton");
        voiceButton.setLayoutX(10);
        voiceButton.setLayoutY(60);
        Label text1 = new Label();
        text1.setText("English");
        text1.setLayoutX(45);
        text1.setLayoutY(68);
        text1.setId("text1");

        Label text2 = new Label();
        text2.setText("Vietnamese");
        text2.setLayoutX(20);
        text2.setLayoutY(190);
        text2.setId("text2");

        Label text3 = new Label();
        text3.setText("ENGLISH");
        text3.setLayoutX(80);
        text3.setLayoutY(15);
        text3.setId("text3");

        Label text4 = new Label();
        text4.setText("Dictionary");
        text4.setLayoutX(150);
        text4.setLayoutY(15);
        text4.setId("text4");

        TextField addWord_input = new TextField();
        addWord_input.setLayoutX(10);
        addWord_input.setLayoutY(50);
        addWord_input.setId("word_input1");
        addWord_input.setPrefSize(280,80);

        TextField addword_output = new TextField();
        addword_output.setLayoutX(10);
        addword_output.setLayoutY(140);
        addword_output.setId("word_output1");
        addword_output.setPrefSize(280,80);

        Button  goBackRoot = new Button();
        goBackRoot.setLayoutX(10);
        goBackRoot.setLayoutY(10);
        goBackRoot.setId("goBackRoot");

        Button add_SummitButton = new Button();
        add_SummitButton.setText("Add");
        add_SummitButton.setLayoutX(110);
        add_SummitButton.setLayoutY(230);
        add_SummitButton.setId("buttonAdd");

        Label add_text1 = new Label();
        add_text1.setText("Add Screen");
        add_text1.setLayoutX(110);
        add_text1.setLayoutY(15);
        add_text1.setId("text4");

        Label add_text2 = new Label();
        add_text2.setText("English");
        add_text2.setLayoutX(18);
        add_text2.setLayoutY(60);
        add_text2.setId("text1");

        Label add_text3 = new Label();
        add_text3.setText("Vietnamese");
        add_text3.setLayoutX(18);
        add_text3.setLayoutY(150);
        add_text3.setId("text2");


        String str = word_input.getText() ;
        word_output.setText(dictionaryManagement.dictionaryLookup(str));
        List<String> listString = new ArrayList<>();
        listString.clear();
        listString = dictionaryManagement.dictionarySeacher(str) ;
        word_list.getItems().clear();
        for(int i = 0; i <listString.size() ;i++)
            word_list.getItems().add(listString.get(i));
        word_input.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String str = word_input.getText();
                word_output.setText(dictionaryManagement.dictionaryLookup(str));
                List<String> listString = new ArrayList<>();
                listString.clear();
                listString = dictionaryManagement.dictionarySeacher(str) ;
                Collections.sort(listString);
                word_list.getItems().clear();
                for(int i = 0 ; i< listString.size();i++)
                    word_list.getItems().add(listString.get(i));
            }

        });

        // sampleScreen.
        Pane root = new Pane();
        root.setId("rootPane");
        root.getChildren().addAll(word_input,
                word_output,word_list,rectangle1,addButton,
                subButton,rePairButton,voiceButton,
                text1,text2,text3,text4);
        Scene sampleScreen = new Scene(root,300,510);
        sampleScreen.getStylesheets().add(getClass().getResource("DictionaryCSS.css").toExternalForm());
        // addScreen.
        Pane addViewScreen = new Pane();
        addViewScreen.setId("rootPane");
        addViewScreen.getChildren().addAll(addWord_input,addword_output,goBackRoot,add_SummitButton,add_text1,add_text2,add_text3);
        Scene addScreen = new Scene(addViewScreen,300,300);
        addScreen.getStylesheets().add(getClass().getResource("DictionaryCSS.css").toExternalForm());
        addButton.setOnAction(e->primaryStage.setScene(addScreen));
        goBackRoot.setOnAction(e->primaryStage.setScene(sampleScreen));

        add_SummitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                dictionaryManagement.add(addWord_input.getText(),addword_output.getText());
                System.out.println(addWord_input.getText() + addword_output.getText());
                dictionaryManagement.dictionaryExportToFile();

            }
        });


        primaryStage.setScene(sampleScreen);
        primaryStage.show();

    }
}

