package com.example.strucural.facade.second;

// 灯光控制器类
public class LightController {
    public void dim(int level) {
        System.out.println("LightController: 调暗灯光至 " + level + "%");
    }

    public void on() {
        System.out.println("LightController: 打开灯光");
    }

    public void off() {
        System.out.println("LightController: 关闭灯光");
    }

    public void setBrightness(int level) {
        System.out.println("LightController: 设置亮度为 " + level + "%");
    }
}
