package com.example.behavioral.state.demo_4;

class OffState implements LightState {
    public void switchLight(LightContext context) {
        System.out.println("开灯");
        context.setState(new OnState()); // 状态转换
    }
}
