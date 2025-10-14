package com.example.strucural.facade.second;
// 投影仪类
public class Projector {
    public void on() {
        System.out.println("Projector: 打开投影仪");
    }

    public void off() {
        System.out.println("Projector: 关闭投影仪");
    }

    public void setInput(String input) {
        System.out.println("Projector: 设置输入源为 " + input);
    }

    public void setMode(String mode) {
        System.out.println("Projector: 设置模式为 " + mode);
    }
}
