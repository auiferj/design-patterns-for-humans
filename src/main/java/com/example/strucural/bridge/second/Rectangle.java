package com.example.strucural.bridge.second;

public class Rectangle implements Shape{
    protected Color color;  // 桥接的颜色维度

    public Rectangle(Color color) {
        this.color = color;
    }
    @Override
    public void draw() {
        System.out.println(color.applyColor() + "画矩形");
    }
}
