package com.example.behavioral.mediator.first;

// 具体同事类 - 普通用户
class ChatUser extends User {
    public ChatUser(String name) {
        super(name);
    }

    public void send(String message) {
        System.out.println(name + " 发送: " + message);
        mediator.sendMessage(message, this); // 通过中介者发送
    }

    public void sendTo(String message, User receiver) {
        System.out.println(name + " 私聊 " + receiver.getName() + ": " + message);
        if (mediator instanceof ChatRoom) {
            ((ChatRoom) mediator).sendPrivateMessage(message, this, receiver);
        }
    }

    public void receive(String message) {
        System.out.println(name + " 收到: " + message);
    }
}
