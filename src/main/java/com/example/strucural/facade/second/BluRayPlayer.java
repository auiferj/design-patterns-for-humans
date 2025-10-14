package com.example.strucural.facade.second;

// 蓝光播放器类
public class BluRayPlayer {
    public void on() {
        System.out.println("BluRayPlayer: 打开蓝光播放器");
    }

    public void off() {
        System.out.println("BluRayPlayer: 关闭蓝光播放器");
    }

    public void play(String movie) {
        System.out.println("BluRayPlayer: 播放电影 \"" + movie + "\"");
    }

    public void stop() {
        System.out.println("BluRayPlayer: 停止播放");
    }

    public void eject() {
        System.out.println("BluRayPlayer: 弹出光盘");
    }
}
