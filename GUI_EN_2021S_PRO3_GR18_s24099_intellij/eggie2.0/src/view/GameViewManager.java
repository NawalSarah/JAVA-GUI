package view;

import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Player;
import model.SmallinfoLabel;

import java.util.Random;

public class GameViewManager {

    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private Stage menuStage;

    private boolean isLeftKeyPressed;
    private boolean isRightKeyPressed;
    private int angle;
    private ImageView wolfImage;
    private AnimationTimer gameTimer;
    private GridPane gridPane1;
    private GridPane gridPane2;
    private ImageView[] wastes = new ImageView[6];
    private ImageView egg;
    private Player wolf;
    private SmallinfoLabel pointLabel;
    private ImageView[] playerLives;
    private int playerLivesInt;
    private int points;
    private int difficulty;
    Random wastePosition;

    private static final String eggURL = "view/resources/star_gold.png";
    private static final double WIDTH=912;
    private static final double HEIGHT=612;
    private static double angleChanger = 6;
    private static double Xchanger = 4;
    private static double backgroundSpeed = 4;
    private static double wasteSpeed = 5;
    private static double wasteSpeedAngle = 3;
    //  private static final double paneLayoutDiff = 1000;

    private static final double WASTE_RADIUS = 4;
    private static final double EGG_RADIUS = 12;
    private static final double WOLF_RADIUS = 27;

    public  GameViewManager(){
        wastePosition = new Random();
        initializeStage();
        createKeyListeners();
    }


      //create keyListeners

    private void createKeyListeners(){
        gameScene.setOnKeyPressed(e->{
            if(e.getCode()== KeyCode.LEFT || e.getCode()== KeyCode.A){
                isLeftKeyPressed = true;
            }else if(e.getCode() == KeyCode.RIGHT || e.getCode()== KeyCode.D){
                isRightKeyPressed =true;
            }
        });

        gameScene.setOnKeyReleased(e->{
            if(e.getCode()== KeyCode.LEFT || e.getCode()== KeyCode.A){
                isLeftKeyPressed = false;
            }else if(e.getCode() == KeyCode.RIGHT || e.getCode()== KeyCode.D){
                isRightKeyPressed = false;
            }
        });
    }


      //initializes the stage

