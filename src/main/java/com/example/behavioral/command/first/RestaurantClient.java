package com.example.behavioral.command.first;
// Client（客户） - 你
public class RestaurantClient {
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
    }
}
