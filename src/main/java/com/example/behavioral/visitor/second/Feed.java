package com.example.behavioral.visitor.second;

// 新添加的访问者 - 喂食行为（展示扩展性）
class Feed implements AnimalOperation {
    @Override
    public void visitMonkey(Monkey monkey) {
        System.out.println("Fed the monkey with bananas!");
    }

    @Override
    public void visitLion(Lion lion) {
        System.out.println("Fed the lion with meat!");
    }

    @Override
    public void visitDolphin(Dolphin dolphin) {
        System.out.println("Fed the dolphin with fish!");
    }
}
