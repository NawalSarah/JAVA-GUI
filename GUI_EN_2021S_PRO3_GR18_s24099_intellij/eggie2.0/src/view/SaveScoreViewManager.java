package view;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.InfoLabel;
import model.MenuButton;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SaveScoreViewManager {
    private AnchorPane scorePane;
    private Scene scoreScene;
    private Stage scoreStage;
    private TextField textField;

    private Stage menuStage;
    private int score;
    private int difficulty;

    private static final String fileString = "src/model/score.txt";

    public SaveScoreViewManager(){
        initializeStage();
    }

    //initializing
    private void initializeStage(){
        scorePane = new AnchorPane();
        scoreScene = new Scene(scorePane,512,256);
        scoreStage = new Stage();
        scoreStage.setScene(scoreScene);
        scoreStage.setResizable(false);
    }


     // creates the get nickname scene


    public void createScoreScene(Stage menuStage,int score,String backgroundPath,int difficulty){
        this.menuStage = menuStage;
        this.score = score;
        this.difficulty = difficulty;
        setBackground(backgroundPath);
        setUI();
        scoreStage.show();
    }

    private void setUI(){
        InfoLabel label = new InfoLabel("PRINT NICKNAME");
        label.setLayoutY(60);
        label.setLayoutX(70);
        textField = new TextField();
        textField.setPrefColumnCount(30);
        textField.setLayoutY(label.getLayoutY()+60);
        textField.setLayoutX(85);
        MenuButton submit = new MenuButton("SUBMIT","green");
        submit.setLayoutY(textField.getLayoutY()+60);
        submit.setLayoutX(170);

        submit.setOnAction(e-> onActionFunction());

        scoreScene.setOnKeyPressed(e->{
            if(e.getCode() == KeyCode.ENTER){
                onActionFunction();
            }
        });
        scorePane.getChildren().addAll(label,textField,submit);
    }

    //action listener

    private void onActionFunction(){
        List<String> scoresString = new ArrayList<>();
        String text = textField.getText();
        if(!text.trim().equals("")){
            File file = new File(fileString);
            try{
                if(!file.exists()) file.createNewFile();
                BufferedReader bfr = new BufferedReader(new FileReader(file));
                String line;
                while((line = bfr.readLine())!=null){
                    if(!line.trim().equals("")){
                        scoresString.add(line);
                    }
                }
                bfr.close();
                scoresString.add(score+" ( lvl: "+difficulty+" )"+" - "+text);
                Collections.sort(scoresString,Collections.reverseOrder());
                while(scoresString.size()>10){
                    scoresString.remove(scoresString.size()-1);
                }
                BufferedWriter bfw = new BufferedWriter(new FileWriter(file, false)); //saves to a file
                for(int i =0;i<scoresString.size();i++){
                    bfw.write(scoresString.get(i));
                    bfw.newLine();
                }
                bfw.close();

                menuStage.show();
                scoreStage.close();
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    private void setBackground(String background){
        BackgroundImage backgroundImage =
                new BackgroundImage(
                        new Image(background,912,612,false,true),
                        BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT,
                        BackgroundPosition.DEFAULT,
                        null);
        scorePane.setBackground(new Background(backgroundImage));
    }
}
