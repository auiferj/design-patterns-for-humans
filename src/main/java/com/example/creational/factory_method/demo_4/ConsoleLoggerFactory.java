package com.example.creational.factory_method.demo_4;

/**
 * 具体工厂B - 负责创建控制台日志
 * 我们为每种记录器创建对应的具体工厂
 */
public class ConsoleLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        // 创建ConsoleLogger的逻辑
        return new ConsoleLogger();
    }
}