    private void initializeStage(){
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane, WIDTH, HEIGHT);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
        gameStage.setResizable(false);
    }


     // create the egg

    private void createEgg(){
        egg = new ImageView(eggURL);
        setNewMeteorPosition(egg);
        gamePane.getChildren().add(egg);
        Path p = new Path();
        p.getElements().add(new MoveTo(100, 200));
        p.getElements().add(new LineTo(100, 400));
        PathTransition pt = new PathTransition(Duration.millis(4000), p);
    }


     // create the info bar on the right upper corner

    private void createStatisticsUI(){
        pointLabel = new SmallinfoLabel("POINTS : 00");
        pointLabel.setLayoutY(30);
        pointLabel.setLayoutX(400);
        gamePane.getChildren().add(pointLabel);
        playerLives = new ImageView[playerLivesInt];
        for (int i =0;i< playerLives.length;i++){
            ImageView life = new ImageView(wolf.getUrl_player_life());
            life.setLayoutY(90);
            life.setLayoutX(400+i*70);
            playerLives[i] = life;
            gamePane.getChildren().add(playerLives[i]);
        }
    }


     //creates meteors

    private void createMeteors(){
        for(int i =0;i< 4;i++){
            ImageView meteor = new ImageView(getMeteorImage());
            wastes[i] = meteor;
            setNewMeteorPosition(meteor);
            gamePane.getChildren().add(meteor);
        }
    }


     // randomly set position of the object

    private void setNewMeteorPosition(ImageView meteor){
        meteor.setLayoutX(wastePosition.nextInt(599)+155);
        meteor.setLayoutY(wastePosition.nextInt(120)+100);

    }


     // pick the image of the meteor


    private String getMeteorImage(){
        //  int number =(int) (Math.random()*2+1);
        return "view/resources/wolfChooser/meteor2.png";
    }


     // creates background

    private void createBackground(){
        gridPane1 = new GridPane();
        gridPane2 = new GridPane();
        String backgroundImageString = getBackgroundImage();
        for(int i =0;i<12;i++){
            ImageView backgroundImage1 = new ImageView(backgroundImageString);
            ImageView backgroundImage2 = new ImageView(backgroundImageString);
            GridPane.setConstraints(backgroundImage1,i%3,i/3);
            GridPane.setConstraints(backgroundImage2,i%3,i/3);
            gridPane1.getChildren().add(backgroundImage1);
            gridPane2.getChildren().add(backgroundImage2);
        }
        //  gridPane2.setLayoutY(-paneLayoutDiff);
        gamePane.getChildren().addAll(gridPane1,gridPane2);
    }


     // picks a background image

    private String getBackgroundImage(){
        int number =(int) (Math.random()*3+1);
        return "view/resources/game_bg"+number+".png";
    }


     //creates the game scene

    public void createGameScene(Stage earlierStage, Player wolf,int difficulty){
        this.menuStage = earlierStage;
        this.menuStage.hide();
        this.wolf = wolf;
        this.difficulty = difficulty;
        setDifficulty(difficulty);
        createBackground();
        createEgg();
        createMeteors();
        createStatisticsUI();
        createShip(wolf);
        createGameLoop();
        gameStage.show();
    }



      //change of the difficulty

    private void setDifficulty(int difficulty){
        playerLivesInt = 3;
        switch (difficulty){
            case 1:
                backgroundSpeed = 0;
                wasteSpeed = 1;
                // wasteSpeedAngle = 1.5;
                break;
            case 2:
                backgroundSpeed = 0;
                wasteSpeed = 3.5;
                wasteSpeedAngle = 2;
                break;
            case 4:
                playerLivesInt = 2;
                Xchanger = 5;
                backgroundSpeed = 0;
                wasteSpeed = 7;
                wasteSpeedAngle = 5;
                break;
            case 5:
                playerLivesInt = 2;
                Xchanger = 8;
                backgroundSpeed = 0;
                wasteSpeed = 9;
                wasteSpeedAngle = 7;
                break;
        }
    }


     //creates and locate the wolfImage

    private void createShip(Player wolf){
        wolfImage = new ImageView(new Image(wolf.getUrl()));
        wolfImage.setLayoutX(500);
        wolfImage.setLayoutY(275);
        gamePane.getChildren().add(wolfImage);
    }


      //gameTimer for animation

    private void createGameLoop(){
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                checkifElementsCollide();
                moveMeteorsAndStars();
                moveShip();
            }
        };
        gameTimer.start();
    }

    //collision

    private void checkifElementsCollide(){
        if(WOLF_RADIUS+EGG_RADIUS >
                calculateDistanceBetweenCoordinates(wolfImage.getLayoutX()+49,
                        egg.getLayoutX()+15,
                        wolfImage.getLayoutY()+39,
                        egg.getLayoutY()+15)){
            setNewMeteorPosition(egg);
            addPoint();
        }
        for(int i =0;i<4;i++){
            if(WOLF_RADIUS+WASTE_RADIUS >
                    calculateDistanceBetweenCoordinates(wolfImage.getLayoutX()+49,
                            wastes[i].getLayoutX()+20,
                            wolfImage.getLayoutY()+39,
                            wastes[i].getLayoutY()+20)){
                removeLife();
                setNewMeteorPosition(wastes[i]);
            }
        }
    }

    //adding point

    private void addPoint(){
        points++;
        String stringPointLabel="POINTS : ";
        if(points<10){
            stringPointLabel = stringPointLabel+"0";
        }
        stringPointLabel = stringPointLabel+points;
        pointLabel.setText(stringPointLabel);
    }


      //remove life of the player

    private void removeLife(){
        gamePane.getChildren().remove(playerLives[playerLivesInt-1]);
        playerLivesInt--;
        if(playerLivesInt<=0){
            gameStage.close();
            gameTimer.stop();
            SaveScoreViewManager saveScoreViewManager = new SaveScoreViewManager();
            saveScoreViewManager.createScoreScene(menuStage,points,getBackgroundImage(),difficulty);
        }
    }


      //calculate distance between objects' centers

    private double calculateDistanceBetweenCoordinates(double x, double x1,double y, double y1){
        return Math.sqrt(Math.pow(x-x1,2)+Math.pow(y-y1,2));
    }


      //frame of waste/egg move

    private void moveMeteorsAndStars(){
        egg.setLayoutY(egg.getLayoutY()+wasteSpeed);
        egg.setRotate(egg.getRotate()+wasteSpeedAngle);
        if(egg.getLayoutY()>450){
            setNewMeteorPosition(egg);
        }
        for (int i=0;i<4;i++){

            wastes[i].setLayoutY(wastes[i].getLayoutY()+wasteSpeed);
            wastes[i].setRotate(wastes[i].getRotate()+wasteSpeedAngle);
            if(wastes[i].getLayoutY()>400){
                setNewMeteorPosition(wastes[i]);
            }
        }
    }


     // frame of wolf moving

    private void moveShip(){
        if(isRightKeyPressed && !isLeftKeyPressed){
            if(angle<30){
                angle +=angleChanger;
            }
            wolfImage.setRotate(angle);
            if(wolfImage.getLayoutX()<612)//right limit
            {
                wolfImage.setLayoutX(wolfImage.getLayoutX()+Xchanger);
            }
        }else if(isLeftKeyPressed && !isRightKeyPressed){
            if(angle>-30){
                angle -=angleChanger;
            }
            wolfImage.setRotate(angle);
            if(wolfImage.getLayoutX()>150)// left limit
            {
                wolfImage.setLayoutX(wolfImage.getLayoutX()-Xchanger);
            }
        }else{
            if(angle<0){
                angle += angleChanger;
            }else if(angle >0){
                angle -= angleChanger;
            }
            wolfImage.setRotate(angle);
        }
    }

}
