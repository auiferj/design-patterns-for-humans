package com.example.factory_abstract.factory;

import com.example.factory_abstract.category.Door;
import com.example.factory_abstract.category.WoodenDoor;
import com.example.factory_abstract.profession.Carpenter;
import com.example.factory_abstract.profession.DoorFittingExpert;

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
