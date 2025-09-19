package com.example.factory_method.first;

import com.example.factory_method.first.manager.DevelopmentManager;
import com.example.factory_method.first.manager.HiringManager;
import com.example.factory_method.first.manager.MarketingManager;

/**
 * 工厂方法模式
 */
public class FactoryMethodExample {
    public static void main(String[] args) {
        HiringManager devManager = new DevelopmentManager();
        devManager.takeInterview(); // Output: Asking about design patterns!

        HiringManager marketingManager = new MarketingManager();
        marketingManager.takeInterview(); // Output: Asking about community building
    }
}
