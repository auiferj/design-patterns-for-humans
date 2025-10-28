package com.example.creational.factory_method.demo_2.creator;

import com.example.creational.factory_method.demo_2.product.Transport;
import com.example.creational.factory_method.demo_2.product.Truck;

/**
 * 具体创建者A
 */
public class RoadLogistics extends Logistics{
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
