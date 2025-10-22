package com.example.behavioral.visitor.first;

// 1. 不修改原有图形类
class Circle {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    // 只添加这个接受访问者的方法
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
