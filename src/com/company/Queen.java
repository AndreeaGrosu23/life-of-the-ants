package com.company;

public class Queen extends Ant {

    private static int mood;

    public Queen() {
        super();
        final String queenSpawn = "25 25";
        this.location = queenSpawn;
        this.mood = 0;
        Grid.queenLocation = this.location;
    }

    @Override
    public void setNextStep() {};

    @Override
    public void setLocation() {
        String[] coordinates = this.location.split(" ");
        Grid.placeOnMap("Q", Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
        if (mood > 0) mood--;
    }

    public static int getMood() {
        return mood;
    }

    public static void setMood(int newMood) {
        mood = newMood;
    }
}
