package com.example.behavioral.chain_of_responsibility.first;

// 测试类
public class ZApp {
    public static void main(String[] args) {
        // 准备责任链：bank -> paypal -> bitcoin
        // 优先级：Bank第一，如果不能支付则用PayPal，再不能则用Bitcoin

        Bank bank = new Bank(100);          // Bank with balance 100
        Paypal paypal = new Paypal(200);    // Paypal with balance 200
        Bitcoin bitcoin = new Bitcoin(300); // Bitcoin with balance 300

        bank.setNext(paypal);
        paypal.setNext(bitcoin);

        // 尝试使用第一优先级的银行支付，（参照second，259相当于一个命令对象）
        System.out.println("Trying to pay 259:");
        bank.pay(259);

        System.out.println("\n--- Another test ---");
        // 另一个测试：支付150，（参照second，150相当于一个命令对象）
        System.out.println("Trying to pay 150:");
        bank.pay(150);

        System.out.println("\n--- Another test ---");
        // 另一个测试：支付50，（参照second，50相当于一个命令对象）
        System.out.println("Trying to pay 50:");
        bank.pay(50);

        System.out.println("\n--- Another test ---");
        // 测试无法支付的情况，（参照second，400相当于一个命令对象）
        System.out.println("Trying to pay 400:");
        try {
            bank.pay(400);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
