package com.example.behavioral.visitor.demo_3;

// 6️⃣ 具体访问者：绩效计算
class PerformanceVisitor implements Visitor {
    @Override
    public void visit(Engineer engineer) {
        System.out.println("计算工程师 " + engineer.getName() + " 的绩效...");
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("计算经理 " + manager.getName() + " 的绩效...");
    }
}
