package com.example.behavioral.visitor.second;

public class VisitorPatternExample {
    public static void main(String[] args) {
        // 创建动物对象
        Monkey monkey = new Monkey();
        Lion lion = new Lion();
        Dolphin dolphin = new Dolphin();

        // 创建访问者对象
        Speak speak = new Speak();
        Jump jump = new Jump();

        System.out.println("=== 动物说话行为 ===");
        monkey.accept(speak);    // Ooh oo aa aa!
        lion.accept(speak);      // Roaaar!
        dolphin.accept(speak);   // Tuut tuttu tuutt!

        System.out.println("\n=== 动物跳跃行为 ===");
        monkey.accept(jump);     // Jumped 20 feet high! on to the tree!
        lion.accept(jump);       // Jumped 7 feet! Back on the ground!
        dolphin.accept(jump);    // Walked on water a little and disappeared

        System.out.println("\n=== 混合行为演示 ===");
        monkey.accept(speak);    // Ooh oo aa aa!
        monkey.accept(jump);     // Jumped 20 feet high! on to the tree!

        lion.accept(speak);      // Roaaar!
        lion.accept(jump);       // Jumped 7 feet! Back on the ground!

        dolphin.accept(speak);   // Tuut tuttu tuutt!
        dolphin.accept(jump);    // Walked on water a little and disappeared

        // 演示添加新操作的便利性
        System.out.println("\n=== 添加新操作：喂食行为 ===");
        Feed feed = new Feed();
        monkey.accept(feed);
        lion.accept(feed);
        dolphin.accept(feed);
    }
}
