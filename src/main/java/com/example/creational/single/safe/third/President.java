package com.example.creational.single.safe.third;

public class President {
    //INSTANCE; // 唯一的枚举实例

    public void makeSpeech() {
        System.out.println("Addressing the nation...");
    }

    public void signLaw(String lawName) {
        System.out.println("Signing into law: " + lawName);
    }
}
