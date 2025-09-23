package com.example.strucural.adapter;

public class Hunter {
    public void hunt(Lion lion) {
        // 猎人先让狮子吼叫，确认目标
        lion.roar();
        // 然后开始狩猎
        lion.hunt();
        System.out.println("Hunter completes the hunt!");
    }
}
