package com.example.strucural.flyweight.demo_1;

// 茶的类型 - 内在状态（可共享）
class TeaType {
    private String name;    // 茶名（红茶、绿茶等）
    private String recipe;  // 配方

    public TeaType(String name, String recipe) {
        this.name = name;
        this.recipe = recipe;
    }

    public void serveTea(String customer) {  // customer是外在状态
        System.out.println("为顾客 " + customer + " 端上 " + name);
    }
}
