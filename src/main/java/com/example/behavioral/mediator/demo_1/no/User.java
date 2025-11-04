package com.example.behavioral.mediator.demo_1.no;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    // 每个用户都要保存其他所有用户的引用
    private List<User> friends = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public void send(String message) {
        for (User friend : friends) {
            friend.receive(message, name);
        }
    }

    public void receive(String message, String from) {
        System.out.println(name + " 收到来自 " + from + " 的消息: " + message);
    }
}
