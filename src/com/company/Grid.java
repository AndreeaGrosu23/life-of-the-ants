package com.company;

import java.util.Arrays;

public class Grid {

    public static boolean activityFrozen = false;
    public static final int size = 50;
    public static String waspLocation="";
    public static String queenLocation="";
    public static String[][] map;

    public Grid() {
        String[][] map = new String[50][50];

        for (String[] row : map) {
            Arrays.fill(row, ". .");
        }
        this.map=map;
    }

    public static String getWaspLocation() {
        return waspLocation;
    }

    public static String getQueenLocation() {
        return queenLocation;
    }

    public void drawMap() {
        for (String[] row : this.map) {
            System.out.println("");
            for (String box : row) {
                System.out.print(box);
            }
        }
    }

    public void removeFromMap(int coordinateX, int coordinateY) {
        this.map[coordinateX][coordinateY] = "..";
    }

    public static void placeOnMap(String symbol, int coordinateX, int coordinateY) {
        map[coordinateX][coordinateY] = symbol;
    }

}
