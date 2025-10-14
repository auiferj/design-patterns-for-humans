package com.example.strucural.facade.second;

public class HomeTheaterFacade {
    private Projector projector;
    private Amplifier amp;
    private BluRayPlayer player;
    private LightController light;

    // 构造函数中传入所有子系统组件
    public HomeTheaterFacade(Projector projector, Amplifier amp,
                             BluRayPlayer player, LightController light) {
        this.projector = projector;
        this.amp = amp;
        this.player = player;
        this.light = light;
    }

    // 提供一个简化的接口方法 - 观看电影
    public void watchMovie(String movie) {
        System.out.println("=== 准备观看电影 ===");
        projector.on();
        projector.setInput("HDMI");
        amp.on();
        amp.setVolume(5);
        amp.setSurroundSound();
        player.on();
        light.dim(10);
        player.play(movie);
        System.out.println("=== 电影开始 ===");
    }

    // 结束观看电影
    public void endMovie() {
        System.out.println("=== 结束观影 ===");
        player.stop();
        player.eject();
        player.off();
        amp.off();
        projector.off();
        light.on();
        System.out.println("=== 家庭影院已关闭 ===");
    }

    // 只听音乐
    public void listenToMusic() {
        System.out.println("=== 音乐模式 ===");
        amp.on();
        amp.setVolume(3);
        light.setBrightness(50);
        System.out.println("=== 准备播放音乐 ===");
    }
}
