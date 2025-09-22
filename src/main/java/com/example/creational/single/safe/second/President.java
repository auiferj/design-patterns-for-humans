package com.example.creational.single.safe.second;

/**
 * 双重检查锁
 */
public class President {
    private static volatile President instance;

    private President() {
        System.out.println("President is elected!");
    }

    public static President getInstance() {
        if (instance == null) { // 第一次检查
            synchronized (President.class) { // 加锁防止多线程同时创建
                if (instance == null) { // 第二次检查
                    instance = new President();
                }
            }
        }
        return instance;
    }
}
