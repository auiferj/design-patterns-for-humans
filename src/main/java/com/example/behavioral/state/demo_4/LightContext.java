package com.example.behavioral.state.demo_4;

// 上下文类
class LightContext {
    private LightState currentState;

    public LightContext() {
        this.currentState = new OffState(); // 初始状态
    }

    public void setState(LightState state) {
        this.currentState = state;
    }

    // 客户端调用的方法
    public void pressSwitch() {
        currentState.switchLight(this); // 行为随状态改变
    }
}
