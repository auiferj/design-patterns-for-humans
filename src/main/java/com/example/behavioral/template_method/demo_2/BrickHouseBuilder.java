package com.example.behavioral.template_method.demo_2;

// 砖房建造者
class BrickHouseBuilder extends HouseBuilder {
    protected void prepareBase() {
        System.out.println("准备混凝土地基");
    }

    protected void buildWalls() {
        System.out.println("建造砖墙");
    }

    protected void addRoof() {
        System.out.println("添加瓦片屋顶");
    }

    protected void addOtherFloors() {
        System.out.println("添加砖混二层");
    }
}
