package com.company;

public class Soldier extends Ant {

    private String enemyLocation;
    private String[] normalSteps;

    public Soldier(int xCoordinate, int yCoordinate) {
        super();
        this.location=xCoordinate+" "+yCoordinate;
        this.nextStep=this.location;
        this.normalSteps=buildNormalRoute(this.location);
    }

    @Override
    public void setNextStep() {
        if (!Grid.activityFrozen) {
            for (int i=0;i<this.normalSteps.length;i++) {
                if (this.normalSteps[i].equals(this.location)) {
                    if (i<this.normalSteps.length-1) {
                        this.nextStep=this.normalSteps[i+1];
                    } else {
                        this.nextStep=this.normalSteps[0];
                    }
                }
            }
        } else {
            String waspLocation = Grid.getWaspLocation();
            String[] waspCoordinates = waspLocation.split(" ");
            String[] soldierCoordinates = this.location.split(" ");

            int waspX = Integer.parseInt(waspCoordinates[0]);
            int waspY = Integer.parseInt(waspCoordinates[1]);

            int soldierX = Integer.parseInt(soldierCoordinates[0]);
            int soldierY = Integer.parseInt(soldierCoordinates[1]);

            int nextX, nextY;

            if (waspX==soldierX && waspY==soldierY) {
                System.out.println("HAJIME");
                Grid.activityFrozen = false;
                this.normalSteps=buildNormalRoute(this.location);
            }

            if (waspX>=soldierX && waspY>=soldierY) {
                if (soldierX==waspX) nextX=soldierX;
                else nextX=soldierX+1;
                if (soldierY==waspY) nextY=soldierY;
                else nextY=soldierY+1;
                this.nextStep=nextX+" "+nextY;
            } else if (waspX<soldierX && waspY<soldierY) {
                nextX=soldierX-1;
                nextY=soldierY-1;
                this.nextStep=nextX+" "+nextY;
            } else if (waspX>=soldierX && waspY<soldierY) {
                if (soldierX==waspX) nextX=soldierX;
                else nextX=soldierX+1;
                nextY=soldierY-1;
                this.nextStep=nextX+" "+nextY;
            } else if (waspX<soldierX && waspY>=soldierY) {
                nextX=soldierX-1;
                if (soldierY==waspY) nextY=soldierY;
                else nextY=soldierY+1;
                this.nextStep=nextX+" "+nextY;
            }
        }
    }

    @Override
    public void setLocation() {
        setNextStep();
        this.location = this.nextStep;
        String[] coordinates = this.nextStep.split(" ");
        Grid.placeOnMap("S", Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
    }

    private String[] buildNormalRoute(String location) {
        String[] result = new String[4];
        try {
            result[0]=location;
            String[] coordinates=this.location.split(" ");
            if (Math.abs(Integer.parseInt(coordinates[1])+1) > Grid.size) throw new ArithmeticException("Out of grid");
            result[1]=coordinates[0]+" "+(Integer.parseInt(coordinates[1])+1);
            if (Math.abs(Integer.parseInt(coordinates[0])+1) > Grid.size) throw new ArithmeticException("Out of grid");
            result[2]=(Integer.parseInt(coordinates[0])+1)+" "+(Integer.parseInt(coordinates[1])+1);
            result[3]=(Integer.parseInt(coordinates[0])+1)+" "+coordinates[1];
            return result;
        } catch (ArithmeticException e) {
            for (int i=0; i<result.length; i++) {
                result[i] = this.location;
            }
            return result;
        }
    }

}
