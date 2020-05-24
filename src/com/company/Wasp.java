package com.company;

public class Wasp extends Ant {

    public Wasp(int coordinateX, int coordinateY) {

        super();

        this.location=coordinateX+" "+coordinateY;
        this.nextStep=coordinateX+" "+coordinateY;
        Grid.activityFrozen=true;
        Grid.waspLocation=this.location;

    }

    @Override
    public void setNextStep() {
        this.nextStep=this.location;
    }

    @Override
    public void setLocation() {
        setNextStep();
        this.location=this.nextStep;
        String[] coordinates=this.location.split(" ");
        Grid.placeOnMap("W", Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
    }
}
