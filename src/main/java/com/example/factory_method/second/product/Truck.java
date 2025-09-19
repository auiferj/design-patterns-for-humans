package com.example.factory_method.second.product;
/**
 * 具体产品A
 */
public class Truck implements Transport{
    @Override
    public void deliver() {
        System.out.println("用卡车陆路运输");
    }
}
