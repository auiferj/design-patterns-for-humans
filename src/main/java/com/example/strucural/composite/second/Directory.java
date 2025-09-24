package com.example.strucural.composite.second;

import java.util.ArrayList;
import java.util.List;

// 复合节点：文件夹
public class Directory implements FileSystemComponent{
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>(); // 包含子组件

    public Directory(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void showInfo(String indent) {
        System.out.println(indent + "文件夹: " + name);
        // 递归调用子组件的方法
        for (FileSystemComponent component : components) {
            component.showInfo(indent + "  ");
        }
    }
}
