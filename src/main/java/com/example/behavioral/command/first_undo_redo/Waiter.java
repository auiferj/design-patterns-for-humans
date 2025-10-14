package com.example.behavioral.command.first_undo_redo;

import java.util.ArrayList;
import java.util.List;

public class Waiter {
    private Command command;
    private List<Command> history = new ArrayList<>(); // 命令历史
    private int current = -1; // 当前命令位置

    public void setCommand(Command command) {
        this.command = command;
    }

    public void takeOrder() {
        // 执行新命令时，清除重做历史
        if (current < history.size() - 1) {
            history = history.subList(0, current + 1);
        }
        System.out.println("服务员：收到订单，转交给厨师");
        command.execute(); // 转发命令给接收者
        history.add(command);
        current = history.size() - 1;
        System.out.println("当前订单数量: " + history.size());
    }

    public void undoOrder() {
        if (current >= 0) {
            Command lastCommand = history.get(current);
            lastCommand.undo();
            current--;
            System.out.println("撤销完成，当前订单数量: " + (current + 1));
        } else {
            System.out.println("没有可撤销的订单");
        }
    }

    public void redoOrder() {
        if (current < history.size() - 1) {
            current++;
            Command nextCommand = history.get(current);
            nextCommand.execute();
            System.out.println("重做完成，当前订单数量: " + (current + 1));
        } else {
            System.out.println("没有可重做的订单");
        }
    }
}
