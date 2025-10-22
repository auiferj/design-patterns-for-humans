package com.example.behavioral.mediator.first;

// 中介者接口
interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
    void sendPrivateMessage(String message, User sender, User receiver);
}
