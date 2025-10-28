package com.example.behavioral.state.demo_2;

// 具体状态
class RedState implements ColorState {
    public void draw(Brush brush, int x, int y) {
        System.out.println("在位置(" + x + "," + y + ")绘制红色像素");
        // 实际绘制红色图形的代码
    }
}
