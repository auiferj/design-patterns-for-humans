package com.example.behavioral.command.first;

/**
 * pasta:意大利面
 * ConcreteCommand（具体命令）
 */
class PastaCommand implements Command {
    private Chef chef;

    public PastaCommand(Chef chef) {
        this.chef = chef;
    }

    public void execute() {
        chef.cookPasta(); // 调用接收者的具体方法
    }
}
