package com.example.behavioral.command.second;

// ConcreteCommand（具体命令）
class TurnOnCommand implements TVCommand {
    private Television tv;

    public TurnOnCommand(Television tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOn();
    }
}
