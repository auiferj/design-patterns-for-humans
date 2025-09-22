package com.example.creational.single.safe.first;

/**
 * 急切初始化
 */
public class President {
    // 程序启动时就创建实例（总统就职）
    private static final President instance = new President();

    private President() {
        System.out.println("President is elected on startup!");
    }

    public static President getInstance() {
        return instance; // 直接返回已创建的实例
    }
}
