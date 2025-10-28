package com.example.behavioral.state.demo_3;

public class ProcessApp {
    public static void main(String[] args) {
        Order order = new Order(); // 初始状态：PendingState

        order.process(); // 输出: "处理支付..." → 状态变为PaidState
        order.process(); // 输出: "发货..." → 状态变为ShippedState
        order.process(); // 输出: "订单已完成，无法再处理"

        // 同样的process()方法，三次调用产生三种不同行为！
    }
}
