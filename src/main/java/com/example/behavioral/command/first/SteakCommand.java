package com.example.behavioral.command.first;

/**
 * steak:牛排
 * ConcreteCommand（具体命令）
 */
class SteakCommand implements Command {
    private Chef chef;

    public SteakCommand(Chef chef) {
        this.chef = chef;
    }

    public void execute() {
        chef.cookSteak();
    }
}
