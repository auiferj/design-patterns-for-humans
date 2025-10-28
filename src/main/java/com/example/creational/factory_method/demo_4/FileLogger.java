package com.example.creational.factory_method.demo_4;

/**
 * 具体产品A
 * 我们创建两个具体的记录器类。
 */
public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        // 将日志写入文件的逻辑
        System.out.println("将日志写入文件：" + message);
    }
}
