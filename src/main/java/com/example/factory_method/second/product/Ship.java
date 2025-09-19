package com.example.factory_method.second.product;

/**
 * 具体产品B
 */
public class Ship implements Transport{
    @Override
    public void deliver() {
        System.out.println("用轮船海运运输");
    }
}
