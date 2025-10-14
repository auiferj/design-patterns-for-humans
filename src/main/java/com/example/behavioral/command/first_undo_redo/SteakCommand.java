package com.example.behavioral.command.first_undo_redo;

class SteakCommand implements Command {
    private Chef chef;
    private boolean executed = false;

    public SteakCommand(Chef chef) {
        this.chef = chef;
    }

    public void execute() {
        chef.cookSteak();
        executed = true;
        System.out.println("✅ 牛排已下单");
    }

    @Override
    public void undo() {
        if (executed) {
            chef.cancelSteak();
            executed = false;
            System.out.println("❌ 撤销牛排订单");
        } else {
            System.out.println("没有可撤销的牛排订单");
        }
    }
}
