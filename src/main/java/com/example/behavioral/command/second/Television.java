package com.example.behavioral.command.second;

// Receiver（接收者） - 电视机
class Television {
    public void turnOn() {
        System.out.println("电视机：开机");
    }

    public void turnOff() {
        System.out.println("电视机：关机");
    }

    public void changeChannel(int channel) {
        System.out.println("电视机：切换到频道 " + channel);
    }

    public void adjustVolume(int level) {
        System.out.println("电视机：调整音量到 " + level);
    }
}
