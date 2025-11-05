package com.example.behavioral.visitor.demo_1;

public class VisitorExample {
    public static void main(String[] args) {
        // 创建图形对象
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(3, 4);

        // 添加新功能而不修改图形类
        AreaCalculator areaCalc = new AreaCalculator();
        XMLExporter xmlExporter = new XMLExporter();

        // 应用新操作
        circle.accept(areaCalc);    // 计算面积
        circle.accept(xmlExporter); // 导出XML

        rectangle.accept(areaCalc);    // 计算面积
        rectangle.accept(xmlExporter); // 导出XML
    }
}
