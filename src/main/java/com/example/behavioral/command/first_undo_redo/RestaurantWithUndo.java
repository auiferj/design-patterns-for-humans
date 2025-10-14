package com.example.behavioral.command.first_undo_redo;

// Client（客户） - 你
public class RestaurantWithUndo {
    public static void main(String[] args) {
        // 创建接收者
        Chef chef = new Chef();

        // 创建具体命令
        Command pastaOrder = new PastaCommand(chef);
        Command steakOrder = new SteakCommand(chef);

        // 创建调用者
        Waiter waiter = new Waiter();

        // 客户点餐：意大利面
        waiter.setCommand(pastaOrder);
        waiter.takeOrder();
        // 输出：
        // 服务员：收到订单，转交给厨师
        // 厨师：正在制作意大利面

        // 客户点餐：牛排
        waiter.setCommand(steakOrder);
        waiter.takeOrder();
        // 输出：
        // 服务员：收到订单，转交给厨师
        // 厨师：正在制作牛排


        // 撤销上一个订单（牛排）
        System.out.println("\n--- 撤销订单 ---");
        waiter.undoOrder();

        // 重做订单
        System.out.println("\n--- 重做订单 ---");
        waiter.redoOrder();

        // 再次撤销
        System.out.println("\n--- 再次撤销 ---");
        waiter.undoOrder();
        waiter.undoOrder(); // 撤销所有

        // 尝试撤销空的
        waiter.undoOrder();
    }
}
