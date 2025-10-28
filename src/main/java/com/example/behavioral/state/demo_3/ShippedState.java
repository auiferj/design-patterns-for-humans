package com.example.behavioral.state.demo_3;

class ShippedState implements OrderState {
    public void process(Order order) {
        System.out.println("订单已完成，无法再处理");
    }
}
