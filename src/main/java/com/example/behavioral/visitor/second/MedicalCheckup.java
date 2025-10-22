package com.example.behavioral.visitor.second;

// 更复杂的访问者示例 - 医疗检查
class MedicalCheckup implements AnimalOperation {
    @Override
    public void visitMonkey(Monkey monkey) {
        System.out.println("Medical checkup for monkey: Checked climbing ability and vocal cords");
        monkey.shout(); // 可以调用动物的原有方法
    }

    @Override
    public void visitLion(Lion lion) {
        System.out.println("Medical checkup for lion: Checked teeth strength and roar capability");
        lion.roar();
    }

    @Override
    public void visitDolphin(Dolphin dolphin) {
        System.out.println("Medical checkup for dolphin: Checked sonar ability and swimming speed");
        dolphin.speak();
    }
}
