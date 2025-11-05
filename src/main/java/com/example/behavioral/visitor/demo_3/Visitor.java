package com.example.behavioral.visitor.demo_3;

/**
 * 模拟一个公司中，有不同类型的员工（工程师、经理），
 * 我们希望对他们进行不同的操作，比如「打印信息」、「计算绩效」。
 * 1️⃣.访问者接口：定义对不同类型元素的访问操作
 */
public interface Visitor {
    void visit(Engineer engineer);
    void visit(Manager manager);
}
