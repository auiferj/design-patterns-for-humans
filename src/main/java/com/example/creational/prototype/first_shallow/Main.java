package com.example.creational.prototype.first_shallow;

public class Main {
    public static void main(String[] args) {
        Sheep original = new Sheep("Jolly");
        System.out.println(original.getName()); // Jolly
        System.out.println(original.getCategory()); // Mountain Sheep

        // Clone and modify what is required
        Sheep cloned = original.clone();
        cloned.setName("Dolly");
        System.out.println(cloned.getName()); // Dolly
        System.out.println(cloned.getCategory()); // Mountain Sheep

        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);
    }
}
