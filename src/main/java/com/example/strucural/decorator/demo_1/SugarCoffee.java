package com.example.strucural.decorator.demo_1;
//糖装饰器，装饰器对象
public class SugarCoffee implements Coffee{
    protected Coffee coffee;

    public SugarCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 2;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", 糖";
    }
}
