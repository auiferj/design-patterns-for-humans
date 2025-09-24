package com.example.strucural.decorator.first;
// 基础咖啡实现
public class SimpleCoffee implements Coffee{
    @Override
    public double getCost() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Simple coffee";
    }
}
