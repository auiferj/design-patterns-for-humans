package com.example.strucural.decorator.demo_1;
// 牛奶装饰器，装饰器对象
public class MilkCoffee implements Coffee{
    protected Coffee coffee;

    public MilkCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 2;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", 牛奶";
    }
}
