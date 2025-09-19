package com.example.factory_method.second.creator;

import com.example.factory_method.second.product.Ship;
import com.example.factory_method.second.product.Transport;

/**
 * 具体创建者B
 */
public class SeaLogistics extends Logistics{
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
