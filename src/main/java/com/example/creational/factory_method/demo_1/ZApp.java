package com.example.creational.factory_method.demo_1;

import com.example.creational.factory_method.demo_1.manager.DevelopmentManager;
import com.example.creational.factory_method.demo_1.manager.HiringManager;
import com.example.creational.factory_method.demo_1.manager.MarketingManager;

/**
 * 工厂方法模式
 */
public class ZApp {
    public static void main(String[] args) {
        HiringManager devManager = new DevelopmentManager();
        devManager.takeInterview(); // Output: Asking about design patterns!

        HiringManager marketingManager = new MarketingManager();
        marketingManager.takeInterview(); // Output: Asking about community building
    }
}
