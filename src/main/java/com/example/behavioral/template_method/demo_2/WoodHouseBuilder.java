package com.example.behavioral.template_method.demo_2;

// 木屋建造者
class WoodHouseBuilder extends HouseBuilder {
    protected void prepareBase() {
        System.out.println("准备木质地基");
    }

    protected void buildWalls() {
        System.out.println("建造木墙");
    }

    protected void addRoof() {
        System.out.println("添加木屋顶");
    }

    protected void addOtherFloors() {
        System.out.println("添加木质二层");
    }
}
