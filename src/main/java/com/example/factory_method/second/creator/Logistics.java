package com.example.factory_method.second.creator;

import com.example.factory_method.second.product.Transport;

public abstract class Logistics {
    // 工厂方法
    public abstract Transport createTransport();

    public void planDelivery() {
        Transport transport = this.createTransport(); // 核心：让子类决定创建什么对象
        transport.deliver();
    }
}
