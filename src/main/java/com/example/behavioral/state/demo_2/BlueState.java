package com.example.behavioral.state.demo_2;

class BlueState implements ColorState {
    public void draw(Brush brush, int x, int y) {
        // 实际绘制蓝色图形的代码
        System.out.println("在位置(" + x + "," + y + ")绘制蓝色像素");
    }
}
