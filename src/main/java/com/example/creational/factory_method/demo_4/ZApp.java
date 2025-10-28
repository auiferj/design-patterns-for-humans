package com.example.creational.factory_method.demo_4;

public class ZApp {
    public static void main(String[] args) {
        // 场景1：需要文件日志
        LoggerFactory factory = new FileLoggerFactory();
        factory.logMessage("这是一个用户登录的日志"); // 输出：将日志写入文件：这是一个用户登录的日志

        // 场景2：需要控制台日志（只需换一个工厂即可）
        LoggerFactory factory2 = new ConsoleLoggerFactory();
        factory2.logMessage("这是一个调试信息"); // 输出：控制台日志：这是一个调试信息

        /**
         * 解耦：
         * 最大的好处！ 客户端代码（Client）只依赖于抽象的 LoggerFactory 和 Logger，
         * 完全不知道 FileLogger 或 ConsoleLogger 的存在。
         * 这使得增加新的日志类型（比如 NetworkLogger）时，客户端代码完全不需要修改。
         * 客户端不需要修改，是指增加新产品时，只需要：LoggerFactory factory = new NetworkFactory();，不需要修改原有的代码。
         */
    }
}
