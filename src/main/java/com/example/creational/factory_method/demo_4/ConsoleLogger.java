package com.example.creational.factory_method.demo_4;

/**
 * 具体产品B
 * 我们创建两个具体的记录器类。
 */
public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        // 将日志输出到控制台的逻辑
        System.out.println("控制台日志：" + message);
    }
}
