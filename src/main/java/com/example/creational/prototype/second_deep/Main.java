package com.example.creational.prototype.second_deep;

public class Main {
    /**
     * 浅拷贝的问题：
     * @param args
     */
    public static void main(String[] args) {
        Sheep original = new Sheep("Dolly");
        original.addTrait("Friendly");

        Sheep cloned = original.clone();
        cloned.addTrait("Playful");

        System.out.println(original.getTraits()); // 输出: [Friendly, Playful]
        // 糟糕！原始对象也被修改了，因为共享同一个List对象
    }
}
