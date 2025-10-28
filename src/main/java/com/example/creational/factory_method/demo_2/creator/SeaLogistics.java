package com.example.creational.factory_method.demo_2.creator;

import com.example.creational.factory_method.demo_2.product.Ship;
import com.example.creational.factory_method.demo_2.product.Transport;

/**
 * 具体创建者B
 */
public class SeaLogistics extends Logistics{
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
