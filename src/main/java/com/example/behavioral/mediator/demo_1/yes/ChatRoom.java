package com.example.behavioral.mediator.demo_1.yes;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体中介者 - 聊天室
 * 负责封装对象之间的交互
 */
class ChatRoom implements ChatMediator {
    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void send(String message, User sender) {
        for (User user : users) {
            // 不给自己发
            if (user != sender) {
                user.receive(message, sender.getName());
            }
        }
    }
}
