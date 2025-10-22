package com.example.behavioral.mediator.first;

import java.util.ArrayList;
import java.util.List;

// 具体中介者 - 聊天室
class ChatRoom implements ChatMediator {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
        user.setMediator(this); // 设置用户的中介者
        System.out.println(user.getName() + " 加入了聊天室");
    }

    public void sendMessage(String message, User sender) {
        // 中介者负责将消息分发给所有其他用户
        for (User user : users) {
            // 不将消息发回给发送者自己
            if (user != sender) {
                user.receive(message);
            }
        }
        System.out.println("--- 消息已通过聊天室分发 ---");
    }

    public void sendPrivateMessage(String message, User sender, User receiver) {
        // 中介者也可以处理私聊
        System.out.println("【私聊】" + sender.getName() + " → " + receiver.getName());
        receiver.receive("[私聊] " + message);
    }

    public void broadcast(String message) {
        // 广播消息给所有人
        for (User user : users) {
            user.receive("[广播] " + message);
        }
        System.out.println("=== 广播消息已发送 ===");
    }
}
