package com.example.strucural.flyweight.demo_2;
// 客户端调用
public class ZApp {
    public static void main(String[] args) {
        System.out.println("=== 围棋享元模式示例 ===\n");

        // 获取共享的颜色对象
        ChessPieceColor black = ColorFactory.getColor("黑色");
        ChessPieceColor white = ColorFactory.getColor("白色");

        // 在棋盘上放置棋子（相同颜色共享同一个对象）
        System.out.println("\n放置棋子:");
        black.place(1, 1);
        black.place(2, 3);
        black.place(4, 5);  // 共享黑色棋子对象

        white.place(1, 2);
        white.place(3, 4);  // 共享白色棋子对象

        black.place(5, 6);  // 再次共享黑色棋子对象

        System.out.println("\n=== 结果分析 ===");
        System.out.println("总共放置了: 6 个棋子");
        System.out.println("实际创建的颜色对象: " + ColorFactory.getColorCount() + " 个");
        System.out.println("节省了 " + (6 - ColorFactory.getColorCount()) + " 个对象的内存");

        /**
         * 我的理解：
         * 最后还是要调用享元对象的方法，但是在这个方法中，内部状态是享元对象内部的，同时外部状态通过参数传进来。
         * 这样，2享元对象，不用重复创建占用内存。可以重复使用放在不同的坐标上。
         */
    }
}
