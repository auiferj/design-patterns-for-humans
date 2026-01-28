package com.example.behavioral.command.first;
// Client（客户） - 你
public class ZApp {
    public static void main(String[] args) {
        /**
         * 调用者是waiter，调用者调用命令对象，命令对象内部再调用接收者去做事情
         */


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

        /**
         * 命令持有厨师，厨师是具体干活的人
         * 服务员又持有某一个命令，命令是具体干活的人。当命令干活时，内部又盗用厨师去干活。
         * 服务员->命令->厨师，这三者有依赖关系，服务员依赖命令，命令又依赖厨师。服务员调用某种命令的execute方法，命令内部调用厨师的制作对应的美食。
         */
    }
}
