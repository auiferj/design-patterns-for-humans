package com.example.strucural.decorator.first;
// 奶油装饰器
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
        return coffee.getDescription() + ", whip";
    }
}
