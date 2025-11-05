package com.example.behavioral.template_method.demo_2;

public class ZApp {
    public static void main(String[] args) {
        System.out.println("建造木屋:");
        HouseBuilder woodHouse = new WoodHouseBuilder();
        woodHouse.buildHouse();

        System.out.println("\n建造砖房:");
        HouseBuilder brickHouse = new BrickHouseBuilder();
        brickHouse.buildHouse();
    }
}
