package com.example.behavioral.state.demo_2;

// 上下文 - 画笔工具
class Brush {
    private ColorState currentColor;

    public Brush() {
        // 默认颜色
        this.currentColor = new RedState();
    }

    // 设置颜色状态
    public void setColor(ColorState color) {
        this.currentColor = color;
        System.out.println("🎨 画笔切换为：" + color.getColorName());
    }

    // 绘制方法，行为取决于当前状态
    public void draw(int x, int y) {
        currentColor.draw(this, x, y); // 行为取决于当前状态
    }
}
