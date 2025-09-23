package com.example.strucural.adapter;

public class AfricanLion implements Lion{
    @Override
    public void roar() {
        System.out.println("非洲狮大声咆哮!");
    }

    @Override
    public void hunt() {
        System.out.println("非洲狮在热带草原上捕猎.");
    }
}
