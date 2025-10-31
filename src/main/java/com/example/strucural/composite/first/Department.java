package com.example.strucural.composite.first;

import java.util.ArrayList;
import java.util.List;

public class Department implements Employee{
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        // 部门的薪水是所有下属薪水的总和
        return employees.stream().mapToDouble(Employee::getSalary).sum();
    }

    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void remove(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public List<Employee> getSubordinates() {
        return new ArrayList<>(employees);
    }
}
