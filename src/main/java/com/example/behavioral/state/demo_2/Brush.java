package com.example.behavioral.state.demo_2;

// 上下文 - 画笔工具
class Brush {
    private ColorState currentColor;

    public void setColor(ColorState color) {
        this.currentColor = color;
    }

    public void draw(int x, int y) {
        currentColor.draw(this, x, y); // 行为取决于当前状态
    }
}
