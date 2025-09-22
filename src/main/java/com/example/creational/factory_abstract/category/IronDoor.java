package com.example.creational.factory_abstract.category;

public class IronDoor implements Door {
    @Override
    public void getDescription() {
        System.out.println("I am an iron door");
    }
}
