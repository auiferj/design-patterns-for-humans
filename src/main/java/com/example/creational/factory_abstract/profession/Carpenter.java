package com.example.creational.factory_abstract.profession;

/**
 * 木匠
 */
public class Carpenter implements DoorFittingExpert {
    @Override
    public void getDescription() {
        System.out.println("I can only fit wooden doors");
    }
}
