package com.example.strucural.composite.second;
// 叶子节点：文件
public class File implements FileSystemComponent{
    private String name;

    public File(String name) {
        this.name = name;
    }
    @Override
    public void showInfo(String indent) {
        System.out.println(indent + "文件: " + name);
    }
}
