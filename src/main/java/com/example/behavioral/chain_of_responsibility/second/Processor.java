package com.example.behavioral.chain_of_responsibility.second;

/**
 * 2. 抽象处理对象，或是请求的抽象接收者
 * 这个类的实例作用是：它是处理请求的处理器，例如：登录处理器、支付处理器
 */
abstract class Processor {
    protected Processor nextProcessor;

    /**
     * 传递机制，递归调用
     * @param next
     */
    public void setNext(Processor next) {
        this.nextProcessor = next;
    }

    public void process(Command command) {
        if (canHandle(command)) {
            handleCommand(command);
        } else if (nextProcessor != null) {
            nextProcessor.process(command);  // 传递给下一个
        } else {
            System.out.println("没有处理器能处理此命令: " + command.getCommandType());
        }
    }

    /**
     * 处理逻辑：判断是否能处理
     * @param command
     * @return
     */
    protected abstract boolean canHandle(Command command);
    protected abstract void handleCommand(Command command);
}
