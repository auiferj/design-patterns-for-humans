package com.example.behavioral.mediator.demo_1.no;

public class ZApp {
    public static void main(String[] args) {
        /**
         * 问题分析
         * 1.每个用户都要持有所有其他用户的引用
         *
         * alice 需要 bob 和 charlie；
         *
         * bob 需要 alice 和 charlie；
         *
         * charlie 需要 alice 和 bob。
         *
         * 这就意味着三个人之间的关系是互相缠绕的网状结构。
         *
         * 2.新增一个用户很麻烦
         * 假如现在多了一个 David，
         * 那就得修改所有已有用户：
         *
         * alice.addFriend(david);
         * bob.addFriend(david);
         * charlie.addFriend(david);
         * david.addFriend(alice);
         * david.addFriend(bob);
         * david.addFriend(charlie);
         *
         * 所有代码都要改，系统扩展性极差。
         *“高耦合”指的是：对象之间彼此持有对方引用、互相依赖，修改一个对象就可能影响很多其他对象。
         */
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        // 每个用户都要“知道”其他人是谁
        alice.addFriend(bob);
        alice.addFriend(charlie);

        bob.addFriend(alice);
        bob.addFriend(charlie);

        charlie.addFriend(alice);
        charlie.addFriend(bob);

        alice.send("大家好！");
    }
}
