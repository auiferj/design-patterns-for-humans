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
        return "";
    }

    @Override
    public double getSalary() {
        return 0;
    }

    @Override
    public void add(Employee employee) {

    }

    @Override
    public void remove(Employee employee) {

    }

    @Override
    public List<Employee> getSubordinates() {
        return List.of();
    }
}
