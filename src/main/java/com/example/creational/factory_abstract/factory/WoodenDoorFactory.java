package com.example.creational.factory_abstract.factory;

import com.example.creational.factory_abstract.category.Door;
import com.example.creational.factory_abstract.category.WoodenDoor;
import com.example.creational.factory_abstract.profession.Carpenter;
import com.example.creational.factory_abstract.profession.DoorFittingExpert;

public class WoodenDoorFactory implements DoorFactory {
    @Override
    public Door makeDoor() {
        return new WoodenDoor();
    }

    @Override
    public DoorFittingExpert makeFittingExpert() {
        return new Carpenter();
    }
}
