package com.example.behavioral.chain_of_responsibility.second;

// 4. 使用示例
public class ZApp {
    public static void main(String[] args) {
        // 构建处理对象链
        Processor login = new LoginProcessor();
        Processor payment = new PaymentProcessor();
        Processor logout = new LogoutProcessor();

        login.setNext(payment);
        payment.setNext(logout);

        // 创建命令对象
        Command loginCmd = new Command("LOGIN", "用户登录");
        Command paymentCmd = new Command("PAYMENT", "支付订单");
        Command unknownCmd = new Command("UNKNOWN", "未知命令");

        // 处理命令/发送请求
        login.process(loginCmd);     // 登录处理器处理
        login.process(paymentCmd);   // 支付处理器处理
        login.process(unknownCmd);   // 没有处理器能处理
    }
}
