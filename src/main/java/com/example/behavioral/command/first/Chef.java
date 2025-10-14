package com.example.behavioral.command.first;
// Receiver（接收者） - 厨师
public class Chef {
    public void cookPasta() {
        System.out.println("厨师：正在制作意大利面");
    }

    public void cookSteak() {
        System.out.println("厨师：正在制作牛排");
    }

    public void prepareSalad() {
        System.out.println("厨师：正在准备沙拉");
    }

}
