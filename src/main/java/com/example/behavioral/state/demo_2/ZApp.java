package com.example.behavioral.state.demo_2;

public class ZApp {
    public static void main(String[] args) {
        // 同样的draw方法，不同的行为！
        Brush brush = new Brush();

        // 初始状态（默认红色）
        brush.draw(10, 20);

        // 切换为蓝色
        brush.setColor(new BlueState());
        brush.draw(30, 40);

        // 切换为绿色
        brush.setColor(new GreenState());
        brush.draw(50, 60);

        // 再切回红色
        brush.setColor(new RedState());
        brush.draw(70, 80);
    }
}
