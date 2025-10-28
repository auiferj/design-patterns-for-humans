package com.example.creational.factory_abstract;

import com.example.creational.factory_abstract.category.Door;
import com.example.creational.factory_abstract.factory.DoorFactory;
import com.example.creational.factory_abstract.factory.IronDoorFactory;
import com.example.creational.factory_abstract.factory.WoodenDoorFactory;
import com.example.creational.factory_abstract.profession.DoorFittingExpert;

/**
 * 抽象工厂模式
 */
public class ZApp {
    public static void main(String[] args) {
        // 木门工厂
        DoorFactory woodenFactory = new WoodenDoorFactory();

        Door woodenDoor = woodenFactory.makeDoor();
        DoorFittingExpert woodenExpert = woodenFactory.makeFittingExpert();

        woodenDoor.getDescription();  // Output: I am a wooden door
        woodenExpert.getDescription(); // Output: I can only fit wooden doors

        System.out.println("---------------------");

        // 铁门工厂
        DoorFactory ironFactory = new IronDoorFactory();

        Door ironDoor = ironFactory.makeDoor();
        DoorFittingExpert ironExpert = ironFactory.makeFittingExpert();

        ironDoor.getDescription();  // Output: I am an iron door
        ironExpert.getDescription(); // Output: I can only fit iron doors
    }
}
