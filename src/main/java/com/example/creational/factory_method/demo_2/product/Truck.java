package com.example.creational.factory_method.demo_2.product;
/**
 * 具体产品A
 */
public class Truck implements Transport{
    @Override
    public void deliver() {
        System.out.println("用卡车陆路运输");
    }
}
