package com.example.strucural.flyweight.demo_1;

public class Main {
    public static void main(String[] args) {
        TeaShop shop = new TeaShop();

        // 多个顾客都点红茶 - 但只煮一次
        TeaType blackTea1 = shop.getTeaType("红茶"); // 煮了一壶新的: 红茶
        blackTea1.serveTea("顾客A"); // 为顾客A 端上 红茶

        TeaType blackTea2 = shop.getTeaType("红茶"); // 不再重新煮，直接使用现有的
        blackTea2.serveTea("顾客B"); // 为顾客B 端上 红茶

        TeaType greenTea = shop.getTeaType("绿茶"); // 煮了一壶新的: 绿茶
        greenTea.serveTea("顾客C"); // 为顾客C 端上 绿茶
    }
}
