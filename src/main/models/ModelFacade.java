package main.models;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.MuleUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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


    public static ModelFacade getInstance() { return instance; }

    public ModelFacade() {
        instance = this;
        this.playerArray = MuleUI.getInstance().getPlayerArray();
        players = new ArrayList<Player>();
        generatePlayers();
    }


    public void saveModelText() {
        try (PrintWriter out = new PrintWriter(new File("data.text"))) {
            out.println(MuleUI.getInstance().getMapScene());
            for (Player p: players) {
                p.saveTo(out);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void saveModelJson() throws Exception {
        try {
            try (PrintWriter out = new PrintWriter(new File("data.json"))) {
                Gson gs = new Gson();
                Type type = new TypeToken<List<Player>>(){}.getType();
                String gson = gs.toJson(players);
                out.println(gson);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModelFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void generatePlayers() {

        for (Player p: playerArray) {
            players.add(p);
        }
    }
}
