package com.example.behavioral.visitor.demo_3;

// 5️⃣ 具体访问者：打印信息
class PrintVisitor implements Visitor {
    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师：" + engineer.getName());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理：" + manager.getName());
    }
}
