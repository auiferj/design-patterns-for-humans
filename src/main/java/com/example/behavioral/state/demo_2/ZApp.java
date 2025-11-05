package com.example.behavioral.state.demo_2;

public class ZApp {
    public static void main(String[] args) {
        // 同样的draw方法，不同的行为！
        Brush brush = new Brush();

        // 选择红色状态
        brush.setColor(new RedState());
        brush.draw(10, 20); // 输出: 在位置(10,20)绘制红色像素

        // 切换到蓝色状态
        brush.setColor(new BlueState());
        brush.draw(30, 40); // 输出: 在位置(30,40)绘制蓝色像素
    }
}
