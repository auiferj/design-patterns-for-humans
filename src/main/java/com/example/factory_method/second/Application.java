package com.example.factory_method.second;

import com.example.factory_method.second.creator.Logistics;
import com.example.factory_method.second.creator.RoadLogistics;
import com.example.factory_method.second.creator.SeaLogistics;

public class Application {
    public static void main(String[] args) {
        Logistics logistics = new RoadLogistics();
        logistics.planDelivery(); // 输出：用卡车陆路运输

        logistics = new SeaLogistics();
        logistics.planDelivery(); // 输出：用轮船海运运输
    }
}
