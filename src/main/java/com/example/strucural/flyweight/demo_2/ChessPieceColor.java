package com.example.strucural.flyweight.demo_2;

// 享元对象 - 棋子颜色（内部状态）
public class ChessPieceColor {
    private String color;  // 内部状态 - 共享

    public ChessPieceColor(String color) {
        this.color = color;
        System.out.println("创建棋子颜色：" + color);
    }

    public void place(int x, int y) {  // 外部状态 - 位置
        System.out.println("在(" + x + "," + y + ")放置" + color + "棋子");
    }
}
