package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.controllers.StartScreenController;
import main.models.Player;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Random;


public class MuleUI extends Application {
     
     private Stage stage;
     private static MuleUI instance;
     private int numPlayers;
     private int difficulty; //beginner - 0, standard - 1, tournament - 2
     private final int playerTurn;
     private boolean isLoaded = false;

     private Scene mapScene;
     private Parent pageMap = null;
     
     private Player[] players;

     public Player currentPlayer;
     
     public MuleUI() {
         instance = this;
         numPlayers = 1;
         difficulty = 0;
         players = new Player[numPlayers];
         playerTurn = 0;
     }

     public void getPlayerOrder(Player[] players) {
         //Player[] newOrder = new Player[players.length];
         int n = players.length;
         int k;
         for (int i = n; i >= 0; i--) {
             for (int j = 0; j < n - 1; j++) {
                 k = j + 1;
                 if (players[j].getScore() > players[k].getScore()) {
                     swapPlayers(j, k, players);
                 }
             }
         }
     }

     private void swapPlayers(int j, int k, Player[] players) {
         Player temp;
         temp = players[j];
         players[j] = players[k];
         players[k] = temp;
     }
     
     public int getnumPlayers() {
         return numPlayers;
     }
     
     public void setnumPlayers(int n) {
         numPlayers = n;
         players = new Player[numPlayers];
     }
     
     public int getDifficulty() {
         return difficulty;
     }
     
     public void setDifficulty(int d) {
         difficulty = d;
     }

     public Player[] getPlayerArray() {
         return players;
     }
     public Player getPlayer(int index) {
         return players[index];
     }
     
     public void setPlayerArray(Player p, int index) {
         players[index] = p;
     }

     public static MuleUI getInstance() {
         return instance;
     }
     
     public void start(Stage primaryStage) throws Exception {
         
         try {
             String source = MuleUI.class.getResource("/main/res/Atari M.U.L.E..mp3")
                     .toString();
             Media media = new Media(source);
             MediaPlayer mediaPlayer = new MediaPlayer(media);
             mediaPlayer.play();
             FXMLLoader loader = new FXMLLoader();
             loader.setLocation(MuleUI.class.getResource("/main/views/MainMenu.fxml"));
             Parent root = loader.load();
             Scene scene = new Scene(root);

             stage = primaryStage;
             primaryStage.setScene(scene);
             primaryStage.setTitle("M.U.L.E on Atari");
             
             StartScreenController controller = loader.getController();
             primaryStage.show();
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     
     private Parent replaceSceneContent(String fxml) throws Exception {
		Parent page = (Parent) FXMLLoader.load(MuleUI.class.getResource(fxml),
				null, new JavaFXBuilderFactory());
		Scene scene = stage.getScene();
		scene.setRoot(page);
		stage.sizeToScene();
		return page;
	}
     
     public static void main(String[] args) {
         launch(args);
     }
     
     public void loadSelect() {
         try {
             replaceSceneContent("/main/views/SelectRace.fxml");
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("An error has occurred...");
         }
     }
     
     public void loadMap() {
         Random rand = new Random();
         int seed = 17;
         int randInt = rand.nextInt(seed);
         //int randInt = 88;
         System.out.println("randint" + randInt);
         try {
             if (!isLoaded) {
                 if (randInt <= 3) {
                     pageMap = (Parent) FXMLLoader.load(MuleUI.class.getResource("/main/views/MapScreen.fxml"),
                             null, new JavaFXBuilderFactory());
                 } else if (randInt <= 7) {
                     pageMap = (Parent) FXMLLoader.load(MuleUI.class.getResource("/main/views/MapScreen2.fxml"),
                             null, new JavaFXBuilderFactory());
                 } else if (randInt < 10){
                     pageMap = (Parent) FXMLLoader.load(MuleUI.class.getResource("/main/views/MapScreen3.fxml"),
                             null, new JavaFXBuilderFactory());
                 } else {
                     pageMap = (Parent) FXMLLoader.load(MuleUI.class.getResource("/main/views/MapScreen4.fxml"),
                             null, new JavaFXBuilderFactory());
                 }
                 mapScene = stage.getScene();
                 mapScene.setRoot(pageMap);
                 stage.sizeToScene();
                 isLoaded = true;
             } else {
                 mapScene = stage.getScene();
                 mapScene.setRoot(pageMap);
                 stage.sizeToScene();
             }
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("An error has occurred...");
         }
     }

     public Scene getMapScene() throws Exception {
         loadMap();
         return mapScene;
     }


     public void loadTown() {
         try {
             replaceSceneContent("/main/views/TownScreen.fxml");
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("An error has occurred...");
         }
     }

     public void loadPub() throws Exception  {
         try {
             replaceSceneContent("/main/views/Pub.fxml");
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("An error has occurred...");
         }
     }

     public void loadAuction() throws Exception {
         try {
             replaceSceneContent("./AuctionScreen.fxml");
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("An error has occurred...");
         }
     }

    public void loadInstructions() throws Exception {
        try {
            replaceSceneContent("/main/views/Instructions.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error has occurred...");
        }
    }

    public void loadLandOffice() throws Exception {
         try {
             replaceSceneContent("/main/views/LandOffice.fxml");
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("An error has occurred...");
         }
     }

     public void loadStore() throws Exception {
         try {
             replaceSceneContent("/main/views/StoreScreen.fxml");
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("An error has occurred...");
         }
     }

     public void loadAssayOffice() throws Exception {
         try {
             replaceSceneContent("/main/views/AssayOffice.fxml");
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("An error has occurred...");
         }
     }

    public void loadMainMenu() throws Exception {
        try {
            replaceSceneContent("/main/views/MainMenu.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error has occurred...");
        }
    }
 }
 
 