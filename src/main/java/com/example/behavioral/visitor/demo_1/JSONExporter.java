package com.example.behavioral.visitor.demo_1;

// 想要添加JSON导出功能？只需：
class JSONExporter implements Visitor {
    public void visit(Circle circle) { /* JSON逻辑 */ }
    public void visit(Rectangle rectangle) { /* JSON逻辑 */ }
}
