package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int waspSpawnTurn = 5;
        final int maxTurns = 50;

        Grid grid = new Grid();

        Queen queen = new Queen();
        queen.setLocation();

        Soldier soldier = new Soldier(23, 32);
        soldier.setLocation();

        grid.drawMap();

        int turn = 0;
        Scanner scanner = new Scanner(System.in);
        String userCommand;

        while(turn<maxTurns) {
            System.out.println("");
            System.out.println("Enter 1 for next turn, anything else to quit");
            userCommand=scanner.nextLine();
            if (userCommand.equals("1")) {
                soldier.setLocation();
                if (turn==waspSpawnTurn) {
                    Wasp wasp = new Wasp(23, 23);
                    wasp.setLocation();
                    while (Grid.activityFrozen) {
                        String combat;
                        System.out.println("Enter 1 for next turn, anything else to quit");
                        combat=scanner.nextLine();
                        if (combat.equals("1")) {
                            soldier.setLocation();
                            grid.drawMap();
                        }
                    }
                    wasp = null;
                }
                grid.drawMap();
                turn++;
            } else turn=maxTurns;
        }
    }
}
