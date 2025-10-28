package com.example.creational.factory_method.demo_4;

/**
 * 具体工厂A - 负责创建文件日志
 * 我们为每种记录器创建对应的具体工厂
 */
public class FileLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        // 在这里完成创建FileLogger所需的复杂逻辑
        // 比如初始化文件路径、设置缓冲区等
        return new FileLogger();
    }
}