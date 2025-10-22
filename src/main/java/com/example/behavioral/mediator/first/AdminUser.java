package com.example.behavioral.mediator.first;

// 管理员用户（可以广播）
class AdminUser extends User {
    public AdminUser(String name) {
        super(name);
    }

    public void send(String message) {
        System.out.println("【管理员】" + name + " 发送: " + message);
        mediator.sendMessage(message, this);
    }

    public void broadcast(String message) {
        System.out.println("【管理员广播】" + name + ": " + message);
        if (mediator instanceof ChatRoom) {
            ((ChatRoom) mediator).broadcast(message);
        }
    }

    public void receive(String message) {
        System.out.println("【管理员】" + name + " 收到: " + message);
    }
}
