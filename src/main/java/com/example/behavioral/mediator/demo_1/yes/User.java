package com.example.behavioral.mediator.demo_1.yes;

// 同事类
public class User {
    protected String name;
    protected ChatMediator mediator;


    public User(String name, ChatMediator chatRoom) {
        this.name = name;
        this.mediator = chatRoom;
    }

    public String getName() {
        return name;
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    public void receive(String message, String from) {
        System.out.println(name + " 收到来自 " + from + " 的消息: " + message);
    }
}

