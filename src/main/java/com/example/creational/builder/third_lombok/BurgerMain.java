package com.example.creational.builder.third_lombok;

public class BurgerMain {
    /**
     * Lombok 的 @Builder 注解正是实现了建造者模式。
     * @param args
     */
    public static void main(String[] args) {
        // 链式调用创建对象
        Burger burger = Burger.builder()
                .size(14)
                .cheese(true)
                .pepperoni(true)
                .lettuce(true)
                .tomato(false)
                .build();

        System.out.println(burger);
    }
}
