package com.example.behavioral.visitor.second;

// 具体的动物类
class Monkey implements Animal {
    public void shout() {
        System.out.println("Ooh oo aa aa!");
    }

    @Override
    public void accept(AnimalOperation operation) {
        operation.visitMonkey(this);
    }
}
