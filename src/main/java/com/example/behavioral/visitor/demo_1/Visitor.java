package com.example.behavioral.visitor.demo_1;

// 2. 通过访问者添加新操作
interface Visitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}
