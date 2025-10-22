package com.example.behavioral.visitor.second;

// 具体的访问者 - 说话行为
class Speak implements AnimalOperation {
    @Override
    public void visitMonkey(Monkey monkey) {
        monkey.shout();
    }

    @Override
    public void visitLion(Lion lion) {
        lion.roar();
    }

    @Override
    public void visitDolphin(Dolphin dolphin) {
        dolphin.speak();
    }
}
