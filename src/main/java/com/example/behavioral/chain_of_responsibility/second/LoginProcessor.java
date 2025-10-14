package com.example.behavioral.chain_of_responsibility.second;

// 3. 具体处理对象
class LoginProcessor extends Processor {
    protected boolean canHandle(Command command) {
        return "LOGIN".equals(command.getCommandType());
    }

    protected void handleCommand(Command command) {
        System.out.println("登录处理器处理: " + command.getData());
    }
}
