package com.example.creational.factory_method.second.creator;

import com.example.creational.factory_method.second.product.Transport;
import com.example.creational.factory_method.second.product.Truck;

/**
 * 具体创建者A
 */
public class RoadLogistics extends Logistics{
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
