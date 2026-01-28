package com.example.behavioral.command.first;

public class Waiter {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 服务员接单
     */
    public void takeOrder() {
        System.out.println("服务员：收到订单，转交给厨师");
        command.execute(); // 转发命令给接收者
    }
}
