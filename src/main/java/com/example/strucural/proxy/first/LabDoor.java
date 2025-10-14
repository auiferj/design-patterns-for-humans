package com.example.strucural.proxy.first;
// 2. 实现基本的门功能
public class LabDoor implements Door{
    public void open() {
        System.out.println("打开实验室的门");
    }

    public void close() {
        System.out.println("关闭实验室的门");
    }
}
