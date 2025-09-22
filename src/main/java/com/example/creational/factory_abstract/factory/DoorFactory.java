package com.example.creational.factory_abstract.factory;

import com.example.creational.factory_abstract.category.Door;
import com.example.creational.factory_abstract.profession.DoorFittingExpert;

public interface DoorFactory {
    Door makeDoor();
    DoorFittingExpert makeFittingExpert();
}
