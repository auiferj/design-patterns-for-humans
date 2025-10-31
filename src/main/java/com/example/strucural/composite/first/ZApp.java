package com.example.strucural.composite.first;

public class ZApp {
    public static void main(String[] args) {
        // 创建开发人员
        Employee dev1 = new Developer("张三", 15000);
        Employee dev2 = new Developer("李四", 16000);
        Employee dev3 = new Developer("王五", 17000);

        // 创建设计师
        Employee designer1 = new Designer("赵六", 14000);
        Employee designer2 = new Designer("钱七", 15000);

        // 创建开发部门
        Department devDepartment = new Department("开发部");
        devDepartment.add(dev1);
        devDepartment.add(dev2);
        devDepartment.add(dev3);

        // 创建设计部门
        Department designDepartment = new Department("设计部");
        designDepartment.add(designer1);
        designDepartment.add(designer2);

        // 创建技术部门（包含开发部和设计部）
        Department techDepartment = new Department("技术部");
        techDepartment.add(devDepartment);
        techDepartment.add(designDepartment);

        // 显示组织结构和薪水
        displayStructure(techDepartment, 0);

        System.out.println("\n技术部总薪水: " + techDepartment.getSalary());
        System.out.println("开发部总薪水: " + devDepartment.getSalary());
        System.out.println("设计部总薪水: " + designDepartment.getSalary());
    }

    private static void displayStructure(Employee employee, int level) {
        String indent = "  ".repeat(level);
        System.out.println(indent + employee.getName() + " - 薪水: " + employee.getSalary());

        for (Employee subordinate : employee.getSubordinates()) {
            displayStructure(subordinate, level + 1);
        }
    }
}
