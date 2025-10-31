package com.example.strucural.decorator.demo_1;
// 香草装饰器，装饰器对象
public class VanillaCoffee implements Coffee{
    protected Coffee coffee;

    public VanillaCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 3;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", 香草";
    }
}
