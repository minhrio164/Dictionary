package sample;

import com.gtranslate.Audio;
import com.gtranslate.Language;
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javazoom.jl.decoder.JavaLayerException;
import sample.commandline.DictionaryManagement;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DictionaryApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
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
        word_input.setPrefSize(280, 120);


        TextField word_output = new TextField();
        word_output.setLayoutX(10);
        word_output.setLayoutY(180);
        word_output.setId("word_output1");
        word_output.setPrefSize(280, 70);

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
        addWord_input.setPrefSize(280, 80);

        TextField addword_output = new TextField();
        addword_output.setLayoutX(10);
        addword_output.setLayoutY(140);
        addword_output.setId("word_output1");
        addword_output.setPrefSize(280, 80);

        Button goBackRoot = new Button();
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

        TextField subWord_input = new TextField();
        subWord_input.setLayoutX(10);
        subWord_input.setLayoutY(50);
        subWord_input.setId("word_input1");
        subWord_input.setPrefSize(280, 80);

        TextField subword_output = new TextField();
        subword_output.setLayoutX(10);
        subword_output.setLayoutY(140);
        subword_output.setId("word_output1");
        subword_output.setPrefSize(280, 80);

        Button sub_goBackRoot = new Button();
        sub_goBackRoot.setLayoutX(10);
        sub_goBackRoot.setLayoutY(10);
        sub_goBackRoot.setId("goBackRoot");

        Button sub_SummitButton = new Button();
        sub_SummitButton.setText("Remove");
        sub_SummitButton.setLayoutX(110);
        sub_SummitButton.setLayoutY(145);
        sub_SummitButton.setId("buttonSub");

        Label sub_text1 = new Label();
        sub_text1.setText("Sub Screen");
        sub_text1.setLayoutX(110);
        sub_text1.setLayoutY(15);
        sub_text1.setId("text4");

        Label sub_text2 = new Label();
        sub_text2.setText("Word Delete");
        sub_text2.setLayoutX(18);
        sub_text2.setLayoutY(60);
        sub_text2.setId("text1");

        Label sub_text3 = new Label();
        sub_text3.setText("Vietnamese");
        sub_text3.setLayoutX(18);
        sub_text3.setLayoutY(150);
        sub_text3.setId("text2");

        TextField rePairWord_input = new TextField();
        rePairWord_input.setLayoutX(10);
        rePairWord_input.setLayoutY(50);
        rePairWord_input.setId("word_input1");
        rePairWord_input.setPrefSize(280, 80);

        TextField rePairword_output = new TextField();
        rePairword_output.setLayoutX(10);
        rePairword_output.setLayoutY(140);
        rePairword_output.setId("word_output1");
        rePairword_output.setPrefSize(280, 80);

        Button rePair_goBackRoot = new Button();
        rePair_goBackRoot.setLayoutX(10);
        rePair_goBackRoot.setLayoutY(10);
        rePair_goBackRoot.setId("goBackRoot");

        Button rePair_SummitButton = new Button();
        rePair_SummitButton.setText("Add");
        rePair_SummitButton.setLayoutX(110);
        rePair_SummitButton.setLayoutY(230);
        rePair_SummitButton.setId("buttonRepair");

        Label repair_text1 = new Label();
        repair_text1.setText("Repair Screen");
        repair_text1.setLayoutX(100);
        repair_text1.setLayoutY(15);
        repair_text1.setId("text4");

        Label repair_text2 = new Label();
        repair_text2.setText("Repair Word");
        repair_text2.setLayoutX(18);
        repair_text2.setLayoutY(60);
        repair_text2.setId("text1");

        Label repair_text3 = new Label();
        repair_text3.setText("New Vietnamese mean");
        repair_text3.setLayoutX(18);
        repair_text3.setLayoutY(150);
        repair_text3.setId("text2");


        String str = word_input.getText();
        word_output.setText(dictionaryManagement.dictionaryLookup(str));
        List<String> listString = new ArrayList<>();
        listString.clear();
        listString = dictionaryManagement.dictionarySeacher(str);
        word_list.getItems().clear();
        for (int i = 0; i < listString.size(); i++)
            word_list.getItems().add(listString.get(i));
        word_input.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String str = word_input.getText();
                word_output.setText(dictionaryManagement.dictionaryLookup(str));
                List<String> listString = new ArrayList<>();
                listString.clear();
                listString = dictionaryManagement.dictionarySeacher(str);
                Collections.sort(listString);
                word_list.getItems().clear();
                for (int i = 0; i < listString.size(); i++)
                    word_list.getItems().add(listString.get(i));
            }

        });

        // sampleScreen.
        Pane root = new Pane();
        root.setId("rootPane");
        root.getChildren().addAll(word_input,
                word_output, word_list, rectangle1, addButton,
                subButton, rePairButton, voiceButton,
                text1, text2, text3, text4);
        Scene sampleScreen = new Scene(root, 300, 510);
        sampleScreen.getStylesheets().add(getClass().getResource("DictionaryCSS.css").toExternalForm());
        // addScreen.
        Pane addViewScreen = new Pane();
        addViewScreen.setId("rootPane");
        addViewScreen.getChildren().addAll(addWord_input, addword_output, goBackRoot, add_SummitButton, add_text1, add_text2, add_text3);
        Scene addScreen = new Scene(addViewScreen, 300, 300);
        addScreen.getStylesheets().add(getClass().getResource("DictionaryCSS.css").toExternalForm());
        addButton.setOnAction(e -> primaryStage.setScene(addScreen));
        goBackRoot.setOnAction(e -> primaryStage.setScene(sampleScreen));

        add_SummitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                dictionaryManagement.add(addWord_input.getText(), addword_output.getText());
                System.out.println(addWord_input.getText() + addword_output.getText());
                dictionaryManagement.dictionaryExportToFile();
                Alert add_alert = new Alert(Alert.AlertType.INFORMATION);
                add_alert.setContentText("Word Added: " + addWord_input.getText());
                add_alert.show();
            }
        });

        Pane subViewScreen = new Pane();
        subViewScreen.setId("rootPane");
        subViewScreen.getChildren().addAll(sub_goBackRoot, sub_SummitButton, subWord_input, sub_text1, sub_text2);
        Scene subScreen = new Scene(subViewScreen, 300, 200);
        subScreen.getStylesheets().add(getClass().getResource("DictionaryCSS.css").toExternalForm());
        subButton.setOnAction(e -> primaryStage.setScene(subScreen));
        sub_goBackRoot.setOnAction(e -> primaryStage.setScene(sampleScreen));
        sub_SummitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dictionaryManagement.remove(subWord_input.getText());
                dictionaryManagement.dictionaryExportToFile();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Word Deleted: " + subWord_input.getText());
                alert.show();
            }
        });

        Pane rePairViewScreen = new Pane();
        rePairViewScreen.setId("rootPane");
        rePairViewScreen.getChildren().addAll(rePair_goBackRoot,rePair_SummitButton,repair_text1,rePairWord_input,rePairword_output,repair_text2,repair_text3);
        Scene rePairScreen = new Scene(rePairViewScreen, 300, 300);
        rePairScreen.getStylesheets().add(getClass().getResource("DictionaryCSS.css").toExternalForm());
        rePairButton.setOnAction(e->primaryStage.setScene(rePairScreen));
        rePair_goBackRoot.setOnAction(e->primaryStage.setScene(sampleScreen));
        rePair_SummitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dictionaryManagement.change(rePairWord_input.getText(),rePairword_output.getText());
                dictionaryManagement.dictionaryExportToFile();
                Alert repair_alert = new Alert(Alert.AlertType.INFORMATION);
                repair_alert.setContentText("Word Repaired: " + rePairWord_input.getText() +"\n" + "New means " + rePairword_output.getText());
                repair_alert.show();
            }
        });
        voiceButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                InputStream sound = null;
                try {
                    System.out.println("Hello");
                    Audio audio = Audio.getInstance() ;
                    sound = audio.getAudio(word_input.getText(), Language.ENGLISH);
                    audio.play(sound);
                } catch (IOException | JavaLayerException e) {
                    e.printStackTrace();
                }   finally {
                    try{
                        sound.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        primaryStage.setScene(sampleScreen);
        primaryStage.show();

    }
}

