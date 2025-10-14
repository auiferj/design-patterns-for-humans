package com.example.behavioral.command.second_undo_redo;

// Invoker（调用者） - 遥控器
class RemoteControl {
    private TVCommand command;

    public void setCommand(TVCommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute(); // 执行命令
    }
}
