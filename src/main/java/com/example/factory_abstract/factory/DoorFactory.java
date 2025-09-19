package com.example.factory_abstract.factory;

import com.example.factory_abstract.category.Door;
import com.example.factory_abstract.profession.DoorFittingExpert;

public interface DoorFactory {
    Door makeDoor();
    DoorFittingExpert makeFittingExpert();
}
