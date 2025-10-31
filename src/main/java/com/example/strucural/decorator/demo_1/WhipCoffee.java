package com.example.strucural.decorator.demo_1;
// 奶油装饰器，装饰器对象
public class WhipCoffee implements Coffee{
    protected Coffee coffee;

    public WhipCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 5;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", 奶油";
    }
}
