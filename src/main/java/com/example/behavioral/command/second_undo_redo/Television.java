package com.example.behavioral.command.second_undo_redo;

// Receiver（接收者） - 电视机
class Television {
    private boolean isOn = false;
    private int currentChannel = 1;
    private int currentVolume = 10;
    private int previousChannel = 1;
    private int previousVolume = 10;

    public void turnOn() {
        isOn = true;
        System.out.println("电视机：开机，频道 " + currentChannel + "，音量 " + currentVolume);
    }

    public void turnOff() {
        isOn = false;
        System.out.println("电视机：关机");
    }

    public void changeChannel(int channel) {
        previousChannel = currentChannel;
        currentChannel = channel;
        if (isOn) {
            System.out.println("电视机：切换到频道 " + channel);
        }
    }

    public void adjustVolume(int level) {
        previousVolume = currentVolume;
        currentVolume = level;
        if (isOn) {
            System.out.println("电视机：调整音量到 " + level);
        }
    }

    // 撤销相关的方法
    public void revertChannel() {
        int temp = currentChannel;
        currentChannel = previousChannel;
        previousChannel = temp;
        if (isOn) {
            System.out.println("电视机：切回频道 " + currentChannel);
        }
    }

    public void revertVolume() {
        int temp = currentVolume;
        currentVolume = previousVolume;
        previousVolume = temp;
        if (isOn) {
            System.out.println("电视机：恢复音量到 " + currentVolume);
        }
    }

    public int getCurrentChannel() { return currentChannel; }
    public int getCurrentVolume() { return currentVolume; }
}
