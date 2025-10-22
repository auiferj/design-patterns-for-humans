package com.example.behavioral.visitor.first;

// 面积计算器 - 新增功能，不修改原有类
class AreaCalculator implements Visitor {
    public void visit(Circle circle) {
        // 计算圆形面积
        double area = Math.PI * circle.getRadius() * circle.getRadius();
    }

    public void visit(Rectangle rectangle) {
        // 计算矩形面积
        double area = rectangle.getWidth() * rectangle.getHeight();
    }
}
