package com.example.strucural.bridge.second;

/**
 * 多维度独立变化的场景
 * 典型场景：图形绘制系统
 */
// 【抽象化类】：形状（定义了“要画什么”这个高层操作）
public interface Shape {
    void draw();// “做什么”的契约
}
