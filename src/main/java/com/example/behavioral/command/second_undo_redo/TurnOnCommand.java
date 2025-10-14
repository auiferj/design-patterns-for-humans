package com.example.behavioral.command.second_undo_redo;

// ConcreteCommand（具体命令）
class TurnOnCommand implements TVCommand {
    private Television tv;
    private boolean executed = false;

    public TurnOnCommand(Television tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOn();
        executed = true;
    }

    public void undo() {
        if (executed) {
            tv.turnOff();
            executed = false;
        }
    }
}
