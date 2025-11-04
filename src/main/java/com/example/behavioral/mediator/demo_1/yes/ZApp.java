package com.example.behavioral.mediator.demo_1.yes;

// 使用中介者模式
public class ZApp {
    public static void main(String[] args) {
        /**
         * 改进点
         * 每个 User 只知道一个对象：ChatRoom
         * 不再需要知道其他用户是谁；
         * 新增用户时，只需 chatRoom.register(newUser)，完全不影响已有对象。
         *
         * 中介者模式的作用，就是让它们都只依赖一个中间对象（中介者），从“网状关系”变为“星型关系”。
         */
        ChatMediator chatRoom = new ChatRoom();

        User alice = new User( "Alice",chatRoom);
        User bob = new User( "Bob",chatRoom);
        User charlie = new User( "Charlie",chatRoom);

        chatRoom.addUser(alice);
        chatRoom.addUser(bob);
        chatRoom.addUser(charlie);

        //用户发消息，会调用中介者去发。中介持有所有用户的引用。
        alice.send("大家好！");
        bob.send("嗨，Alice！");
    }
}
