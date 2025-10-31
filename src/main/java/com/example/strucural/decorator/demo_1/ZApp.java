package com.example.strucural.decorator.demo_1;

public class ZApp {
    public static void main(String[] args) {
        Coffee someCoffee = new BaseCoffee();
        System.out.println("Cost: " + someCoffee.getCost()); // 10.0
        System.out.println("Description: " + someCoffee.getDescription()); // Simple coffee

        // 添加牛奶
        someCoffee = new MilkCoffee(someCoffee);
        System.out.println("Cost: " + someCoffee.getCost()); // 12.0
        System.out.println("Description: " + someCoffee.getDescription()); // Simple coffee, milk

        // 添加奶油
        someCoffee = new WhipCoffee(someCoffee);
        System.out.println("Cost: " + someCoffee.getCost()); // 17.0
        System.out.println("Description: " + someCoffee.getDescription()); // Simple coffee, milk, whip

        // 添加香草
        someCoffee = new VanillaCoffee(someCoffee);
        System.out.println("Cost: " + someCoffee.getCost()); // 20.0
        System.out.println("Description: " + someCoffee.getDescription()); // Simple coffee, milk, whip, vanilla

        // 也可以直接创建复杂的组合
        System.out.println("\n--- 直接创建复杂咖啡 ---");
        Coffee complexCoffee = new VanillaCoffee(new WhipCoffee(new MilkCoffee(new BaseCoffee())));
        System.out.println("Cost: " + complexCoffee.getCost()); // 20.0
        System.out.println("Description: " + complexCoffee.getDescription()); // Simple coffee, milk, whip, vanilla

        // 创建不同的组合
        System.out.println("\n--- 不同的组合 ---");
        Coffee anotherCoffee = new WhipCoffee(new VanillaCoffee(new BaseCoffee()));
        System.out.println("Cost: " + anotherCoffee.getCost()); // 18.0 (10 + 3 + 5)
        System.out.println("Description: " + anotherCoffee.getDescription()); // Simple coffee, vanilla, whip
    }
}
