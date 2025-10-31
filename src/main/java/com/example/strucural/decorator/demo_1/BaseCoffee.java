package com.example.strucural.decorator.demo_1;
// 基础咖啡实现，被装饰对象
public class BaseCoffee implements Coffee{
    @Override
    public double getCost() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "基本咖啡";
    }
}
