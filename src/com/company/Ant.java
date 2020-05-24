package com.company;

public abstract class Ant {

    String location;
    String nextStep;

    public int stepsToQueen() {
        int result;
        result = 1;
        return result;
    }

    public abstract void setNextStep();

    public abstract void setLocation();
}
