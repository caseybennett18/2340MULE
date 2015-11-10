package main.models;

/**
 * Created by Admin on 9/23/15.
 */

import java.io.PrintWriter;

/**
 * This class defines a Tile which resides on the Map.
 * A Tile has a TileType, a x location (row), and a y location (column).
 * It also has a boolean flag, selected, to signify whether it is currently selected or not.
 */
public class Tile {
    private TileType tileType;
    private int xLocation, yLocation;
    private boolean selected;
    private Property property;

    int xCord;
    int yCord;
    static String[][] colorMatrix;

    public Tile() {
        xCord = 0;
        yCord = 0;
        colorMatrix = new String[5][9];
    }

    public TileType getTileType() {
        return tileType;
    }

    public int getXLocation() {
        return xLocation;
    }

    public int getYLocation() {
        return yLocation;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean a) {
        selected = a;
    }

    public Property getProperty() {
        return property;
    }

    public void setTileLocationColor(double x, double y, String color) {
        switch((int) x) {
            case 0:
                xCord = 0;
                break;
            case 67:
                xCord = 1;
                break;
            case 134:
                xCord = 2;
                break;
            case 202:
                xCord = 3;
                break;
            case 270:
                xCord = 4;
                break;
            case 338:
                xCord = 5;
                break;
            case 406:
                xCord = 6;
                break;
            case 474:
                xCord = 7;
                break;
            case 542:
                xCord = 8;
                break;
            default:
                xCord = 0;
                break;
        }
        switch((int) y) {
            case 0:
                yCord = 0;
                break;
            case 133:
                yCord = 1;
                break;
            case 266:
                yCord = 2;
                break;
            case 399:
                yCord = 3;
                break;
            case 532:
                yCord = 4;
                break;
            default:
                yCord = 0;
                break;
        }
        colorMatrix[yCord][xCord] = color;
    }

    public String[][] getColorMatrix() {
        return colorMatrix;
    }


    public void saveColorMatrix(PrintWriter out, String[][] colorMatrix) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (colorMatrix[i][j] != null) {
                    out.println(j + "\t" + i + "\t" + colorMatrix[i][j]);
                }
            }
        }
    }
}