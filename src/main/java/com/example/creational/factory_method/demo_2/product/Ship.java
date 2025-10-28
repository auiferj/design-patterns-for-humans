package com.example.creational.factory_method.demo_2.product;

/**
 * 具体产品B
 */
public class Ship implements Transport{
    @Override
    public void deliver() {
        System.out.println("用轮船海运运输");
    }
}
