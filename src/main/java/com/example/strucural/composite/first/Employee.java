package com.example.strucural.composite.first;

import java.util.List;

// 统一的组件接口
public interface Employee {
    String getName();
    double getSalary();
    void add(Employee employee);
    void remove(Employee employee);
    List<Employee> getSubordinates();//下级
}
