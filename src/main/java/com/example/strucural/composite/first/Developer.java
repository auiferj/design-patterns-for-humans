package com.example.strucural.composite.first;

import java.util.List;

public class Developer implements Employee{
    private String name;
    private double salary;

    public Developer(String name, double salary) {
        this.name = name;
        this.salary = salary;
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
