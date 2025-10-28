package com.example.behavioral.template_method.demo_2;

// 抽象类定义算法骨架
abstract class HouseBuilder {

    // 模板方法 - 定义不变的步骤顺序
    public final void buildHouse() {
        prepareBase();
        buildWalls();
        addRoof();
        addOtherFloors();
    }

    // 抽象方法 - 由子类实现具体步骤
    protected abstract void prepareBase();
    protected abstract void buildWalls();
    protected abstract void addRoof();
    protected abstract void addOtherFloors();
}
