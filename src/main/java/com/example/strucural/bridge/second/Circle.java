package com.example.strucural.bridge.second;

public class Circle implements Shape {
    protected Color color;  // 桥接的颜色维度

    public Circle(Color color) {
        this.color = color;
    }
    @Override
    public void draw() {
        // 这是高层的业务逻辑：“画一个圆形”这个动作...
        System.out.println("画一个圆形，然后");
        // ... 委派给底层的“实现”去完成填充工作。
        System.out.println(color.applyColor());
    }
}
