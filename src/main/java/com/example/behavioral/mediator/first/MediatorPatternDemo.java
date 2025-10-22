package com.example.behavioral.mediator.first;

// 使用中介者模式
public class MediatorPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== 中介者模式演示：聊天室系统 ===\n");

        // 创建中介者 - 聊天室
        ChatRoom chatRoom = new ChatRoom();

        // 创建用户
        User alice = new ChatUser("Alice");
        User bob = new ChatUser("Bob");
        User charlie = new ChatUser("Charlie");
        User admin = new AdminUser("SystemAdmin");

        // 用户加入聊天室（通过中介者）
        chatRoom.addUser(alice);
        chatRoom.addUser(bob);
        chatRoom.addUser(charlie);
        chatRoom.addUser(admin);

        System.out.println("\n--- 群组聊天演示 ---");
        alice.send("大家好！我是Alice");
        bob.send("你好Alice！我是Bob");

        System.out.println("\n--- 私聊演示 ---");
        alice.sendTo("这是一个私密消息", bob);

        System.out.println("\n--- 管理员广播演示 ---");
        ((AdminUser) admin).broadcast("系统将在5分钟后维护");

        System.out.println("\n--- 新用户加入演示 ---");
        User david = new ChatUser("David");
        chatRoom.addUser(david);
        david.send("大家好，我是新来的David！");
    }
}
