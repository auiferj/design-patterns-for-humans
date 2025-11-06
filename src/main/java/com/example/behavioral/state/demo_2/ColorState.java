package com.example.behavioral.state.demo_2;

// 状态接口：定义画笔颜色状态的通用行为
interface ColorState {
    void draw(Brush brush, int x, int y);

    String getColorName(); // 新增：方便显示当前状态名
}
