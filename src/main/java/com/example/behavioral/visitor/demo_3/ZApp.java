package com.example.behavioral.visitor.demo_3;

import java.util.ArrayList;
import java.util.List;

public class ZApp {
    /**
     * 每次都不用改员工类（Engineer、Manager），
     * 只要加一个新的访问者就能扩展功能 ✅。
     * @param args
     */
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Engineer("Alice"));
        employees.add(new Manager("Bob"));

        // 使用不同访问者执行不同逻辑
        Visitor printVisitor = new PrintVisitor();
        Visitor performanceVisitor = new PerformanceVisitor();

        System.out.println("=== 打印员工信息 ===");
        for (Employee e : employees) {
            e.accept(printVisitor);
        }

        System.out.println("\n=== 计算绩效 ===");
        for (Employee e : employees) {
            e.accept(performanceVisitor);
        }
    }
}
