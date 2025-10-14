package com.example.behavioral.chain_of_responsibility.second;

/**
 * 具体请求接收者
 */
class PaymentProcessor extends Processor {
    protected boolean canHandle(Command command) {
        return "PAYMENT".equals(command.getCommandType());
    }

    protected void handleCommand(Command command) {
        System.out.println("支付处理器处理: " + command.getData());
    }
}
