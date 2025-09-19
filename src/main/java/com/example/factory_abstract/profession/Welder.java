package com.example.factory_abstract.profession;

/**
 * 焊工
 */
public class Welder implements DoorFittingExpert {
    @Override
    public void getDescription() {
        System.out.println("I can only fit iron doors");
    }
}
