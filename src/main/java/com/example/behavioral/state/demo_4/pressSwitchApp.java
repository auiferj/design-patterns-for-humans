package com.example.behavioral.state.demo_4;

public class pressSwitchApp {
    public static void main(String[] args) {
        LightContext light = new LightContext();

        light.pressSwitch(); // 输出: "开灯" (OffState → OnState)
        light.pressSwitch(); // 输出: "关灯" (OnState → OffState)
        light.pressSwitch(); // 输出: "开灯" (OffState → OnState)

        // 同样的pressSwitch()，不同的行为！
    }
}
