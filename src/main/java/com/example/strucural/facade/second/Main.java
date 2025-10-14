package com.example.strucural.facade.second;
// 测试类
public class Main {
    public static void main(String[] args) {
        // 创建子系统组件
        Projector projector = new Projector();
        Amplifier amp = new Amplifier();
        BluRayPlayer player = new BluRayPlayer();
        LightController light = new LightController();

        // 创建外观对象
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(projector, amp, player, light);

        // 使用简化的接口
        homeTheater.watchMovie("阿凡达");
        System.out.println("\n--- 享受电影中... ---\n");
        homeTheater.endMovie();

        System.out.println();
        homeTheater.listenToMusic();
    }
}
