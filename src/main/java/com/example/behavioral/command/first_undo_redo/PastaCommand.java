package com.example.behavioral.command.first_undo_redo;

// ConcreteCommand（具体命令）
class PastaCommand implements Command {
    private Chef chef;
    private boolean executed = false;

    public PastaCommand(Chef chef) {
        this.chef = chef;
    }

    public void execute() {
        chef.cookPasta(); // 调用接收者的具体方法
        executed = true;
        System.out.println("✅ 意大利面已下单");
    }

    @Override
    public void undo() {
        if (executed) {
            chef.cancelPasta();
            executed = false;
            System.out.println("❌ 撤销意大利面订单");
        } else {
            System.out.println("没有可撤销的意大利面订单");
        }
    }
}
