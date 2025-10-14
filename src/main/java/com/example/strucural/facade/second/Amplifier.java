package com.example.strucural.facade.second;

// 功放类
public class Amplifier {
    public void on() {
        System.out.println("Amplifier: 打开功放");
    }

    public void off() {
        System.out.println("Amplifier: 关闭功放");
    }

    public void setVolume(int level) {
        System.out.println("Amplifier: 设置音量为 " + level);
    }

    public void setSurroundSound() {
        System.out.println("Amplifier: 设置环绕声模式");
    }
}
