package com.example.strucural.composite.first;

import java.util.ArrayList;
import java.util.List;

public class Designer implements Employee{
    private String name;
    private double salary;

    public Designer(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void add(Employee employee) {
        throw new UnsupportedOperationException("叶子节点不能添加下属");
    }

    @Override
    public void remove(Employee employee) {
        throw new UnsupportedOperationException("叶子节点不能移除下属");
    }

    @Override
    public List<Employee> getSubordinates() {
        return new ArrayList<>(); // 叶子节点没有下属
    }
}
