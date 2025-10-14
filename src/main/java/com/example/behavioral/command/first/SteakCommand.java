package com.example.behavioral.command.first;

class SteakCommand implements Command {
    private Chef chef;

    public SteakCommand(Chef chef) {
        this.chef = chef;
    }

    public void execute() {
        chef.cookSteak();
    }
}
