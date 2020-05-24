package com.company;

import java.util.Random;

public class Util {

    public static String getRandomDirection() {
        String[] direction = {"-1", "0", "1"};
        Random rand = new Random();
        int random = rand.nextInt(direction.length);
        return direction[random];
    }

    public static int randomFromRange(int min, int max) {
        Random rand = new Random();
        int random = rand.nextInt((max-min)+1)+min;
        return random;
    }

    public static String getRandomEdge() {
        String[] edge = {"0", "49"};
        Random rand = new Random();
        int random = rand.nextInt(edge.length);
        return edge[random];
    }

}
