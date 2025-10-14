package com.example.behavioral.command.first_undo_redo;
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

    public void cancelPasta() {
        System.out.println("厨师：取消意大利面订单");
    }

    public void cancelSteak() {
        System.out.println("厨师：取消牛排订单");
    }

    public void cancelSalad() {
        System.out.println("厨师：取消沙拉订单");
    }
}
