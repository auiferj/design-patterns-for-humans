package com.example.behavioral.mediator.first;

// 抽象同事类
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public void setMediator(ChatMediator mediator) {
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
    // 公共方法 - 所有用户都可以发送私聊消息
    public void sendTo(String message, User receiver) {
        System.out.println(name + " 私聊 " + receiver.getName() + ": " + message);
        mediator.sendPrivateMessage(message, this, receiver);
    }
}

