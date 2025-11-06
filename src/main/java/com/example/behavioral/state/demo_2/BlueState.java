package com.example.behavioral.state.demo_2;

class BlueState implements ColorState {
    // 上下文Brush对象会把请求委托给状态对象，所以状态也有上下文Brush对象的动作
    public void draw(Brush brush, int x, int y) {
        // 实际绘制蓝色图形的代码
        System.out.println("🟦 使用蓝色画笔，在位置(" + x + "," + y + ")绘制蓝色像素");
    }

    public String getColorName() {
        return "蓝色";
    }
}
