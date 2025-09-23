package com.example.strucural.bridge.second;

/**
 * 多维度独立变化的场景
 * 典型场景：图形绘制系统
 * 实际应用：UI组件库（按钮、输入框等）需要支持多种样式主题
 */
public class Main {
    public static void main(String[] args) {
        RedColor redColor = new RedColor();
        BlueColor blueColor = new BlueColor();

        Circle red_circle = new Circle(redColor);
        red_circle.draw();
        Circle blue_circle = new Circle(blueColor);
        blue_circle.draw();

        Rectangle red_rectangle = new Rectangle(redColor);
        red_rectangle.draw();
        Rectangle blue_rectangle = new Rectangle(blueColor);
        blue_rectangle.draw();
    }
}
