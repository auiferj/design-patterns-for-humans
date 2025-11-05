package com.example.behavioral.visitor.demo_1;

// XML导出器 - 另一个新功能，不修改原有类
class XMLExporter implements Visitor {
    public void visit(Circle circle) {
        // 导出圆形为XML
    }

    public void visit(Rectangle rectangle) {
        // 导出矩形为XML
    }
}
