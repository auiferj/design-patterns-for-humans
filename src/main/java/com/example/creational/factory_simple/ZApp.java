package com.example.creational.factory_simple;

/**
 * 简单工厂
 */
public class ZApp {
    public static void main(String[] args) {
        // Make me a door of 100x200
        Door door = DoorFactory.createDoor(DoorType.WOODEN ,100.0f, 200.0f);

        System.out.println("Width: " + door.getWidth());
        System.out.println("Height: " + door.getHeight());

        // Make me a door of 50x100
        Door door2 = DoorFactory.createDoor(DoorType.GLASS,50.0f, 100.0f);

        System.out.println("Width: " + door2.getWidth());
        System.out.println("Height: " + door2.getHeight());
    }
}
