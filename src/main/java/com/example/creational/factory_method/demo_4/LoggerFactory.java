package com.example.creational.factory_method.demo_4;

/**
 * 抽象工厂
 * 我们创建一个“工厂”的抽象基类。它声明了创建Logger的工厂方法，但同时它可能包含一些不依赖于具体Logger类型的核心业务逻辑。
 */
public abstract class LoggerFactory {
    // 这就是“工厂方法”，它由子类去实现
    public abstract Logger createLogger();

    // 这是一个可能存在的核心业务的方法，它依赖于产品接口，而不是具体产品
    public void logMessage(String message) {
        // 1. 创建Logger（具体是File还是Console，由子类决定）
        Logger logger = this.createLogger();
        // 2. 使用Logger记录日志
        logger.log(message);
        // 可能还有其他公共逻辑，比如格式化、过滤等
    }
}
