package com.example.behavioral.chain_of_responsibility.second;

/**
 * 1. 命令对象
 * 命令对象的来源
 * 指的是请求的发起者或命令的创建者
 * 这些命令对象包含了需要被执行的操作或请求
 * 这个类的实例作用是封装请求数据。例如：登录请求，支付请求
 */
class Command {
    private String commandType;
    private Object data;

    public Command(String type, Object data) {
        this.commandType = type;
        this.data = data;
    }

    public String getCommandType() { return commandType; }
    public Object getData() { return data; }
}
