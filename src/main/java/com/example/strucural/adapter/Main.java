package com.example.strucural.adapter;

public class Main {
    public static void main(String[] args) {
        Hunter hunter = new Hunter();

        // 狩猎熟悉的非洲狮（直接使用，无需适配）
        hunter.hunt(new AfricanLion());

        // 狩猎野生狗（通过适配器）
        WildDog dog = new WildDog();
        Lion dogAdapter = new WildDogAdapter(dog); // 创建适配器
        hunter.hunt(dogAdapter); // 成功！猎人现在可以“理解”野生狗了
    }
}
