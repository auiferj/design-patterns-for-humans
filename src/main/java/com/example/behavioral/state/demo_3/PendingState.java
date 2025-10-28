package com.example.behavioral.state.demo_3;

// 具体状态
class PendingState implements OrderState {
    public void process(Order order) {
        System.out.println("处理支付...");
        order.setState(new PaidState()); // 状态改变
    }
}
