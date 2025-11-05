package com.example.behavioral.visitor.demo_3;

/**
 * 2️⃣.被访问元素接口
 */
public interface Employee {
    void accept(Visitor visitor);
}
