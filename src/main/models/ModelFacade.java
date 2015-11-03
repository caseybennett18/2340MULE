package main.models;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.MapScreenController;
import main.MuleUI;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by caseybennett on 11/1/15.
 */



public class ModelFacade {

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
        try (PrintWriter out = new PrintWriter(new File("data.text"))) {
            out.println(MuleUI.getInstance().getnumPlayers());
            out.println(MuleUI.getInstance().getDifficulty());
            out.println(MapScreenController.getInstance().getCurrentRound().getCurrentRound());
            for (Player p: players) {
                p.saveTo(out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void loadModelText() {
        loaded = true;
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("data.text"))) {
                int numPlayers = Integer.parseInt(br.readLine());
                int difficulty = Integer.parseInt(br.readLine());
                round = Integer.parseInt(br.readLine());
                MuleUI.getInstance().setnumPlayers(numPlayers);
                MuleUI.getInstance().setDifficulty(difficulty);

                for (int i = 0; i < numPlayers; ++i) {
                    String line = br.readLine();
                    String[] tokens = line.split("\t");
                    Player newPlayer = new Player(Integer.parseInt(tokens[2]));
                    newPlayer.setEnergy(Integer.parseInt(tokens[5]));
                    newPlayer.setPlayerName(tokens[0]);
                    newPlayer.setFood(Integer.parseInt(tokens[4]));
                    newPlayer.setOre(Integer.parseInt(tokens[7]));
                    newPlayer.setScore(Integer.parseInt(tokens[8]));
                    newPlayer.setMoney(Integer.parseInt(tokens[6]));
                    newPlayer.setPlayerColor(newPlayer.getPlayerColor(Integer.parseInt(tokens[1])));
                    newPlayer.setRace(tokens[3]);
                    MuleUI.getInstance().setPlayerArray(newPlayer, i);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ModelFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ModelFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


//    public void saveModelJson() throws Exception {
//        try {
//            try (PrintWriter out = new PrintWriter(new File("data.json"))) {
//                Gson gs = new Gson();
//                Type type = new TypeToken<List<Player>>(){}.getType();
//                String gson = gs.toJson(players);
//                out.println(gson);
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ModelFacade.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }


    private void generatePlayers() {

        for (Player p: playerArray) {
            players.add(p);
        }
    }


    public int getRoundFromData() {return round;}
    public boolean getLoaded() {return loaded;}
}
