package com.example.behavioral.state.demo_4;

// 具体状态类
class OnState implements LightState {
    public void switchLight(LightContext context) {
        System.out.println("关灯");
        context.setState(new OffState()); // 状态转换
    }
}
