package com.example.behavioral.chain_of_responsibility.second;

class LogoutProcessor extends Processor {
    protected boolean canHandle(Command command) {
        return "LOGOUT".equals(command.getCommandType());
    }

    protected void handleCommand(Command command) {
        System.out.println("登出处理器处理: " + command.getData());
    }
}
