package com.example.creational.single;

public class President {
    // 静态变量保存唯一的实例
    private static President instance;

    // 私有构造函数：防止外部通过 new President() 创建实例
    private President() {
        System.out.println("President is elected! (Instance created)");
    }

    // 全局访问点：获取唯一实例
    public static President getInstance() {
        if (instance == null) {
            instance = new President(); // 第一次调用时创建
        }
        return instance;
    }

    // 总统的行为方法
    public void makeSpeech() {
        System.out.println("Addressing the nation...");
    }

    public void signLaw(String lawName) {
        System.out.println("Signing into law: " + lawName);
    }
}
