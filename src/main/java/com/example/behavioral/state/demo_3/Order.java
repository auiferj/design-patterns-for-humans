package com.example.behavioral.state.demo_3;

// 订单类 - 行为随状态改变
class Order {
    private OrderState state;

    public Order() {
        this.state = new PendingState(); // 初始状态
    }

    public void setState(OrderState state) {
        this.state = state; // 状态改变！
    }

    public void process() {
        state.process(this); // 行为随状态改变！
    }
}
