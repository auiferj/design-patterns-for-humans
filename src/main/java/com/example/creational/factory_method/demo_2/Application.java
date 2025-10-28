package com.example.creational.factory_method.demo_2;

import com.example.creational.factory_method.demo_2.creator.Logistics;
import com.example.creational.factory_method.demo_2.creator.RoadLogistics;
import com.example.creational.factory_method.demo_2.creator.SeaLogistics;

public class Application {
    public static void main(String[] args) {
        Logistics logistics = new RoadLogistics();
        logistics.planDelivery(); // 输出：用卡车陆路运输

        logistics = new SeaLogistics();
        logistics.planDelivery(); // 输出：用轮船海运运输
    }
}
