package main.models;


//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import javafx.scene.control.Button;
import main.controllers.MapScreenController;
import main.MuleUI;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;

import javax.print.Doc;

/**
 * Created by caseybennett on 11/1/15.
 */



public class ModelFacade {

    Document document, document1;

    MongoClient mongoClient = new MongoClient("localhost");

    MongoDatabase db = mongoClient.getDatabase("MULEdb");

    MongoCollection<Document> saved = db.getCollection("saved");

    private List<Player> players;
    private static ModelFacade instance;
    private Player[] playerArray;
    //private Player p;
    private MuleUI main;

    private int round;

    private boolean loaded = false;


    public static ModelFacade getInstance() { return instance; }

    public ModelFacade() {
        instance = this;
        this.playerArray = MuleUI.getInstance().getPlayerArray();
        players = new ArrayList<Player>();
        generatePlayers();
    }


    public void saveModelText() {

        document = new Document();
        document1 = new Document();

        System.out.println("Databases: ");
        MongoIterable<String> dbs = mongoClient.listDatabaseNames();
        for (String d: dbs) {
            System.out.println(d);
        }

        try (PrintWriter out = new PrintWriter(new File("data.text"))) {
            document.append("numPlayers", MuleUI.getInstance().getnumPlayers())
                    .append("difficulty", MuleUI.getInstance().getDifficulty())
                    .append("round", MapScreenController.getInstance().getCurrentRound().getCurrentRound());

            for (Player p: players) {
                document = p.saveTo(document);
//                p.saveTo(out);
            }

            System.out.println(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new File("map.text"))) {
            String[][] colorMatrix = MapScreenController.getInstance().getTile().getColorMatrix();
            document = MapScreenController.getInstance().getTile().saveColorMatrix(document, colorMatrix);

            System.out.println(document);
            saved.insertOne(document);

            //saveColorMatrix(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void loadModelText() throws Exception {
        loaded = true;

        FindIterable<Document> iterable = saved.find().skip((int) saved.count() - 1);

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                //System.out.println("Document: " + document);

                int numPlayers = (int) document.get("numPlayers");
                int difficutlty = (int) document.get("difficulty");
                MuleUI.getInstance().setnumPlayers(numPlayers);
                MuleUI.getInstance().setDifficulty(difficutlty);

                for (int i = 0; i < numPlayers; ++i) {
                    System.out.println("ID: " + document.get("playerID" + i)
                            + "\nName: " + document.get("playerName" + i)
                            + "\nColor: " + document.get("playerColor" + i)
                            + "\nRace: " + document.get("race" + i)
                            + "\nFood: " + document.get("food" + i)
                            + "\nOre: " + document.get("ore" + i)
                            + "\nCrystite: " + document.get("cyrstite" + i)
                            + "\nMoney: " + document.get("money" + i)
                            + "\nScore: " + document.get("score" + i));

                    Player p = new Player((int) document.get("playerID" + i));
                    p.setPlayerName((String) document.get("playerName" + i));
                    p.setPlayerColor(p.getPlayerColor((int) document.get("playerColor" + i)));
                    p.setRace((String) document.get("race" + i));
                    p.setFood((int) document.get("food" + i));
                    p.setOre((int) document.get("ore" + i));
                    p.setCrystite((int) document.get("crystite" + i));
                    p.setMoney((int) document.get("money" + i));
                    p.setScore((int) document.get("score" + i));
                    MuleUI.getInstance().setPlayerArray(p, i);
                }
            }
        });

//        try {
//            try (BufferedReader br = new BufferedReader(new FileReader("data.text"))) {
//                int numPlayers = Integer.parseInt(br.readLine());
//                int difficulty = Integer.parseInt(br.readLine());
//                round = Integer.parseInt(br.readLine());
//                MuleUI.getInstance().setnumPlayers(numPlayers);
//                MuleUI.getInstance().setDifficulty(difficulty);
//
//                for (int i = 0; i < numPlayers; ++i) {
//                    String line = br.readLine();
//                    String[] tokens = line.split("\t");
//                    Player newPlayer = new Player(Integer.parseInt(tokens[2]));
//                    newPlayer.setEnergy(Integer.parseInt(tokens[5]));
//                    newPlayer.setPlayerName(tokens[0]);
//                    newPlayer.setFood(Integer.parseInt(tokens[4]));
//                    newPlayer.setOre(Integer.parseInt(tokens[7]));
//                    newPlayer.setScore(Integer.parseInt(tokens[8]));
//                    newPlayer.setMoney(Integer.parseInt(tokens[6]));
//                    newPlayer.setPlayerColor(newPlayer.getPlayerColor(Integer.parseInt(tokens[1])));
//                    newPlayer.setRace(tokens[3]);
//                    MuleUI.getInstance().setPlayerArray(newPlayer, i);
//                }
//
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(ModelFacade.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(ModelFacade.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        try (BufferedReader br = new BufferedReader(new FileReader("map.text"))) {
//            MapScreenController ms = new MapScreenController();
//            for (int i = 0; i <3; i++) {
//                String line = br.readLine();
//                String[] tokens = line.split("\t");
//                ms.getButtons(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), tokens[2]);
//            }
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ModelFacade.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }



    private void generatePlayers() {

        for (Player p: playerArray) {
            players.add(p);
        }
    }


    public int getRoundFromData() {return round;}
    public boolean getLoaded() {return loaded;}
}
