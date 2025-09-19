package com.example.factory_abstract.factory;

import com.example.factory_abstract.category.Door;
import com.example.factory_abstract.category.IronDoor;
import com.example.factory_abstract.profession.DoorFittingExpert;
import com.example.factory_abstract.profession.Welder;

public class IronDoorFactory implements DoorFactory {
    @Override
    public Door makeDoor() {
        return new IronDoor();
    }

    @Override
    public DoorFittingExpert makeFittingExpert() {
        return new Welder();
    }
}
