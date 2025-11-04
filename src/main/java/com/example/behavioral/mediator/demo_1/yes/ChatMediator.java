package com.example.behavioral.mediator.demo_1.yes;

// 中介者接口
interface ChatMediator {
    void send(String message, User user);
    void addUser(User user);
}
