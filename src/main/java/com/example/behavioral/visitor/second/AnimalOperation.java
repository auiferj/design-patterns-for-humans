package com.example.behavioral.visitor.second;

// Visitor 接口
interface AnimalOperation {
    void visitMonkey(Monkey monkey);
    void visitLion(Lion lion);
    void visitDolphin(Dolphin dolphin);
}
