package com.example.strucural.adapter;

public class AsianLion implements Lion{
    @Override
    public void roar() {
        System.out.println("亚洲狮凶猛咆哮!");
    }

    @Override
    public void hunt() {
        System.out.println("亚洲狮在丛林中捕猎.");
    }
}
