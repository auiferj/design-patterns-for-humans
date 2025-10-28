package com.example.behavioral.state.demo_3;

class PaidState implements OrderState {
    public void process(Order order) {
        System.out.println("发货...");
        order.setState(new ShippedState()); // 状态改变
    }
}
