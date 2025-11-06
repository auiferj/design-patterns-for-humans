package com.example.behavioral.state.demo_2;

// 具体状态：绿色
class GreenState implements ColorState {
    // 上下文Brush对象会把请求委托给状态对象，所以状态也有上下文Brush对象的动作
    public void draw(Brush brush, int x, int y) {
        System.out.println("🟩 使用绿色画笔，在位置(" + x + "," + y + ")绘制图形");
    }

    public String getColorName() {
        return "绿色";
    }
}
