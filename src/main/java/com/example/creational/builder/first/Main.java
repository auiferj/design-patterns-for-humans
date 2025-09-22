package com.example.creational.builder.first;

public class Main {
    public static void main(String[] args) {
        Burger burger = new Burger.BurgerBuilder(14)
                .addPepperoni()
                .addLettuce()
                .addTomato()
                .build();

        System.out.println(burger);
    }
}
