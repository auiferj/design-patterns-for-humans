package com.example.creational.single;

public class Country {
    public static void main(String[] args) {
        // 尝试创建多个"总统" - 但只会有一个真正的总统
        President president1 = President.getInstance();
        President president2 = President.getInstance();

        president1.makeSpeech(); // Addressing the nation...
        president2.signLaw("Education Reform Act"); // Signing into law: Education Reform Act

        // 验证确实是同一个总统
        System.out.println("Same president? " + (president1 == president2)); // true
        System.out.println("President1 hash: " + president1.hashCode());
        System.out.println("President2 hash: " + president2.hashCode());
    }
}
